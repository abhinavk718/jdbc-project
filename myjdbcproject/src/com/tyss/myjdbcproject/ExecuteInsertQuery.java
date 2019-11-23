package com.tyss.myjdbcproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import com.mysql.jdbc.Driver;

public class ExecuteInsertQuery 
{
	public static void main(String[] args)
	{
		Connection conn = null;
		Statement stmt = null;
		try 
		{
			//Step 1---->Load and Register the Driver
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			
			//Step 2---->Get the connection
			String url="jdbc:mysql://localhost:3306/ust_ty_db?user=root&password=root";
			conn=DriverManager.getConnection(url);
			
			//Step 3---->Issue SQl Query
			String sql="insert into employee_info values(101,'Sanjay Choudhary',25000,'M')";
			stmt=conn.createStatement();
			
			//Read executed sql query
			int count=stmt.executeUpdate(sql);
			System.out.println(count+"Rows inserted");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			//Close all jdbc resources
			try 
			{
				if (conn!=null) 
				{
					conn.close();
				}
				if (stmt!=null) 
				{
					stmt.close();
				}
			}
			catch (Exception e2)
			{
				e2.printStackTrace();
			}
		}//end of finally
	}//end of main
}//end of ExecuteInsertQuery
