package demo.spring.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

	@Pointcut("execution(* demo.spring.aop.dao.*.*(..))")
	public void forDAOPackageMethod() {
	}

	// create pointcut for getter methods
	@Pointcut("execution(* demo.spring.aop.dao.*.get*(..))")
	public void getter() {
	}

	// create pointcut for setter methods
	@Pointcut("execution(* demo.spring.aop.dao.*.set*(..))")
	public void setter() {
	}
	
	// create pointcut for toString methods
	@Pointcut("execution(* demo.spring.aop.dao.*.toString(..))")
	public void tostring() {
	}

	// create pointcut: include package . exclude getter/setter
	@Pointcut("forDAOPackageMethod() && !(getter()||setter()||tostring())")
	public void forDaoPackageNoGetterSetter() {
	}

}
