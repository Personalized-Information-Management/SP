<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

name：<%=request.getSession().getAttribute("name")%>
id：<%=request.getSession().getAttribute("id")%>
per：<%=request.getSession().getAttribute("per")%>

<h1>已退出登录</h1>
<a href="/logins"><h1>重新登录</h1></a>

