package org.gmnz.web.store;


/**
 * Describes a catalog item for an online store. The itemID uniquely identifies
 * the item, the short description gives brief info like the book title and
 * author, the long description describes the item in a couple of sentences, and
 * the cost gives the current per-item price. Both the short and long
 * descriptions can contain HTML markup.
 */
public class CatalogItem {

	private String itemID;
	private String shortDescription;
	private String longDescription;
	private double cost;




	public CatalogItem(String itemID, String shortDescription, String longDescription, double cost) {
		this.itemID = itemID;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
		this.cost = cost;
	}




	public String getItemID() {
		return itemID;
	}




	public void setItemID(String itemID) {
		this.itemID = itemID;
	}




	public String getShortDescription() {
		return shortDescription;
	}




	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}




	public String getLongDescription() {
		return longDescription;
	}




	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}




	public double getCost() {
		return cost;
	}




	public void setCost(double cost) {
		this.cost = cost;
	}
}
