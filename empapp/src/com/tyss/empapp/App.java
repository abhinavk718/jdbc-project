package com.tyss.empapp;

import java.util.List;
import java.util.Scanner;

import com.tyss.empapp.dao.EmployeeDAOImpl;
import com.tyss.empapp.dao.EmployeeDao;
import com.tyss.empapp.dto.EmployeeBean;
import com.tyss.empapp.util.EmployeeManager;
 
public class App
{
	public static void main(String[] args)
	{
		System.out.println("pess 1 to show all employee data");
		System.out.println("pess 2 to insert employee data");
		System.out.println("pess 3 to update employee data");
		System.out.println("pess 4 to delete employee data");
		System.out.println("press 5 to search single employee details");
		
		Scanner scn=new Scanner(System.in);
		int ch=scn.nextInt();
		
		switch (ch) 
		{
		    case 1:
		    	 EmployeeDao dao=EmployeeManager.getEmployeeDao();
		    	List<EmployeeBean> result=dao.getAllEmployeeData();
		    	for (EmployeeBean bean : result) 
		    	{
		    		System.out.println("Name is "+bean.getName());
		    		System.out.println("Id is "+bean.getId());
		    		System.out.println("Salary is "+bean.getSal() );
		    		System.out.println("Gender is "+bean.getGender());
		    		System.out.println("*******************************************");
				}
			break;
		    case 2:
		    	break;
		    case 3:
		    	break;
		    case 4:
		    	break;
		    case 5:
		    	EmployeeDao dao5=EmployeeManager.getEmployeeDao();
		    	System.out.println("Enter employee id number");
		    	int id=scn.nextInt();
		    	EmployeeBean bean=dao5.searchEmployeeData(id);
		    	if(bean!=null)
		    	{
		    		System.out.println("Id is "+bean.getId());
		    		System.out.println("Name is "+bean.getName());
		    		System.out.println("Salary is "+bean.getSal());
		    		System.out.println("Gender is "+bean.getGender());
		    	}
		    	else
		    	{
		    		System.out.println("No Records Found.");
		    	}
		    	break; 	
		}
	}//end of main
}//end of App
