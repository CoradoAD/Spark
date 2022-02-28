package com.sparkies.spark.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sparkies.spark.exception.ErrorEnergy;
import com.sparkies.spark.model.User;
import com.sparkies.spark.repository.UserRepo;
import com.sparkies.spark.service.GainSparkService;
import com.sparkies.spark.service.impl.GainSparkServiceImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/users")
public class UserControllerRest {
	
	@Autowired
	UserRepo userRepo;
	

	

	
	@GetMapping
	public Iterable<User> getAll() {
		return userRepo.findAll();
	}
	
	@CrossOrigin(origins = "*")
	@PatchMapping("{id}")
	public User update(@RequestBody User user, @PathVariable("id") Long uid) throws ErrorEnergy  {
		

                 user = userRepo.findById(uid).get();
                 user.setNumberOfSparks(user.getNumberOfSparks());
                 return userRepo.save(user);
                 
                 
                 
        

	
	}

}
