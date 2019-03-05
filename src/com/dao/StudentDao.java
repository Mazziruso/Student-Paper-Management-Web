package com.dao;

import java.util.List;
import com.entity.User;
import com.entity.Paper;

public interface StudentDao {
	public boolean logIn(String cardID, String pwd);
	public boolean register(User user);
	public List<User> getAllUser();
	public User getUser(String cardID);
	public boolean existUser(String cardID);
	public boolean delete(String cardID);
	public boolean update(String cardID, String name, String sex, String tutor, String specialty, int papers);
	public int updatePwd(String cardID, String oldPwd, String newPwd);
	public boolean appendPaper(String cardID, String title, String URL);
	public boolean removePaper(String cardID, String title);
	public List<Paper> getPapers(String cardID);
}
