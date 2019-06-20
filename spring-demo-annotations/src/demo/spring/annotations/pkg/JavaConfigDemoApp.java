package demo.spring.annotations.pkg;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {
		
		// read spring config from class
		AnnotationConfigApplicationContext context = new
				AnnotationConfigApplicationContext(SportSpringConfig.class);
		
		//retrieve the bean
		TennisCoach theCoach =  context.getBean("tennisCoach",TennisCoach.class);
		
		//call a method on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		//call a method on the bean to get daily fortune
		System.out.println(theCoach.getDailyFortune());
		
		
		System.out.println("Coach email: "+theCoach.getEmail());
		System.out.println("Coach team: "+theCoach.getTeam());
		
		//close the context
		context.close();
	}

}
