package com.util;

import java.sql.*;

public class DB {
	private String URL;
	private static String USER = "root";
	private static String PWD = "1234";
	private Connection conn;
	private PreparedStatement pstmt;
	
	public DB() {
		this.URL = "jdbc:mysql://localhost:3306/students";
		this.conn = null;
		this.pstmt = null;
	}
	
	public DB(String URL) {
		this.URL = URL;
		this.conn = null;
		this.pstmt = null;
	}
	
	public void init() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.conn = DriverManager.getConnection(URL, USER, PWD);
			this.conn.setAutoCommit(false);
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int addUpDel(String SQL) {
		int num = 0;
		try {
			pstmt = conn.prepareStatement(SQL);
			num = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}
	
	public ResultSet select(String SQL) {
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public void finishConn() {
		try {
			if(pstmt != null) {
				pstmt.close();
				pstmt = null;
			}
			if(conn != null) {
				conn.setAutoCommit(true);
				conn.close();
				conn = null;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
