<%@page import="master.dto.RegisterDTO"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="master.dao.RegisterDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="2">
<tr>
<td>USERNAME</td>
<td>PASSWORD</td>
<td>NAME</td>
<td>PHONE NUMBER</td>
<td>EMAIL</td>
</tr>
<%
RegisterDAO rdao=new RegisterDAO();
ArrayList results=rdao.getDatas();
Iterator itr=results.iterator();
while(itr.hasNext())
{
	RegisterDTO rdto= (RegisterDTO)itr.next();
%>
<tr>
<td><%=rdto.getUname() %></td>
<td><%=rdto.getPass() %></td>
<td><%=rdto.getNm() %></td>
<td><%=rdto.getPhno() %></td>
<td><%=rdto.getEmail() %></td>
</tr>
<%
}
%>
</table>
<a href="Index.jsp">MENU</a>
</body>
</html>