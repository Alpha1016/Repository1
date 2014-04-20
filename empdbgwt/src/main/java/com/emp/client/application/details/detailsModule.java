package com.emp.client.application.details;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class detailsModule extends AbstractPresenterModule {
	@Override
	protected void configure() {
		bindPresenter(detailsPresenter.class, detailsPresenter.MyView.class,
				detailsView.class, detailsPresenter.MyProxy.class);
	}
}
