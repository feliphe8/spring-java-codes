package com.feliphe.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		Coach coach = context.getBean("myCoach", Coach.class);
		Coach alphaCoach = context.getBean("myCoach", Coach.class);

		// check if they are the same bean(object)
		boolean result = (coach == alphaCoach);

		System.out.println(result);

		System.out.println(coach);

		System.out.println(alphaCoach);

		context.close();
	}

}
