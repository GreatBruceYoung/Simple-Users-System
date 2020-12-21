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
	//�û�ע����
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name"); //��ȡjspҳ�洫�����Ĳ���
		String pwd = request.getParameter("pwd");
		String sex = request.getParameter("sex");
		String home = request.getParameter("home");
		String info = request.getParameter("info");
		
		//ʵ����һ��������װ����
		Users user = new Users(); 
		user.setName(name);
		user.setPwd(pwd);
		user.setSex(sex);
		user.setHome(home);
		user.setInfo(info);
		
		UserDao ud = new UserDaoImpl();
		
		if(ud.register(user)){
			System.out.println("�û�"+name+"ע��ɹ�");
			request.setAttribute("username", name);  //��request���з��ò���
			request.setAttribute("message", "ע��ɹ�");
			request.getRequestDispatcher("login.jsp").forward(request, response);  //ת������¼ҳ��
		}else{
			response.sendRedirect("failure.jsp");//�ض�����ҳ
		}
	}

}
