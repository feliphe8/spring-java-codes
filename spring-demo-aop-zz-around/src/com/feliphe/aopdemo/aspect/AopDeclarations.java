package com.feliphe.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(-1)
public class AopDeclarations {
	@Pointcut("execution(* com.feliphe.aopdemo.dao.*.*(..))") // pointcut declaration
	public void forDaoPackage() {
	}

	@Pointcut("execution(* com.feliphe.aopdemo.dao.*.get*(..))") // pointcut declaration
	public void getter() {
	}

	@Pointcut("execution(* com.feliphe.aopdemo.dao.*.set*(..))") // pointcut declaration
	public void setter() {
	}

	// Apply Advice for all methods in package EXCEPT getters and setters
	@Pointcut("forDaoPackage() && !(getter() || setter())") // pointcut declaration
	public void forDaoPackageNoGetterSetter() {
	}
}
