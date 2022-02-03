package com.sparkies.spark;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sparkies.spark.model.Energy;
import com.sparkies.spark.model.TypeVehicle;
import com.sparkies.spark.model.Vehicle;
import com.sparkies.spark.model.Zone;
import com.sparkies.spark.repository.UserRepo;
import com.sparkies.spark.service.EmissionService;

@SpringBootTest
class TestEmissionService {

	@Autowired
	private EmissionService emissionService;

	@Autowired
	UserRepo userRepo;

	@Test
	public void TestCarbonFootprintByConso() {

		Vehicle vehicule = new Vehicle(null, 100, TypeVehicle.voiture);
		Energy energy = new Energy(null, "Diesel", 2392);

		vehicule.setEnergy(energy);

		double result = emissionService.carbonFootprintByConso(vehicule);
		assertEquals(2392, result, 0);
	}

	@Test
	public void TestemissionConsumedByRoute() {

		Vehicle vehicule = new Vehicle();
		Energy energy = new Energy(null, "thermique standard", 193);

		vehicule.setEnergy(energy);
		double result = emissionService.emissionConsumedByRoute(4, vehicule);
		assertEquals(772, result, 0);

	}

	@Test
	public void TestdistanceLookForPark() {

		Zone zone = new Zone();
		zone.setMinute(7); // minute
		double result = emissionService.distanceLookForPark(zone);
		assertEquals(20, result, 0);

	}

}
