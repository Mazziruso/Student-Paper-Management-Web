package com.entity;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable, Cloneable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2710820901930537171L;
	private int id;
	private int cardID;
	private String name;
	private String pwd;
	private String sex;
	private String tutor;
	private String specialty;
	private int papers;
	private List<String> title;
	private List<String> URL;
	
	public User() {
		this(1,0,"","","","","",0);
	}
	
	public User(int id, int cardId, String name, String pwd, String sex, String tutor, String specialty, int papers) {
		this.id = id;
		this.cardID = cardId;
		this.name = name;
		this.pwd = pwd;
		this.sex = sex;
		this.tutor = tutor;
		this.specialty = specialty;
		this.papers = papers;
		this.title = null;
		this.URL = null;
	}
	
	public int getId() {
		return this.id;
	}
	public int getCardID() {
		return this.cardID;
	}
	public String getName() {
		return this.name;
	}
	public String getPwd() {
		return this.pwd;
	}
	public String getSex() {
		return this.sex;
	}
	public String getTutor() {
		return this.tutor;
	}
	public String getSpecialty() {
		return this.specialty;
	}
	public int getPapers() {
		return this.papers;
	}
	public List<String> getTitle() {
		return this.title;
	}
	public List<String> getURL() {
		return this.URL;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setCardID(int cardId) {
		this.cardID = cardId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public void setTutor(String tutor) {
		this.tutor = tutor;
	}
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	public void setPapers(int papers) {
		this.papers = papers;
	}
	public void setTitle(List<String> title) {
		this.title = title;
	}
	public void setURL(List<String> URL) {
		this.URL = URL;
	}
	public void appendPaper(String title, String URL) {
		this.papers++;
		this.title.add(title);
		this.URL.add(URL);
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
