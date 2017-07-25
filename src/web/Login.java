package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import pojo.User;


@WebServlet(urlPatterns = "/login")
public class Login extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
				
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		User newUser = new UserDAO().searchByEmailAndPassword(email, password);
		
		resp.setContentType("text/html");
		
		if(newUser != null){			
			HttpSession session = req.getSession();
			session.setAttribute("user.online", newUser);
			
			resp.sendRedirect("registration.html");
			
		}else{
			resp.sendRedirect("login.html");
		}		
	}
	
}
