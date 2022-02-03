package com.sparkies.spark;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sparkies.spark.model.api.Park;
import com.sparkies.spark.service.IParkAPIReader;

@SpringBootTest
public class ParkAPIReaderTest {
	@Autowired
	IParkAPIReader reader;
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

	@Test
	public void testParkAPI_uri() {
		Park park=reader.readPark("https://data.montpellier3m.fr/sites/default/files/ressources/","FR_MTP_TRIA.xml");
		assertEquals(park.getName(),"Triangle");
		System.out.println("Nom Parking: "+park.getName());
		System.out.println("Nb Places libres: "+park.getFree());
		System.out.println("Nb total: "+park.getTotal());
	
	
	}
	
	
}
