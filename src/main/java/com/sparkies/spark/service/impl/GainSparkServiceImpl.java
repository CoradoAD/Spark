
package com.sparkies.spark.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sparkies.spark.model.User;
import com.sparkies.spark.repository.UserRepo;
import com.sparkies.spark.service.GainSparkService;

@Service
public class GainSparkServiceImpl implements GainSparkService {
	
	@Autowired
	UserRepo userRepo;

	/**
	 * Get gain spark of user
	 */
	@Override
	public int getGainSpark(User user) {
		
		return user.getNumberOfSparks();
	}

	/**
	 * Method to calculate the gain Spark from emission carbon
	 */
	@Override
	public int calGainSpark(int emissionCarbon) {
		
		int cal =  (int) Math.ceil(emissionCarbon / 100);
		return cal;
	}

	/**
	 * Save the gain Spark in the DB 
	 */
	@Override
	public void saveGainSpark(User user, int gainSpark) {
		
		int gainDB = user.getNumberOfSparks();
		user.setNumberOfSparks(gainSpark + gainDB);
		userRepo.save(user);
	}
}


