package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dao.StudentDaoClass;
import com.entity.User;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		StudentDaoClass stuDB = new StudentDaoClass();
		
		String cardIDStr = request.getParameter("cardID");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String sex = request.getParameter("sex");
		String tutor = request.getParameter("tutor");
		String specialty = request.getParameter("specialty");
		int cardID = Integer.valueOf(cardIDStr).intValue();
		
		User user = new User();
		user.setCardID(cardID);
		user.setPwd(pwd);
		user.setName(name);
		user.setSex(sex);
		user.setTutor(tutor);
		user.setSpecialty(specialty);
		
		if(stuDB.register(user)) {
			System.out.println("Register Successfully");
			request.setAttribute("cardID", cardIDStr);
			request.getRequestDispatcher("SignIn.jsp").forward(request,response);
		} else {
			//Failure
			System.out.println("Register Failure");
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
