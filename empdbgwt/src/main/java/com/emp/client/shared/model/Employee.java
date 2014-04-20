package com.emp.client.shared.model;

public class Employee {
	Integer emp_id;
	String emp_name;
	int emp_age;
	Long emp_phone;
	String emp_address;

	public Employee(Integer emp_id,String emp_name,int emp_age,Long emp_phone,String emp_address) 
	{
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.emp_age=emp_age;
		this.emp_phone= emp_phone;
		this.emp_address=emp_address;
	}
	




	public Integer getEmp_id() {
		return emp_id;
	}





	public int getAge() {
		return emp_age;
	}






	public String getName() {
		return emp_name;
	}






	public String getAddress() {
		return emp_address;
	}






	public Long getPhone() {
		return emp_phone;
	}



	

}
