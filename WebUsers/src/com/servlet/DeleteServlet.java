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
	//ɾ���û���Ϣ
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		System.out.println("ɾ�����û�idΪ��"+id);
		/*��ȡ����id��һ�������������ͼ�������Ҫ��ɻ�������������Ϊ��������*/
		int userId = Integer.parseInt(id);/*����dao�㣬����ֵ��һ����������*/
		
		UserDao ud = new UserDaoImpl();
		/*delete�����Ĳ���Ϊint id�����Ա���Ѵ�jspҳ���ȡ����idת���ɻ�����������*/
		
		if(ud.delete(userId)){
			request.setAttribute("message", "ɾ���ɹ�");
			request.getRequestDispatcher("SearchAllServlet").forward(request, response);
		}else{
			response.sendRedirect("failure.jsp");
		}
	}
}
