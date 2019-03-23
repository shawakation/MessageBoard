/**
 * Copyright (c) 2017, 2020, YCHS-英才汇硕信息科技有限公司. All rights reserved.
 */
package com.yckj.messageboard.service;

import com.yckj.messageboard.dao.UserDao;
import com.yckj.messageboard.vo.User;

/**
 * @author admin
 * @version 1.0 
 * @date 2018年10月16日 下午4:39:34
 */
public class UserService {
	/**
	 * 用户注册的业务方法（添加用户）
	 * @param user  包含用户信息的对象
	 * @return   如果返回true表示注册成功，否则表示注册失败
	 */
	public boolean addUser(User user) {
		UserDao userDao = new UserDao();
		boolean flag = userDao.insertUser(user);
		return flag;
	}
	/*
	 * 根据用户名和密码登录
	 * 
	*/
	public User login(String uname,String upsw) {
		UserDao userDao=new UserDao();
		User user = userDao.checkUser(uname, upsw);
		return user;
	}
	
	/**
	 * 通过用户id查询用户信息
	 * @param userId
	 * @return
	 */
	public User queryUser(int userId) {
		UserDao userDao = new UserDao();
		User user = userDao.queryUserById(userId);
		return user;
	}
	
	/**
	 * 通过id修改用户信息
	 * @param user
	 * @return
	 */
	public boolean updateUserById(User user) {
		boolean result = false;
		UserDao userDao = new UserDao();
		result = userDao.updateUserById(user);
		return result;
	}
}















