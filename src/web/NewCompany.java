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
		
		if(failed)
			writer.println("<html><body>Erro ao cadastrar uma nova empresa!</body></html>");
		else
			writer.println("<html><body>Nova empresa adicionada com sucesso!</body></html>");
		
	}
	
}
