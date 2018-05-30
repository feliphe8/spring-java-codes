package com.feliphe.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Coach coach = context.getBean("tennisCoach", Coach.class);
		// Coach coach2 = context.getBean("tennisCoach", Coach.class);

		System.out.println(coach);
		// System.out.println(coach2);

		context.close();

	}

}
