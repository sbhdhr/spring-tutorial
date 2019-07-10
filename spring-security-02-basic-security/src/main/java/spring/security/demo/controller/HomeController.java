package spring.security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String viewHome(Model model) {
		model.addAttribute("title", "Welcome to homepage !!");
		
		return "home";
	}
}
