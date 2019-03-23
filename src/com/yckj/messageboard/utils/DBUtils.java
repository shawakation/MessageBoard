package com.yckj.messageboard.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Copyright(c) 2018 英才汇硕信息科技有限公司. All rights reserved
 * 
 * 数据库连接操作工具类，用于数据连接的获取、释放、操作
 * 
 * @author zhoujy
 * @version 1.0
 * date 20180921
 *
 */
public class DBUtils {
	private static final String URL="jdbc:mysql://123.56.12.60:3306/messageboard?autoReconnect=true&useUnicode=true&characterEncoding=utf8";
	private static final String USER = "root";
	private static final String PASSWORD ="root";
	
	protected static Statement s = null;
	protected static ResultSet rs = null;
	protected static Connection conn = null;
	
	/**
	 * 连接获取静态方法，用于获取数据库连接
	 * @return
	 */
	public static synchronized Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL,USER,PASSWORD);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 添加、修改、删除操作语句执行方法
	 * @param sql
	 * @return
	 */
	public static int executeUpdate(String sql) {
		int result = 0;
		try {
			s = getConnection().createStatement();
			result = s.executeUpdate(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 查询操作语句执行方法
	 * @param sql
	 * @return
	 */
	public static ResultSet executeQuery(String sql) {
		try {
			s = getConnection().createStatement();
			rs= s.executeQuery(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return rs;
	} 
	
	/**
	 * 预编译操作模板获取方法
	 * @param sql
	 * @return
	 */
	public static PreparedStatement executePreparedStatement(String sql) {
		PreparedStatement ps=null;
		try {
			ps = getConnection().prepareStatement(sql);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ps;
	}
	
	/**
	 * 操作回滚方法
	 */
	public static void rollback() {
		try {
			getConnection().rollback();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 资源释放操作方法
	 */
	public static void close() {
		try {
			if(rs!=null)
				rs.close();
			if(s!=null)
				s.close();
			if(conn!=null)
				conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
