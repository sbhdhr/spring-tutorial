package demo.spring.one;

public class BaseballCoach implements Coach {

	// define a private field for dependency
	
	private FortuneService fortuneService;
	
	
	// define a constructor for dependency injection
	public BaseballCoach(FortuneService fortuneService) {
		this.fortuneService=fortuneService;
	}
	
	
	@Override
	public String getDailyWorkout() {
		return "Spend 30 min in batting practice.";
	}

	@Override
	public String getDailyFortune() {
		
		// use FortuneService to get a fortune
		return fortuneService.getFortune();
	}
	
	
}
