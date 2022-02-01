package com.sparkies.spark.model;

import javax.persistence.*;

@Entity
public class Energie {
	
	/**
     * id : "id_energie"
     * type : String
     */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_Energie")
	private Long id_energie; 
	private String nom;
	private double coefficient;
}
