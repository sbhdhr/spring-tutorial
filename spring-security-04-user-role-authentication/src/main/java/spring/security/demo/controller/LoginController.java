package spring.security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	public static final String LOGIN_PAGE_URL = "/showLoginPage";
	public static final String ACCESS_DENIED_URL = "/accessDenied";
	
	@GetMapping(LOGIN_PAGE_URL)
	public String showLoginPage(){
		return "login";
	}
}
