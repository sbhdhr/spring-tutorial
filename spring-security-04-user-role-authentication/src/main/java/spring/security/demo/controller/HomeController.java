package spring.security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	public static final String HOME_URL = "/";
	public static final String MANAGER_PAGE_URL = "/management";
	public static final String ADMIN_PAGE_URL = "/systems";

	@GetMapping(HOME_URL)
	public String viewHome(Model model) {
		model.addAttribute("title", "Welcome to sbhdhr Employee Homepage !!");
		
		return "home";
	}
	
	
	@GetMapping(MANAGER_PAGE_URL)
	public String viewHomeManager(Model model) {
		model.addAttribute("title", "Welcome to sbhdhr Employee Homepage !!");
		
		return "manager";
	}
	
	
	@GetMapping(ADMIN_PAGE_URL)
	public String viewHomeAdmin(Model model) {
		model.addAttribute("title", "Welcome to sbhdhr Employee Homepage !!");
		
		return "admin";
	}
}
