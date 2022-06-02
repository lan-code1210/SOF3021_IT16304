package IT16304.ASM.controller;

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

import IT16304.ASM.entity.Account;
import IT16304.ASM.model.AccountModel;
import IT16304.ASM.repository.AccountRepository;

@Controller
@RequestMapping("admin/accounts")
public class AccountController {

	@Autowired
	private AccountRepository accountservice;


	@GetMapping("create")
	public String create(@ModelAttribute("account") AccountModel account) {
		return "/admin/accounts/create";

	}

	@PostMapping("store")
	public String store(AccountModel accountModel) {
		Account account = new Account();
		BeanUtils.copyProperties(accountModel, account);
		account.setActivated(0);
		this.accountservice.save(account);

		return "redirect:/admin/accounts/index";
	}

	@GetMapping("edit/{accountId}")
	public String update(Model model, AccountModel accountModel,
			@PathVariable("accountId") Integer accountId) {
		Optional<Account> account = this.accountservice.findById(accountId);
		model.addAttribute("account", account);
		return "/admin/accounts/update";

	}

	@GetMapping("delete/{accountId}")
	public String delete(@PathVariable("accountId") Integer accountId) {
		this.accountservice.deleteById(accountId);
		System.out.println("Thành Công");
		return "redirect:/admin/accounts/index";
	}

	@GetMapping("index")
	public String index(Model model, 
			@RequestParam(name = "page", defaultValue = "0") Integer page,
			@RequestParam(name = "size", defaultValue = "10") Integer size,
			@RequestParam(name = "field") Optional<String> field) {

		Sort sort = Sort.by(Direction.DESC, field.orElse("username"));
		Pageable pagable = PageRequest.of(page, size, sort);
		Page<Account> data = this.accountservice.findAll(pagable);
		model.addAttribute("data", data);
		return "/admin/accounts/index";
	}
}
