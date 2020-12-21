<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>用户注册</title>
  </head>
  <body >
  <form action="RegisterServlet" method="post" style="padding-top:-700px;">
	   输入用户名:<input name="name" type="text"><br><br>
	   输入密码:<input name="pwd" type="password"><br><br>
	   选择性别:<input type="radio"name="sex"value="男"checked>男(Male)
	        <input type="radio"name="sex"value="女">女(Female)<br><br>
	   选择家乡:
	   <select name="home">
		   <option value="上海">上海</option>
		   <option value="北京" selected>北京</option>
		   <option value="天津" selected>天津</option>
		   <option value="香港" selected>香港</option>
		   <option value="广州">广州</option>
   		</select><br>
               填写个人信息:(Enter your information)<br>
	   <textarea name="info" rows="5" cols="30"></textarea><br>
	   <input type="reset"value="重置"><input type="submit"value="注册">
   </form>
  </body>
</html>
