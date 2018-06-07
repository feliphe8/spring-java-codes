package com.feliphe.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.feliphe.aopdemo.Account;

@Component
public class AccountDAO {

	private String name;
	private String serviceCode;

	public void addAccount(Account account, boolean vipFlag) {
		System.out.println(getClass() + " inside addAccount() method.");
	}

	public List<Account> findAccounts(boolean tripWire) {

		// simulate exception
		if (tripWire) {
			throw new RuntimeException("RunTime Exception");
		}

		List<Account> accounts = new ArrayList<>();
		Account temp1 = new Account("John", "Silver");
		Account temp2 = new Account("Madhu", "Platinum");
		Account temp3 = new Account("Luca", "Gold");
		accounts.add(temp1);
		accounts.add(temp2);
		accounts.add(temp3);

		return accounts;
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
