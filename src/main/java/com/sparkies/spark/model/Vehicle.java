package com.sparkies.spark.model;

import javax.persistence.*;

/**
 * 
 * Adress Entity for Sql table "vehicule"
 *
 */
@Entity
@Table(name="VEHICULE")
public class Vehicle {

	/**
	 * id:"id_vehicule"
	 * type: double
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_vehicule")
	private Long idVehicle;
	/**
	 * methode de coef avec calcul en fonction du vehicule
	 */
	@Column(name="Consomation")
	private double consomation;
	
	@ManyToOne @JoinColumn(name="id_energie")
	private Energy energy;

	@ManyToOne
	@JoinColumn(name = "id_utilisateur")
	private User vehicleUser;
	
	
	@Enumerated(EnumType.STRING)
	@Column(name="type_vehicule", columnDefinition ="enum('moto','voiture')"  )
	private TypeVehicle typeVehicle;
	


	public Vehicle(Long idVehicle, double consomation, TypeVehicle typeVehicle) {
		super();
		this.idVehicle = idVehicle;
		this.consomation = consomation;
		this.typeVehicle = typeVehicle;
	}
	

	public Vehicle() {
		super();
	}


	public Long getIdVehicle() {
		return idVehicle;
	}


	public void setIdVehicle(Long idVehicle) {
		this.idVehicle = idVehicle;
	}


	public double getConsomation() {
		return consomation;
	}


	public void setConsomation(double consomation) {
		this.consomation = consomation;
	}


	public Energy getEnergy() {
		return energy;
	}


	public void setEnergy(Energy energy) {
		this.energy = energy;
	}


	public User getVehicleUser() {
		return vehicleUser;
	}


	public void setVehicleUser(User vehicleUser) {
		this.vehicleUser = vehicleUser;
	}


	public TypeVehicle getTypeVehicle() {
		return typeVehicle;
	}


	public void setTypeVehicle(TypeVehicle typeVehicle) {
		this.typeVehicle = typeVehicle;
	}

}
