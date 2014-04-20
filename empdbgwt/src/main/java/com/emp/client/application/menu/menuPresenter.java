package com.emp.client.application.menu;

import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.gwt.user.client.ui.Button;
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

public class menuPresenter extends
		Presenter<menuPresenter.MyView, menuPresenter.MyProxy> 
{
	interface MyView extends View
   {
	

		Button getAddButton();
		
		Button getDisplayButton();
		
		
		
	}

	@ContentSlot
	public static final Type<RevealContentHandler<?>> SLOT_menu = new Type<RevealContentHandler<?>>();

	@NameToken(NameTokens.menu)
	@ProxyStandard
	public interface MyProxy extends ProxyPlace<menuPresenter> 
	{
	}

	@Inject
	public menuPresenter(EventBus eventBus, MyView view, MyProxy proxy)
	{
		super(eventBus, view, proxy, RevealType.Root);

	}
	
	 
		
	
	 @Inject
	    PlaceManager placemanager;
	    
	 
	 
	 
	    @Override
	    protected void onBind()
	    {
	    	super.onBind();
	    	getView().getAddButton().addClickHandler(new ClickHandler() 
	    	{
	    		@Override
				public void onClick(ClickEvent event)
				{
				   //call the home presenter
					PlaceRequest placerequest = new PlaceRequest(NameTokens.home);
					placemanager.revealPlace(placerequest);
					
					
				}
			});

        
	   	   
	   
	    	getView().getDisplayButton().addClickHandler(new ClickHandler() 
	    	
     	{
	    		@Override
				public void onClick(ClickEvent event)
				{
				   //call the list presenter
					PlaceRequest placerequest = new PlaceRequest(NameTokens.list);
					placemanager.revealPlace(placerequest);
					
					
				}
			

	    });

	    }
}

