package com.shubhankar.services;

import org.springframework.stereotype.Component;

import com.shubhankar.spring.interfaces.FortuneInterface;

@Component
public class GoodFortuneService implements FortuneInterface {

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return "You shall make a lot of money today!!";
	}

}
