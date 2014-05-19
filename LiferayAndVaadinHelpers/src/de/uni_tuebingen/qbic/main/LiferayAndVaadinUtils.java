package de.uni_tuebingen.qbic.main;

import com.vaadin.server.VaadinService;
import com.vaadin.server.VaadinSession;

import de.uni_tuebingen.qbic.sessions.VaadinSessions;
import de.uni_tuebingen.qbic.user.UserRelated;


/**
 * LiferayAndVaadinUtils is the main class of this library. It implements most of the needed functionality.
 * @author wojnar
 *
 */
public class LiferayAndVaadinUtils{	
	private static String LiferaySpecificAttribute =  "PORTLET_ID";
	
	/**
	 * returns the current Base path
	 * @return base path of the runnnig portlet as string
	 */
	public static String getCurrentBasePath(){
		return VaadinSessions.getCurrentBasePath();
	}
	
	/**
	 * if run in an Liferay environment the current user is returned. If run independendly e.g. as a servlet null is returned  
	 * @return current Liferay user or null if no user exists.
	 */
	public static com.liferay.portal.model.User getUser(){
		VaadinSession.getCurrent().getService();
		String remoteuser = VaadinService.getCurrentRequest().getRemoteUser();
		
		if(remoteuser == null){
			return null;
		}
		return UserRelated.getLiferayUser(remoteuser);
	}
	
	/**
	 * Checks whether it is run in a Liferay Portal environment. 
	 * @return true, if run in a Liferay Portal environement.
	 */
	public static boolean isLiferayPortlet(){
		VaadinSession.getCurrent().getService();
		String remoteuser = VaadinService.getCurrentRequest().getRemoteUser();
		Object PORTLET_ID = VaadinService.getCurrentRequest().getAttribute(LiferayAndVaadinUtils.LiferaySpecificAttribute);
		return remoteuser != null && PORTLET_ID != null;
	}
	
}
