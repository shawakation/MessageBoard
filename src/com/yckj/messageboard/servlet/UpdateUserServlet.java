package com.yckj.messageboard.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yckj.messageboard.service.UserService;
import com.yckj.messageboard.vo.User;

/**
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String username = request.getParameter("username");//此处的username是网页上输入框的名字
		String psw = request.getParameter("password");// 这里的名字和网页上一样，包括大小写
		String realName = request.getParameter("name");//网页上叫name
		String age = request.getParameter("age");
		String sex = request.getParameter("sex");
		String school = request.getParameter("school");
		String email = request.getParameter("email");
		String tel = request.getParameter("telephone");
		
		User user = new User();
		user.setUserid(id);
		user.setUsername(username);
		user.setPsw(psw);
		user.setRealName(realName);
		user.setAge(Integer.parseInt(age));//  age是字符串，数据库要的是int，所以要转换
		user.setSex(sex);
		user.setSchool(school);
		user.setEmail(email);
		user.setTel(tel);
		
		UserService userService = new UserService();
		boolean result = userService.updateUserById(user);
		if(result) {
			request.setAttribute("message", "修改成功！");
		}else {
			request.setAttribute("message", "修改失败！");
		}
		
		//跳转到userInfo.jsp页面
		request.getRequestDispatcher("/userInfo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
