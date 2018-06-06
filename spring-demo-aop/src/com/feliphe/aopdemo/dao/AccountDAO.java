package com.feliphe.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.feliphe.aopdemo.Account;

@Component
public class AccountDAO {

	public void addAccount(Account account, boolean vipFlag) {
		System.out.println(getClass() + " inside addAccount() method.");
	}

	public String doStuff() {
		return "Hey Buddy :^D";
	}
}
