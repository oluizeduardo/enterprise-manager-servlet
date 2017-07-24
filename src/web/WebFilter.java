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


@javax.servlet.annotation.WebFilter(urlPatterns = "/*")
public class WebFilter implements Filter {

	@Override
	public void destroy() { }

	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		String uri = req.getRequestURI();
		Cookie[] cookies = req.getCookies();
		String user = "<offline>";
		
		for (Cookie cookie : cookies) {
			if(cookie.getName().equals("user.online")){
				user = cookie.getValue();
			}
		}
		
		
		System.out.println("User access: "+uri);
		
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException { }

}
