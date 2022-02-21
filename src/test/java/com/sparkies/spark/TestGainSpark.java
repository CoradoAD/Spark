
package com.sparkies.spark;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sparkies.spark.model.User;
import com.sparkies.spark.repository.UserRepo;
import com.sparkies.spark.service.GainSparkService;

@SpringBootTest
class TestGainSpark {

	@Autowired
	private GainSparkService gainSparkService;

	@Autowired
	UserRepo userRepo;

	@Test
	@Ignore
	void testGetGainSpark() {

		User user = new User();
		user.setNumberOfSparks(70);
		int result = gainSparkService.getGainSpark(user);
		assertEquals(70, result);
	}

	@Test
	@Ignore
	public void testCalGainSpark() {

		int result = gainSparkService.calGainSpark(540);
		assertEquals(5, result);
	}

	//	@Test
//	@Ignore
//	void testSaveGainSpark() {
//
//		User user = userRepo.findById(1L).get();
//		gainSparkService.saveGainSpark(user, 40);
//	}
}
=======
package com.sparkies.spark;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sparkies.spark.model.User;
import com.sparkies.spark.repository.UserRepo;
import com.sparkies.spark.service.GainSparkService;

@SpringBootTest
class TestGainSpark {

	@Autowired
	private GainSparkService gainSparkService;

	@Autowired
	UserRepo userRepo;


	@Test
	@Ignore
	public void testCalGainSpark() {

		int result = gainSparkService.calGainSpark(540);
		assertEquals(5, result);
	}

	//	@Test
//	@Ignore
//	void testSaveGainSpark() {
//
//		User user = userRepo.findById(1L).get();
//		gainSparkService.saveGainSpark(user, 40);
//	}
}

