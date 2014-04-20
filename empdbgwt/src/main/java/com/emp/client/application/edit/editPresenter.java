package com.emp.client.application.edit;

import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.emp.client.place.NameTokens;
import com.emp.client.shared.model.Employee;
import com.emp.client.shared.model.EmployeeDB;

public class editPresenter extends
		Presenter<editPresenter.MyView, editPresenter.MyProxy> implements
		editUiHandlers {
	interface MyView extends View, HasUiHandlers<editUiHandlers> {

		void editEmployeeDetails(Employee emp);


		public Label getId();

		public TextBox getName(); 
		
		public TextBox getAge();

		public TextBox getPhone();

		public TextBox getAddress();


		

		
		
	}

	@ContentSlot
	public static final Type<RevealContentHandler<?>> SLOT_edit = new Type<RevealContentHandler<?>>();

	@NameToken(NameTokens.edit)
	@ProxyStandard
	public interface MyProxy extends ProxyPlace<editPresenter> {
	}

	@Inject
	public editPresenter(EventBus eventBus, MyView view, MyProxy proxy) {
		super(eventBus, view, proxy, RevealType.Root);

		getView().setUiHandlers(this);
		

		
	}

	
	
	@Inject
	EmployeeDB empdb;
	
	@Inject
	PlaceManager placemanager;
	
	@Override
	public void prepareFromRequest(PlaceRequest request) {
		
		super.prepareFromRequest(request);
		
		
		
		Integer id =Integer.parseInt(request.getParameter("param","Did not find" ));
	
		// get the data from the list and set the data to the view
				Employee emp = empdb.searchById(id);
                //getView().editEmployeeDetails(emp);
				//Integer emp_id=Integer.parseInt(id);
				
				 //Employee employee= employeedb.searchEmpDataById(emp_id);
				 getView().editEmployeeDetails(emp);
				
	}

	@Override
	public void getEmpValues(int id) {
		
		   empdb.deleteEmpData(id);
		   Employee emp=new Employee(Integer.parseInt(getView().getId().getText()),
				   getView().getName().getText(),
				   Integer.parseInt(getView().getAge().getText()),
				   Long.parseLong(getView().getPhone().getText()),
				    getView().getAddress().getText());
				//call to the addEmployee Method and pass the object of employee 
				empdb.addEmpData(emp);
				Window.alert("Successfuly Updated");
			
		}

		
	}
               		
               

	
	

	
	
	    

