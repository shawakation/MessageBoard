package com.yckj.messageboard.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yckj.messageboard.service.MessageService;
import com.yckj.messageboard.vo.MessageInfo;

/**
 * Copyright(c) 2018 英才汇硕信息科技有限公司. All rights reserved
 * 
 * 发布留言控制器
 * 
 * @author zhoujy
 * @version 1.0
 * @date 2018-10-18
 */
@WebServlet("/SendMessageServlet")
public class SendMessageServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取页面上的内容信息
		String fromuser = request.getParameter("fromuser");
		String toUser = request.getParameter("toUser");
		String title = request.getParameter("title");
		String messageInfoStr = request.getParameter("messageInfo");
		
		//获取留言信息的id以及发送时间
		int id = (int)(Math.random() * 10000);
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = simpleDateFormat.format(date);
		
		//将获取到的信息存放到MessageInfo对象当中，用于方法的传递
		MessageInfo messageInfo = new MessageInfo();
		messageInfo.setId(id);
		messageInfo.setTitle(title);
		messageInfo.setMessageInfo(messageInfoStr);
		messageInfo.setFromdate(dateStr);
		messageInfo.setFromUser(fromuser);
		messageInfo.setToUser(toUser);
		
		//调用发件的业务层代码
		MessageService messageService = new MessageService();
		boolean result = messageService.sendMessageInfo(messageInfo);
		if(result) {
			request.setAttribute("message","发送留言成功！");
			request.getRequestDispatcher("sendMessage.jsp").forward(request, response);//跳转网页
		}else {
			request.setAttribute("messageInfo", messageInfo);
			request.setAttribute("message","发送留言失败！");
			request.getRequestDispatcher("sendMessage.jsp").forward(request, response);//跳转网页
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
