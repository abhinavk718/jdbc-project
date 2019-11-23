package com.tyss.jdbcapp;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
  

public class SelectProperties
{
	public static void main(String[] args)
	{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
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
			String sql=prop.getProperty("select-query");
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			//step-4 Read the Result
			while(rs.next())
			{
				int id=rs.getInt("id");
				String name=rs.getString("name");
				int sal=rs.getInt("sal"); 
				String gender=rs.getString("gender");
				System.out.println("Id: "+id);
				System.out.println("Name : "+name);
				System.out.println("Salary : "+sal);
				System.out.println("Gender : "+gender);
				System.out.println("******************************************");
			}
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
				if(stmt!=null)
				{
					stmt.close();
				}
				if(rs!=null)
				{
					rs.close();
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
}//SelectProperties