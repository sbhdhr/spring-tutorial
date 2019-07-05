package demo.spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import demo.spring.aop.dao.AccountDAO;

public class AfterReturningDemo {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);

		// get the bean from spring container
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
 
		
		//call method to find accounts
		accountDAO.findAccounts();
		
		// close the context
		context.close();

	}

}
