package com.shubhankar.coaches;

import org.springframework.beans.factory.annotation.Value;

import com.shubhankar.interfaces.Coach;
import com.shubhankar.interfaces.Fortune;

public class MathCoach implements Coach {

	private Fortune fortunes;
	
	@Value("${mathcoach.name}")
	private String coachName;
	
	@Value("${mathcoach.email}")
	private String coachEmail;
	private String[] workouts = {
			"",
			"Practice trigonometry today",
			"Learn tables upto 30 by heart",
			"Practice mental calculation today"
	};
	
	public MathCoach(Fortune fortuneProvider) {
		this.fortunes = fortuneProvider;
	}
	
	@Override
	public String getDailyWorkout() {
		return this.workouts[ (int) Math.ceil(Math.random() * this.workouts.length - 1)];
	}
	
	public String getDailyFortune() {
		return this.fortunes.getFortune();
	}
	
	public String getCoachDetails() {
		return "Email: " + coachEmail + ", Name: " + coachName;
	}
}
