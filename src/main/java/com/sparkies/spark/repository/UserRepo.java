package com.sparkies.spark.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sparkies.spark.model.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {
	Optional<User> findByUsername(String username);

	Optional<User> findByUserEmail(String useremail);

	Boolean existsByUsername(String username);

	Boolean existsByUserEmail(String userEmail);
}
