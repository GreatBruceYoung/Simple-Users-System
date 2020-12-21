package com.servlet;

import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.dao.UserDao;
import com.dao.UserDaoImpl;

public class LoginServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		//用户登录
	//需要继承HttpServlet  并重写doGet  doPost方法
		public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doPost(request, response);  //将信息使用doPost方法执行   对应jsp页面中的form表单中的method
		}
		public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			/*request.getParameter获取前端输入框的值即input框里的name属性的值*/
			String name = request.getParameter("name"); //得到jsp页面传过来的参数
			String pwd = request.getParameter("pwd");
			UserDao ud = new UserDaoImpl();
			
			if(ud.login(name, pwd)){
				System.out.println("用户"+name+"登录成功！");
				request.setAttribute("message", "欢迎用户"+name); //向request域中放置信息
				request.getRequestDispatcher("success.jsp").forward(request, response);//转发到成功页面
			}else{
				/*如果不获取参数则使用重定向到错误页面*/
				response.sendRedirect("failure.jsp"); //重定向到首页
			}
		}

}
