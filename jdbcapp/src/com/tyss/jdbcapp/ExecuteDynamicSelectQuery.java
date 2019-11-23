package com.tyss.jdbcapp;
import java.sql.*;

import com.mysql.jdbc.Driver;

public class ExecuteDynamicSelectQuery 
{
	public static void main(String[] args) 
	{
		Connection conn = null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try 
		{
			//Step -1 Load & Register the Driver
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			
			//Step - 2 Get the connection
			String url="jdbc:mysql://localhost:3306/ust_ty_db?user=root&password=root";
			conn=DriverManager.getConnection(url);
			
			//Step - 3 Issue SQl Query
			String sql=" select * from employee_info where id=? ";
			pstmt=conn.prepareStatement(sql);
			
			String empid=args[0];
			int id=Integer.parseInt(empid);
			pstmt.setInt(1, id);
			
			rs=pstmt.executeQuery();
			
			//Step - 4 Read the Result
			if(rs.next())
			{
				int emp_id=rs.getInt("id");
				int sal=rs.getInt("sal");
				String name=rs.getString("name");
				String gender=rs.getString("gender");
				System.out.println("Id is "+emp_id);
				System.out.println("Name is "+name);
				System.out.println("Salary is "+sal);
				System.out.println("Gender is "+gender);
				System.out.println("******************************* ");
			}
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
				if(rs!=null)
				{
					rs.close();
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();	
			}
		}
	} //end of main
}//end of ExecuteInsertQuery
