package de.uni_tuebingen.qbic.main;

import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinService;
import com.vaadin.server.VaadinSession;

import de.uni_tuebingen.qbic.sessions.*;
import de.uni_tuebingen.qbic.user.*;



public class LiferayAndVaadinUtils{	
	private static String LiferaySpecificAttribute =  "PORTLET_ID";
	public static String getCurrentBasePath(){
		return VaadinSessions.getCurrentBasePath();
	}
	
	public static com.liferay.portal.model.User getUser(){
		VaadinSession.getCurrent().getService();
		String remoteuser = VaadinService.getCurrentRequest().getRemoteUser();
		
		if(remoteuser == null){
			return null;
		}
		return UserRelated.getLiferayUser(remoteuser);
	}
	
	public static boolean isLiferayPortlet(){
		VaadinSession.getCurrent().getService();
		String remoteuser = VaadinService.getCurrentRequest().getRemoteUser();
		Object PORTLET_ID = VaadinService.getCurrentRequest().getAttribute(LiferayAndVaadinUtils.LiferaySpecificAttribute);
		return remoteuser != null && PORTLET_ID != null;
	}
	
}
