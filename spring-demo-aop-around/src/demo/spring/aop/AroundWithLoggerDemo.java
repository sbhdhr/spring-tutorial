package demo.spring.aop;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import demo.spring.aop.service.TrafficFortuneService;

public class AroundWithLoggerDemo {

	public static void main(String[] args) {
		
		Logger logger = Logger.getLogger(AroundWithLoggerDemo.class.getName());

		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);

		// get the bean from spring container
		TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService",
				TrafficFortuneService.class);
		
		logger.info("------------- Main Program: AroundDemo ---------------");
		
		logger.info("Calling getFortune");
		
		logger.info("The Fortune is: "+trafficFortuneService.getFortune());
		
		logger.info("---------------------  Finished  ---------------------");
		

		// close the context
		context.close();

	}

}
