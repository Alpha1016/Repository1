package com.emp.client.application.list.leavetype;

import java.util.List;

import com.emp.client.shared.model.Leave;
import com.gwtplatform.mvp.client.UiHandlers;

public interface LeaveTypeUiHandlers extends UiHandlers {

	
	Integer getEmpId();

	void saveAssignedLeaves(Integer empId, List<String> leavelist);

	

	
	
}
