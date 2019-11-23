package com.tyss.jdbcapp;
import java.sql.*;
import com.mysql.jdbc.Driver;

public class ExecuteUpdateQuery
{
	public static void main(String[] args)
	{
		Connection conn=null;
		Statement stmt=null;
		try 
		{
			//Step 1 Load and Register Driver
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			
			//Step -2 Get Connection
			String url="jdbc:mysql://localhost:3306/ust_ty_db?user=root&password=root";
			conn=DriverManager.getConnection(url);
			
			//step 3 Issue SQLquery
			String sql=" update employee_info set name='Aniket Raj',sal=25000,gender='m' where id=6";
			stmt=conn.createStatement();
			int count=stmt.executeUpdate(sql);
			
			//Step 4 Read Result
			System.out.println(count+" Row(s) updated");	
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
	}//end of main
}//ExecuteUpdateQuery
