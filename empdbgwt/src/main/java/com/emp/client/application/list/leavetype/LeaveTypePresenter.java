package com.emp.client.application.list.leavetype;

import java.util.List;

import com.emp.client.application.list.listPresenter;
import com.emp.client.place.NameTokens;
import com.emp.client.shared.model.LeaveDB;
import com.google.gwt.user.client.Window;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

public class LeaveTypePresenter extends
		Presenter<LeaveTypePresenter.MyView, LeaveTypePresenter.MyProxy>
		implements LeaveTypeUiHandlers {
	interface MyView extends View, HasUiHandlers<LeaveTypeUiHandlers> {

		void setEmpNameToLabel(String emp_name);
	}

	/*@ContentSlot
	public static final Type<RevealContentHandler<?>> SLOT_LeaveType = new Type<RevealContentHandler<?>>();*/

	@NameToken(NameTokens.laevetype)
	@ProxyStandard
	public interface MyProxy extends ProxyPlace<LeaveTypePresenter> {
	}

	@Inject
	public LeaveTypePresenter(EventBus eventBus, MyView view, MyProxy proxy) {
		super(eventBus, view, proxy, listPresenter.SLOT_leaveType);
                        
		getView().setUiHandlers(this);
	}

	@Inject
	LeaveDB leavedb;
	
	String name;
	Integer empId;

	@Inject
	PlaceManager placemanager;
	
	public void saveAssignedLeaves(Integer emp_id,List<String> leavelist)
	{
		leavedb.addLeaveData(empId, leavelist);
		System.out.println("the size of the hashmap is" + leavedb.getLeaveCount());
		Window.alert("leave details saved in list");
	}

	public void setName(String emp_name) {
		this.name = name;
	getView().setEmpNameToLabel(emp_name);
	}


	


	public void setEmpId(Integer empId) {
		this.empId = empId;
	}











	public Integer getEmpId() {
		return empId;
	}




	



	
	
		
}

