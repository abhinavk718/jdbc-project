package com.tyss.jdbcapp;

import java.sql.*;

import com.mysql.jdbc.Driver;

public class ExecuteInsertQuery 
{
	public static void main(String[] args) 
	{
		Connection conn = null;
		Statement stmt = null;
		try 
		{
			//Step -1 Load the Driver
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			
			//Step - 2 Get the connection
			String url="jdbc:mysql://localhost:3306/ust_ty_db?user=root&password=root";
			conn=DriverManager.getConnection(url);
			
			//Step - 3 Issue SQl Query
			String sql=" insert into employee_info values(7,'Abhinav',10000,'M') ";
			stmt=conn.createStatement();
			int count=stmt.executeUpdate(sql);
			//Step - 4 Read the Result
			System.out.println(count+" Row(s) inseted");	
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			//Step - 5 Close all jdbc Objects
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
			}
			catch (Exception e)
			{
				e.printStackTrace();	
			}
		}
	} //end of main
}//end of ExecuteInsertQuery
