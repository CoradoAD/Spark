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
    private Double numberOfSparks;

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

    /**
     *  User's car list
     */
    @OneToMany(mappedBy = "vehicleUser", fetch = FetchType.EAGER)
    private List<Vehicle> vehicles;

    /**
     * Default constructor
     */
    public User() {
        // TODO AUTOGENERATED
    }
    

    public Double getNumberOfSparks() {
        return numberOfSparks;
    }

    public void setNumberOfSparks(Double numberOfSparks) {
        this.numberOfSparks = numberOfSparks;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Boolean getPMR() {
        return isPMR;
    }

    public void setPMR(Boolean PMR) {
        isPMR = PMR;
    }


	public List<Vehicle> getVehicles() {
		return vehicles;
	}


	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
    
}