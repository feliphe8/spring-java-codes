package com.feliphe.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"beanLifeCycle-applicationContext2.xml");
		Coach coach = context.getBean("myCoach", Coach.class);

		System.out.println(coach.getDailyWorkout());

		context.close();
	}

}
