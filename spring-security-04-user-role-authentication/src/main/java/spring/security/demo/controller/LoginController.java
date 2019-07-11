package spring.security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/showLoginPage")
	public String showLoginPage(Model model){
		model.addAttribute("title", "Welcome to my custom Login Page.");
		return "fancy-login";
	}
}
