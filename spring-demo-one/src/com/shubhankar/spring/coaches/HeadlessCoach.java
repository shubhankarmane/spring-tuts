package com.shubhankar.spring.coaches;

import com.shubhankar.spring.interfaces.CoachInterface;

public class HeadlessCoach implements CoachInterface {

	@Override
	public String getDailyWorkout() {
		return "Do nothing";
	}
	
	public void customInit() {
		System.out.println("Custom Init!");
	}

	public void customDestroy() {
		System.out.println("Custom Destroy!");
	}
}
