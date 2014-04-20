package com.emp.client.shared.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.inject.Singleton;




@Singleton
public class EmployeeDB {
	

		public List<Employee> emp1 = new ArrayList<Employee>();

		// Adding employee data
		public void addEmpData(Employee emp) 
		{
	
			//adding the emp details into the list
			emp1.add(emp);
			
		

		}
		
		
		public int getEmployeeCount() {

			return emp1.size();
		}

		public List<Employee> display()
		{
			return emp1;
         }

		
		public void deleteEmpData(int emp_id)
		{
			
				Iterator<Employee> it = emp1.iterator();
				while (it.hasNext()) 
				{
					Employee emp = it.next();
					if (emp.getEmp_id() == emp_id)
					{
						 emp1.remove(emp);
						 break;
						
					}
				}
				
			}
			

		public Employee searchById(Integer emp_id)
		{
			
			Iterator<Employee> it = emp1.iterator();
			while (it.hasNext()) 
			{
				Employee emp = it.next();
				if (emp.getEmp_id() == emp_id)
				{
					 return emp;
					
			
		         }
		   }
			return null;
		}
		
		
		
		public void editById(Integer emp_id)
		{

		
		}
       
			
			
	}
	

		
		

