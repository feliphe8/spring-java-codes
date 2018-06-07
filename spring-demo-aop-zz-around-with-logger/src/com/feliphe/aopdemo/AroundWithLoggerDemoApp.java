package com.feliphe.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.feliphe.aopdemo.service.TrafficFortuneService;

public class AroundWithLoggerDemoApp {
	private static Logger myLogger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		TrafficFortuneService fService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

		myLogger.info("Calling getFortune()");

		String data = fService.getFortune();

		myLogger.info(data);

		context.close();
	}

}
