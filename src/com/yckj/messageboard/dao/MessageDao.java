package com.yckj.messageboard.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yckj.messageboard.vo.MessageInfo;

/**
 * Copyright(c) 2018 英才汇硕信息科技有限公司. All rights reserved
 * 
 * 留言数据模型操作实体
 * 
 * @author zhoujy
 * @version 1.0
 * @date 2018-10-18
 */
public class MessageDao {
	
	/**
	 * 发布留言记录操作
	 * @param messageInfo 需要发布的留言信息
	 * @return 操作的结果，false代表发布失败，true代表发布成功
	 */
	public boolean insertMessage(MessageInfo messageInfo) {
		//result变量用于记录是否操作数据成功，如果值为false代表操作失败
		boolean result = false;
		
		Connection connection = null;
		PreparedStatement ps = null;
		
		/*
		 * 数据库连接字符串，用于连接数据库，需要指明连接的数据库库名，其中
		 * messageboard就代表库名，需要进行替换
		 */
		//123.56.12.60
		//String url = "jdbc:mysql://localhost:3306/messageboard?autoReconnect=true&useUnicode=true&characterEncoding=utf8";
		String url = "jdbc:mysql://123.56.12.60:3306/messageboard?autoReconnect=true&useUnicode=true&characterEncoding=utf8";
		try {
			//通过此两行代码获取数据库连接
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url,"root","root");
			
			//定义执行sql语句模板
			String sql = "INSERT INTO messageinfo\r\n" + 
					"(id,title,messageinfo,fromuser,fromdate,toUser)\r\n" + 
					"VALUES\r\n" + 
					"(?,?,?,?,?,?)";
			
			//执行预编译模板
			ps = connection.prepareStatement(sql);
			
			//将具体的留言记录信息添加到sql语句当中去
			ps.setInt(1, messageInfo.getId());
			//ps.setString(1, messageInfo.getId() + "");
			ps.setString(2, messageInfo.getTitle());
			ps.setString(3, messageInfo.getMessageInfo());
			ps.setString(4, messageInfo.getFromUser());
			ps.setString(5, messageInfo.getFromdate());
			ps.setString(6, messageInfo.getToUser());
			
			//真正将带有数据的sql进行执行，flag代表影响的行数
			int flag = ps.executeUpdate();
			if(flag == 0) {
				result = false;
			}else {
				result = true;
			}
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return result;
	}
	
	/**
	 * 通过用户名来查询当前传入的用户是否存在，
	 * 如果存在，则返回true;
	 * 如果不存在，则返回false。
	 * @param username 要查询的用户名称
	 * @return 是否存在该用户
	 */
	public boolean queryUserByName(String username) {
		boolean result = false;
		
		Connection connection = null;
		PreparedStatement ps = null;
		
		/*
		 * 数据库连接字符串，用于连接数据库，需要指明连接的数据库库名，其中
		 * messageboard就代表库名，需要进行替换
		 */
		//String url = "jdbc:mysql://localhost:3306/messageboard?autoReconnect=true&useUnicode=true&characterEncoding=utf8";
		String url = "jdbc:mysql://123.56.12.60:3306/messageboard?autoReconnect=true&useUnicode=true&characterEncoding=utf8";
		try {
			//通过此两行代码获取数据库连接
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url,"root","root");
			
			//定义执行sql语句模板
			String sql = "SELECT * from users WHERE username = ?";
			
			//执行预编译模板
			ps = connection.prepareStatement(sql);
			
			//将具体的留言记录信息添加到sql语句当中去
			ps.setString(1, username);
			
			//真正将带有数据的sql进行执行，flag代表影响的行数
			String usernameOut = null;
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				usernameOut = resultSet.getString("username");
			}
			
			//对于字符串String类型数据的比较，要使用equals方法来进行比较
			if(username.equals(usernameOut)) {
			//if(username == usernameOut) {
				result = true;
			}else{
				result = false;
			}
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return result;
	}
	
	/**
	 * 通过toUser收件人名称查询该用户的收件信息
	 * @param toUser 收件人名称
	 * @return MessageInfo类型的集合，用于存放零条或者多条留言信息记录
	 */
	public List<MessageInfo> queryMessageByToUser(String toUser) {
		//MessageInfo类型的集合，用于存放零条或者多条留言信息记录
		List<MessageInfo> messageInfoList = new ArrayList<>();
		
		Connection connection = null;
		PreparedStatement ps = null;
		
		/*
		 * 数据库连接字符串，用于连接数据库，需要指明连接的数据库库名，其中
		 * messageboard就代表库名，需要进行替换
		 */
		//String url = "jdbc:mysql://localhost:3306/messageboard?autoReconnect=true&useUnicode=true&characterEncoding=utf8";
		String url = "jdbc:mysql://123.56.12.60:3306/messageboard?autoReconnect=true&useUnicode=true&characterEncoding=utf8";
		try {
			//通过此两行代码获取数据库连接
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url,"root","root");
			
			//定义执行sql语句模板
			String sql = "SELECT * FROM messageinfo WHERE touser = ?";
			
			//执行预编译模板
			ps = connection.prepareStatement(sql);
			
			//将具体的留言记录信息添加到sql语句当中去
			ps.setString(1, toUser);
			
			//真正将带有数据的sql进行执行，flag代表影响的行数
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				String id = resultSet.getString("id");
				String title = resultSet.getString("title");
				String messageInfoStr = resultSet.getString("messageinfo");
				String fromUser = resultSet.getString("fromuser");
				String fromDate = resultSet.getString("fromdate");
				
				//将数据库中的一条记录存放于一个MessageInfo对象当中
				MessageInfo messageInfo = new MessageInfo();
				messageInfo.setId(Integer.parseInt(id));
				messageInfo.setTitle(title);
				messageInfo.setMessageInfo(messageInfoStr);
				messageInfo.setFromUser(fromUser);
				messageInfo.setFromdate(fromDate);
				messageInfoList.add(messageInfo);
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return messageInfoList;
	}
	
	/**
	 * 通过id来删除对应的留言信息
	 * @param id
	 * @return
	 */
	public boolean deleteMessageById(int id) {
		boolean result = false;
		
		Connection connection = null;
		PreparedStatement ps = null;
		
		/*
		 * 数据库连接字符串，用于连接数据库，需要指明连接的数据库库名，其中
		 * messageboard就代表库名，需要进行替换
		 */
		//String url = "jdbc:mysql://localhost:3306/messageboard?autoReconnect=true&useUnicode=true&characterEncoding=utf8";
		String url = "jdbc:mysql://123.56.12.60:3306/messageboard?autoReconnect=true&useUnicode=true&characterEncoding=utf8";
		try {
			//通过此两行代码获取数据库连接
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url,"root","root");
			
			//定义执行sql语句模板
			String sql = "DELETE FROM messageinfo WHERE id = ?";
			
			//执行预编译模板
			ps = connection.prepareStatement(sql);
			
			//将具体的留言记录信息添加到sql语句当中去
			ps.setInt(1, id);
			
			//真正将带有数据的sql进行执行，flag代表影响的行数
			int flag = ps.executeUpdate();
			if(flag > 0) {
				result = true;
			}else {
				result = false;
			}
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		MessageDao messageDao = new MessageDao();
		List<MessageInfo> messageInfoList = messageDao.queryMessageByToUser("lisi");
		System.out.println(messageInfoList.get(0).getMessageInfo());
		System.out.println(messageInfoList.get(1).getTitle());
	}

}
