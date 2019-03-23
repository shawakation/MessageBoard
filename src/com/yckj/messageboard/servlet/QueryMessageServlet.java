package com.yckj.messageboard.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yckj.messageboard.service.MessageService;
import com.yckj.messageboard.vo.MessageInfo;
import com.yckj.messageboard.vo.User;

/**
 * Copyright(c) 2018 英才汇硕信息科技有限公司. All rights reserved
 * 
 * 查询留言信息控制器
 * 
 * @author zhoujy
 * @version 1.0
 * @date 2018-10-19
 */
@WebServlet("/QueryMessageServlet")
public class QueryMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryMessageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//从session仓储域当中获取当前登录者信息
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		//获取当前登录者的用户名
		String username = user.getUsername();
		
		//创建留言信息的业务实体
		MessageService messageService = new MessageService();
		List<MessageInfo> messageInfoList = messageService.queryMessageByToUser(username);
		
		//将查询到的List信息携带到首页
		request.setAttribute("messageInfoList",messageInfoList);
		//跳转到index.jsp页面
		request.getRequestDispatcher("/index.jsp").forward(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
