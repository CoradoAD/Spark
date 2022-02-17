package com.sparkies.spark;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.sparkies.spark.service.ZoneService;

import java.io.IOException;

import javax.transaction.Transactional;

@SpringBootApplication
@ComponentScan
public class SparkApplication {

	@Autowired
	ZoneService zoneService;

	public static void main(String[] args) throws IOException {
		SpringApplication.run(SparkApplication.class, args);

	}

	@Transactional
	public void run(String... args) throws Exception {
 
//      Zone zone1  = new Zone();
//      zone1.setNameZone("Proximité");
//      zone1.setMinute(5);
//      
//      Zone zone2  = new Zone();
//      zone2.setNameZone("Centre-ville");
//      zone2.setMinute(7);
//      
//      Zone zone3 = new Zone();
//      zone3.setNameZone("Parc relais");
//      zone3.setMinute(9);
//      
//      zoneService.saveDataZone(zone1);
//      zoneService.saveDataZone(zone2);
//      zoneService.saveDataZone(zone3);
//      
	}
}
