package com.emp.client.shared.model;


	import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Singleton;



	@Singleton
	public class LeaveDB {

		// Stores the Database of the leave
		public Map<Integer,List<String>> leaves = new HashMap<Integer,List<String>>();

		// Adding Leave data
		public void addLeaveData(Integer emp_id,List leavelist) {

			leaves.put(emp_id,leavelist);

		}

		
		// function to return  the  size list
		public int getLeaveCount() {

			return leaves.size();
		}

	
	
		
}
