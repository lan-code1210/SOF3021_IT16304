package IT16304.ASM.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import IT16304.ASM.entity.Category;
import IT16304.ASM.entity.Order;
import IT16304.ASM.entity.Order_detail;
import IT16304.ASM.entity.Product;
import IT16304.ASM.model.OrderDetailModel;
import IT16304.ASM.model.ProductModel;
import IT16304.ASM.repository.OrderDetailRepository;
import IT16304.ASM.repository.OrderRepository;
import IT16304.ASM.repository.ProductRepository;

@Controller
@RequestMapping("admin/order_details")
public class OrderDetailController {
	@Autowired
	private OrderDetailRepository orderdeService;
	@Autowired
	private OrderRepository orderService;
	@Autowired
	private ProductRepository proService;
	
	@GetMapping("create")
	public String create(@ModelAttribute("orderdetail") OrderDetailModel orderdetail , Model model )
	{
		List<Order> listOrd = this.orderService.findAll();
		model.addAttribute("listOrd", listOrd);
		List<Product> listPro = this.proService.findAll();
		model.addAttribute("listPro", listPro);
		return "admin/orderdetails/create";
	}
	@PostMapping("store")
	public String store( @ModelAttribute("orderdetail") OrderDetailModel orderde , Model model) {
		List<Order> listOrd = this.orderService.findAll();
		model.addAttribute("listOrd", listOrd);
		List<Product> listPro = this.proService.findAll();
		model.addAttribute("listPro", listPro);
		Order_detail ordde = new Order_detail();
		
		BeanUtils.copyProperties(orderde, ordde);
		
	
		
		this.orderdeService.save(ordde);
		return "redirect:/admin/order_details/index";
	}
	@GetMapping("index")
	public String index(Model model, @RequestParam(name = "page", defaultValue = "0") Integer page,
			@RequestParam(name = "size", defaultValue = "5") Integer size,
			@RequestParam(name = "field") Optional<String> field) {
		
		Sort sort = Sort.by(Direction.DESC, field.orElse("price"));
		Pageable pageable = PageRequest.of(page, size, sort);
		Page<Order_detail> data = this.orderdeService.findAll(pageable);
		model.addAttribute("data", data);
		return "admin/orderdetails/index";
	}
	
	@GetMapping("delete/{id}")
	public String delete(@PathVariable("id") Order_detail orderde) {
		this.orderdeService.delete(orderde);
		return "redirect:/admin/order_details/index";
	}
	@GetMapping("edit/{id}")
	public String edit(Model model,
			@PathVariable("id") Order_detail order_detail, 
			@ModelAttribute("orderdetail") OrderDetailModel orderDetailModel) {
		List<Order> listOrd = this.orderService.findAll();
		model.addAttribute("listOrd", listOrd);
		List<Product> listPro = this.proService.findAll();
		model.addAttribute("listPro", listPro);
		orderDetailModel.setId(order_detail.getId());
		orderDetailModel.setOrder(order_detail.getOrder());
		orderDetailModel.setPrice(order_detail.getPrice());
		orderDetailModel.setProduct(order_detail.getProduct());
		orderDetailModel.setQuantity(order_detail.getQuantity());

		return "admin/orderdetails/edit";
	}
	
	@PostMapping("update/{id}")
	public String update(@PathVariable("id") Order_detail order_detail, 
			@ModelAttribute("orderdetail") OrderDetailModel orderDetailModel) {
		order_detail.setId(orderDetailModel.getId());
		order_detail.setOrder(orderDetailModel.getOrder());
		order_detail.setPrice(orderDetailModel.getPrice());
		order_detail.setProduct(orderDetailModel.getProduct());
		order_detail.setQuantity(orderDetailModel.getQuantity());

		this.orderdeService.save(order_detail);
		return "redirect:/admin/order_details/index";
	}
//	@PostMapping("update/{id}")
//	public String update(@PathVariable("id") OrderDetail ordde, @ModelAttribute("orderde") OrderDetailModel order) {
//		ordde.setQuantity(order.getQuantity());
//		ordde.setPrice(order.getPrice());
//
//		this.orderdeRepo.save(ordde);
//		return "redirect:/admin/orderdetails/index";
//	}
//	@PostMapping("mail/{id}")
//	public String mail(@PathVariable("id") OrderDetail ordde, @ModelAttribute("orderde") OrderDetailModel order) {
//	
//		return "redirect:/admin/orderdetails/index";
//	}
}
