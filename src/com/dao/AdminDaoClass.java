package com.dao;

import java.util.List;
import java.util.ArrayList;
import com.entity.Administrator;

import java.sql.*;
import com.util.DB;

public class AdminDaoClass implements AdminDao {
	
	private DB db;
	
	public AdminDaoClass() {
		this.db = new DB();
	}
	
	public AdminDaoClass(String URL) {
		this.db = new DB(URL);
	}

	@Override
	public boolean logIn(String name, String pwd) {
		// TODO Auto-generated method stub
		this.db.init();
		boolean flag = false;
		
		try {
			ResultSet rs = this.db.select("SELECT count(*) FROM admin_user WHERE name='" + name + "' and pwd='" + pwd + "'");
			while(rs.next()) {
				if(rs.getInt(1) > 0) {
					flag = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		this.db.finishConn();
		return flag;
	}

	@Override
	public boolean register(Administrator admin) {
		// TODO Auto-generated method stub
		this.db.init();
		boolean flag = false;
		int num = this.db.addUpDel("INSERT INTO admin_user (name,pwd) VALUES ('"
				+ admin.getName() + "','"
				+ admin.getPwd() + "')");
		flag = num>0 ? true : false;
		this.db.finishConn();
		return flag;
	}

	@Override
	public List<String> getAllAdmin() {
		// TODO Auto-generated method stub
		this.db.init();
		List<String> list = new ArrayList<String>();
		
		try {
			ResultSet rs = this.db.select("SELECT name FROM admin_user");
			while(rs.next()) {
				list.add(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.db.finishConn();
		return list;
	}

	@Override
	public boolean existAdmin(String name) {
		// TODO Auto-generated method stub
		this.db.init();
		boolean flag = false;
		try {
			ResultSet rs = this.db.select("SELECT count(*) FROM admin_user WHERE name='" + name + "'");
			while(rs.next()) {
				if(rs.getInt(1) > 0) {
					flag = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.db.finishConn();
		return flag;
	}

	@Override
	public boolean delete(String name) {
		// TODO Auto-generated method stub
		this.db.init();
		boolean flag = false;
		
		int num = this.db.addUpDel("DELETE FROM admin_user WHERE name='" + name + "'");
		flag = (num>=0) ? true : false;
		
		this.db.finishConn();
		return flag;
	}

}
