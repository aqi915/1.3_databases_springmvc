package com.kingtop.databases.mongodb.model;


public class User {
	private String uid;
	private String upassword;
	private String usex;
	private String uname;
	private String age;
	
	public User() {
		super();
	}
	
	public User(String uid, String upassword, String usex, String uname, String age) {
		super();
		this.uid = uid;
		this.upassword = upassword;
		this.usex = usex;
		this.uname = uname;
		this.age = age;
	}



	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	public String getUsex() {
		return usex;
	}
	public void setUsex(String usex) {
		this.usex = usex;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}


}