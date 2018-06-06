package com.feliphe.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.feliphe.aopdemo.dao.AccountDAO;
import com.feliphe.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

		Account account = new Account();
		account.setName("Ana");
		account.setLevel("Pop Punk");

		accountDAO.addAccount(account, true);
		membershipDAO.addMembership();

		accountDAO.setName("Ana");
		accountDAO.setServiceCode("Pop Punk");

		System.out.println(accountDAO.getName());
		System.out.println(accountDAO.getServiceCode());

		System.out.println(accountDAO.doStuff());

		context.close();
	}

}
