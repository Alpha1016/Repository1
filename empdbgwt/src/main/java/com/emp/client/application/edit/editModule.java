package com.emp.client.application.edit;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class editModule extends AbstractPresenterModule {
	@Override
	protected void configure() {
		bindPresenter(editPresenter.class, editPresenter.MyView.class,
				editView.class, editPresenter.MyProxy.class);
	}
}
