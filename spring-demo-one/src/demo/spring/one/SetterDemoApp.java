package demo.spring.one;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {
		
		//load the configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
		//load the bean from spring container
		CricketCoach theCoach = context.getBean("myCricketCoach", CricketCoach.class);
		
		//call methods on the bean
		System.out.println(theCoach.getDailyWorkout());		
		System.out.println(theCoach.getDailyFortune());
		
		
		System.out.println(theCoach.getEmailAddress());		
		System.out.println(theCoach.getTeam());
		
		//close application context
		context.close();
	}

}
