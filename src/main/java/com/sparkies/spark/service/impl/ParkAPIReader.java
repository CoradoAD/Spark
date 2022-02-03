package com.sparkies.spark.service.impl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import com.sparkies.spark.model.api.Park;
import com.sparkies.spark.service.IParkAPIReader;

import reactor.core.publisher.Flux;


@Service
public class ParkAPIReader implements IParkAPIReader {
	private static final int TIMEOUT = 5000;
	@Override
	public Park readPark(String parkApiUrl) {
		
		WebClient webClient = WebClient
				  .builder()
				  .baseUrl(parkApiUrl)		  
	              .build();
				
		Flux<Park> parkFlux=webClient.get()
		.retrieve()
		.onStatus(HttpStatus::isError, clientResponse -> {
           
            throw new RuntimeException("Error processing park API call "+parkApiUrl);
		})
		
		.bodyToFlux(Park.class).timeout(Duration.ofMillis(TIMEOUT));
		
		return parkFlux.blockLast();
		
	}

	
	@Override
	public Park readPark(String parkBaseURL, String xmlFileParameter) {
		

		WebClient webClient = WebClient
				  .builder()
				  .baseUrl(parkBaseURL)				
				  .build();
				
		return webClient.get()
		  .uri(uriBuilder-> uriBuilder
		    .path("/{param}")
		    .build(xmlFileParameter)).accept(MediaType.ALL)
		  .retrieve().bodyToFlux(Park.class).blockLast();
		
		
	}
	
	/**
	 * methode de test utiliser pour effectuer une lecture de fichier xml park avec JAXB et URL
	 * @param parkApiUrl
	 * @return
	 */
	 Park readParkWithJAXB(String parkApiUrl) {
		JAXBContext context = null;
		try {
			context = JAXBContext.newInstance(Park.class);
		} catch (JAXBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    
		
		Park park=null;
		URL aURL=null;
		try {
			aURL = new URL(parkApiUrl);
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		URLConnection con=null;
	           //ouvrir la connexion
	    try {
			 con = aURL.openConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
				park = (Park) context.createUnmarshaller()
				  .unmarshal(con.getInputStream());
		} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		
		return park;
	}
		
}
