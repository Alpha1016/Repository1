package com.emp.client.application.list.leavetype;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.jukito.JukitoRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.emp.client.shared.model.Employee;




@RunWith(JukitoRunner.class)
public class LeaveTypePresenterTest {
	
	@Inject
	LeaveTypeView leavetypeview;
	@Inject
	LeaveTypePresenter leavetypepresenter;
	@Inject
	Employee emp;
	
	@Test
	public void testsaveAssignedLeaves() 
	{
		leavetypepresenter.saveAssignedLeaves(1, );
	}

}
