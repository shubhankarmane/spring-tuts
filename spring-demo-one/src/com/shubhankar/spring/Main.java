package com.shubhankar.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shubhankar.spring.coaches.BaseballCoach;
import com.shubhankar.spring.coaches.CricketCoach;
import com.shubhankar.spring.coaches.SleepCoach;
import com.shubhankar.spring.interfaces.CoachInterface;

public class Main {
    public static void main(String[] args) throws Exception{
        // POJO - Hard coded coach implementation
        CoachInterface coach = new BaseballCoach();
        System.out.println(coach.getDailyWorkout());
        
        System.out.println("--Track coach start--");
        
        // Using spring's applicationContext to get the object. What we get is bean which is also like a java object
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("./applicationContext.xml");
        CoachInterface trackCoach = context.getBean("trackCoach", CoachInterface.class);
        System.out.println(trackCoach.getDailyWorkout());
        context.close();
        
        System.out.println("--Track coach end--");
        
        System.out.println("--Sleep coach start--");
        
        // Dependency injection demo, here, we are making use of constructor injection to inject in the dependency
        ClassPathXmlApplicationContext contextTwo = new ClassPathXmlApplicationContext("./applicationContext.xml");
        CoachInterface sleepCoach = contextTwo.getBean("sleepCoach", CoachInterface.class);
        System.out.println(sleepCoach.getDailyWorkout());
        System.out.println(
        		((SleepCoach) sleepCoach).getFortune()
        );
        contextTwo.close();
        
        System.out.println("--Sleep coach end--");
        
        System.out.println("--Baseball coach start--");
        
        // Another dependency injection demo, here, we are making use of setter injection
        ClassPathXmlApplicationContext contextThree = new ClassPathXmlApplicationContext("./applicationContext.xml");
        CoachInterface baseballCoach = contextThree.getBean("baseballCoach", CoachInterface.class);
        System.out.println(
        		((BaseballCoach) baseballCoach).getFortune()
        );
        contextThree.close();
        System.out.println("--Baseball coach end--");
        
        System.out.println("--Cricket coach end--");
        
        // Injecting literal values demo
        ClassPathXmlApplicationContext contextFour = new ClassPathXmlApplicationContext("./applicationContext.xml");
        CoachInterface cricketCoach = contextFour.getBean("cricketCoach", CoachInterface.class);
        System.out.println(
        		((CricketCoach) cricketCoach).coachDetails()
        );
        contextFour.close();
        System.out.println("--Cricket coach end--");
        
        // Example of beans with singleton scope
        ClassPathXmlApplicationContext contextFive = new ClassPathXmlApplicationContext("./applicationContext.xml");
        CoachInterface spongebob = contextFive.getBean("trackCoach", CoachInterface.class);
        CoachInterface patrick = contextFive.getBean("trackCoach", CoachInterface.class);    
        // By default, the scope for the beans will be singleton which means the trackCoach object/bean will be a shared one. Let's verify
        System.out.println("Address of spongebob: "+spongebob+", "+"Address of patrick: "+patrick);
        System.out.println("Does spongebob's address match patrick's? "+(boolean)(spongebob == patrick));
        // as you can see the String representation of the object in memory is same
        // let us take another example
        CoachInterface bart = contextFive.getBean("tennisCoach", CoachInterface.class);
        CoachInterface homer = contextFive.getBean("tennisCoach", CoachInterface.class);
        System.out.println("Address of bart: "+bart+", "+"Address of homer: "+homer);
        System.out.println("Does bart's address match homer's? "+(boolean)(bart == homer));
        contextFive.close();
        
        // Using custom init and destroy methods
        ClassPathXmlApplicationContext contextSix = new ClassPathXmlApplicationContext("./applicationContext.xml");
        CoachInterface headlessCoach = contextSix.getBean("headlessCoach", CoachInterface.class);
        headlessCoach.getDailyWorkout();
        contextSix.close();
        // note that you'll see custom init and destroy for every object here. If you don't want that, then use a different configuration file. Also if you use prototype
        // then the custom destroy method won't be so straightforward.
        
    }
}