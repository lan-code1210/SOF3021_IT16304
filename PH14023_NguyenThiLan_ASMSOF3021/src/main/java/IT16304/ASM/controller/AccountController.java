package IT16304.ASM.controller;

import java.util.Optional;

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

import IT16304.ASM.EncrytUtil.EncryptUtil;
import IT16304.ASM.entity.Account;
import IT16304.ASM.entity.Category;
import IT16304.ASM.model.AccountModel;
import IT16304.ASM.model.CategoryModel;
import IT16304.ASM.repository.AccountRepository;

@Controller
@RequestMapping("admin/accounts")
public class AccountController {

	@Autowired
	private AccountRepository accountservice;
	
	@Autowired
	private HttpSession session;

	@GetMapping("create")
	public String create(@ModelAttribute("account") AccountModel account) {
		return "/admin/accounts/create";

	}

	@PostMapping("store")
	public String store(@Valid
			@ModelAttribute("account") AccountModel accountModel,
			BindingResult bin) {
		if (bin.hasErrors()) {
			System.out.println("Không hợp lệ");
			return "/admin/accounts/create";
		}
			Account account = new Account();
			BeanUtils.copyProperties(accountModel, account);
			account.setPassword(EncryptUtil.encrypt(accountModel.getPassword()));
			account.setActivated(0);
			this.accountservice.save(account);
			session.setAttribute("message", "Thêm mới thành công");
		return "redirect:/admin/accounts/index";
	}

	@GetMapping("edit/{accountId}")
	public String edit(@PathVariable("accountId") Account account,
			@ModelAttribute("account") AccountModel accountModel) {

		accountModel.setId(account.getId());
		accountModel.setUsername(account.getUsername());
		accountModel.setFullname(account.getFullname());
		accountModel.setEmail(account.getEmail());
		accountModel.setPhoto(account.getPhoto());
		accountModel.setAdmin(account.getAdmin());
		return "admin/accounts/edit";
	}

	@PostMapping("update/{accountId}")
	public String update( @PathVariable("accountId") Account account,
		@Valid	@ModelAttribute("account") AccountModel accountModel,
		BindingResult bin) {
		if (bin.hasErrors()) {
			return "/admin/accounts/edit";
		}
		account.setUsername(accountModel.getUsername());
		account.setFullname(accountModel.getFullname());
		account.setEmail(accountModel.getEmail());
		account.setAdmin(account.getAdmin());
		account.setPhoto(accountModel.getPhoto());
		this.accountservice.save(account);
		session.setAttribute("message", "Sửa thành công");
		return "redirect:admin/accounts/index";
	}

	@GetMapping("delete/{accountId}")
	public String delete(@PathVariable("accountId") Integer accountId) {
		this.accountservice.deleteById(accountId);
		session.setAttribute("message", "Xoá thành công");
		return "redirect:/admin/accounts/index";
	}

	@GetMapping("index")
	public String index(Model model, @RequestParam(name = "page", defaultValue = "0") Integer page,
			@RequestParam(name = "size", defaultValue = "5") Integer size,
			@RequestParam(name = "field") Optional<String> field) {

		Sort sort = Sort.by(Direction.DESC, field.orElse("username"));
		Pageable pagable = PageRequest.of(page, size, sort);
		Page<Account> data = this.accountservice.findAll(pagable);
		model.addAttribute("data", data);
		return "/admin/accounts/index";
	}
}
