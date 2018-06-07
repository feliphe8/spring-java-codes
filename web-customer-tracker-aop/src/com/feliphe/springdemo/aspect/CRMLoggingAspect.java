package com.feliphe.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	// setup logger
	private Logger myLogger = Logger.getLogger(getClass().getName());

	// setup pointcut declarations
	@Pointcut("execution(* com.feliphe.springdemo.controller.*.*(..))")
	public void forControllerPackage() {
	}

	@Pointcut("execution(* com.feliphe.springdemo.service.*.*(..))")
	public void forServicePackage() {
	}

	@Pointcut("execution(* com.feliphe.springdemo.dao.*.*(..))")
	public void forDAOPackage() {
	}

	@Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
	private void forAppFlow() {
	}

	// add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint joinPoint) {
		String method = joinPoint.getSignature().toShortString();
		myLogger.info("=====>>> in @Before advice calling method: " + method);
		Object[] args = joinPoint.getArgs();
		for (Object arg : args) {
			myLogger.info("======>>> Argument: " + arg);
		}
	}

	// add @AfterReturning advice
	@AfterReturning(pointcut = "forAppFlow()", returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		String method = joinPoint.getSignature().toShortString();
		myLogger.info("=====>>> in @AfterReturning advice from method: " + method);
		myLogger.info("====>>> Result: " + result);
	}
}
