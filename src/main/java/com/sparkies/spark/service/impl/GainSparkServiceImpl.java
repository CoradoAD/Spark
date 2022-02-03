package com.sparkies.spark.service.impl;

import org.springframework.stereotype.Service;

import com.sparkies.spark.model.User;
import com.sparkies.spark.service.GainSparkService;

@Service
public class GainSparkServiceImpl implements GainSparkService {

	@Override
	public int getGainSpark(User user) {
		return user.getNumberOfSparks();
	}

	@Override
	public int calGainSpark(Double emissionCarbon) {
		int cal = (int) Math.ceil(emissionCarbon / 100);
		return cal;
	}

	@Override
	public void saveGainSpark(User user, int gainSpark) {

		user.setNumberOfSparks(gainSpark);

	}
}
