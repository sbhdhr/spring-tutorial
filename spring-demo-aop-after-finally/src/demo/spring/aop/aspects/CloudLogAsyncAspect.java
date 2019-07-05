package demo.spring.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(10)
public class CloudLogAsyncAspect {

	@Before("demo.spring.aop.aspects.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeCloudSyncAdvice() {
		System.out.println("\n======> Aspect @Before |Cloud Sync| Async process =========");
	}

}
