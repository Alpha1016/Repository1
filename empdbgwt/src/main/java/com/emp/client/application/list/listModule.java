package com.emp.client.application.list;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.emp.client.application.list.leavetype.LeaveTypeModule;


public class listModule extends AbstractPresenterModule {
	@Override
	protected void configure() {
		
		install(new LeaveTypeModule());
		bindPresenter(listPresenter.class, listPresenter.MyView.class,
				listView.class, listPresenter.MyProxy.class);
	}
}
