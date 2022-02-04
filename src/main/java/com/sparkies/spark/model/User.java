package com.sparkies.spark.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * User Entity for SQL table 'UTILISATEUR'
 */
@Entity
@Table (name = "UTILISATEUR")
public class User extends Person{

    /**
     * 'numberOfSparks' -> 'NOMBRE_SPARK'
     * Double && not NULL (at least equal to zero)
     */
    @Column(name = "NOMBRE_SPARK", nullable = false)
    private int numberOfSparks;

    /**
     * 'registrationDate' -> 'DATE_INSCRIPTION'
     * Datetime && not NULL
     */
    @Column(name = "DATE_INSCRIPTION", nullable = false)
    private Date registrationDate;

    /**
     * 'isPMR' -> 'isPMR'
     * Boolean && not NULL
     */
    @Column(name = "isPMR", nullable = false)
    private Boolean isPMR;

    /**
     * Personal and 'Favorites' address
     */
    @ManyToOne
    @JoinColumn(name="id_adresse")
    private Address personnalAddress;

    @OneToMany(mappedBy = "favoriteUser")
    private List<Favorite> favorites;

	public int getNumberOfSparks() {
		return numberOfSparks;
	}

	public void setNumberOfSparks(int numberOfSparks) {
		this.numberOfSparks = numberOfSparks;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Boolean getIsPMR() {
		return isPMR;
	}

	public void setIsPMR(Boolean isPMR) {
		this.isPMR = isPMR;
	}

	public Address getPersonnalAddress() {
		return personnalAddress;
	}

	public void setPersonnalAddress(Address personnalAddress) {
		this.personnalAddress = personnalAddress;
	}

	public List<Favorite> getFavorites() {
		return favorites;
	}

	public void setFavorites(List<Favorite> favorites) {
		this.favorites = favorites;
	}
    
    

}