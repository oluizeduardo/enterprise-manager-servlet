package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CompanyDAO;

@WebServlet(urlPatterns = "/delete")
public class DeleteCompany extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = 0;
		try {
			id = Integer.parseInt(req.getParameter("id"));
		} catch (Exception e) {
			System.out.println("Error while trying to convert the ID value. Probably it is not a number.");
		}

		new CompanyDAO().delete(id);
		resp.sendRedirect("/EnterpriseManager/search");
	}
	
}
