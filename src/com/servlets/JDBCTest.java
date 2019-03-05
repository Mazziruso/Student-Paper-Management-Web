package com.servlets;

import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JDBCTest
 */
@WebServlet("/JDBCTest")
public class JDBCTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//JDBC Parameter
	private static final String USER = "root";
	private static final String PWD = "1234";
	private static final String URL = "jdbc:mysql://localhost:3306/students";
	
	private static Connection conn = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JDBCTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter pw = response.getWriter();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USER, PWD);
			if (conn != null) {
				stmt = conn.createStatement();
			}
			if (stmt != null) {
				rs = stmt.executeQuery("SELECT * FROM stu");
				pw.println("<html><head>Info</head>");
				while(rs.next()) {
					pw.println("<br/>");
					pw.println("<body><h1 align=\"CENTER\">name: " + rs.getString("name") + "</h1>"
							+ "<h1 align=\"CENTER\">card ID:" + rs.getInt("cardID") + "</h1>"
							+ "<h1 align=\"CENTER\">password:" + rs.getString("pwd") + "</h1>"
							+ "<h1 align=\"CENTER\">sex:" + rs.getString("sex") + "</h1>"
							+ "<h1 align=\"CENTER\">tutor:" + rs.getString("tutor") + "</h1>"
							+ "<h1 align=\"CENTER\">special field:" + rs.getString("specialty") + "</h1>"
							+ "<h1 align=\"CENTER\">paper number:" + rs.getInt("papers") + "</h1>"
							+ "</body>");
				}
				pw.println("</html>");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(rs != null) {
				rs.close();
				rs = null;
			}
			if(stmt != null) {
				stmt.close();
				stmt = null;
			}
			if(conn != null) {
				conn.close();
				conn = null;
			}
			if(pw != null) {
				pw.close();
			}
		} catch(SQLException e) {
			e.printStackTrace();
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
