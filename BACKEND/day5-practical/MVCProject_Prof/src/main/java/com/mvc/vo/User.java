package com.mvc.vo;

public class User {
	private String id;
	private String pass;
	
	public User() {}	
	
	public User(String id, String pw) {
		this.id = id;
		this.pass = pw;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pass;
	}
	public void setPw(String pw) {
		this.pass = pw;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", pw=" + pass + "]";
	}
	
}
