package com.sparkies.spark.service;

import com.sparkies.spark.model.Vehicle;
import com.sparkies.spark.model.Zone;

public interface EmissionService {

	public double distanceLookForPark(Zone zone);

	public double emissionConsumedByRoute(int distanceKmDone, Vehicle vehicule);

	public double carbonFootprintByConso(Vehicle vehicule);

}
