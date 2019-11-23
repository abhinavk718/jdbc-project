package com.tyss.myjdbcproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ExecuteInsertQueryDynamically
{
	public static void main(String[] args) 
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		try
		{
			//step1---->Load and register the driver
			Class.forName("com.mysql.jdbc.Driver");
			
			//step2 get the connecction
			String url="jdbc:mysql://localhost:3306/ust_ty_db?user=root&password=root";
			conn=DriverManager.getConnection(url);
			
			//Step 3----------->Issue SQL Query
			String sql="insert into employee_info values(?,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			
			String eid=args[0];
			int id=Integer.parseInt(eid);
			pstmt.setInt(1, id);
			
			String name=args[1];
			pstmt.setString(2, name);
			
			String esal=args[2];
			int sal=Integer.parseInt(esal);
			pstmt.setInt(3, sal);
			
			String gender=args[3];
			pstmt.setString(4, gender);
			
			//Step 4----->Read executed Sql Query
			int count=pstmt.executeUpdate();
			System.out.println(count+"Rows Inserted");	
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
			}
			catch (Exception e2)
			{
				e2.printStackTrace();
			}
		}//end of finally
	}//end of main
}//end of ExecuteInsertQueryDynamically
