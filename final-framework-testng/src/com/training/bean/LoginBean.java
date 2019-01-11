package com.training.bean;

public class LoginBean {
	private String userName;
	//private String password;
	private String fname;
	private String lname;
	private String mail;

	public LoginBean() {
	}

	public LoginBean(String userName, String fname, String lname, String mail ) {
		super();
		this.userName = userName;
		//this.password = password;
		this.fname= fname;
		this.lname= lname;
		this.mail= mail;
		
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getfname() {
		return fname;
	}

	public void setfname(String fname) {
		this.fname = fname;
	}
	
	public String getlname() {
		return lname;
	}

	public void setlname(String lname) {
		this.lname = lname;
	}
	
	public String getmail() {
		return mail;
	}

	public void setmail(String mail) {
		this.mail = mail;
	}

	//public String getPassword() {
		//return password;
	//}/

	//public void setPassword(String password) {
		//this.password = password;
	//}

	//@Override
	//public String toString() {
		//return "LoginBean [userName=" + userName + ", password=" + password + "]";
	//}

}
