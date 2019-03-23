package com.yckj.messageboard.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yckj.messageboard.service.MessageService;

/**
 * Copyright(c) 2018 英才汇硕信息科技有限公司. All rights reserved
 * 
 * 删除留言信息控制器
 * 
 * @author zhoujy
 * @version 1.0
 * @date 2018-10-19
 */
@WebServlet("/DeleteMessageServlet")
public class DeleteMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMessageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		//调用MessageService当中的删除方法
		MessageService messageService = new MessageService();
		messageService.deleteMessageById(Integer.parseInt(id));
		
		request.getRequestDispatcher("/QueryMessageServlet").forward(request, response);//跳转网页
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
