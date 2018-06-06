package com.feliphe.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// this is where we added all of our related advices for logging

	// let's start with @Before advice

	@Pointcut("execution(* com.feliphe.aopdemo.dao.*.*(..))") // pointcut declaration
	private void forDaoPackage() {
	}

	@Pointcut("execution(* com.feliphe.aopdemo.dao.*.get*(..))") // pointcut declaration
	private void getter() {
	}

	@Pointcut("execution(* com.feliphe.aopdemo.dao.*.set*(..))") // pointcut declaration
	private void setter() {
	}

	// Apply Advice for all methods in package EXCEPT getters and setters
	@Pointcut("forDaoPackage() && !(getter() || setter())") // pointcut declaration
	private void forDaoPackageNoGetterSetter() {
	}

	@Before("forDaoPackageNoGetterSetter()") // execute this method BEFORE
	// addAccount()
	public void beforeAddAccountAdvice() {
		System.out.println("\n======>>> Executing @Before advice on add*()");
	}

	@Before("forDaoPackageNoGetterSetter()")
	public void performApiAnalytics() {
		System.out.println("\n==========>>> Perfoming API Analytics method.");
	}

}