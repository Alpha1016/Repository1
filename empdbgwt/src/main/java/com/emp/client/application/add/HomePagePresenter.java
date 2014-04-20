/**
 * Copyright 2012 ArcBees Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.emp.client.application.add;

import com.emp.client.application.ApplicationPresenter;
import com.emp.client.place.NameTokens;
import com.emp.client.shared.model.Employee;
import com.emp.client.shared.model.EmployeeDB;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

public class HomePagePresenter extends
		Presenter<HomePagePresenter.MyView, HomePagePresenter.MyProxy> {
	public interface MyView extends View {

		TextBox getEmpIdTextBox();

		TextBox getEmpNameTextBox();

		TextBox getEmpAgeTextBox();

		TextBox getEmpPhoneTextBox();

		TextBox getEmpAddressTextBox();

		Button getButton();
	}

	@ProxyStandard
	@NameToken(NameTokens.home)
	public interface MyProxy extends ProxyPlace<HomePagePresenter> {
	}

	@Inject
	EmployeeDB empdb;

	@Inject
	public HomePagePresenter(EventBus eventBus, MyView view, MyProxy proxy) {
		super(eventBus, view, proxy, ApplicationPresenter.SLOT_SetMainContent);
	}

	@Override
    protected void onBind()
    {
    	super.onBind();
    	//adding the clickhandler for the add  button
    	getView().getButton().addClickHandler(new ClickHandler()
    	{
			
			@Override
			public void onClick(ClickEvent event)
			{
				
				//call the Employee constructor to set the values into the Employee object
				Employee emp=new Employee(Integer.parseInt(getView().getEmpIdTextBox().getText()),
						getView().getEmpNameTextBox().getText(),
						Integer.parseInt(getView().getEmpAgeTextBox().getText()),
						Long.parseLong(getView().getEmpPhoneTextBox().getText()),
						getView().getEmpAddressTextBox().getText());
			    Window.alert("employee details added to the list");
			    //add the employee object into the list
			    empdb.addEmpData(emp);
			    Window.alert("the no. of employees are" + empdb.getEmployeeCount());
			    
		
				
			}
		});
    	
    
    
}
}
