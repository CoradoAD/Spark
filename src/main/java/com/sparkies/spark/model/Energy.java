package com.sparkies.spark.model;

import javax.persistence.*;

@Entity
@Table(name = "ENERGIE")
public class Energy {
	
	/**
     * id : "id_energy"
     * name : name
     * coefficient : coefficient
     */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_energie")
	private Long idEnergie; 
	private String nom;
	private double coefficient;
	
	
	public Energy() {
		super();
	}
	
	
	public Energy(Long idEnergie, String nom, double coefficient) {
		super();
		this.idEnergie = idEnergie;
		this.nom = nom;
		this.coefficient = coefficient;
	}




	public Long getIdEnergie() {
		return idEnergie;
	}


	public void setIdEnergie(Long idEnergie) {
		this.idEnergie = idEnergie;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public double getCoefficient() {
		return coefficient;
	}


	public void setCoefficient(double coefficient) {
		this.coefficient = coefficient;
	}
	
	
}


