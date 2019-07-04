package demo.spring.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	//@Before("execution(public void addAccount())")
	
	//@Before("execution(public void demo.spring.aop.dao.MembershipDAO.addAccount())")
	
	//@Before("execution(* demo.spring.aop.dao.*.addAccount(..))")
	
	@Before("execution(* demo.spring.aop.dao.*.addAccount(..))")
	public void beforeAddAccountAdvice() {
		System.out.println("\n======> Aspect @Before |public void addAccount()| =========");
	}
}
