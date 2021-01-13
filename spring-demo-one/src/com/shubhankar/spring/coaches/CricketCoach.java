package com.shubhankar.spring.coaches;

import com.shubhankar.spring.interfaces.CoachInterface;

public class CricketCoach implements CoachInterface {
	
	private String coachName;
	private String teamName;
	private String email;
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setCoachName(String coachName) {
		this.coachName = coachName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	@Override
	public String getDailyWorkout() {
		return "Practice batting today";
	}
	
	public String coachDetails() {
		return coachName+", "+teamName+" "+email;
	}

}
