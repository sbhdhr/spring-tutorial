package demo.spring.annotations.pkg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")  -- bean scope using annotations
public class TennisCoach implements Coach {

	
	//Field Injection
	
	// Using Qualifier to call HappyFortuneService using default ID
	@Autowired
	@Qualifier("fileFortuneService")
	private FortuneService fortuneService;
	
	/*
	//Constructor Injection
	@Autowired
	public TennisCoach(FortuneService fortuneService) {
		
		this.fortuneService = fortuneService;
	}*/
	
	
	/*
	//Setter Injection
	@Autowired
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
		System.out.println("TennisCoach: Inside setFortuneService method.");
	}
	*/

	
	//Using Annotations to  inject literal values from prop file
	
	@Value("${coach.email}")
	private String email;
	
	@Value("${coach.team}")
	private String team;
	
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	@Override
	public String getDailyWorkout() {
		return "Practice backhand volley!";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	

}
