package spring.security.db.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import spring.security.db.auth.constants.UrlConstants;

@Controller
public class HomeController {
	
	

	@GetMapping(UrlConstants.HOME_URL)
	public String viewHome(Model model) {
		model.addAttribute("title", "Welcome to sbhdhr Employee Homepage !!");
		
		return "home";
	}
	
	
	@GetMapping(UrlConstants.MANAGER_PAGE_URL)
	public String viewHomeManager(Model model) {
		model.addAttribute("title", "Welcome to sbhdhr Employee Homepage !!");
		
		return "manager";
	}
	
	
	@GetMapping(UrlConstants.ADMIN_PAGE_URL)
	public String viewHomeAdmin(Model model) {
		model.addAttribute("title", "Welcome to sbhdhr Employee Homepage !!");
		
		return "admin";
	}
}
