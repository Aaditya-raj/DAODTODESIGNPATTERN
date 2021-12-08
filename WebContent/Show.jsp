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
ResultSet rs=rdao.getData();
while(rs.next())
{
	String uname=rs.getString(1);
	String pass=rs.getString(2);
	String nm=rs.getString(3);
	String phno=rs.getString(4);
	String email=rs.getString(5);
%>
<tr>
<td><%=uname %></td>
<td><%=pass %></td>
<td><%=nm %></td>
<td><%=phno %></td>
<td><%=email %></td>
</tr>
<%
}
%>
</table>
<a href="Index.jsp">MENU</a>
</body>
</html>