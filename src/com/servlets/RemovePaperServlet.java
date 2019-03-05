package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dao.StudentDaoClass;

/**
 * Servlet implementation class RemovePaperServlet
 */
@WebServlet("/RemovePaperServlet")
public class RemovePaperServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemovePaperServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		StudentDaoClass stuDB = new StudentDaoClass();
		String cardID = request.getParameter("cardID");
		String title = request.getParameter("title");
		
		if(stuDB.removePaper(cardID, title)) {
			System.out.println("Remove Paper Successfully");
			request.getRequestDispatcher("PersonInfo.jsp").forward(request, response);
		} else {
			System.out.println("Remove Paper Failure");
			request.getRequestDispatcher("Failure.jsp").forward(request, response);
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
