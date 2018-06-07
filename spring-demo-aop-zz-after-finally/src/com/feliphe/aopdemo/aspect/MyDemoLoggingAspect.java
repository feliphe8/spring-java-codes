package com.feliphe.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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

	// add a new advice for AfterReturning findAccounts()
	@AfterReturning(pointcut = "execution(* com.feliphe.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "results")
	public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> results) {
		String method = joinPoint.getSignature().toString();
		System.out.println("\n=======>>>>> Executing AfterReturning on method: " + method);
		System.out.println("\n Return: " + results);

		// let's post-process the data
		convertAccountNamesToUpperCase(results);
		System.out.println(results);
	}

	private void convertAccountNamesToUpperCase(List<Account> results) {

		for (Account account : results) {
			String upperName = account.getName().toUpperCase();
			account.setName(upperName);
		}

	}

	@AfterThrowing(pointcut = "execution(* com.feliphe.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "exception")
	public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exception) {
		System.out.println("\n====>>> Executing @AfterThrowing: " + joinPoint.getSignature().toString());
		System.out.println("\nThe exception is: " + exception);
	}

	@After("execution(* com.feliphe.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
		System.out.println("\n====>>> Executing @After(finally): " + joinPoint.getSignature().toString());
	}

}