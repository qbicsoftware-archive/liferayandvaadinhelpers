package life.qbic.portal.liferayandvaadinhelpers.main;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.security.Principal;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.Cookie;

import org.junit.Test;

import com.vaadin.server.DefaultDeploymentConfiguration;
import com.vaadin.server.ServiceException;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinService;
import com.vaadin.server.VaadinServlet;
import com.vaadin.server.VaadinServletService;
import com.vaadin.server.VaadinSession;
import com.vaadin.server.WrappedSession;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)

public class TestLiferayAndVaadinUtils {
	public class StubVaadinRequest implements VaadinRequest{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		Map <String, Object> attributes = new HashMap <String, Object> ();
		@Override
		public String getParameter(String parameter) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Map<String, String[]> getParameterMap() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int getContentLength() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public InputStream getInputStream() throws IOException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Object getAttribute(String name) {
			//String userinfoAttribute = "javax.portlet.userinfo";
			return this.attributes.get(name);
		}

		@Override
		public void setAttribute(String name, Object value) {
			this.attributes.put(name, value);
		}

		@Override
		public String getPathInfo() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getContextPath() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public WrappedSession getWrappedSession() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public WrappedSession getWrappedSession(boolean allowSessionCreation) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getContentType() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Locale getLocale() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getRemoteAddr() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean isSecure() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public String getHeader(String headerName) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public VaadinService getService() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Cookie[] getCookies() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getAuthType() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getRemoteUser() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Principal getUserPrincipal() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean isUserInRole(String role) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void removeAttribute(String name) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Enumeration<String> getAttributeNames() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Enumeration<Locale> getLocales() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getRemoteHost() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int getRemotePort() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public String getCharacterEncoding() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public BufferedReader getReader() throws IOException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getMethod() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getDateHeader(String name) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public Enumeration<String> getHeaderNames() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Enumeration<String> getHeaders(String name) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
	StubVaadinRequest request;
	public void setUp() {
		//PowerMockito.mockStatic(VaadinSer);
		
	}
	public class MyVaadinUI extends UI{

		@Override
		protected void init(VaadinRequest request) {
			// TODO Auto-generated method stub
			
		}
		
		public com.liferay.portal.model.User tellUser(){
			return LiferayAndVaadinUtils.getUser();
		}
		
	}		
	@Mock
	VaadinSession vaadinsession;
	@Mock
	VaadinService vaadinservice;
	@PrepareForTest({VaadinService.class, VaadinSession.class})
	@Test
	public void test_getUser_no_liferay_instance() {
		//request = new StubVaadinRequest();
		//request.setAttribute("javax.portlet.userinfo","testUser");
		PowerMockito.mockStatic(VaadinSession.class);
		PowerMockito.mockStatic(VaadinService.class);
		
		MyVaadinUI ui = new MyVaadinUI();
		ui.init(new StubVaadinRequest());
		ui.getSession();
		Mockito.when(VaadinService.getCurrentRequest()).thenReturn(new StubVaadinRequest());
		com.liferay.portal.model.User user = ui.tellUser();
		assertEquals(user, null);
	}
	
	@Test 
	public void test_getUser_liferay_instance(){
		fail("Not yet implemented");
	}
	@Test
	public void test_isLiferayPortlet_(){
		fail("Not yet implemented");
	}
	
	@Test
	public void test_getCurrentBasePath_(){
		fail("Not yet implemented");
	}
	
}
