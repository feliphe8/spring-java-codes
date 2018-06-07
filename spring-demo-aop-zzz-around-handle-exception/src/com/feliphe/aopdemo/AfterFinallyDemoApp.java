package com.feliphe.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.feliphe.aopdemo.dao.AccountDAO;

public class AfterFinallyDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		List<Account> accounts = null;
		try {
			boolean tripWire = true;
			accounts = accountDAO.findAccounts(tripWire);
		} catch (Exception e) {
			System.out.println("Main program: " + e);
		}

		System.out.println("\nMain Program - AfterThrowingDemoApp\n");
		System.out.println(accounts);
		System.out.println("\n");

		context.close();
	}

}
