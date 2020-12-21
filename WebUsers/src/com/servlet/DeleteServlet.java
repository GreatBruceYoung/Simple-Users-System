package com.servlet;

import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.dao.UserDao;
import com.dao.UserDaoImpl;

public class DeleteServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//删除用户信息
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		System.out.println("删除的用户id为："+id);
		/*获取到的id是一个引用数据类型即对象，需要变成基本数据类型作为参数传输*/
		int userId = Integer.parseInt(id);/*调用dao层，返回值是一个整形数字*/
		
		UserDao ud = new UserDaoImpl();
		/*delete方法的参数为int id，所以必须把从jsp页面获取到的id转换成基本数据类型*/
		
		if(ud.delete(userId)){
			request.setAttribute("message", "删除成功");
			request.getRequestDispatcher("SearchAllServlet").forward(request, response);
		}else{
			response.sendRedirect("failure.jsp");
		}
	}
}
