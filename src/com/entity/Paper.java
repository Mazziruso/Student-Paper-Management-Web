package com.entity;

import java.io.Serializable;

public class Paper implements Serializable, Cloneable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6115387282206672555L;
	private String title;
	private String URL;
	
	public Paper() {
		this(null, null);
	}
	
	public Paper(String title, String URL) {
		this.title = title;
		this.URL = URL;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getURL() {
		return this.URL;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setURL(String URL) {
		this.URL = URL;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
