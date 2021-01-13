package com.shubhankar.spring.coaches;

import com.shubhankar.spring.interfaces.CoachInterface;

public class TrackCoach implements CoachInterface{

    @Override
    public String getDailyWorkout() {
        return "Run 2 kilometers today!";
    }
    
}
