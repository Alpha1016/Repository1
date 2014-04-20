package com.emp.client.shared.model;

public class Leave 
{
	

	int emp_id;
	String emp_name,leaveType;
	
	public Leave(int emp_id, String name, String leaveType) {
		super();
		this.emp_id = emp_id;
		this.emp_name = name;
		this.leaveType = leaveType;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public String getName() {
		return emp_name;
	}

	public String getLeaveType() {
		return leaveType;
	}

}
