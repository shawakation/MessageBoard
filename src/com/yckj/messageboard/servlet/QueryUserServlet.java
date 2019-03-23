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
 * Servlet implementation class QueryUserServlet
 */
@WebServlet("/QueryUserServlet")
public class QueryUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//从session中获取当前登录用户的信息
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		//获取该用户的id信息
		String userId = user.getUserid();
		
		//查询用户所有的信息
		UserService userService = new UserService();
		User queryUserInfo = userService.queryUser(Integer.parseInt(userId));
		
		//将查询出来的信息携带到页面中
		request.setAttribute("queryUserInfo", queryUserInfo);
		request.getRequestDispatcher("/userInfo.jsp").forward(request, response);//跳转网页
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
