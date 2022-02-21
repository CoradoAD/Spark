package com.sparkies.spark;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sparkies.spark.model.api.Park;
import com.sparkies.spark.service.ParkAPIReader;

@SpringBootTest
public class ParkAPIReaderTest {
	@Autowired
	ParkAPIReader reader;
	@Test
	void contextLoads() {
	}
	
	@Test
	public void testParkAPI() {
		Park park=reader.readPark("https://data.montpellier3m.fr/sites/default/files/ressources/FR_MTP_TRIA.xml");
		assertEquals(park.getName(),"Triangle");
		System.out.println("Nom Parking: "+park.getName());
		System.out.println("Nb Places libres: "+park.getFree());
		System.out.println("Nb total: "+park.getTotal());
	}
	
	
	
	
}
