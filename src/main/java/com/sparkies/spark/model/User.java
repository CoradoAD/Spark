package com.sparkies.spark.model;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * User Entity for SQL table 'UTILISATEUR'
 */
@Entity
@Table(name = "users")

public class User extends Person {

	/**
	 * 'numberOfSparks' -> 'NOMBRE_SPARK' Double && not NULL (at least equal to
	 * zero)
	 */
	@Column(name = "NOMBRE_SPARK")
	private int numberOfSparks;

	/**
	 * 'registrationDate' -> 'DATE_INSCRIPTION' Datetime && not NULL
	 */
	@Column(name = "DATE_INSCRIPTION")
	private Date registrationDate = new Date();

	/**
	 * 'isPMR' -> 'isPMR' Boolean && not NULL
	 */
	@Column(name = "isPMR")
	private Boolean isPMR = false;

	/**
	 * Personal and 'Favorites' address
	 */
	@ManyToOne
	@JoinColumn(name = "id_adresse")
	private Address personnalAddress;

	@OneToMany(mappedBy = "favoriteUser")
	private List<Favorite> favorites;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "id_utilisateur"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	public User() {
		super();
	}

	public User(String username, String userEmail, String encode) {
		super(username, userEmail, encode);
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

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