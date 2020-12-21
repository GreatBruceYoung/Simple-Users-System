package com.servlet;

import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.dao.UserDao;
import com.dao.UserDaoImpl;

public class UpdateServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//更新用户信息
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		int userId = Integer.parseInt(id);
		
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String sex = request.getParameter("sex");
		String home = request.getParameter("home");
		String info = request.getParameter("info");
		
		System.out.println("------------------------------------"+userId);
		
		UserDao ud = new UserDaoImpl();
		
		if(ud.update(userId, name, pwd, sex, home, info)){
			request.setAttribute("message", "更新成功");
			request.getRequestDispatcher("SearchAllServlet").forward(request, response);
		}else{
			response.sendRedirect("failure.jsp");
		}
	}

}
