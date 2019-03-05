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
 * Servlet implementation class PwdUpdateServlet
 */
@WebServlet("/PwdUpdateServlet")
public class PwdUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PwdUpdateServlet() {
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
		String oldPwd = request.getParameter("oldPwd");
		String newPwd = request.getParameter("newPwd");
		
		int status = stuDB.updatePwd(cardID, oldPwd, newPwd);
		
		if(status == 0) {
			System.out.println("Pwd Modification Successfully");
			//session unbound
			HttpSession session = request.getSession(true);
			session.invalidate();
			
			request.setAttribute("cardID", cardID);
			request.getRequestDispatcher("SignIn.jsp").forward(request, response);
		} else if(status == 1) {
			System.out.println("Pwd Modification Failure");
			request.getRequestDispatcher("Failure.jsp").forward(request, response);
		} else {
			request.setAttribute("tip", "Old Password Is Incorrect");
			request.getRequestDispatcher("PwdPersonUpdate.jsp").forward(request, response);
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
