package com.dao;

import java.util.List;

import com.entity.Administrator;;

public interface AdminDao {
	public boolean logIn(String name, String pwd);
	public boolean register(Administrator admin);
	public List<String> getAllAdmin();
	public boolean existAdmin(String name);
	public boolean delete(String name);
}
