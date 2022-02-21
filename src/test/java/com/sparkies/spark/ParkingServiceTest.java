package com.sparkies.spark;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sparkies.spark.model.Parking;
import com.sparkies.spark.service.ParkingDisponibilityService;

@SpringBootTest
public class ParkingServiceTest {
	@Autowired
	ParkingDisponibilityService parkingService;
	@Test
	void contextLoads() {
	}
	@Test
	public void testGetAllParking() {
		List<Parking> parkingList=parkingService.getAllParking();
		assertEquals(22,parkingList.size());
		assertTrue(parkingList.get(0).getFreeCapacity()>=0);
		System.out.println("Nb parking dispo "+ parkingList.get(0).getFreeCapacity());
	}

	@Test
	public void testgetParkingAproximiteNonTrouve() {

		// creation données de test pour effectuer le
		Double refLat=43.610769;
		Double refLong=3.876716;

		List<Parking> parkingList=parkingService.getParkingList(3.876716, 43.610769, 1.0);
		assertEquals(10,parkingList.size());
		assertTrue(parkingList.get(0).getFreeCapacity()>=0);
		System.out.println("Nb parking dispo "+ parkingList.get(0).getFreeCapacity());
	}
	@Test
	public void testdetParkingAproximiteTrouve() {

		// creation données de test pour effectuer le
		Double refLat=43.610769;
		Double refLong=3.876716;
		List<Parking> parkingList=parkingService.getParkingList(3.876716, 43.610769, 10.0);
		assertEquals(22,parkingList.size());
		assertTrue(parkingList.get(0).getFreeCapacity()>=0);
		System.out.println("Nb parking dispo "+ parkingList.get(0).getFreeCapacity());
	}
}
