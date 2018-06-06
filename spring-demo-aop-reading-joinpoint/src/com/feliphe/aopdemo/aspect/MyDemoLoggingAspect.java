package com.feliphe.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.feliphe.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

	// this is where we added all of our related advices for logging

	// let's start with @Before advice

	@Before("com.feliphe.aopdemo.aspect.AopDeclarations.forDaoPackageNoGetterSetter()") // execute this method BEFORE
	// addAccount()
	public void beforeAddAccountAdvice(JoinPoint jPoint) {
		System.out.println("\n======>>> Executing @Before advice on add*()");

		// display method signature
		MethodSignature nMethodSignature = (MethodSignature) jPoint.getSignature();
		System.out.println(nMethodSignature);

		// display method arguments
		Object[] args = jPoint.getArgs();

		for (Object tempArg : args) {
			System.out.println(tempArg);
			if (tempArg instanceof Account) {
				Account account = (Account) tempArg;
				System.out.println("Account name: " + account.getName());
				System.out.println("Account level: " + account.getLevel());
			}
		}
	}

}