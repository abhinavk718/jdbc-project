package com.tyss.empapp.util;

import com.tyss.empapp.dao.EmployeeDAOImpl;
import com.tyss.empapp.dao.EmployeeDao;

public class EmployeeManager
{
	private EmployeeManager()
	{
		
	}
	public static EmployeeDao getEmployeeDao()
	{
		return new EmployeeDAOImpl();
	}

}
