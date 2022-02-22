package com.sparkies.spark.service;

import com.sparkies.spark.model.Parking;
import com.sparkies.spark.model.Zone;
import com.sparkies.spark.repository.ParkingRepo;
import com.sparkies.spark.repository.ZoneRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * Initialize Parking list in DB
 */
@Service
public class InitParkDBList {
	
    private static List<Parking> myParks;
    private List<Zone> zoneArray;
    
    @Autowired
    ParkingRepo parkingRepository;
    
    @Autowired
    ZoneRepo zoneRepo;
    
    @Autowired
    ZoneService zoneService;

    /**
     * Create 'Parkings' in DB
     * @return List<Parking>
     * @throws IOException Jackson Exception
     */
    @Autowired
    public List<Parking> initialize() throws IOException {

        try {
            List<Parking> myParks = JSONParkLoader.getParksInfo();
            zoneArray = (List<Zone>) zoneService.findAll();
            
            for (Parking myPark : myParks) {
            	
                
                if (myPark.getFunctionType().equals("Centre-ville") && !zoneArray.contains("Centre-ville")) {
                	
                	Zone zone1 = new Zone();
                	zone1.setIdZone(1L);
                	zone1.setNom("Centre-ville");
                	zone1.setMinute(10);
                	zoneService.saveDataZone(zone1);
             
                	
                }else if (myPark.getFunctionType().equals("Parc relais") && !zoneArray.contains("Parc relais")) {
                	
                   	Zone zone2 = new Zone();
                   	zone2.setIdZone(2L);
                	zone2.setNom("Relais");
                	zone2.setMinute(3);
                	zoneService.saveDataZone(zone2);
    
                	
                }else if (myPark.getFunctionType().equals("Proximité") && !zoneArray.contains("Parc relais")) {
                	
                  	Zone zone3 = new Zone();
                	zone3.setIdZone(3L);
                	zone3.setNom("Proximité");
                	zone3.setMinute(7);
                	zoneService.saveDataZone(zone3);
                	
                }
                
                
                Parking newPark = new Parking(myPark);
               
         
                parkingRepository.save(newPark);
                System.out.println("########################");
                System.out.println(myPark);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return myParks;

    }
}
