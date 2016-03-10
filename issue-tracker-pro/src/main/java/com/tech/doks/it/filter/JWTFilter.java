package com.tech.doks.it.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.tech.doks.it.token.VerifyToken;


/**
 * Servlet Filter implementation class JWTFilter
 */
@WebFilter("/JWTFilter")
public class JWTFilter implements Filter {

	public void init(FilterConfig fConfig) throws ServletException {}
    
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		VerifyToken verifyToken = null;
		boolean isValidToken = false;
				
		System.out.println("Calling doFilter method !!");
		String token = request.getParameter("userToken");
		if(!token.equals(null)) {
			verifyToken = new VerifyToken();
			isValidToken = verifyToken.parseJWT(token);
			if(isValidToken) {
				chain.doFilter(request, response);
			} else {
				PrintWriter out = response.getWriter();
				out.println("Invalid Token !!");
			}
			System.out.println("isValidToken : " + isValidToken);
		}		
	}

	public void destroy() {}

}