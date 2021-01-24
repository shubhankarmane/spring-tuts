package com.shubhankar.fortuneservices;

import com.shubhankar.interfaces.Fortune;

public class PleasantFortune implements Fortune {

	private String[] fortunes = {
			"",
			"You shall meet the love of your life today",
			"You shall be promoted today",
			"Go for the stars, you shall definitely reach them!",
			"It is your time to shine now!"
	};
	
	@Override
	public String getFortune() {
		return this.fortunes[
		                    (int)Math.ceil(
		                    		Math.random() * this.fortunes.length - 1
		                    		)
		                    ];
	}

}		
