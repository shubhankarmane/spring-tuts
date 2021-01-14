package com.shubhankar.coaches;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.shubhankar.spring.interfaces.CoachInterface;
import com.shubhankar.spring.interfaces.FortuneInterface;

@Component
@Scope("singleton") // Note that the scope is singleton by default so no need to specify singleton
public class CodingCoach implements CoachInterface {

	@Autowired
	@Qualifier("badFortuneService")
	private FortuneInterface fortune;
	
	@Override
	public String getDailyWorkout() {
		return "Practice linked lists today";
	}
	
	public String getFortune() {
		return this.fortune.getDailyFortune();
	}
	
	@PostConstruct
	public void postInit() {
		System.out.println("Custom post init method");
	}
	
	@PreDestroy
	public void preDestroy() {
		System.out.println("Custom pre destroy method");
	}
}
