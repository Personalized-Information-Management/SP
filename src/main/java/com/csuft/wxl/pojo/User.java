package com.csuft.wxl.pojo;

public class User {
	String id;
	String user_pwd;
	String user_per;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUser_pwd() {
		return user_pwd;
	}

	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}

	public String getUser_per() {
		return user_per;
	}

	public void setUser_per(String user_per) {
		this.user_per = user_per;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", user_pwd=" + user_pwd + ", user_per=" + user_per + "]";
	}

}
