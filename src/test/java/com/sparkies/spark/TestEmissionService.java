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

	
	@Test
	public void TestdistanceLookForPark() { //distance traveled by a user looking for a carpark
		
		Zone zone = new Zone();
		zone.setMinute(7); // minute
		double result = emissionService.distanceLookForPark(zone); //distance traveled when a person is looking for a carpark
		assertEquals(20, result, 0);
	}

	@Test
	public void TestCarbonFootprintByConso() {

		Vehicle vehicule = new Vehicle(null, 5, TypeVehicle.voiture);
		Energy energy = new Energy(null, "Diesel", 2392);
		vehicule.setEnergy(energy);
		double result = emissionService.carbonFootprintByConso(vehicule); //Give a carbonFootprint of vehicule
		assertEquals(120, result, 0);
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
	public void TestemissionConsumedByRoutePerso() {
		
		double result =  emissionService.emissionConsumedByRoutePerso(4, 120);
		assertEquals(480, result, 0);
	}
}
