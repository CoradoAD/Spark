package com.sparkies.spark;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sparkies.spark.model.User;
import com.sparkies.spark.service.GainSparkService;

@SpringBootTest
class TestGainSpark {
	
	@Autowired
	private GainSparkService gainSparkService;

	@Test
	void test() {
		
		User user = new User();
		
		user.setNumberOfSparks(70);
		int result = gainSparkService.getGainSpark(user);
		assertEquals(70, result);
		
	}
}
