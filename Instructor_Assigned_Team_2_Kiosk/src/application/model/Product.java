package application.model;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import javafx.scene.image.Image;

/*		Product Class
 * 
 * 		Purpose:
 * 
 * 		Notes:
 * 
 * 
 */
/**
 * Each product has a name, description, ID, and price.
 * @author 
 *
 */
public class Product {

	//PIV
	private String pszName;
	private String pszDescription;

	private Integer iID;

	private double fPrice;

	//Constructors
	/*
	 * Purpose:
	 * 	Loads Product
	 * Parameters:
	 * 	I - String name							name of Product
	 *  I - String description					description of Product
	 *  I - int id							id number for Product
	 *  I - int stockCount						number being added to Kiosk
	 *  I - double price						cost of Product
	 * Notes:
	 * 	
	 */
	/**
	 * 
	 * @param name The new Product's given name.
	 * @param description The new Product's given description.
	 * @param id The new Product's given ID.
	 * @param price The new Product's given price.
	 */
	public Product(String name, String description, int id, double price){
		pszName = name;
		pszDescription = description;
		iID = id;
		fPrice = price;
	}
	
	//Methods
	/*
	 * Purpose:
	 * 	Get the name of a Product
	 * Parameters:
	 * 	None
	 * Returns:
	 * 	String name of the Product
	 * Notes:
	 * 	
	 */
	/**
	 * Retrieves the Product's name.
	 * @return pszName A String containing the Product's name.
	 */
	public String getName(){
		return pszName;
	}
	
	/*
	 * Purpose:
	 * 	Get the name of a Product
	 * Parameters:
	 * 	None
	 * Returns:
	 * 	String name of the Product
	 * Notes:
	 * 	
	 */
	/**
	 * Retrieves the Product's description.
	 * @return pszDescription A String containing the Product's description.
	 */
	public String getDescription(){
		return pszDescription;
	}
	
	/*
	 * Purpose:
	 * 	Get the price of a Product
	 * Parameters:
	 * 	None
	 * Returns:
	 * 	double price of the Product
	 * Notes:
	 * 	
	 */
	/**
	 * Retrieves the Product's price.
	 * @return fPrice A double containing the Product's price.
	 */
	public double getPrice(){
		return fPrice;
	}
	
	/*
	 * Purpose:
	 * 	Get the id of a Product
	 * Parameters:
	 * 	None
	 * Returns:
	 * 	int ID of the Product
	 * Notes:
	 * 	
	 */
	/**
	 * Retrieves the Product's ID.
	 * @return iID An integer containing the Product's ID.
	 */
	public int getId(){
		return iID;
	}
	
	//toString
	/**
	 * Provides a textual representation of the Product's attributes.
	 */
	public String toString(){
		String tempProductString = "";
		tempProductString += pszName;
		tempProductString += "\nDescription:  ";
		String[] tempDescription = pszDescription.split("\\s+");
		for(int i = 0; i < tempDescription.length;i++){
			tempProductString += " -"+tempDescription[i];
		}
		tempProductString += "\nPrice: $"+fPrice;
		return tempProductString;
	}
}
