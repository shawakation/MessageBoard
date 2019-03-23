package com.yckj.messageboard.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yckj.messageboard.service.UserService;
import com.yckj.messageboard.vo.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//1.接收登录网页login.jsp传来的数据（用户名和密码）
		String uname=request.getParameter("username");//username是网页文本框的名字
		String upsw=request.getParameter("password");//网页上密码框的名字，大小写完全相同
		//2.调用UserService中的login方法做登录验证
		UserService userService=new UserService();
		User user = userService.login(uname, upsw);
		
		//根据flag的值做相应的反应；如果登录成功，跳转到indexk.jsp页面；如果失败了，在login.jsp上提示
		//用户名密码错误
		if (user.getUserid() != null) {
			//3.如果当前用户存在，则进行页面跳转，跳转到首页，
			//在跳转之前，将该用户的信息记录到session仓储域中
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			
			request.getRequestDispatcher("/QueryMessageServlet").forward(request, response);//跳转网页
		}else {
			request.setAttribute("loginTip","用户名或密码错误！");//设置提示信息，将来在login.jsp上显示
			request.getRequestDispatcher("login.jsp").forward(request, response);
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
