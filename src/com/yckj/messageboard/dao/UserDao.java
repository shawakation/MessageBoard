/*
 * CopyRight (c) 2018 - 2020 英才汇硕信息科技有限公司. 
 */
package com.yckj.messageboard.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.yckj.messageboard.vo.User;

/**
 * 对用户表users进行操作
 * 
 * @author admin
 * @version 1.0 
 */
public class UserDao {
	/**
	 * 把接收到的数据写入数据表users
	 * 0. 注册驱动
	 * 1. 打开数据库连接
	 * 2. 定义SQL语句insert
	 * 3. 准备SQL语句
	 * 4. 给问号赋值
	 * 5. 执行SQL语句（insert）
	 * 6. 如果插入数据成功得到非0整数；失败得到的是0
	 * 7. 关闭数据库连接和pstmt
	 */
	public boolean insertUser(User user) {
		 Connection conn = null;  //代表数据库连接对象
		 PreparedStatement pstmt = null;  //用于准备并执行SQL语句的对象
		 boolean flag = false;   //添加是否成功的标志，如值是true表示成功，否则表示失败
		 
		 //url是连接字符串；localhost是连接的主机；3306是端口号，message是数据库名字(根据自己的实际更改)
		 String url = "jdbc:mysql://123.56.12.60:3306/messageboard?autoReconnect=true&useUnicode=true&characterEncoding=utf8";
		try {
			 Class.forName("com.mysql.jdbc.Driver");//注册MySQL数据库驱动
			//获取数据库连接；url叫做连接字符串；第1个root是数据库用户名；第2个root是数据库密码（根据自己的实际更改）
			 conn = DriverManager.getConnection(url,"root","root");
			 
			 //定义SQL语句insert；问号的次序就是数据库表users中字段的次序,共有9个
			 String sql = "INSERT INTO users VALUES(?,?,?,?,?,?,?,?,?)";
			 //准备SQL语句，此处是插入数据的语句insert
			 pstmt = conn.prepareStatement(sql);
			 pstmt.setString(1,(int)(Math.random() * 10000) + "");//给第1个问号赋值
			 pstmt.setString(2, user.getUsername());//给第2个问号赋值
			 pstmt.setString(3, user.getPsw());
			 pstmt.setString(4, user.getRealName());
			 pstmt.setInt(5, user.getAge());
			 pstmt.setString(6, user.getSex());
			 pstmt.setString(7, user.getSchool());
			 pstmt.setString(8, user.getEmail());
			 pstmt.setString(9, user.getTel());
			 int count = pstmt.executeUpdate();//执行SQL语句insert，如果写入失败，返回值是0
			 if (count == 0) {
				 flag = false; // 写入失败
			 } else {
				 flag = true; //写入成功
			 }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}		 
		 return flag;
	}
	
