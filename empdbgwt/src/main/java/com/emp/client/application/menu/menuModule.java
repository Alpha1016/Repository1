package com.emp.client.application.menu;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;


public class menuModule extends AbstractPresenterModule {
	@Override
	protected void configure() {
		
		bindPresenter(menuPresenter.class, menuPresenter.MyView.class,
				menuView.class, menuPresenter.MyProxy.class);
	}
}
