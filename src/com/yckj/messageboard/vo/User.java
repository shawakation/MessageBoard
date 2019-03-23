/**
 * Copyright (c) 2017, 2020, YCHS-英才汇硕信息科技有限公司. All rights reserved.
 */
package com.yckj.messageboard.vo;

/**
 * 用户类，用于封装用户数据
 * @author admin
 * @version 1.0 
 * @date 2018年10月16日 下午3:47:31
 */
public class User {
	String userid;//不一定与数据库的字段名相同
	String username;
	String psw;
	String realName;
	int age;
	String sex;
	String school;
	String email;
	String tel;
	 
	public User() {
		super();
	}


	public User(String userid, String username, String psw, String realName, int age, String sex, String school,
			String email, String tel) {
		super();
		this.userid = userid;
		this.username = username;
		this.psw = psw;
		this.realName = realName;
		this.age = age;
		this.sex = sex;
		this.school = school;
		this.email = email;
		this.tel = tel;
	}


	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPsw() {
		return psw;
	}


	public void setPsw(String psw) {
		this.psw = psw;
	}


	public String getRealName() {
		return realName;
	}


	public void setRealName(String realName) {
		this.realName = realName;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public String getSchool() {
		return school;
	}


	public void setSchool(String school) {
		this.school = school;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}	
}
