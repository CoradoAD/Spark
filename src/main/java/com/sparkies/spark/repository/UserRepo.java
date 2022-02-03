package com.sparkies.spark.repository;

import org.springframework.data.repository.CrudRepository;

import com.sparkies.spark.model.Energy;
import com.sparkies.spark.model.User;

public interface UserRepo extends CrudRepository<User, Long> {

}
