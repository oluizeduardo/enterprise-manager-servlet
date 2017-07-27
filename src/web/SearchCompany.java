package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
		List<Company> companies = new CompanyDAO().list();
		req.setAttribute("companies", companies);
				
		RequestDispatcher disp = req.getRequestDispatcher("WEB-INF/pages/search.jsp");
		disp.forward(req, resp);
	}
	
}
