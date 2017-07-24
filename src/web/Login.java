package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.UserDAO;
import pojo.User;


@WebServlet(urlPatterns = "/login")
public class Login extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		User newUser = new UserDAO().searchByEmailAndPassword(email, password);
		
		RequestDispatcher view;
		resp.setContentType("text/html");
		
		if(newUser != null){
			view = req.getRequestDispatcher("registration.html");
		}else{
			view = req.getRequestDispatcher("login.html");
		}
		view.forward(req, resp);
		
		
        		
	}
	
}
