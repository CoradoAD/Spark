package com.sparkies.spark.service;

import com.sparkies.spark.model.Parking;
import com.sparkies.spark.model.Zone;
import com.sparkies.spark.repository.ParkingRepo;
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
    @Autowired
    ParkingRepo parkingRepository;
    
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
            for (Parking myPark : myParks) {
            	
                Parking newPark = new Parking(myPark);
                
                if (newPark.getFunctionType().getNom().equals("Centre-ville")) {
                	
                	System.out.println("Helooo");
                	
                	Zone zone1 = new Zone();
                	zone1.setNom("Centre-ville");
                	zone1.setMinute(1);
                	zoneService.saveDataZone(zone1);
                	newPark.setFunctionType(zone1);
                	
                }else if (newPark.getFunctionType().getNom().equals("Parc relais")) {
                	
                   	Zone zone2 = new Zone();
                	zone2.setNom("Relais");
                	zone2.setMinute(5);
                	zoneService.saveDataZone(zone2);
                	newPark.setFunctionType(zone2);
                	
                }else if (newPark.getFunctionType().getNom().equals("Proximité")) {
                	
                  	Zone zone3 = new Zone();
                	zone3.setNom("Proximité");
                	zone3.setMinute(7);
                	zoneService.saveDataZone(zone3);
                	newPark.setFunctionType(zone3);
                	
                }
               
          
                
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
