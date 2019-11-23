package com.tyss.myjdbcproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ExecuteDeleteQuery
{
	public static void main(String[] args) 
	{
		Connection conn = null;
		Statement stmt = null;
		try 
		{
			//Step 1----->Load and register the driver
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			
			//Step 2---->Get the connection
			String url="jdbc:mysql://localhost:3306/ust_ty_db?user=root&password=root";
			conn=DriverManager.getConnection(url);
			
			//Step 3---->Issue SQLQuery
			String sql="delete from employee_info where name='Deepak'";
			stmt=conn.createStatement();
			
			//Step 4---->Read the executed SQL Query
			int count=stmt.executeUpdate(sql);
			System.out.println(count+"Rows deleted");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			//Step 5---->Close all jdbc resources
			try 
			{
				
			}
			catch (Exception e2)
			{
				e2.printStackTrace();
			}
		}//End of finaly
	}//End of main
}//end of ExecuteDeleteQuery
