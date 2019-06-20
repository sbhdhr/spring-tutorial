package demo.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import demo.spring.mvc.beans.Student;

@Controller
@RequestMapping("/student")
public class StudentController {

	
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		
		//Create a Student object
		Student theStudent = new Student();
		
		//add Student object to model
		theModel.addAttribute("student", theStudent);
		
		
		return "student-form";
	}
	
	
	@RequestMapping("processForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {
		
		//log input data
		System.out.println(theStudent);
		
		return "student-confirmation";
	}
}
