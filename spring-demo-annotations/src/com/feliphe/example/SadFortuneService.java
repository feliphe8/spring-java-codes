package com.feliphe.example;

public class SadFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Today IS NOT your lucky day! Loser :^D";
	}

}
