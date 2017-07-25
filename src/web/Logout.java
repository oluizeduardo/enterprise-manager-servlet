package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "/logout")
public class Logout extends HttpServlet {

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Cookie cookie = new Cookies(req.getCookies()).searchUserOnline();
		PrintWriter writer = resp.getWriter();
		
		if(cookie == null){
			writer.println("<html><body>The user was not online!</body></html>");
			return;
		}
		cookie.setMaxAge(0); // Minimum time to live.
		resp.addCookie(cookie);
		writer.println("<body><html>You're offline!</body></html>");
		
	}
	
}
