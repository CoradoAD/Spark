package com.sparkies.spark.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

@Entity
@Table(name = "ZONE")
public class Zone {

	@Id
	@Column(name="id_zone")
	private Long idZone; 

	
	@Nullable
	private String nom;
	
	private int minute;


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

	public Long getIdZone() {
		return idZone;
	}

	public void setIdZone(Long idZone) {
		this.idZone = idZone;
	}
	
	
}
