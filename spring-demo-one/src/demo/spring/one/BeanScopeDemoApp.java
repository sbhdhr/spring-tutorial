package demo.spring.one;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {

		//load spring configuration file
		ClassPathXmlApplicationContext context = new 
				ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		
		//retrieve bean from spring container
		Coach theCoach = context.getBean("myCoach",Coach.class);
		
		
		Coach alphaCoach = context.getBean("myCoach",Coach.class);
		
		
		//check if they are same
		boolean result = (theCoach == alphaCoach);
		
		
		//print the result
		System.out.println("Pointing to same object : "+result);
		
		System.out.println("Memory Location of theCoach: "+theCoach);
		System.out.println("Memory Location of alphaCoach: "+alphaCoach);
		
		
		
		context.close();
	}

}
