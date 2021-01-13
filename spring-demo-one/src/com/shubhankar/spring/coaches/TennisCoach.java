package com.shubhankar.spring.coaches;

import com.shubhankar.spring.interfaces.CoachInterface;

public class TennisCoach implements CoachInterface {

	@Override
	public String getDailyWorkout() {
		return "Practice swings today";
	}

}
