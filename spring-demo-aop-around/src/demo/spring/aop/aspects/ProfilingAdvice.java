package demo.spring.aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(40)
public class ProfilingAdvice {

	@Around("demo.spring.aop.aspects.AopExpressions.forServiceGetFotune()")
	public Object aroundGetFortuneAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		
		//print out method we are advising on 
		String method = proceedingJoinPoint.getSignature().toLongString();
		System.out.println("\n==> Aspect @Around method:|" + method + "|");
		
		
		//get begin timestamp 
		long begin = System.currentTimeMillis();
		
		
		//now, let 's execute the method 
		Object result = proceedingJoinPoint.proceed();
		
		//get end timestamp
		long end = System.currentTimeMillis();
		
		//compute duration and display it 
		System.out.println("\n==> Duration: " + (end-begin)/1000.0 + "sec");
		
		
		return result;
	}
	
	

}
