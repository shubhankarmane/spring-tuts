package com.shubhankar.spring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.shubhankar.coaches.MathCoach;
import com.shubhankar.fortuneservices.PleasantFortune;
import com.shubhankar.interfaces.Coach;
import com.shubhankar.interfaces.Fortune;

@Configuration
@PropertySource("classpath:mathcoach.properties")
public class Config {

	// this is the way to define beans in java code config.
	// this is also an example of constructor injection
	// the name of the method becomes the bean id
	@Bean
	public Coach getMathCoach() {
		return new MathCoach(fortuneProvider());
	}
	
	// this bean is a dependency of the above bean, it is not private because spring throws exception if I make it so
	@Bean
	public Fortune fortuneProvider() {
		return new PleasantFortune();
	}
}
