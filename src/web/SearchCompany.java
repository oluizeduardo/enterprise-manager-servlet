package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CompanyDAO;
import pojo.Company;

@WebServlet(urlPatterns = "/search")
public class SearchCompany extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String title = "Registered Companies";		
			      
	    out.println("<!DOCTYPE html>" +
	         "<html>\n" +
	         "<head><title>" + title + "</title></head>\n" +
	         "<body bgcolor = \"#f0f0f0\">\n" +
	         "<h1 align = \"center\">" + title + "</h1>\n");
	    
	    out.println("<ul>");
	    
		List<Company> listCompany = new CompanyDAO().list();
		
		for (Company comp : listCompany) {
			// Add a new list item.
			out.println("<li>");
			// Display the values.
			out.println("ID: "+comp.getId());
			out.println(" NAME: "+comp.getName());
			out.println(" EMAIL: "+comp.getEmail());	
			
			out.println("</li>");
		}
		out.println("</ul>");
		
	}
	
}
