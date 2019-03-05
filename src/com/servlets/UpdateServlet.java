package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dao.StudentDaoClass;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cardID = request.getParameter("cardID");
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String tutor = request.getParameter("tutor");
		String specialty = request.getParameter("specialty");
		String papersStr = request.getParameter("papers");
		int papers = Integer.valueOf(papersStr).intValue();
		
		StudentDaoClass stuDB = new StudentDaoClass();
		
		if(stuDB.update(cardID, name, sex, tutor, specialty, papers)) {
			System.out.println("Update Successfully");
			request.getRequestDispatcher("PersonInfo.jsp").forward(request, response);
		} else {
			//Failure
			System.out.println("Update Failure");
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
