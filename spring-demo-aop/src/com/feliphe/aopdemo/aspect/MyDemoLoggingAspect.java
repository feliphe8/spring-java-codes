package com.feliphe.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// this is where we added all of our related advices for logging

	// let's start with @Before advice

	@Before("execution(* com.feliphe.aopdemo.dao.*.add*(..))") // execute this method BEFORE
	// addAccount()
	public void beforeAddAccountAdvice() {
		System.out.println("\n======>>> Executing @Before advice on add*()");
	}

}
