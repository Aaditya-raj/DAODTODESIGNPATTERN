package master.dao;
import java.sql.*;
import java.util.ArrayList;

import master.dto.RegisterDTO;
import master.utilities.ConnectionFactory;
public class RegisterDAO {
Connection cn=null;
Statement st=null;
ResultSet rs=null;
PreparedStatement ps=null;
String insert_sql="insert into registration values(?,?,?,?,?)";
String delete_sql="delete from registration where uname=?";
String update_sql="update registration set pass=? where uname=?";
String select_sql="select * from registration";
public void insertData(RegisterDTO rdto)
{
	try
	{
	ConnectionFactory con=new ConnectionFactory();
	cn=con.getConn();
	ps=cn.prepareStatement(insert_sql);
	ps.setString(1, rdto.getUname());
	ps.setString(2, rdto.getPass());
	ps.setString(3, rdto.getNm());
	ps.setString(4, rdto.getPhno());
	ps.setString(5, rdto.getEmail());
	ps.executeUpdate();
	cn.commit();
	}
	catch(SQLException se)
	{
		se.printStackTrace();
	}
}

public void deleteData(RegisterDTO rdto)
{
	try
	{
	ConnectionFactory con=new ConnectionFactory();
	cn=con.getConn();
	ps=cn.prepareStatement(delete_sql);
	ps.setString(1, rdto.getUname());
	ps.executeUpdate();
	cn.commit();
	}
	catch(SQLException se)
	{
		se.printStackTrace();
	}
}

public void updateData(RegisterDTO rdto)
{
	try
	{
	ConnectionFactory con=new ConnectionFactory();
	cn=con.getConn();
	ps=cn.prepareStatement(update_sql);
	ps.setString(1, rdto.getPass());
	ps.setString(2, rdto.getUname());
	ps.executeUpdate();
	cn.commit();
	}
	catch(SQLException se)
	{
		se.printStackTrace();
	}
}

public ResultSet getData()
{
	try
	{
	ConnectionFactory con=new ConnectionFactory();
	cn=con.getConn();
	st=cn.createStatement();
	rs=st.executeQuery(select_sql);
	}
	catch(SQLException se)
	{
		se.printStackTrace();
	}
	return rs;
}
public ArrayList getDatas()
{
	ArrayList arr = new ArrayList();
	try
	{
	ConnectionFactory con=new ConnectionFactory();
	cn=con.getConn();
	st=cn.createStatement();
	rs=st.executeQuery(select_sql);
	while(rs.next())
	{
		RegisterDTO rdto=new RegisterDTO();
		rdto.setUname(rs.getString(1));
		rdto.setPass(rs.getString(2));
		rdto.setNm(rs.getString(3));
		rdto.setPhno(rs.getString(4));
		rdto.setEmail(rs.getString(5));
		arr.add(rdto);
	}
	}
	catch(SQLException se)
	{
		se.printStackTrace();
	}
	return arr;
}
public boolean checkLogin(String uname,String pass)
{
	boolean flag=false;
	String check_login="select * from registration where uname='"+uname+"' and pass='"+pass+"'";
	try
	{
	ConnectionFactory con=new ConnectionFactory();
	cn=con.getConn();
	st=cn.createStatement();
	rs=st.executeQuery(check_login);
	if(rs.next())
	{
		flag=true;
	}
	}
	catch(SQLException se)
	{
		se.printStackTrace();
	}
	return flag;
}
}
