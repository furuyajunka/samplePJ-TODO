package sample.thymeleaf.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sample.common.service.LoginService;

@Controller
public class RegisterController {
	private final LoginService loginService;
	
	public RegisterController(LoginService loginService) {
		this.loginService = loginService;
	}
	
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
	@PostMapping("/register")
	public String doRegister(@RequestParam String username,@RequestParam String password,Model model) {
		boolean ok =loginService.register(username,password);
		
		if(!ok) {
			model.addAttribute("error","そのユーザー名は既に使われています");
			return "register";
		}
		return "redirect:/login";
	}
}
