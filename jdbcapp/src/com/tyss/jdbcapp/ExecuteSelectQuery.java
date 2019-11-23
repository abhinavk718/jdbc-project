package com.tyss.jdbcapp;

import java.sql.*;

import com.mysql.jdbc.Driver;

public class ExecuteSelectQuery
{
	public static void main(String[] args)
	{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try
		{
			//Step 1 Load and Register the Driver
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			
			//Step 2 Get Connection
			String url="jdbc:mysql://localhost:3306/ust_ty_db?user=root&password=root";
			conn=DriverManager.getConnection(url);
			
			//Step 3 Issue SQL Query
			String sql="select * from employee_info";
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			//Step 4 Read the result
			while(rs.next())
			{
				int id=rs.getInt("id");
				String name=rs.getString("name");
				int salary=rs.getInt("sal");
				String gender=rs.getString("gender");
				System.out.println("Name is "+name);
				System.out.println("Id is "+id);
				System.out.println("Salary is "+salary);
				System.out.println("Gender is "+gender);
				System.out.println("====================================");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			//Step 5 Close all jdbc Objects
			try
			{
				if(conn!=null)
				{
					conn.close();
				}
				if(stmt!=null)
				{
					stmt.close();
				}
				if(rs!=null)
				{
					rs.close();
				}
			} 
			catch (Exception e2)
			{
				e2.printStackTrace();
			}
		}
	}//end of main
}//end of ExecuteSelectQuery
