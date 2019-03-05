package com.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AdminAuthFilter
 */
@WebFilter("/AdminAuthFilter")
public class AdminAuthFilter implements Filter {
	private FilterConfig config;
    /**
     * Default constructor. 
     */
    public AdminAuthFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		this.config = null;
		System.out.println("AdminAuthFilter Destroys");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		String loginPage = config.getInitParameter("loginPage");
				
		HttpServletRequest requ = (HttpServletRequest) request;
		HttpSession sess = requ.getSession(true);
		//Obtain Request Page URL
		String requestPath = requ.getServletPath();
		if(sess.getAttribute("admin") == null && !requestPath.endsWith(loginPage)) {
			request.setAttribute("tip", "You Have Not Signed In");
			request.getRequestDispatcher(loginPage).forward(request, response);
		} else {
			// pass the request along the filter chain
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.config = fConfig;
		System.out.println("AdminAuthFilter Initializes");
	}

}
