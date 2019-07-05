package demo.spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import demo.spring.aop.dao.AccountDAO;
import demo.spring.aop.dao.MembershipDAO;

public class Main {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);

		// get the bean from spring container
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

		// get membershipdao object
		MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

		// call the business method
		accountDAO.addAccount();
		accountDAO.doWork(true);
		
		accountDAO.setName("Bank");
		accountDAO.setServiceID(1);
		
		System.out.println("Account DAO: "+accountDAO);

		// call the business method for membership object
		membershipDAO.addAccount();
		membershipDAO.goToSleep();

		// close the context
		context.close();

	}

}
