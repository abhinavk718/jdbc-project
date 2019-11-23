package com.tyss.myjdbcproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ExecuteUpdateQuery
{
	public static void main(String[] args)
	{
		Connection conn = null;
		Statement stmt = null;
		try
		{
			//Step 1------>Load and register thr driver
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			
			//Step 2---->Get the connection
			String url="jdbc:mysql://localhost:3306/ust_ty_db?user=root&password=root";
			conn=DriverManager.getConnection(url);
			
			//Step 3---->Issue SQL Query
			String sql="update employee_info set name='Deepak' where id=101";
			stmt=conn.createStatement();
			
			//Step 4---->Read Executed Query
			int count=stmt.executeUpdate(sql);
			System.out.println(count+"Rows updated");	
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			//Step 5----->Close all jdbc resources
			try
			{
				if (stmt!=null)
				{
					stmt.close();
				}
				if (conn!=null)
				{
					conn.close();
				}
			} 
			catch (Exception e2) 
			{
				e2.printStackTrace();
			}
		}//End of finally
	}//end of main
}//end of ExecuteUpdateQuery