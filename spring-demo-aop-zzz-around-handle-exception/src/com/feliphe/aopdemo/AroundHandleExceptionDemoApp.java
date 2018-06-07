package com.feliphe.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.feliphe.aopdemo.service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp {
	private static Logger myLogger = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		TrafficFortuneService fService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

		myLogger.info("Calling getFortune()");

		boolean tripWire = true;
		String data = fService.getFortune(tripWire);

		myLogger.info(data);

		context.close();
	}

}
