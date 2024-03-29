package com.tyss.myjdbcproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ExecuteSingleEmployeeDetails 
{
	public static void main(String[] args)
	{
		Connection conn= null;
		Statement stmt= null;
		ResultSet rs=null;
		try 
		{
			//Step 1---->Load and register the driver
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			
			//Step 2---->GEt the connection
			String url="jdbc:mysql://localhost:3306/ust_ty_db?user=root&password=root";
			conn=DriverManager.getConnection(url);
			 
			//Step 3---->Issue sqlQuery
			String sql="Select * from employee_info where id=18";
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			//Step 4----->Read the executed sql Query
			if(rs.next())
			{
				int id=rs.getInt("id");
				String name=rs.getString("name");
				int salary=rs.getInt("sal");
				String gender =rs.getString("gender");
				System.out.println("Id is "+id);
				System.out.println("Name is "+name);
				System.out.println("Salary is "+salary);
				System.out.println("Gender is "+gender);
				System.out.println("*********************************");
			}
			
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
				if (stmt!=null)
				{
					stmt.close();	
				}
				if (conn!=null)
				{
					conn.close();	
				}
				if (rs!=null)
				{
					rs.close();	
				}
			}
			catch (Exception e2) 
			{
				e2.printStackTrace();
			}
		}//end of finally
	}//end of main
}//end of ExecuteSingleEmployeeDetails
