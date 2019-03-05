package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.StudentDaoClass;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cardID = request.getParameter("cardID");
		
		StudentDaoClass stuDB = new StudentDaoClass();
		
		String fileJSP = "Failure.jsp";
		
		if(stuDB.delete(cardID)) {
			System.out.println("Delete Successfully");
			HttpSession session = request.getSession();
			if(session.getAttribute("admin") != null) {
				fileJSP = "SelectAllServlet";
			} else {
				fileJSP = "SignIn.jsp";
			}
			request.getRequestDispatcher(fileJSP).forward(request, response);
		} else {
			System.out.println("Delete Failure");
			response.sendRedirect(fileJSP);
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
