<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>登录注册页面</title>
  </head>
  <body>
  <div align="center">
       <form action="LoginServlet"  method="post"  style="margin:0 auto;">
		用户名(Account)：<input type="text" name="name"value=""><br><br>
 		密码(Password)：<input type="password" name="pwd"value=""><br><br>
	        <input type="submit"value="登录(Log in)"name="login">
	        <input type="reset"value="重置(Reset)"><br>
	 </form>
	 <form action="register.jsp">
	 	<input type="submit"value="新用户注册(New accounts)">
     </form>
  </div>
  </body>
</html>