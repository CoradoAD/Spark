package com.sparkies.spark.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sparkies.spark.model.Energy;
import com.sparkies.spark.model.User;
import com.sparkies.spark.model.Vehicle;
import com.sparkies.spark.model.Zone;
import com.sparkies.spark.repository.UserRepo;
import com.sparkies.spark.repository.VehicleRepo;
import com.sparkies.spark.repository.ZoneRepo;
import com.sparkies.spark.service.EmissionService;

@Service
public class EmissionServiceImpl implements EmissionService {

	@Autowired
	ZoneRepo zoneRepo;

	@Autowired
	VehicleRepo vehicleRepo;

	@Autowired
	UserRepo userRepo;
	

	/**
	 * Allows you to calculate the distance traveled by a user looking for a carpark
	 * 
	 */
	@Override
	public double distanceLookForPark(Zone zone) {

		double time = Math.ceil((zone.getMinute() / 60) + 1); // result in hour
		double speed = 20;
		return speed * time;
	}

	/**
	 * 
	 */
	@Override
	public double emissionConsumedByRoute(int distanceKmDone, Vehicle vehicle) {

		Energy energy = vehicle.getEnergy();
		return energy.getCoefficient() * distanceKmDone;
	}

	// if the vehicle'energy of client is "Diesel or Essence"
	@Override
	public double carbonFootprintByConso(Vehicle vehicule) {

		double consomation = vehicule.getConsomation();
		Energy energy = vehicule.getEnergy();
		double coefficient = energy.getCoefficient();
		return Math.ceil(consomation * coefficient / 100);

	}
}
