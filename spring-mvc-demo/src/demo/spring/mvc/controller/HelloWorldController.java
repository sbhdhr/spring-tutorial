package demo.spring.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	
	//controller method to show the html form
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	
	
	
	//controller method to process the html form
	
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	
	
	
	// new a controller method to read form data and 
	// add data to the model 
	@RequestMapping("/processFormV2")
	public String processModelData(HttpServletRequest request, Model model) {
		
		
		// read the request parameter from the HTMl form
		String name = request.getParameter("studentName");
		
	 
		// convert the data to all caps 
		name = name.toUpperCase();
		
		
		// create the message 
		String result = "Yo! "+name+" hi there !!";
		
	
		// add message to the model 
		model.addAttribute("message",result);
		
		return "helloworld";
	}

	
	
	@RequestMapping("/processFormV3")
	public String processModelDataV3(
			@RequestParam("studentName") String name, 
			Model model) {
		
	 
		// convert the data to all caps 
		name = name.toUpperCase();
		
		
		// create the message 
		String result = "Yo! "+name+" hi there !!";
		
	
		// add message to the model 
		model.addAttribute("message",result);
		
		return "helloworld";
	}
	
	
	
}
