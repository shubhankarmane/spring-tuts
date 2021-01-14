package com.shubhankar.services;

import org.springframework.stereotype.Component;

import com.shubhankar.spring.interfaces.FortuneInterface;

@Component
public class BadFortuneService implements FortuneInterface {

	@Override
	public String getDailyFortune() {
		return "You'll regret being born today";
	}

}
