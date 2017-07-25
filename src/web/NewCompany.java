package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
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
		RequestDispatcher disp;
		
		if(failed)
			disp = req.getRequestDispatcher("WEB-INF/pages/alerts/error.html");
		else
			disp = req.getRequestDispatcher("WEB-INF/pages/alerts/success.html");
		
		disp.forward(req, resp);
		
	}
	
}
