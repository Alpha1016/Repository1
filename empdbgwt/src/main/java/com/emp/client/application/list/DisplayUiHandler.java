package com.emp.client.application.list;

import com.gwtplatform.mvp.client.UiHandlers;


public interface DisplayUiHandler extends UiHandlers{
	
	public void viewEmployeeDetails(Integer empId);

	public void editEmployeeDetails(Integer empId);

	public void editLeaveTypes(Integer empId, String emp_name);

	
	

}
