package com.sparkies.spark.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ZONE")
public class Zone {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name="id_zone")
	private Long idZone; 
	
	private String nom;
	
	private int minute;

	public Long getIdZone() {
		return idZone;
	}
	

	public void setIdZone(Long idZone) {
		this.idZone = idZone;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


	public int getMinute() {
		return minute;
	}


	public void setMinute(int minute) {
		this.minute = minute;
	}


	
	

}


