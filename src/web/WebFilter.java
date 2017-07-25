package web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import pojo.User;


@javax.servlet.annotation.WebFilter(urlPatterns = "/*")
public class WebFilter implements Filter {

	@Override
	public void destroy() { }

	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		String uri = req.getRequestURI();
		
		String user = getUser(req);
		
		System.out.println("User "+user+" accessing: "+uri);
		
		chain.doFilter(request, response);
	}

	
	
	/**
	 * @param req An object HttpServletRequest.
	 * @return The name of the user online.
	 */
	private String getUser(HttpServletRequest req) {
		User user = (User) req.getSession().getAttribute("user.online");
		if(user == null) return "<offline>";
		return user.getName();
	}


	@Override
	public void init(FilterConfig arg0) throws ServletException { }
	
	
}
