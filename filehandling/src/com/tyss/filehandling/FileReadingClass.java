package com.tyss.filehandling;

import java.io.FileReader;

import java.io.IOException;

public class FileReadingClass
{
	public static void main(String[] args) 
	{
		String path="C:\\Users\\The Machine\\Desktop\\text.txt.txt";
		FileReader reader = null;
		try 
		{
			reader = new FileReader(path);
			int i ;
			while((i=reader.read())!=-1)
			{
				System.out.print((char)i);
			}
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				if(reader!=null)
				{
					reader.close();
				}
			} catch (Exception e2) 
			{
				e2.printStackTrace();
			}	
		}
	}//end of main 
}//end of FileReadingClass
