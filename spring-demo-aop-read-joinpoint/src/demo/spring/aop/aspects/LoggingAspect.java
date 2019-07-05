package demo.spring.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(20)
public class LoggingAspect {

	@Before("demo.spring.aop.aspects.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeLoggingAdvice(JoinPoint joinPoint) {
		System.out.println("\n======> Aspect @Before |Logging for server| DAO method =========");

		// display method signature
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

		System.out.println("Method: " + methodSignature);

		// display method arguments

		Object args[] = joinPoint.getArgs();

		System.out.println("Method arguments:");
		for (Object temp : args) {
			System.out.print(temp + "\t");
		}

	}
}
