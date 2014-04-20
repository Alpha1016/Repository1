package com.emp.client.application.list;

import java.util.Iterator;
import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FocusWidget;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.IsWidget;
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
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.emp.client.application.list.leavetype.LeaveTypePresenter;
import com.emp.client.place.NameTokens;
import com.emp.client.shared.model.Employee;
import com.emp.client.shared.model.EmployeeDB;

public class listPresenter extends
		Presenter<listPresenter.MyView, listPresenter.MyProxy> implements DisplayUiHandler  
{
	interface MyView extends View,HasUiHandlers<DisplayUiHandler> 
	{

		public void clearTable();

		public void addEmpData(Employee emp);

		//void editEmpData(Employee emp);
		
	
		
	}
	
	public static final Object SLOT_leaveTypes= new Object();

	
	@Override
	protected void onBind() {
		super.onBind();
		getView().setUiHandlers(this);
			
	};
	
	@ContentSlot
	public static final Type<RevealContentHandler<?>> SLOT_leaveType = new Type<RevealContentHandler<?>>();

	@NameToken(NameTokens.list)
	@ProxyStandard
	public interface MyProxy extends ProxyPlace<listPresenter>
	{
		
	}

	
	
	@Inject
	EmployeeDB empdb;
	
	 @Inject
	    PlaceManager placemanager;
	    
	 @Inject
	 LeaveTypePresenter leaveTypePresenter;
	 
	 
	
	 
	@Inject
	public listPresenter(EventBus eventBus, MyView view, MyProxy proxy) 
	{
		super(eventBus, view, proxy, RevealType.Root);

	}
	
	
	
	


	//Define viewEmployeeDetails function
	public void viewEmployeeDetails(Integer empId)
	{
		
		
			   //call the home presenter
				
				PlaceRequest placerequest = new PlaceRequest(NameTokens.details).with("param", empId.toString());
				placemanager.revealPlace(placerequest);
				
		}
		
	@Override
	public void editEmployeeDetails(Integer empId)
	{
		PlaceRequest placerequest = new PlaceRequest(NameTokens.edit).with("param", empId.toString());
		placemanager.revealPlace(placerequest);
		
		
		
	}

	
	
	
	protected void onReset()
	{
		super.onReset();
		getView().clearTable();
		System.out.println(empdb.getEmployeeCount());
		List<Employee> emp=empdb.display();
		Iterator<Employee> it = emp.iterator();
		while (it.hasNext()) 
		{
			Employee emp1=it.next();
			getView().addEmpData(emp1);

		}
		
		
	}






	@Override
	public void editLeaveTypes(Integer empId,String emp_name) {
		
		leaveTypePresenter.setName(emp_name);
		//leaveTypePresenter.setEmpId(empId);
		
		setInSlot( SLOT_leaveTypes,leaveTypePresenter );	
	//System.out.println("editleavetypes clicked");
	}






	
	
	
	}

	
	



	
	
