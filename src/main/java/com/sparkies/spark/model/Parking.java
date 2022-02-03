package com.sparkies.spark.model;

import javax.persistence.*;

/**
 * Address Entity for SQL table 'PARKING'
 */
@Entity
@Table(name = "PARKING")

public class Parking {
	
	/**
<<<<<<< HEAD
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
=======
	 * Unique 'id' formatted as following :
	 * [CodePostal(5chiffres)]_[Nom Parking en 6 lettres MAX]
     * id : "id_parking"
     * type : String - Max length of 15 'car' && not NULL
     */
    @Id
    @Column(name = "id_parking", length = 15 ,nullable = false)  // String ID
    private String idParking;

	/**
	 * 'name' -> 'nom'
	 * type : String - Max length of 50 'car' && not NULL
	 */
	@Column(name ="nom", length = 50, nullable = false)
	private String name;

	/**
	 * informative address - display only
	 * 'addressInfo' -> 'adresse_info'
	 * type : String - Max length of 50 'car' && not NULL
	 */
	@Column(name ="adresse_info", length = 50, nullable = false)
	private String addressInfo;

	/**
	 * Return if the park as free cost
	 * true if park as free cost
	 * 'asFreeCost' -> 'gratuit'
	 * type : Boolean && not NULL
	 */
	@Column(name = "gratuit", nullable = false)
	private boolean asFreeCost;

	/**
	 * Total number of spaces
	 * 'nbPlaces' -> 'nb_places'
	 * type : Int && not NULL
	 */
	@Column(name = "nb_places", nullable = false)
	private int nbPlaces;

	/**
	 * Number of 'PMR' spaces
	 * Allow to display number of 'PMR spaces' ou define if they exist (!= 0 || != NULL)
	 * 'nbPMR' -> 'nb_pmr'
	 * type : Int && nullable
	 */
	@Column(name = "nb_pmr", nullable = true)
	private int nbPMR;

	/**
	 * Number of 'velo' spaces
	 * 'nbVelo' -> 'nb_velo'
	 * type : Int && nullable
	 */
	@Column(name = "nb_velo", nullable = true)
	private int nbVelo;

	/**
	 * Number of 'Moto' spaces ("2 roues motorisÃ©s")
	 * 'nb2RM' -> 'nb_2_rm'
	 * type : Int && nullable
	 */
	@Column(name = "nb_2_rm", nullable = true)
	private int nb2RM;

	/**
	 * Max Height (usable for filter result on specified 'vehicles' height)
	 * 'maxHeight' -> 'hauteur_max'
	 * type : Int && Nullable
	 */
	@Column(name = "hauteur_max", nullable = true)
	private int maxHeight;

	/**
	 * Park 'longitude' 'Xlong'
	 * 'xLong' -> 'Xlong'
	 * type : long && not NULL
	 */
	@Column(name = "Xlong", nullable = false)
	private long xLong;

	/**
	 * Park 'longitude' 'Ylat'
	 * 'yLat' -> 'Ylat'
	 * type : long && not NULL
	 */
	@Column(name = "Ylat", nullable = false)
	private long yLat;

	/**
	 * Kind of structure
	 * ('ouvrage' or 'enclos en surface')
	 * 'structType' -> 'type_ouvra'
	 * type : String - Max length of 50 'car' && Nullable
	 */
	@Column(name = "type_ouvra", length = 50, nullable = true)
	private String structType;

	/**
	 * Kind of usage
	 * ('centre-ville', 'proximitÃ©', 'parc relais')
	 * 'functionType' -> 'typo_fonct'
	 * type : String - Max length of 50 'car' && Nullable
	 */
	
	@ManyToOne @JoinColumn(name="id_zone")
	private Zone zone;

	/**
	 * Number of levels
	 * 'nbLevel' -> 'nbre_niv'
	 * type : Int - Max lenght 11 && Nullable
	 */
	@Column(name = "nbre_niv", length = 11, nullable = true)
	private int nbLevel;

	/**
	 * Number of public spaces
	 * 'nbPub' -> 'places_pub'
	 * type : Int - Max lenght 11 && Nullable
	 */
	@Column(name = "places_pub", length = 11, nullable = true)
	private int nbPub;

	/**
	 * Number of residential spaces
	 * 'NbRes' -> 'places_res'
	 * type : Int - Max lenght 11 && Nullable
	 */
	@Column(name = "places_res", length = 11, nullable = true)
	private int NbRes;

	/**
	 * Parking address
	 */
	@OneToOne
	@JoinColumn(name="id_adresse_adresse")
    
    private Address parkingAddress;

	public Parking() {
		// TODO document why this constructor is empty
	}

	public String getIdParking() {
		return idParking;
	}

	public void setIdParking(String idParking) {
		this.idParking = idParking;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddressInfo() {
		return addressInfo;
	}

	public void setAddressInfo(String addressInfo) {
		this.addressInfo = addressInfo;
	}

	public boolean isAsFreeCost() {
		return asFreeCost;
	}

	public void setAsFreeCost(boolean asFreeCost) {
		this.asFreeCost = asFreeCost;
	}

	public int getNbPlaces() {
		return nbPlaces;
	}

	public void setNbPlaces(int nbPlaces) {
		this.nbPlaces = nbPlaces;
	}

	public int getNbPMR() {
		return nbPMR;
	}

	public void setNbPMR(int nbPMR) {
		this.nbPMR = nbPMR;
	}

	public int getNbVelo() {
		return nbVelo;
	}

	public void setNbVelo(int nbVelo) {
		this.nbVelo = nbVelo;
	}

	public int getNb2RM() {
		return nb2RM;
	}

	public void setNb2RM(int nb2RM) {
		this.nb2RM = nb2RM;
	}

	public int getMaxHeight() {
		return maxHeight;
	}

	public void setMaxHeight(int maxHeight) {
		this.maxHeight = maxHeight;
	}

	public long getxLong() {
		return xLong;
	}

	public void setxLong(long xLong) {
		this.xLong = xLong;
	}

	public long getyLat() {
		return yLat;
	}

	public void setyLat(long yLat) {
		this.yLat = yLat;
	}

	public String getStructType() {
		return structType;
	}

	public void setStructType(String structType) {
		this.structType = structType;
	}


	public Zone getZone() {
		return zone;
	}

	public void setZone(Zone zone) {
		this.zone = zone;
	}

	public int getNbLevel() {
		return nbLevel;
	}

	public void setNbLevel(int nbLevel) {
		this.nbLevel = nbLevel;
	}

	public int getNbPub() {
		return nbPub;
	}

	public void setNbPub(int nbPub) {
		this.nbPub = nbPub;
	}

	public int getNbRes() {
		return NbRes;
	}

	public void setNbRes(int nbRes) {
		NbRes = nbRes;
	}

	public Address getParkingAddress() {
		return parkingAddress;
	}

	public void setParkingAddress(Address parkingAddress) {
		this.parkingAddress = parkingAddress;
	}
}

>>>>>>> refs/heads/service-vehicle
