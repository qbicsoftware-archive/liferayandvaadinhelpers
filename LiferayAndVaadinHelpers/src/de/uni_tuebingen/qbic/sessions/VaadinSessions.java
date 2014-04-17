package de.uni_tuebingen.qbic.sessions;

import java.util.Map;

import com.vaadin.server.VaadinPortletSession;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinService;
import com.vaadin.server.VaadinSession;


/**
 * This class deals specifically with vaadin sessions
 * and returns some useful information about the session.
 * @author wojnar
 *
 */
public class VaadinSessions {

	private static VaadinRequest request;
	public static void init(){
		VaadinSession.getCurrent().getService();
		VaadinSessions.request = VaadinService.getCurrentRequest();
	}
	
	public static boolean isVaadinSession(){
		return (VaadinSession.getCurrent() instanceof VaadinPortletSession);
	}
	
	public static Map getAttribute(String attribute) {
		return (Map) VaadinSessions.request.getAttribute(attribute);
	}
	
	public static String getCurrentBasePath(){
		return VaadinService.getCurrent().getBaseDirectory().getAbsolutePath();
	}
}
