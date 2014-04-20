package com.emp.client.application.list.leavetype;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.emp.client.shared.model.LeaveDB;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

public class LeaveTypeView extends ViewWithUiHandlers<LeaveTypeUiHandlers>
		implements LeaveTypePresenter.MyView {
	interface Binder extends UiBinder<Widget, LeaveTypeView> {
	}

	@Inject
	LeaveDB leavedb;


	@Inject
	LeaveTypeView(Binder uiBinder) {
		initWidget(uiBinder.createAndBindUi(this));
		saveButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				String leave;
				List<String> leavelist= new ArrayList<String>();
				
				
				int count=assignedleaves.getItemCount();
				
				for(int index=0;index<count;index++)
				{
			     leave= assignedleaves.getItemText(index);
				leavelist.add(leave);
				}
				System.out.println("the size of the list is" + leavelist.size());
				Integer empId=getUiHandlers().getEmpId();
				getUiHandlers().saveAssignedLeaves(empId, leavelist);
				/*leavedb.addLeaveData(empId, leavelist);
				System.out.println("the size of the hashmap is" + leavedb.getLeaveCount());
				Window.alert("leave details saved in list");*/
			}

			
			
			
		});
				

	}
	

@UiField
ListBox availableleaves;

@UiField
ListBox assignedleaves;

@UiField
Label namelabel;

@UiField
Button addButton;

@UiField
Button delButton;

@UiField
Button saveButton;



@UiHandler(value = { "addButton" })
public void assignLeaves(ClickEvent e)
{
	
	int index=availableleaves.getSelectedIndex();
	String leave= availableleaves.getItemText(index);
	assignedleaves.addItem(leave);
	//availableleaves.removeItem(index);
		
} 


@UiHandler(value = { "delButton" })
public void deleteAssignedLeaves(ClickEvent e)
{
	
	Integer index=assignedleaves.getSelectedIndex();
	assignedleaves.removeItem(index);
	
}

/*@UiHandler(value= {"saveButton"})
public void saveLeaves(ClickEvent e)
{
	String leave;
	List<String>leavelist= new ArrayList<String>();
	
	
	int count=assignedleaves.getItemCount();
	
	for(int index=0;index<count;index++)
	{
     leave= assignedleaves.getItemText(index);
	leavelist.add(leave);
	}
	System.out.println("the size of the list is" + leavelist.size());
	//getUiHandlers().getEmpId();
	//Integer empId=leaveTypePresenter.empId;
	//leavedb.addLeaveData(empId, leavelist);
	//System.out.println("the siz of the hashmap is" + leavedb.getLeaveCount());
	
	
}*/



@Override
public void setEmpNameToLabel(String name)
{
	namelabel.setText(name);
}
	



}


