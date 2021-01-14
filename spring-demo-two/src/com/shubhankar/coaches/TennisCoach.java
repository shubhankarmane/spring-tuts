package com.shubhankar.coaches;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.shubhankar.spring.interfaces.CoachInterface;
import com.shubhankar.spring.interfaces.FortuneInterface;

@Component("tennisCoach")
public class TennisCoach implements CoachInterface {
	private FortuneInterface fortune;
	
	@Autowired
	@Qualifier("goodFortuneService")
	public void setFortuneService(FortuneInterface service) {
		this.fortune  = service;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}
	
	public String getFortune() {
		return this.fortune.getDailyFortune();
	}

}
