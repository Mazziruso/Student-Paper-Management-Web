package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.regex.*;
import com.dao.StudentDaoClass;
/**
 * Servlet implementation class SignInServlet
 */
@WebServlet("/SignInServlet")
public class SignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignInServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cardID = request.getParameter("cardID");
		String pwd = request.getParameter("pwd");
		
		StudentDaoClass stuDB = new StudentDaoClass();
		
		if(Pattern.matches(".*\\D.*", cardID)) {
			//Failure
			response.sendRedirect("Failure.jsp");
		} else {
			if(stuDB.existUser(cardID)) {
				if(stuDB.logIn(cardID, pwd)) {
					//Success
					System.out.println("Sign In Successfully");
					//Session
					HttpSession session = request.getSession(true);
					session.setAttribute("user", cardID);
					
					request.setAttribute("userName", "Welcome Student " + stuDB.getUser(cardID).getName());
					request.setAttribute("cardID", cardID);
					request.getRequestDispatcher("Success.jsp").forward(request,response);
				} else {
					//Failure
					System.out.println("Sign In Failure, Error Password");
					request.setAttribute("cardID", cardID);
					request.getRequestDispatcher("SignIn.jsp").forward(request, response);
				}
			} else {
				//Failure
				System.out.println("Sign In Failure, Need Register");
				request.setAttribute("cardID", cardID);
				request.getRequestDispatcher("Register.jsp").forward(request, response);
			}
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
