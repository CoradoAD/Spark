package com.sparkies.spark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;


@SpringBootApplication
@ComponentScan
public class SparkApplication {


	public static void main(String[] args) throws IOException {
		SpringApplication.run(SparkApplication.class, args);

	}

}
