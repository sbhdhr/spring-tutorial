package demo.spring.aop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

	private String name;
	private int serviceID;

	public AccountDAO() {
	}

	public AccountDAO(String name, int serviceID) {
		this.name = name;
		this.serviceID = serviceID;
	}

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

	// new method : findAccounts()

	public List<AccountDAO> findAccounts() {
		List<AccountDAO> accounts = new ArrayList<AccountDAO>();
		accounts.add(new AccountDAO("sam", 1));
		accounts.add(new AccountDAO("tom", 2));
		accounts.add(new AccountDAO("harry", 3));
		System.out.println("--------- IN FINDACCOUNTS ----------");
		return accounts;
	}

}
