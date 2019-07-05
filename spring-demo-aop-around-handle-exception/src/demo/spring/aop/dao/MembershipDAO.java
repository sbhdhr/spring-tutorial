package demo.spring.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public void addAccount() {
		System.out.println(getClass()+" :DOING MY JOB. Adding membership account.");
	}
	
	public void goToSleep() {
		System.out.println(getClass()+" :sleeping");
	}
	
}
