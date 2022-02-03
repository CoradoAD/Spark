package com.sparkies.spark.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sparkies.spark.model.Parking;
import com.sparkies.spark.model.api.Park;
import com.sparkies.spark.repository.ParkingRepo;
import com.sparkies.spark.service.IDistanceCalculator;
import com.sparkies.spark.service.IParkAPIReader;
import com.sparkies.spark.service.IParkingService;

@Service
public class ParkingService implements IParkingService {
//	@Autowired
//	IParkAPIReader reader;
//	@Autowired
//	IDistanceCalculator distanceCalculator;
//	@Autowired
//	@Qualifier("parkingRepoMock")
//	ParkingRepo parkingRepository;
//
//	@Override
//	public List<Parking> getAllParking() {
//		// recupere la liste des parkings en base
//		List <Parking> parkings=(List<Parking>) parkingRepository.findAll();
//		parkings.forEach(parking->{
//			Park park=reader.readPark(parking.getApiUrl());
//			parking.setFreeCapacity(park.getFree());
//		});
//		// pour chaque parking récuperation des dernières disponibilités
//		return parkings;
//	}
//
//
//
//	@Override
//	public List<Parking> getParkingList(Double xLong, Double xLat, Double maxRange) {
//		// TODO Auto-generated method stub
//		List <Parking> list=getAllParking();
//		return list.stream().filter(p->{
//			return isWithinPerimeter(p,xLong,xLat,maxRange);
//		}
//		).toList();
//	}
//	/**
//	 *  return true si  la distance entre  le parking et  le point de reference de coordonnées refLong et refLat  est inférieure ou égale à  maxRange
//	 *  max Rage est exprimé en km
//	 *
//	 */
//	private boolean isWithinPerimeter (Parking parking, Double refLong, Double refLat, Double maxRange ) {
//		Double parkingLong=parking.getxLong();
//		Double parkingLat=parking.getyLat();
//		Double distance =distanceCalculator.distance(parkingLat, parkingLong, refLat, refLong, IDistanceCalculator.UNITE_KM);
//
//
//		System.out.println("distance calculée: "+distance);
//		return (distance<=maxRange);
//	}

}
