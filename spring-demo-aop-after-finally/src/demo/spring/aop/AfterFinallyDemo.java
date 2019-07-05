package demo.spring.aop;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import demo.spring.aop.dao.AccountDAO;

public class AfterFinallyDemo {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);

		// get the bean from spring container
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

		// add try catch block
		List<AccountDAO> accounts = null;
		try {
			accounts = accountDAO.findAccounts(false);
			System.out.println(accounts);
		} catch (Exception e) {
			System.out.println("Caught exception: " + e);
		}

		// close the context
		context.close();

	}

}
