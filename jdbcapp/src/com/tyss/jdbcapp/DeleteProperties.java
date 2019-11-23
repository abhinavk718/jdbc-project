package com.tyss.jdbcapp;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
  

public class DeleteProperties
{
	public static void main(String[] args)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		FileReader reader=null;
		try 
		{
			
			reader=new FileReader("db.properties");
			Properties prop=new Properties();
			prop.load(reader);
			
			//step-1 load & register the driver
			String driver=prop.getProperty("driver-class-name");
			Class.forName(driver);
			
			//Driver driver=new Driver();
			//.registerDriver(driver);
			
			//step-2 Get the connection
			String url=prop.getProperty("url");
			conn=DriverManager.getConnection(url,prop);
			
			//step-3 Issue SQL query   
			String sql=prop.getProperty("delete-query");
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1,Integer.parseInt(args[0]));
			int count=pstmt.executeUpdate();
			
			//Step 4 Read Result
			System.out.println(count+" Row(s) deleted");	
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			//step-5 Close all jdbc Objects
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
				if(reader!=null)
				{
					reader.close();
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}//end of main
}