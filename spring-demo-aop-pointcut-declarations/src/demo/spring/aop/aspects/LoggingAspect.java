package demo.spring.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	@Pointcut("execution(* demo.spring.aop.dao.*.add*(..))")
	private void forDAOPackageAddMethod() {}
	
	@Pointcut("execution(* demo.spring.aop.dao.*.*(..))")
	private void performAPIAnalytics() {}
	
	@Before("performAPIAnalytics()")
	public void beforeAllAdvice() {
		System.out.println("\n======> Aspect @Before |Analytics|  =========");
	}
	
	@Before("forDAOPackageAddMethod()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n======> Aspect @Before |Logging for server| Add method =========");
	}
}
