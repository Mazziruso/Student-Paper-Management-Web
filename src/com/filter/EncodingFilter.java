package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EncodingFilter implements Filter {
	
	private FilterConfig config;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		config = null;
		System.out.println("EncodingFilter Destroys");
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		//Obtain init-param in web.xml
		request.setCharacterEncoding(config.getInitParameter("charset"));
		response.setContentType(config.getInitParameter("contentType"));
		response.setCharacterEncoding(config.getInitParameter("charset"));
		//next
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		this.config = arg0;
		System.out.println("EncodingFilter Initializes");
	}

}
