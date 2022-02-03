package com.sparkies.spark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sparkies.spark.controller.rest.VehicleControllerRest;
import com.sparkies.spark.model.Vehicle;

@SpringBootApplication
public class SparkApplication {

	public static void main(String[] args) {
		SpringApplication.run(SparkApplication.class, args);
		
	}

}
