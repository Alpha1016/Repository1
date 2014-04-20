package com.emp.client.application.details;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
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

public class detailsPresenter extends
		Presenter<detailsPresenter.MyView, detailsPresenter.MyProxy> {
	interface MyView extends View {

		void clearTable();

		

		void viewEmployeeDetails(Employee emp);



		
		
	}

	@ContentSlot
	public static final Type<RevealContentHandler<?>> SLOT_details = new Type<RevealContentHandler<?>>();

	@NameToken(NameTokens.details)
	@ProxyStandard
	public interface MyProxy extends ProxyPlace<detailsPresenter> {
	}

	@Inject
	public detailsPresenter(EventBus eventBus, MyView view, MyProxy proxy) {
		super(eventBus, view, proxy, RevealType.Root);

	}
	
	
	@Inject
	EmployeeDB empdb;
	
	@Inject
	PlaceManager placemanager;
	
	@Override
	public void prepareFromRequest(PlaceRequest request) {
		
		super.prepareFromRequest(request);
		
		// get the id passed by the detailsPresenterView 	
		Integer id =Integer.parseInt(request.getParameter("param","Did not find" ));
	
		     // search the employee detail by id
				Employee emp = empdb.searchById(id);
				//clear the table each time the details of a particular employee is displayed
				getView().clearTable();
				//call the function defined in details view
                getView().viewEmployeeDetails(emp);
	}
               		
               

	}
	


