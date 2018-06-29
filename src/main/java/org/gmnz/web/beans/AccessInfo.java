package org.gmnz.web.beans;


import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import java.util.Date;


public class AccessInfo implements HttpSessionBindingListener {

	private Date sessionCreationDate;

	private int accessCount;




	public AccessInfo() {
		accessCount = 1;
	}




	@Override
	public void valueBound(HttpSessionBindingEvent httpSessionBindingEvent) {
		final HttpSession session = httpSessionBindingEvent.getSession();
		sessionCreationDate = new Date(session.getCreationTime());
		System.out.printf("new value bound | name [%s] | value [%s]%n", httpSessionBindingEvent.getName(),
				httpSessionBindingEvent.getValue());
	}




	@Override
	public void valueUnbound(HttpSessionBindingEvent httpSessionBindingEvent) {

	}




	public void updateAccessCount() {
		accessCount++;
	}




	public int getAccessCount() {
		return accessCount;
	}




	public Date getSessionCreationDate() {
		return sessionCreationDate;
	}
}
