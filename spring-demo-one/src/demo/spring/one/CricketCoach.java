package demo.spring.one;

public class CricketCoach implements Coach {

	
	//add new private members
	private String emailAddress;
	private String team;
	
	
	private FortuneService fortuneService;
	
	
	//create a no-arg constructor
	public CricketCoach() {
		System.out.println("CricketCoach: Inside no-arg constructor.");
	}
	
	//setter method
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
		System.out.println("CricketCoach: Inside setter method.");
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
		System.out.println("CricketCoach: Inside setEmailAddress method.");
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
		System.out.println("CricketCoach: Inside setTeam method.");
	}

	@Override
	public String getDailyWorkout() {
		return "Practice fast bowling for 15 mins.";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
