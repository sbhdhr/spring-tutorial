package demo.spring.aop.aspects;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import demo.spring.aop.dao.AccountDAO;

@Aspect
@Component
@Order(20)
public class LoggingAspect {

	@AfterThrowing(pointcut = "execution(* demo.spring.aop.dao.AccountDAO.findAccounts(..))", throwing = "ex")
	public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable ex) {
		String method = joinPoint.getSignature().toLongString();
		System.out.println("\n==> Aspect @AfterThrowing method:|" + method + "|");

		// get current date time
		Date date = new Date();
		String strDateFormat = "yyyy-M-dd HH:mm:ss.SSS";
		DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
		String formattedDate = dateFormat.format(date);

		System.out.println(formattedDate + ":Exception: " + ex);
	}

	// add new advice for @AfterReturning on findAccounts method
	@AfterReturning(pointcut = "execution(* demo.spring.aop.dao.AccountDAO.findAccounts(..))", returning = "result")
	public void afterFindAccountsAdvice(JoinPoint joinPoint, List<AccountDAO> result) {
		String method = joinPoint.getSignature().toLongString();
		System.out.println("\n==> Aspect @AfterReturning method:|" + method + "|");
		System.out.println("The result in aspect method is: " + result);

		// modify data
		if (result != null) {
			for (AccountDAO temp : result) {
				temp.setName(temp.getName().toUpperCase());
			}
		}
	}

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
