package com.tyss.filehandling;

public class BuilderDesign
{
	public static void main(String[] args)
	{
		StringBuffer sb=new StringBuffer().append("Hello").append("Word");
		//Hello
		//sb.append("Hello");
		//World
		//sb.append("world");
		System.out.println(sb);
	}
}
