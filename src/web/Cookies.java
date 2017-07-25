package web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class Cookies {

	
	private Cookie[] cookies = null;
	
	
	
	public Cookies(Cookie[] cookies){
		this.cookies = cookies;
	}
	
	
	
	/**
	 * Search for a user online. 
	 * @param req
	 * @return An object Cookie.
	 */
	public Cookie searchUserOnline(){
		if(cookies == null) return null;
		
		for (Cookie cookie : cookies) {
			if(cookie.getName().equals("user.online")){
				return cookie;
			}
		}
		return null;
	}
	
	
}
