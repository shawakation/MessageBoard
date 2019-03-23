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
 * Servlet implementation class RegistUserServlet
 */
@WebServlet("/RegistUserServlet")
public class RegistUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 *  1. 接收regist.jsp输入的数据
	 *  2. 调用UserService
	 *  3. 给用户提示注册是否成功
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");//此处的username是网页上输入框的名字
		String psw = request.getParameter("password");// 这里的名字和网页上一样，包括大小写
		String realName = request.getParameter("name");//网页上叫name
		String age = request.getParameter("age");
		String sex = request.getParameter("sex");
		String school = request.getParameter("school");
		String email = request.getParameter("email");
		String tel = request.getParameter("telephone");
		
		User user = new User();
		user.setUsername(username);
		user.setPsw(psw);
		user.setRealName(realName);
		user.setAge(Integer.parseInt(age));//  age是字符串，数据库要的是int，所以要转换
		user.setSex(sex);
		user.setSchool(school);
		user.setEmail(email);
		user.setTel(tel);
		
		UserService userService = new UserService(); //使用UserService完成注册
		boolean flag =userService.addUser(user);
		if (flag) {
			request.setAttribute("info", "注册成功！");
		} else {
			request.setAttribute("info", "注册失败！");
		}
		//跳转到regits.jsp页面
		request.getRequestDispatcher("regist.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}




