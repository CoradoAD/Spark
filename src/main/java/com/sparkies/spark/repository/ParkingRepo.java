package com.sparkies.spark.repository;

import org.springframework.data.repository.CrudRepository;

import com.sparkies.spark.model.Parking;

public interface ParkingRepo extends CrudRepository<Parking, Integer> {

}
