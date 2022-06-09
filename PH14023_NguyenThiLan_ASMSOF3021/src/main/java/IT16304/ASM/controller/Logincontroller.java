package IT16304.ASM.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import IT16304.ASM.entity.Account;
import IT16304.ASM.repository.AccountRepository;

@Controller
public class Logincontroller {
	@Autowired
	private AccountRepository accountRepository;
	
	
	@GetMapping("login")
	public String login() {
		return "admin/login";
	}
	
	@PostMapping("/login")
	public String login(
			HttpSession session,
			@RequestParam(name = "email",defaultValue = "email") String email,
			@RequestParam(name = "pass",defaultValue = "pass") String pass
			) {
		Account account = this.accountRepository.findByEmailLike(email);
		if (account != null) {
			System.out.println("Đăng nhập thành công ");
			session.setAttribute("user", account);
			return "redirect:/admin/accounts/index";
		}else {
			System.out.println("Nhập đúng");
			return "admin/login";
		}
		
	}
}
