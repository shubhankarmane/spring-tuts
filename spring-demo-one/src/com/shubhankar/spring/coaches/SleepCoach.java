package com.shubhankar.spring.coaches;

import com.shubhankar.spring.interfaces.CoachInterface;
import com.shubhankar.spring.interfaces.FortuneInterface;

public class SleepCoach implements CoachInterface {
	
	private FortuneInterface fortuneService;
	
	public SleepCoach(FortuneInterface service) {
		fortuneService = service;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Just sleep!";
	}

	public String getFortune() {
		return fortuneService.getDailyFortune();
	}
}
