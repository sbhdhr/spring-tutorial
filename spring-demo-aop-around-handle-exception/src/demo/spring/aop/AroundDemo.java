package demo.spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import demo.spring.aop.service.TrafficFortuneService;

public class AroundDemo {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);

		// get the bean from spring container
		TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService",
				TrafficFortuneService.class);
		
		System.out.println("------------- Main Program: AroundDemo ---------------");
		
		System.out.println("Calling getFortune");
		
		System.out.println("The Fortune is: "+trafficFortuneService.getFortune(false));
		
		System.out.println("---------------------  Finished  ---------------------");
		

		// close the context
		context.close();

	}

}
