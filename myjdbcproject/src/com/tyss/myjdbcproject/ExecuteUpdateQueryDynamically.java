package com.tyss.myjdbcproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ExecuteUpdateQueryDynamically
{
	public static void main(String[] args)
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		try 
		{
			// Step1 -------------> Load and register the driver
			Class.forName("com.mysql.jdbc.Driver");
		    
			//Step 2 ---------------->Get the connection
			String url="jdbc:mysql://localhost:3306/ust_ty_db?user=root&password=root";
			conn=DriverManager.getConnection(url);
			
			//Step 3 ----------------->Issue Sql Query
			String sql="update employee_info set name=?,gender=? where id=?";
			pstmt=conn.prepareStatement(sql);
			
			String eid=args[0];
			int id=Integer.parseInt(eid);
			pstmt.setInt(3, id);
			
			String name=args[1];
			pstmt.setString(1, name);
			
			String gender=args[2];
			pstmt.setString(2, gender);
			
			//Step 4------------>Read executed SQlQuery
			int count=pstmt.executeUpdate();
			System.out.println(count+"Rows updated");		
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			//step5----->close all jdbc resources
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
}//ExecuteUpdateQueryDynamically
