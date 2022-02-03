package com.sparkies.spark.service;

import com.sparkies.spark.model.User;

public interface GainSparkService {

	public int getGainSpark(User user);
	
	public int calGainSpark(Double emission);
	
	public void saveGainSpark(User user,int spark);
}
