<%@ page import="java.io.FileInputStream" %>
<%@ page import="java.io.FileNotFoundException" %>
<%@ page import="java.io.IOException" %>
<%@ page import="java.util.Properties" %>
<!DOCTYPE html>
<%@ page pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<html >
	
	<head>
		<title>高新区一体化平台登录中心</title>
	</head>
	<body>
		<h1>您登陆成功</h1>
		您可以<a href="logout">退出</a>登陆

		<%
			String path = "";

			Properties pro = new Properties();
			String realpath = request.getRealPath("/WEB-INF/classes");
			try{
				//读取配置文件
				FileInputStream in = new FileInputStream(realpath+"/sys.properties");
				pro.load(in);
			}
			catch(FileNotFoundException e){
				out.println(e);
			}
			catch(IOException e){
				out.println(e);
			}

			//通过key获取配置文件
			path = pro.getProperty("loginSuccessRedirect");
			//byte b[]=title.getBytes("utf-8");
			//title=new String(b);
			System.out.println(path);
			response.sendRedirect(path);
		%>

		<%
		//response.sendRedirect("http://127.0.0.1:10086/gxqpt-center/admin/index");
		//response.sendRedirect("http://127.0.0.1:10086/gxqpt-center/admin/index");
		//response.sendRedirect("http://127.0.0.1:10086/gxqpt-center/admin/index");
		%>
	</body>
</html>