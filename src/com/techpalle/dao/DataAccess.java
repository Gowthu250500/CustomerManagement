package com.techpalle.dao;

import java.sql.*;

import com.techpalle.model.Customer;

public class DataAccess 
{
	private static final String dbUrl = "jdbc:mysql://localhost:3306/palle";
	private static final String dbUsername = "root";
	private static final String dbPassword = "admin";
	
	private static Connection con = null;
	private static Statement s = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	
	private static final String qry = "insert into customer (name, email, mobile, password, state) values(?,?,?,?,?)";
	
	private static final String validQry = "select email, password from customer where email=? and password=?";
	
	public static boolean validCustomer(String email, String password)
	{
		boolean b = false;
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
			
			ps = con.prepareStatement(validQry);
			ps.setString(1, email);
			ps.setString(2, password);
			
			rs = ps.executeQuery();
			
			
			b= rs.next();
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (rs != null)
				{
					rs.close();
				}
				if (ps != null)
				{
					ps.close();
				}
				if (con != null)
				{
					con.close();
				}
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return b;
	}
	
	public static void insertCustomer(Customer cus)
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
			
			ps = con.prepareStatement(qry);
			ps.setString(1, cus.getName());
			ps.setString(2, cus.getEmail());
			ps.setLong(3, cus.getMobile());
			ps.setString(4, cus.getPassword());
			ps.setString(5, cus.getState());

			ps.executeUpdate();
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (ps != null)
				{
					ps.close();
				}
				if (con != null)
				{
					con.close();
				}
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
}
