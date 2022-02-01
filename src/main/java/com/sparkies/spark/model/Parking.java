package com.sparkies.spark.model;

import javax.persistence.*;

/**
 * Address Entity for SQL table 'PARKING'
 */
@Entity
@Table(name = "PARKING")

public class Parking {
	
	/**
     * id : "id_parking"
     * type : long
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_parking" ,nullable = false)  // AutoIncremental
    private long idParking;

	/**
	 * TODO
	 */
	@Column(name ="total_places", nullable = false)    
	private long totalCapacity;

	/**
	 * TODO
	 */
	@Column(name ="NOM", nullable = false)
	private String name;

	/**
	 * TODO
	 */
	@Column(name ="isGratuit", nullable = false)
   	private boolean isFree;
    @Column(name ="isPMR", nullable = false)    
   	private boolean isPMR;

	/**
	 * TODO
	 */
	@OneToOne
	@JoinColumn(name="id_adresse_adresse")
    
    private Address parkingAddress;

	public long getIdParking() {
		return idParking;
	}

	public void setIdParking(long idParking) {
		this.idParking = idParking;
	}

	public long getTotalCapacity() {
		return totalCapacity;
	}

	public void setTotalCapacity(long totalCapacity) {
		this.totalCapacity = totalCapacity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isFree() {
		return isFree;
	}

	public void setFree(boolean isFree) {
		this.isFree = isFree;
	}

	public boolean isPMR() {
		return isPMR;
	}

	public void setPMR(boolean isPMR) {
		this.isPMR = isPMR;
	}

	public Address getParkingAddress() {
		return parkingAddress;
	}

	public void setParkingAddress(Address parkingAddress) {
		this.parkingAddress = parkingAddress;
	}
	
	
}
