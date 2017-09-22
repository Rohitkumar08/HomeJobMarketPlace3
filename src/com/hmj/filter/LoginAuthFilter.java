package com.hmj.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginAuthFilter
 */

public class LoginAuthFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginAuthFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		HttpSession session=((HttpServletRequest) request).getSession();
		RequestDispatcher rd;
		if(session.getAttribute("uid")==null) {
				rd= request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			
			
		}

		else {
				if(session.getAttribute("utype").equals("Seeker")) {
					rd= request.getRequestDispatcher("seeker.do");
					rd.forward(request, response);
				}
				
				if(session.getAttribute("utype").equals("Sitter")) {
					rd= request.getRequestDispatcher("sitter.do");
					rd.forward(request, response);
				}
			
			chain.doFilter(request, response);
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
