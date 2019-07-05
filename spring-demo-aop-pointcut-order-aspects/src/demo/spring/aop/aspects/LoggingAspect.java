package demo.spring.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(20)
public class LoggingAspect {

	@Before("demo.spring.aop.aspects.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeLoggingAdvice() {
		System.out.println("\n======> Aspect @Before |Logging for server| DAO method =========");
	}
}
