package com.feliphe.example;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
// @Scope("prototype") - prototype scope não tem metodo @predestroy
public class TennisCoach implements Coach {

	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;

	public TennisCoach() {
	}

	// @Autowired
	// public TennisCoach(FortuneService fortuneService) {
	// this.fortuneService = fortuneService;
	// }

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley.";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	@PostConstruct
	public void init() {
		System.out.println(">> init() method called.");
	}

	@PreDestroy
	public void destroy() {
		System.out.println(">> destroy() method called");
	}

	// @Autowired
	// public void setFortuneService(FortuneService fortuneService) {
	// this.fortuneService = fortuneService;
	// }

}
