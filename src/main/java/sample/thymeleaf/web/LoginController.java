package sample.thymeleaf.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import sample.common.service.LoginService;
@Controller
public class LoginController {
	
	private final LoginService loginService;
	
	public LoginController(LoginService loginService) {
		this.loginService = loginService;
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/login")
	public String doLogin(@RequestParam String username, @RequestParam String password, HttpSession session,Model model) {
		boolean ok = loginService.authenticate(username, password);
		if (!ok) {
			model.addAttribute("error","ユーザー名またはパスワードが違います");
			return "login";
		}
		
		session.setAttribute("loginUser",username);
		
		return "redirect:/tasks";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
}
