package org.gmnz.web;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


/**
 * creato da simone in data 27/06/2018.
 */
public class ShowItems extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession = req.getSession();
		ArrayList<String> previousItems = (ArrayList<String>) httpSession.getAttribute("previousItems");
		if (previousItems == null) {
			previousItems = new ArrayList<String>();
			httpSession.setAttribute("previousItems", previousItems);
		}
		String newItem = req.getParameter("newItem");
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String title = "Items Purchased";
		String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n";
		out.println(docType + "<HTML>\n" + "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
		// TODO cambia questa roba con l'uso di un CSS
				"<BODY BGCOLOR=\"#FDF5E6\">\n" + "<H1>" + title + "</H1>");

		synchronized (previousItems) {
			if (newItem != null) {
				previousItems.add(newItem);
			}
			if (previousItems.size() == 0) {
				out.println("<i>No items</i>");
			}
			else {
				out.println("<ul>");
				for (String item : previousItems) {
					out.printf("<li>%s</li>%n", item);
				}
				out.println("</ul>");
			}
			out.println("</body></html>");
		}
	}
}
