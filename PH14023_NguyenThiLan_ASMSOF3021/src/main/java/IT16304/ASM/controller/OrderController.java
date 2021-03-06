package IT16304.ASM.controller;

import java.net.http.HttpRequest;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import IT16304.ASM.entity.Account;
import IT16304.ASM.entity.Category;
import IT16304.ASM.entity.Order;
import IT16304.ASM.entity.Product;
import IT16304.ASM.model.OrderModel;
import IT16304.ASM.model.ProductModel;
import IT16304.ASM.repository.AccountRepository;
import IT16304.ASM.repository.CategoryRepository;
import IT16304.ASM.repository.OrderRepository;
import IT16304.ASM.repository.ProductRepository;

@Controller
@RequestMapping("admin/orders")
public class OrderController {
	@Autowired
	private OrderRepository orderService;

	@Autowired
	private AccountRepository accountService;
	
	@Autowired
	private HttpSession session;

	@Autowired
	private HttpServletRequest request;
	
	@GetMapping("create")
	public String create(Model model,
			@ModelAttribute("order") OrderModel orderModel) {
//		Account account = (Account) request.getSession().getAttribute("user");
		List<Account> account = this.accountService.findAll();
		model.addAttribute("account", account);
		return "admin/orders/create";
	}

	@PostMapping("store")
	public String store(Model model, @Valid @ModelAttribute("order") OrderModel orderModel, BindingResult bin) {
		if (bin.hasErrors()) {
			return "/admin/orders/create";
		} else {
			Order entity = new Order();
			BeanUtils.copyProperties(orderModel, entity);
			entity.setCreateDate(new Date());
			this.orderService.save(entity);
			session.setAttribute("message", "Th??m m???i th??nh c??ng!");
			return "redirect:/admin/orders/index";
		}

	}

	@GetMapping("edit/{orderId}")
	public String edit(Model model,
			@PathVariable("orderId") Order order, @ModelAttribute("order") OrderModel orderModel) {
		List<Account> account = this.accountService.findAll();
		model.addAttribute("account", account);
		
		orderModel.setId(order.getId());
		orderModel.setAddress(order.getAddress());
		orderModel.setUser(order.getUser());
		return "admin/orders/edit";
	}

	@PostMapping("update/{orderId}")
	public String update(@PathVariable("orderId") Order order,
			@Valid @ModelAttribute("order") OrderModel orderModel, 
			BindingResult bin) {
		if(bin.hasErrors()) {
			return "admin/orders/edit";
		}else {
		order.setAddress(orderModel.getAddress());
		order.setUser(orderModel.getUser());
		this.orderService.save(order);
		session.setAttribute("message", "S???a th??nh c??ng!");
		return "redirect:/admin/orders/index";
		}
	}

	@GetMapping("delete/{orderId}")
	public String delete(@PathVariable("orderId") Order order) {
		this.orderService.delete(order);
		session.setAttribute("message", "X??a th??nh c??ng!");
		return "redirect:/admin/orders/index";
	}

	@GetMapping("index")
	public String index(Model model, @RequestParam(name = "page", defaultValue = "0") Integer page,
			@RequestParam(name = "size", defaultValue = "5") Integer size,
			@RequestParam(name = "field") Optional<String> field) {
		List<Account> account = this.accountService.findAll();
		model.addAttribute("account", account);

		Sort sort = Sort.by(Direction.DESC, field.orElse("createDate"));
		Pageable pageable = PageRequest.of(page, size, sort);
		Page<Order> data = this.orderService.findAll(pageable);
		model.addAttribute("data", data);
		return "admin/orders/index";
	}
}
