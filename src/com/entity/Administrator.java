package com.entity;

import java.io.Serializable;

public class Administrator implements Serializable,Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1037488192630378423L;
	
	private String name;
	private String pwd;
	
	public Administrator() {
		this("", "");
	}
	
	public Administrator(String name, String pwd) {
		this.name = name;
		this.pwd = pwd;
	}
	
	public String getName() {
		return this.name;
	}

	public String getPwd() {
		return this.pwd;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
