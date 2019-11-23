package com.tyss.jdbcapp;

import java.sql.*;

import com.mysql.jdbc.Driver;

public class ExecuteDynamicInsertQuery 
{
	public static void main(String[] args) 
	{
		Connection conn = null;
		PreparedStatement pstmt=null;
		try 
		{
			//Step -1 Load the Driver
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			
			//Step - 2 Get the connection
			String url="jdbc:mysql://localhost:3306/ust_ty_db?user=root&password=root";
			conn=DriverManager.getConnection(url);
			
			//Step - 3 Issue SQl Query
			String sql=" insert into employee_info values(?,?,?,?) ";
			pstmt=conn.prepareStatement(sql);
			
			String empid=args[0];
			int id=Integer.parseInt(empid);
			pstmt.setInt(1, id);
			
			String name=args[1];
			pstmt.setString(2, name);
			
			String salary=args[2];
			int sal=Integer.parseInt(salary);
			pstmt.setInt(3, sal);
			
			String gender=args[3];
			pstmt.setString(4, gender);
			int count=pstmt.executeUpdate();
			
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
				if(pstmt!=null)
				{
					pstmt.close();
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();	
			}
		}
	} //end of main
}//end of ExecuteInsertQuery
