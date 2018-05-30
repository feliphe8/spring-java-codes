package com.feliphe.example;

public class TrackCoach implements Coach {

	private FortuneService fortuneService;

	public TrackCoach() {
	}

	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k.";
	}

	@Override
	public String getDailyFortune() {
		return "Just Do It! " + fortuneService.getFortune();
	}

	// add an init method

	public void init() {
		System.out.println("Startup STUFF!");
	}

	// add a destroy method
	public void destroy() {
		System.out.println("Destroy method");
	}

}
