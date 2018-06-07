package com.feliphe.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.feliphe.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		TrafficFortuneService fService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

		System.out.println("Calling getFortune()");

		String data = fService.getFortune();

		System.out.println(data);

		context.close();
	}

}
