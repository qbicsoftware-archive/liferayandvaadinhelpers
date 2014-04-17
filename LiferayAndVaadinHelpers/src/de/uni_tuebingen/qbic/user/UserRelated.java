package de.uni_tuebingen.qbic.user;

import java.util.Map;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.vaadin.server.VaadinSession;
//import com.liferay.portal.service.UserServiceUtil;

/**
 * This class has liferay related user functionality.
 * It follows the singelton pattern, hence use the 
 * {{@link #getInstance()} to get a working object of this class
 * @author wojnar
 *
 */
public class UserRelated {
	
	
	
	public static com.liferay.portal.model.User getLiferayUser(String liferay_user_id){
    	//explode city gots to figure out how to deal with it not being in the map
    	//String locationId = (String) userInfoMap.get("liferay.location.id");
    	//String companyId = (String) userInfoMap.get("liferay.company.id");
	    try {
	    	//String userName = (String) userInfoMap.get("liferay.user.id");
	    	return UserLocalServiceUtil.getUser(Long.parseLong(liferay_user_id)); 
			//com.liferay.portal.model.User currentLocalUser = UserServiceUtil.getUserById(Long.parseLong(userName));
			//currentLocalUser = UserLocalServiceUtil.getUser(Long.parseLong(userName));
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			System.err.println("???");
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return null;
	}
}
