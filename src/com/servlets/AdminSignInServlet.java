package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AdminDaoClass;

/**
 * Servlet implementation class AdminSignInServlet
 */
@WebServlet("/AdminSignInServlet")
public class AdminSignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSignInServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		
		AdminDaoClass adminDB = new AdminDaoClass();
		
		if(adminDB.existAdmin(name)) {
			if(adminDB.logIn(name, pwd)) {
				//Success
				System.out.println("Sign In Successfully");
				//Session
				HttpSession session = request.getSession(true);
				session.setAttribute("admin", name);
				request.getRequestDispatcher("SelectAllServlet").forward(request, response);
			} else {
				System.out.println("Admin Sign In Error, Password Error");
				request.setAttribute("name", name);
				request.getRequestDispatcher("AdminSignIn.jsp").forward(request, response);
			}
		} else {
			System.out.println("Admin Sign In Error, No Admin");
			response.sendRedirect("Failure.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
