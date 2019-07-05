package demo.spring.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

	private String name;
	private int serviceID;

	public void addAccount() {
		System.out.println(getClass() + " :DOING MY JOB. Adding account.");
	}

	public boolean doWork(boolean param) {
		System.out.println(getClass() + " :Doing normal work");
		return param;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getServiceID() {
		return serviceID;
	}

	public void setServiceID(int serviceID) {
		this.serviceID = serviceID;
	}

	@Override
	public String toString() {
		return "AccountDAO [name=" + name + ", serviceID=" + serviceID + "]";
	}

}
