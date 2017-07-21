package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CompanyDAO;
import pojo.Company;


@WebServlet (urlPatterns = "/newCompany")
public class NewCompany extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		
		Company newCompany = new Company();
		newCompany.setId(id);
		newCompany.setName(name);
		newCompany.setEmail(email);
		
		boolean failed = new CompanyDAO().insert(newCompany);
		PrintWriter writer = resp.getWriter();
		
		writer.println("<html><body>");
		writer.println("<div align=\"center\">");
		if(failed)
			writer.println("<h1>An error has been detected!</h1>");
		else
			writer.println("<h1>A new company has been added with success!</h1>");
		
		writer.println("</div>");
		writer.println("<p>");
		writer.println("<h3><a href=\"/EnterpriseManager/search\">List of Registered Companies</a></h3>");
		writer.println("</body></html>");
		
	}
	
}
