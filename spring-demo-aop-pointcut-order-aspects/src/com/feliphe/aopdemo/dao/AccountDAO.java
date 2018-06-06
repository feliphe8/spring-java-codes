package com.feliphe.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.feliphe.aopdemo.Account;

@Component
public class AccountDAO {

	private String name;
	private String serviceCode;

	public void addAccount(Account account, boolean vipFlag) {
		System.out.println(getClass() + " inside addAccount() method.");
	}

	public String doStuff() {
		return "Hey Buddy.";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

}
