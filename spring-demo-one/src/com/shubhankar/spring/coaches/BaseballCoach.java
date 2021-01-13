package com.shubhankar.spring.coaches;

import com.shubhankar.spring.interfaces.CoachInterface;
import com.shubhankar.spring.interfaces.FortuneInterface;

public class BaseballCoach implements CoachInterface{
    private FortuneInterface fortuneService;
    
    public void setFortuneService(FortuneInterface service) {
    	fortuneService = service;
    }
    
    @Override
    public String getDailyWorkout() {
        return "Practice bowling";
    }
    
    public String getFortune() {
    	return fortuneService.getDailyFortune();
    }
}