	/*
	 * 根据用户名和密码查询用户是否存在，存在的，登陆成功，否则失败，操作的表：Users
	 * @param uname 用户名
	 * @param upsw 密码
	 * @param return 返回true 表示登录成功否则失败
	*/
	public User checkUser(String  uname,String upsw){
		Connection conn=null;//数据库连接对像，数据库连接
		PreparedStatement pstmt=null;//执行sql的语句的对象
		ResultSet rs=null;//结果集，存放的是查询到的数据
	
		
		//用来存放查询出来的数据
		User user = new User();
		//1.注册数据库驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");//参数是：MySQL
			//2.获取数据库连接
			//String url="jdbc:mysql://localhost:3306/messageboard?useUnicde=true&characterEncodeing=utf-8";//连接字符串
			String url = "jdbc:mysql://123.56.12.60:3306/messageboard?autoReconnect=true&useUnicode=true&characterEncoding=utf8";
			conn=DriverManager.getConnection(url,"root","root");
			//3.定义并准备SQL语句；select
			String sql="SELECT * FROM users WHERE username=? AND userpsw=?";
			pstmt =conn.prepareStatement(sql);
			pstmt.setString(1, uname);
			pstmt.setString(2, upsw);
			//4.执行SQL语句
			rs=pstmt.executeQuery();
			while(rs.next()) {
				String id = rs.getString("userid");
				String username = rs.getString("username");
				String userpsw = rs.getString("userpsw");
				user.setUserid(id);
				user.setUsername(username);
				user.setPsw(userpsw);
			}
			/*if (rs.next()) {//如果next()返回true，表示rs中有数，否则，表示没数据
				flag=true;
			}else {
				flag=false;
			}*/
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{//5.释放资源，关闭资源
			/*rs.close();//缺陷
			pstmt.close();
			conn.close();*/
			if (rs!=null) {
				try {
				rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} if (pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}if (conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return user;
		
	}
	
	/**
	 * 通过id查询用户信息
	 * @param userId
	 * @return
	 */
	public User queryUserById(int userId){
		Connection conn=null;//数据库连接对像，数据库连接
		PreparedStatement pstmt=null;//执行sql的语句的对象
		ResultSet rs=null;//结果集，存放的是查询到的数据
		
		//用来存放查询出来的数据
		User user = new User();
		//1.注册数据库驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");//参数是：MySQL
			//2.获取数据库连接
			//String url="jdbc:mysql://localhost:3306/messageboard?useUnicde=true&characterEncodeing=utf-8";//连接字符串
			String url = "jdbc:mysql://123.56.12.60:3306/messageboard?autoReconnect=true&useUnicode=true&characterEncoding=utf8";
			conn=DriverManager.getConnection(url,"root","root");
			//3.定义并准备SQL语句；select
			String sql="SELECT * FROM users WHERE userid=?";
			pstmt =conn.prepareStatement(sql);
			pstmt.setInt(1,userId);
			//4.执行SQL语句
			rs=pstmt.executeQuery();
			while(rs.next()) {
				String id = rs.getString("userid");
				String username = rs.getString("username");
				String userpsw = rs.getString("userpsw");
				String realname = rs.getString("realname");
				String age = rs.getString("age");
				String sex = rs.getString("sex");
				String school = rs.getString("school");
				String email = rs.getString("email");
				String tel = rs.getString("tel");
				user.setUserid(id);
				user.setUsername(username);
				user.setPsw(userpsw);
				user.setRealName(realname);
				user.setAge(Integer.parseInt(age));
				user.setSex(sex);
				user.setSchool(school);
				user.setEmail(email);
				user.setTel(tel);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{//5.释放资源，关闭资源
			if (rs!=null) {
				try {
				rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} if (pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}if (conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return user;
	}
	
	/**
	 * 通过id修改用户信息
	 * @param user
	 * @return
	 */
	public boolean updateUserById(User user) {
		boolean result = false;
		
		Connection conn=null;//数据库连接对像，数据库连接
		PreparedStatement pstmt=null;//执行sql的语句的对象
		ResultSet rs=null;//结果集，存放的是查询到的数据
		
		//1.注册数据库驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");//参数是：MySQL
			//2.获取数据库连接
			//String url="jdbc:mysql://localhost:3306/messageboard?useUnicde=true&characterEncodeing=utf-8";//连接字符串
			String url = "jdbc:mysql://123.56.12.60:3306/messageboard?autoReconnect=true&useUnicode=true&characterEncoding=utf8";
			conn=DriverManager.getConnection(url,"root","root");
			//3.定义并准备SQL语句；select
			/*
			 *  UPDATE users
				set 
				username = 'zhangsan001',
				userpsw = '123123',
				realname = '张三001',
				age = '28',
				sex = '女',
				school = '太原科技大学001',
				email = '2222@qq.com',
				tel = '111111112'
				WHERE userid = 1
			 */
			String sql="UPDATE users\r\n" + 
					"set \r\n" + 
					"username = ?,\r\n" + 
					"userpsw = ?,\r\n" + 
					"realname = ?,\r\n" + 
					"age = ?,\r\n" + 
					"sex = ?,\r\n" + 
					"school = ?,\r\n" + 
					"email = ?,\r\n" + 
					"tel = ?\r\n" + 
					"WHERE userid = ?";
			pstmt =conn.prepareStatement(sql);
			pstmt.setString(1,user.getUsername());
			pstmt.setString(2,user.getPsw());
			pstmt.setString(3,user.getRealName());
			pstmt.setInt(4,user.getAge());
			pstmt.setString(5,user.getSex());
			pstmt.setString(6,user.getSchool());
			pstmt.setString(7,user.getEmail());
			pstmt.setString(8,user.getTel());
			pstmt.setInt(9,Integer.parseInt(user.getUserid()));
			
			//4.执行SQL语句
			int flag = pstmt.executeUpdate();
			if(flag>0) {
				result = true;
			}else {
				result = false;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{//5.释放资源，关闭资源
			if (rs!=null) {
				try {
				rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} if (pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}if (conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return result;
	}
	
	
	public static void main(String[] args) {
		UserDao userDao = new UserDao();
		User user = new User("101","zhangsan","123","张三",20,"女","科大","a@a.b","188");
		userDao.insertUser(user);
	}
}