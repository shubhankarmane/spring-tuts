package com.shubhankar.spring.services;

import com.shubhankar.spring.interfaces.FortuneInterface;

public class SimpleFortuneService implements FortuneInterface {

	@Override
	public String getDailyFortune() {
		return "You shall have good luck today";
	}

}
