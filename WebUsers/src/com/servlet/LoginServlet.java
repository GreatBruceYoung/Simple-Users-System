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
		//�û���¼
	//��Ҫ�̳�HttpServlet  ����дdoGet  doPost����
		public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doPost(request, response);  //����Ϣʹ��doPost����ִ��   ��Ӧjspҳ���е�form���е�method
		}
		public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			/*request.getParameter��ȡǰ��������ֵ��input�����name���Ե�ֵ*/
			String name = request.getParameter("name"); //�õ�jspҳ�洫�����Ĳ���
			String pwd = request.getParameter("pwd");
			UserDao ud = new UserDaoImpl();
			
			if(ud.login(name, pwd)){
				System.out.println("�û�"+name+"��¼�ɹ���");
				request.setAttribute("message", "��ӭ�û�"+name); //��request���з�����Ϣ
				request.getRequestDispatcher("success.jsp").forward(request, response);//ת�����ɹ�ҳ��
			}else{
				/*�������ȡ������ʹ���ض��򵽴���ҳ��*/
				response.sendRedirect("failure.jsp"); //�ض�����ҳ
			}
		}

}
