package com.feliphe.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	private static Logger myLogger = Logger.getLogger(MyDemoLoggingAspect.class.getName());

	// this is where we added all of our related advices for logging

	// let's start with @Before advice

	@Before("com.feliphe.aopdemo.aspect.AopDeclarations.forDaoPackageNoGetterSetter()") // execute this method BEFORE
	// addAccount()
	public void beforeAddAccountAdvice(JoinPoint jPoint) {
		myLogger.info("\n======>>> Executing @Before advice on add*()");

		// display method signature
		MethodSignature nMethodSignature = (MethodSignature) jPoint.getSignature();
		myLogger.info(nMethodSignature.toString());

		// display method arguments
		Object[] args = jPoint.getArgs();

		for (Object tempArg : args) {
			myLogger.info(tempArg.toString());
			if (tempArg instanceof Account) {
				Account account = (Account) tempArg;
				myLogger.info("Account name: " + account.getName());
				myLogger.info("Account level: " + account.getLevel());
			}
		}
	}

	// add a new advice for AfterReturning findAccounts()
	@AfterReturning(pointcut = "execution(* com.feliphe.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "results")
	public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> results) {
		String method = joinPoint.getSignature().toString();
		myLogger.info("\n=======>>>>> Executing AfterReturning on method: " + method);
		myLogger.info("\n Return: " + results);

		// let's post-process the data
		convertAccountNamesToUpperCase(results);
		myLogger.info(results.toString());
	}

	private void convertAccountNamesToUpperCase(List<Account> results) {

		for (Account account : results) {
			String upperName = account.getName().toUpperCase();
			account.setName(upperName);
		}

	}

	@AfterThrowing(pointcut = "execution(* com.feliphe.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "exception")
	public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exception) {
		myLogger.info("\n====>>> Executing @AfterThrowing: " + joinPoint.getSignature().toString());
		myLogger.info("\nThe exception is: " + exception);
	}

	@After("execution(* com.feliphe.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
		myLogger.info("\n====>>> Executing @After(finally): " + joinPoint.getSignature().toString());
	}

	@Around("execution(* com.feliphe.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		// print out the method we're advising on
		myLogger.info("\n====>>> Executing ADVICE @Around: " + proceedingJoinPoint.getSignature().toString());

		// get begin timestamp
		long begin = System.currentTimeMillis();

		// execute the method
		Object result = null;
		try {
			result = proceedingJoinPoint.proceed();
		} catch (Exception e) {
			myLogger.warning(e.getMessage());
			// rethrow exception
			throw e;
		}

		// get ent timestamp
		long end = System.currentTimeMillis();

		// compute duration and display it
		long duration = end - begin;
		myLogger.info("\n=====>>> Duration: " + duration / 1000.0 + "s"); // convert milliseconds to seconds

		return result;
	}

}