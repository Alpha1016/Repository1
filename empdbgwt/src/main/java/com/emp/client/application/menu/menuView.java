package com.emp.client.application.menu;

import javax.inject.Inject;

import com.emp.client.shared.model.EmployeeDB;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

public class menuView extends ViewImpl implements menuPresenter.MyView {
	interface Binder extends UiBinder<Widget, menuView> {
	}

	
	@Inject
	menuView(Binder uiBinder) {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Inject
	EmployeeDB empdb;
	
	@UiField
	Button addbutton;
	
	@UiField
	Button displaybutton;

	@Override
	public Button getAddButton() {
		
		return addbutton;
	}
	
	
	public Button getDisplayButton()
	{
		return displaybutton;
	}
	
	

}
