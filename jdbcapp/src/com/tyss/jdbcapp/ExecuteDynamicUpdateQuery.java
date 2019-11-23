package com.tyss.jdbcapp;
import java.sql.*;
import com.mysql.jdbc.Driver;

public class ExecuteDynamicUpdateQuery
{
	public static void main(String[] args)
	{
		Connection conn=null;
		PreparedStatement pstmt = null;
		try 
		{
			//Step 1 Load and Register Driver
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			
			//Step -2 Get Connection
			String url="jdbc:mysql://localhost:3306/ust_ty_db?user=root&password=root";
			conn=DriverManager.getConnection(url);
			
			//step 3 Issue SQLquery
			String sql=" update employee_info set name=?,sal=?,gender=? where id=?";
			pstmt=conn.prepareStatement(sql);
			String empid=args[0];
			int id=Integer.parseInt(empid);
			
			String name=args[1];
			
			String empsal=args[2];
			int sal=Integer.parseInt(empsal);
			
			String gender=args[3];
			
			pstmt.setInt(4, id);
			pstmt.setString(1, name);
			pstmt.setInt(2, sal);
			pstmt.setString(3, gender);
			
			int count=pstmt.executeUpdate();
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
				if(pstmt!=null)
				{
					pstmt.close();
				}	
			}
			catch (Exception e2)
			{
				e2.printStackTrace();
			}
		}
	}//end of main
}//ExecuteUpdateQuery
