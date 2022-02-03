package com.sparkies.spark.controller;

import com.sparkies.spark.model.Parking;
import com.sparkies.spark.repository.ParkingRepo;
import com.sparkies.spark.service.InitParkDBList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.List;

@Component
public class ParkingController {
//    @Autowired
//    ParkingRepo parkingRepo;
//
//    @Autowired
//    InitParkDBList initParkDBList;
//////
//////    public ParkingController() {
//////        // TODO document why this constructor is empty
//////    }
//////
////    public void initParkDBList() throws IOException {
////        initParkDBList.initialize();
////    }
////    public void ParkInit() throws IOException {
////        List<Parking> myParks = initParkDBList.initialize();
////
////        return pr.save(myParks);
////    }
//
//
//    public void initialize() throws IOException {
//
//        List<Parking> myParks = initParkDBList.initialize();
//
//        for (Parking myPark : myParks) {
//            Parking newPark = new Parking(myPark);
//            parkingRepo.save(newPark);
//        }
//
//    }
//
//    public void add() {
//        Parking newParking = new Parking();
//        newParking.setIdParking("12345_ABCDE");
//        parkingRepo.save(newParking);
//    }
}
