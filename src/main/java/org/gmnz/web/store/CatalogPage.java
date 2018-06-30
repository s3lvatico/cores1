package org.gmnz.web.store;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * Base class for pages showing catalog entries. Servlets that extend this class
 * must specify the catalog entries that they are selling and the page title
 * <I>before</I> the servlet is ever accessed. This is done by putting calls to
 * setItems and setTitle in init.
 */
public abstract class CatalogPage extends HttpServlet {

	private CatalogItem[] catalogItems;
	private String[] itemIDs;
	private String title;



	/**
	 * Given an array of item IDs, look them up in the Catalog and put their
	 * corresponding CatalogItem entry into the items array. The CatalogItem
	 * contains a short description, a long description, and a price, using the item
	 * ID as the unique key.
	 * <p>
	 * Servlets that extend CatalogPage <B>must</B> call this method (usually from
	 * init) before the servlet is accessed.
	 */
	protected void setItems(String[] itemIDs) {
		this.itemIDs = itemIDs;
		catalogItems = new CatalogItem[itemIDs.length];
		for (int i = 0; i < catalogItems.length; i++) {
			catalogItems[i] = Catalog.getItem(itemIDs[i]);
		}
	}



	/**
	 * Sets the page title, which is displayed in an H1 heading in resultant page.
	 * <p>
	 * Servlets that extend CatalogPage <B>must</B> call this method (usually from
	 * init) before the servlet is accessed.
	 */
	protected void setTitle(String title) {
		this.title = title;
	}



	/**
	 * First display title, then, for each catalog item, put its short description
	 * in a level-two (H2) heading with the price in parentheses and long
	 * description below. Below each entry, put an order button that submits info to
	 * the OrderPage servlet for the associated catalog entry.
	 * <p>
	 * To see the HTML that results from this method, do "View Source" on
	 * KidsBooksPage or TechBooksPage, two concrete classes that extend this
	 * abstract class.
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (catalogItems == null) {
			response.sendError(response.SC_NOT_FOUND, "Missing Items.");
			return;
		}
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n";
		out.println(docType + "<HTML>\n" + "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n"
				+ "<BODY BGCOLOR=\"#FDF5E6\">\n"
				+ "<H1 ALIGN=\"CENTER\">" + title + "</H1>");

		if (catalogItems.length == 0) {
			out.println("<FONT COLOR=\"RED\">Empty catalog</FONT>");
		} else {
			for (CatalogItem item : catalogItems) {
				out.printf("<HR>%n");
				String formURL = "/cores1/storeSrv/orderPage";

				// Pass URLs that reference own site through encodeURL.
				formURL = response.encodeURL(formURL);
				/*
				nota bene l'input nascosto con nome "itemID", sarà il nome del parametro trasferito alla pagina
				degli ordini quando si invia il form
				 */
				out.println("<FORM ACTION=\"" + formURL + "\">\n" + "<INPUT TYPE=\"HIDDEN\" NAME=\"itemID\" " + " VALUE=\""
						+ item.getItemID() + "\">\n" + "<H2>" + item.getShortDescription() + " ($" + item.getCost()
						+ ")</H2>\n" + item.getLongDescription() + "\n" + "<P>\n<CENTER>\n" + "<INPUT TYPE=\"SUBMIT\" "
						+ "VALUE=\"Add to Shopping Cart\">\n" + "</CENTER>\n<P>\n</FORM>");
			}
		}
		out.println("<HR>\n</BODY></HTML>");
	}
}
