package com.sparkies.spark.service;



import com.sparkies.spark.model.api.Park;

/**
 * interface de lecture de l'API de disponibilité de parking en temps réél
 * @author Brigitte
 *
 */
public interface IParkAPIReader {
	/**
	 * Lit le fichier xml fourni via l'url <code>parkApiUrl</code> et retourne un objet de type Park 
	 * @return
	 */
	public Park readPark(String parkApiUrl);
	
	/**
	 * 
	 * Lit le fichier xml fourni via l'url <code>parkApiUrl/xmlFileParameter</code> et retourne un objet de type Park 
	 *
	 *
	 * @param parkBaseURL
	 * @param xmlFileParameter
	 * @return
	 */
	public Park readPark(String parkBaseURL,String xmlFileParameter);
	
}
