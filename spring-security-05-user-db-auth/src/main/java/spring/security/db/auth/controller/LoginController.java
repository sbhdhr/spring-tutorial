package spring.security.db.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import spring.security.db.auth.constants.UrlConstants;

@Controller
public class LoginController {

	
	
	@GetMapping(UrlConstants.LOGIN_PAGE_URL)
	public String showLoginPage(){
		return "login";
	}
	
	@GetMapping(UrlConstants.ACCESS_DENIED_URL)
	public String showAccessDeniedPage(Model model){
		model.addAttribute("title", "Un-Authorized access attempted !!");
		return "access-denied";
	}
}
