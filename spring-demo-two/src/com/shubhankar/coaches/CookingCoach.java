package com.shubhankar.coaches;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.shubhankar.spring.interfaces.CoachInterface;
import com.shubhankar.spring.interfaces.FortuneInterface;

@Component
public class CookingCoach implements CoachInterface {
	private FortuneInterface fortuneService;
	
	@Value("${cooking.coachname}")
	private String coachName;
	
	@Value("${cooking.coachemail}")
	private String coachEmail;
	
	@Value("100200300400")
	private String coachNumber;
	
	// an example of constructor injection
	@Autowired
	public CookingCoach(
			@Qualifier("goodFortuneService")
			FortuneInterface service
			) {
		this.fortuneService = service;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Chop 20 kg of onions today";
	}

	public String getFortune() {
		return this.fortuneService.getDailyFortune();
	}
	
	public String getCoachDetails() {
		return this.coachEmail + ", " + this.coachName + ", " + this.coachNumber;
	}
}
