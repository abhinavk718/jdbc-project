package com.tyss.jdbcapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class UpdateQuery
{
	public static void main(String[] args) 
	{
		Connection conn = null;
		Statement stmt = null;
		try 
		{
			//Step 1 Load & Register Driver
			Driver d=new Driver();
			DriverManager.registerDriver(d);
			
			//Step 2 Get Connection
			String url="jdbc:mysql://localhost:3306/ust_ty_db?user=root&password=root";
			conn=DriverManager.getConnection(url);
			
			//Step 3 Issue SQLquery
			String sql="update employee_info set name='Amit yadav' where id=5";
			stmt=conn.createStatement();
			int count=stmt.executeUpdate(sql);
			//step 4 Read the Result
			System.out.println(count+"Row(s) updated");		
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
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
			catch (Exception e2) 
			{
				e2.printStackTrace();
			}
		}
	}//end od main
}//End of UpdateQuery