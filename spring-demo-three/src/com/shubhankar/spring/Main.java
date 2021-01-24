package com.shubhankar.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shubhankar.coaches.CodingCoach;
import com.shubhankar.coaches.CookingCoach;
import com.shubhankar.coaches.TennisCoach;
import com.shubhankar.spring.configuration.JavaConfig;
import com.shubhankar.spring.interfaces.CoachInterface;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
		System.out.println("-----Tennis Coach-----");
		CoachInterface tennisGuy = context.getBean("tennisCoach", CoachInterface.class);
		System.out.println(tennisGuy.getDailyWorkout());
		System.out.println(
				((TennisCoach) tennisGuy).getFortune()
				);
		
		CoachInterface cookingCoach = context.getBean("cookingCoach", CoachInterface.class);
		System.out.println("-----Cooking Coach-----");
		System.out.println(cookingCoach.getDailyWorkout());
		System.out.println(
				((CookingCoach) cookingCoach).getFortune()
				);
		System.out.println(
				((CookingCoach) cookingCoach).getCoachDetails()
				);
		
		CoachInterface codingCoach = context.getBean("codingCoach", CoachInterface.class);
		System.out.println("-----Coding Coach-----");
		System.out.println(codingCoach.getDailyWorkout());
		System.out.println(
				((CodingCoach) codingCoach).getFortune()
				);
		
		// Scope demo
		CoachInterface codingCoachTwo = context.getBean("codingCoach", CoachInterface.class);
		
		System.out.println(codingCoach == codingCoachTwo);
		// If the scope is singleton, the above line will print true else false
		context.close();
	}

}
