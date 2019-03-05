package com.dao;

import java.util.List;
import com.util.DB;
import com.entity.User;
import java.sql.*;
import java.util.ArrayList;
import com.entity.Paper;

public class StudentDaoClass implements StudentDao {
	
	private DB db;
	
	public StudentDaoClass() {
		this.db = new DB();
	}
	
	public StudentDaoClass(String URL) {
		this.db = new DB(URL);
	}

	@Override
	public boolean logIn(String cardID, String pwd) {
		// TODO Auto-generated method stub
		this.db.init();
		boolean flag = false;
		try {
			ResultSet rs = this.db.select("SELECT count(*) FROM stu WHERE cardID=" + cardID + " and pwd='" + pwd + "' FOR UPDATE");
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
	public boolean register(User user) {
		// TODO Auto-generated method stub
		this.db.init();
		boolean flag = false;
		int num = this.db.addUpDel("INSERT INTO stu (cardID,name,pwd,sex,tutor,specialty,papers) VALUES ("
				+ user.getCardID() + ",'"
				+ user.getName() + "','"
				+ user.getPwd() + "','"
				+ user.getSex() + "','"
				+ user.getTutor() + "','"
				+ user.getSpecialty() + "','"
				+ user.getPapers() + "')");
		flag = num>0 ? true : false;
		this.db.finishConn();
		return flag;
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		this.db.init();
		List<User> list = new ArrayList<User>();
		
		try {
			ResultSet rs = this.db.select("SELECT * FROM stu FOR UPDATE");
			while(rs.next()) {
				User user = new User();
				user.setCardID(rs.getInt("cardID"));
				user.setName(rs.getString("name"));
				user.setPwd(rs.getString("pwd"));
				user.setSex(rs.getString("sex"));
				user.setTutor(rs.getString("tutor"));
				user.setSpecialty(rs.getString("specialty"));
				user.setPapers(rs.getInt("papers"));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.db.finishConn();
		return list;
	}

	@Override
	public User getUser(String cardID) {
		this.db.init();
		User user = new User();
		try {
			ResultSet rs = this.db.select("SELECT * FROM stu WHERE cardID=" + cardID + " FOR UPDATE");
			while(rs.next()) {
				user.setCardID(rs.getInt("cardID"));
				user.setName(rs.getString("name"));
				user.setPwd(rs.getString("pwd"));
				user.setSex(rs.getString("sex"));
				user.setTutor(rs.getString("tutor"));
				user.setSpecialty(rs.getString("specialty"));
				user.setPapers(rs.getInt("papers"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.db.finishConn();
		return user;
	}
	
	@Override
	public boolean existUser(String cardID) {
		
		this.db.init();
		boolean flag = false;
		
		try {
			ResultSet rs = this.db.select("SELECT count(*) FROM stu WHERE cardID=" + cardID + " FOR UPDATE");
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
	public boolean delete(String cardID) {
		// TODO Auto-generated method stub
		this.db.init();
		boolean flag = true;
		
		int num = this.db.addUpDel("DELETE FROM stu WHERE cardID=" + cardID);
		flag = num >= 0 ? true : false;
		
		this.db.finishConn();
		return flag;
	}

	@Override
	public boolean update(String cardID, String name, String sex, String tutor, String specialty, int papers) {
		// TODO Auto-generated method stub
		this.db.init();
		boolean flag = false;
		
		int num = this.db.addUpDel("UPDATE stu SET "
				+ "name='" + name 
				+ "',sex='" + sex
				+ "',tutor='" + tutor
				+ "',specialty='" + specialty
				+ "',papers=" + papers + " WHERE cardID=" + cardID);
		flag = num > 0 ? true : false;
		this.db.finishConn();
		return flag;
	}
	
	@Override
	public int updatePwd(String cardID, String oldPwd, String newPwd) {
		this.db.init();
		/*
		 * status = 0: denote update successful 
		 * status = 1: denote update failure
		 * status = 2: denote oldPwd can not match with input
		 */
		int status = 0;
		
		try {
			ResultSet rs = this.db.select("SELECT pwd FROM stu WHERE cardID=" + cardID + " FOR UPDATE");
			while(rs.next()) {
				if(!oldPwd.equals(rs.getString(1))) {
					status = 2;
					return status;
				}
			}
			int num = this.db.addUpDel("UPDATE stu SET pwd='" + newPwd + "' WHERE cardID=" + cardID);
			status = num>0 ? 0 : 1;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		this.db.finishConn();
		return status;
	}

	@Override
	public boolean appendPaper(String cardID, String title, String URL) {
		// TODO Auto-generated method stub
		this.db.init();
		boolean flag = false;
		int papers = 1; //Add One Paper Newly
		try {
			ResultSet rs = this.db.select("SELECT papers FROM stu WHERE cardID=" + cardID + " FOR UPDATE");
			while(rs.next()) {
				papers += rs.getInt("papers");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		int num_stu = this.db.addUpDel("UPDATE stu SET papers=" + papers + " WHERE cardID=" + cardID);
		int num_papers = this.db.addUpDel("INSERT INTO papers (cardID,title,url) VALUES "
				+ "(" + cardID 
				+ ",'" + title
				+ "','" + URL + "')");
		
		flag = (num_stu>0 && num_papers>0) ? true : false;
		this.db.finishConn();
		return flag;
	}
	
	@Override
	public boolean removePaper(String cardID, String title) {
		
		this.db.init();
		
		boolean flag = false;
		
		try {
			int num_stu = 0;
			int papers = 0;
			int num_paper = this.db.addUpDel("DELETE FROM papers WHERE cardID=" + cardID + " AND title='" + title + "'");
			ResultSet rs = this.db.select("SELECT papers FROM stu WHERE cardID=" + cardID + " FOR UPDATE");
			while(rs.next()) {
				papers = rs.getInt(1) - 1;
				num_stu += this.db.addUpDel("UPDATE stu SET papers=" + papers + " WHERE cardID=" + cardID);
			}
			flag = (num_paper>=0 && num_stu>=0) ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		this.db.finishConn();
		return flag;
	}
	
	@Override
	public List<Paper> getPapers(String cardID) {
		this.db.init();
		
		List<Paper> list = new ArrayList<Paper>();
		try {
			ResultSet rs = this.db.select("SELECT * FROM papers WHERE cardID=" + cardID + " FOR UPDATE");
			while(rs.next()) {
				Paper paper = new Paper(rs.getString("title"), rs.getString("url"));
				list.add(paper);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		this.db.finishConn();
		return list;
	}

}
