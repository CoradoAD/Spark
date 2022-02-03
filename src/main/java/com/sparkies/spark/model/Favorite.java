package com.sparkies.spark.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="FAVORIS")
public class Favorite extends Address {
	private String label;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@ManyToOne
	@JoinColumn(name = "id_utilisateur")
	private User favoriteUser;

}
