package com.sparkies.spark;

import com.sparkies.spark.service.InitParkDBList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;


@SpringBootApplication
@ComponentScan
public class SparkApplication {
//	@Autowired
//	InitParkDBList initializer;

	public static void main(String[] args) {
		SpringApplication.run(SparkApplication.class, args);



	}

}
