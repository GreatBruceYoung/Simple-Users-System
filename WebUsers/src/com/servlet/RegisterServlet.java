package com.servlet;

import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dao.UserDao;
import com.dao.UserDaoImpl;
import com.entity.Users;

public class RegisterServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//用户注册类
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name"); //获取jsp页面传过来的参数
		String pwd = request.getParameter("pwd");
		String sex = request.getParameter("sex");
		String home = request.getParameter("home");
		String info = request.getParameter("info");
		
		//实例化一个对象，组装属性
		Users user = new Users(); 
		user.setName(name);
		user.setPwd(pwd);
		user.setSex(sex);
		user.setHome(home);
		user.setInfo(info);
		
		UserDao ud = new UserDaoImpl();
		
		if(ud.register(user)){
			System.out.println("用户"+name+"注册成功");
			request.setAttribute("username", name);  //向request域中放置参数
			request.setAttribute("message", "注册成功");
			request.getRequestDispatcher("login.jsp").forward(request, response);  //转发到登录页面
		}else{
			response.sendRedirect("failure.jsp");//重定向到首页
		}
	}

}
