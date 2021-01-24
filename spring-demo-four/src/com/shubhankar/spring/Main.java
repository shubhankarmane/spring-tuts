package com.shubhankar.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shubhankar.coaches.MathCoach;
import com.shubhankar.interfaces.Coach;
import com.shubhankar.spring.configuration.Config;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		Coach aCoach = context.getBean("getMathCoach", Coach.class);
		System.out.println(aCoach.getDailyWorkout());
		System.out.println(
				((MathCoach) aCoach).getCoachDetails()
				);
		context.close();
	}

}
