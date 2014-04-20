package com.emp.client.application.details;

import javax.inject.Inject;

import com.emp.client.shared.model.Employee;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

public class detailsView extends ViewImpl implements detailsPresenter.MyView {
	interface Binder extends UiBinder<Widget, detailsView> {
	}

	

	
	@Inject
	detailsView(Binder uiBinder) {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField
	Label resultLable;
	
	@UiField
	FlexTable empdetails;


		// method to clear the table and the content of the table
		public void clearTable() {
			
			empdetails.clear();
			empdetails.removeAllRows();
		}
		

	   //method to set the heading into the table 
		public void setColumnHeading() {
			empdetails.setWidget(0, 0, new Label("Emp Id"));
			empdetails.setWidget(0, 1, new Label("Age"));
			empdetails.setWidget(0, 2, new Label(" Name"));
			empdetails.setWidget(0, 3, new Label("Address"));
			empdetails.setWidget(0, 4, new Label("Phone No"));
		}
		
		//define the method to view the particular employee's details
		@Override
		public void viewEmployeeDetails(Employee emp) 
		{   
			
			//get all the values of the partoicular employee by using the id 
			Label idlable = new Label(emp.getEmp_id() + "");
			idlable.setWidth("50px");
			Label nameLable = new Label(emp.getName());
			nameLable.setWidth("60px");
			Label ageLable = new Label(emp.getAge() + "");
			ageLable.setWidth("50px");
			Label phnoLable = new Label(emp.getPhone() + "");
			phnoLable.setWidth("80px");
			Label addressLable = new Label(emp.getAddress());
			addressLable.setWidth("150px");
			
			//add the row containing the particular employee's information into the display table
			int sizeOfTable = 0;//intialize the variable to 0
			//set the row count of the table in the variable
			sizeOfTable = empdetails.getRowCount();
			//if the table has no rows, add the headings of the column
			if (sizeOfTable <= 0)
				setColumnHeading();
			sizeOfTable++;
            //add the corresponding info of the particular employee to the same row in different columns
			empdetails.setWidget(sizeOfTable, 0, idlable);
			empdetails.setWidget(sizeOfTable, 2, nameLable);
			empdetails.setWidget(sizeOfTable, 1, ageLable);
			empdetails.setWidget(sizeOfTable, 4, phnoLable);
			empdetails.setWidget(sizeOfTable, 3, addressLable);
			
			
			
		}





	
}
