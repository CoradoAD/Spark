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
}
