package org.gmnz.web.store;


import javax.servlet.http.HttpServlet;


/**
 * Base class for pages showing catalog entries.
 * Servlets that extend this class must specify
 * the catalog entries that they are selling and the page
 * title <I>before</I> the servlet is ever accessed. This
 * is done by putting calls to setItems and setTitle
 * in init.
 */
public abstract class CatalogPage extends HttpServlet {

	private CatalogItem[] catalogItems;
	private String[] itemIDs;
	private String title;



	/**
	 * Given an array of item IDs, look them up in the
	 * Catalog and put their corresponding CatalogItem entry
	 * into the items array. The CatalogItem contains a short
	 * description, a long description, and a price,
	 * using the item ID as the unique key.
	 * <p>
	 * Servlets that extend CatalogPage <B>must</B> call
	 * this method (usually from init) before the servlet
	 * is accessed.
	 */
	protected void setItems(String[] itemIDs) {
		this.itemIDs = itemIDs;
		catalogItems = new CatalogItem[itemIDs.length];
		for (int i = 0; i < catalogItems.length; i++) {
			catalogItems[i] = Catalog.getItem(itemIDs[i]);
		}
	}
}
