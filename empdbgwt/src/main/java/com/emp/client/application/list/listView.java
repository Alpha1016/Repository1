package com.emp.client.application.list;

import javax.inject.Inject;

import com.emp.client.application.list.leavetype.LeaveTypePresenter;
import com.emp.client.place.NameTokens;
import com.emp.client.shared.model.Employee;
import com.emp.client.shared.model.EmployeeDB;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FocusWidget;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.UiHandlers;
import com.gwtplatform.mvp.client.ViewImpl;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;

public class listView extends ViewWithUiHandlers<DisplayUiHandler> implements
		listPresenter.MyView {
	interface Binder extends UiBinder<Widget, listView> {

	}
	

	@Inject
	listView(Binder uiBinder) {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField
	HTMLPanel holderpanel;
	@UiField
	FlexTable emptable;
	
	
	@Inject
	EmployeeDB empdb;
	
	
	@Inject
	 LeaveTypePresenter leaveType;
	
	/*@Inject
	 listPresenter listpresenter;
*/
	@Override
	public void setInSlot(Object slot, IsWidget content) {
	
		super.setInSlot(slot, content);
		
			if(slot==listPresenter.SLOT_leaveTypes)
			{
				holderpanel.clear();
				if(content!=null)
				{
					holderpanel.add(content);
				}
			}
			
			else
			{
				super.setInSlot(slot, content);
			}
		}
	
	
	
	// method to clear the content of the table before loading a new table
	@Override
	public void clearTable() {

		emptable.clear();
		emptable.removeAllRows();
	}

	public void setColumnHeading() {
		emptable.setWidget(0, 0, new Label("Emp id"));
		emptable.setWidget(0, 1, new Label("Emp name"));
		emptable.setWidget(0, 2, new Label("Delete Option"));
		emptable.setWidget(0, 3, new Label("Edit Option"));
		emptable.setWidget(0, 4, new Label("Edit Leave Types"));
		
		
	}

	@Override
	public void addEmpData(final Employee emp) {
        //getting the total no of rows of flex table
		int tableindex = emptable.getRowCount();
        //setting the table heading
		if (tableindex <= 0)
			setColumnHeading();
		tableindex++;
		
		
		final Label idlable = new Label(emp.getEmp_id() + "");
		idlable.setWidth("50px");
		emptable.setWidget(tableindex, 0, new Label(emp.getEmp_id().toString()));
		
		// set the id label in the table's 1st column
		emptable.setWidget(tableindex, 0, idlable);
		
		//declare the anchor widget for calling the detailsPresnter(4rth) presenter
		Anchor name = new Anchor();
		name.setText(emp.getName());
		name.setWidth("60px");
		// set the name label in the table's 2nd column
		emptable.setWidget(tableindex, 1, name);
		// get the current employee id for passing with the anchor handler 
		final Integer empId = emp.getEmp_id();
		final String emp_name=emp.getName();
		// add a clickhandler for the anchored name
		name.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				getUiHandlers().viewEmployeeDetails(empId);

			}
		});

		


		// create a new button to delete the list items
		Button deletebutton = new Button("Delete");
		
		
		// set the delete button in the table's 3rd column
		emptable.setWidget(tableindex, 2, deletebutton);
		deletebutton.setWidth("50px");
	
		final Integer index = tableindex;
		// add a ckickhandler to the delete button
		deletebutton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				emptable.removeRow(index);
				empdb.deleteEmpData(emp.getEmp_id());
				Window.alert("employee deleted from the database");
				setColumnHeading();

			}
		});

		
		
		//code for edit........................................................		
			
		
		Button editbutton=new Button("Edit");
		emptable.setWidget(tableindex, 3, editbutton);
		editbutton.setWidth("50px");
		
		editbutton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				getUiHandlers().editEmployeeDetails(empId);

			}
		});

		
		
		
		//code for Edit leave Types..................................................
		
		
		
	
		Button editLeaveType=new Button("Edit Leave Type");
		emptable.setWidget(tableindex, 4, editLeaveType);
		editLeaveType.setWidth("120px");
		
		editLeaveType.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				
				
				getUiHandlers().editLeaveTypes(empId,emp_name);
				
				//listpresenter.assignLeaveTypes();
				
			}
		});
		
		
		
	}

	
	
	
	

}
