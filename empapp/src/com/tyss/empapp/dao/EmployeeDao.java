package com.tyss.empapp.dao;

import java.util.List;

import com.tyss.empapp.dto.EmployeeBean;

public interface EmployeeDao 
{
	public List<EmployeeBean> getAllEmployeeData();
	public EmployeeBean searchEmployeeData(int id);
	//public int insertEmployeeData(EmployeeBean bean);
	//public int updatetEmployeeData(EmployeeBean bean);
	//public int deletetEmployeeData(int id);
	
}
