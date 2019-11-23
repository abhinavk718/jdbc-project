package com.tyss.myjdbcproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Driver;

public class ExecuteSelectQueryDynamically 
{
	public static void main(String[] args) 
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try 
		{
			//Step 1----->Load and Register the Driver
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			
			//step 2------>Get the connection
			String url="jdbc:mysql://localhost:3306/ust_ty_db?user=root&password=root";
			conn=DriverManager.getConnection(url);
			
			//Step 3---->Issue SQL Query
			String sql="select * from employee_info where id=?";
			pstmt=conn.prepareStatement(sql);
			String empid=args[0];
			int id=Integer.parseInt(empid);
			pstmt.setInt(1, id);
			
			rs=pstmt.executeQuery();
			//Step 4---->Read executed SQL Query
			if(rs.next())
			{
				int eid=rs.getInt("id");
				String name=rs.getString("name");
				int salary=rs.getInt("sal");
				String gender=rs.getString("gender");
				System.out.println("Id is "+eid);
				System.out.println("Name is "+name);
				System.out.println("Salary is "+salary);
				System.out.println("Gender is "+gender);
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			//close all jdbc resources
			try
			{
				if (conn!=null) 
				{
					conn.close();
				}
				if (pstmt!=null) 
				{
					pstmt.close();
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
}//end of ExecuteSelectQueryDynamically