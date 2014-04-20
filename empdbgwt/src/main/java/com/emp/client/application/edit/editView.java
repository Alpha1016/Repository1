package com.emp.client.application.edit;



import javax.inject.Inject;

import com.emp.client.shared.model.Employee;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

public class editView extends ViewWithUiHandlers<editUiHandlers> implements
		editPresenter.MyView {
	interface Binder extends UiBinder<Widget, editView> {
	}

	

	@Inject
	editView(Binder uiBinder) {
		initWidget(uiBinder.createAndBindUi(this));
	}
	

	@UiField
	Label eid;
	
	
	@UiField
	TextBox ename,eage,ephone,eaddress;
	
	@UiField
	Button savebutton;
	
	@Inject
	Button editbutton;
	
	
	
	
    //define the function to edit the employee's details called in the edit Presenter
	@Override
	public void editEmployeeDetails(Employee emp) 
	{
		eid.setText(emp.getEmp_id() + "");
		eid.setWidth("50px");
		
		
		ename.setText(emp.getName());
		ename.setWidth("50px");
		
		
		eage.setText(emp.getAge()+"");
		eage.setWidth("50px");
		
		
		ephone.setText(emp.getPhone()+"");
		ephone.setWidth("50px");
		



		eaddress.setText(emp.getAddress());
		eaddress.setWidth("80px");	
			
		 savebutton.addClickHandler(new ClickHandler()
		 {
			
			@Override
			public void onClick(ClickEvent event) {
				
				getUiHandlers().getEmpValues(Integer.parseInt(eid.getText()));
			
			}
		});
	
	}





	public Label getId() {
		return eid;
	}





	public TextBox getName() {
		return ename;
	}





	public TextBox getAge() {
		return eage;
	}





	public TextBox getPhone() {
		return ephone;
	}





	public TextBox getAddress() {
		return eaddress;
	}


	
}
