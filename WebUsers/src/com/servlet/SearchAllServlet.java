package com.servlet;

import java.io.IOException;
import java.util.List;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.dao.UserDao;
import com.dao.UserDaoImpl;
import com.entity.Users;

public class SearchAllServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//返回数据库中所有用户信息
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDao ud = new UserDaoImpl();
		List<Users> users = ud.searchAll();
		request.setAttribute("users", users);
		System.out.println("查询全部用户成功");
		request.getRequestDispatcher("/showall.jsp").forward(request, response);
	}

}
