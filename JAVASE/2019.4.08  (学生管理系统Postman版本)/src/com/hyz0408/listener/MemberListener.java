package com.hyz0408.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Application Lifecycle Listener implementation class MemberListener
 *
 */
@WebListener
public class MemberListener implements HttpSessionAttributeListener {

    /**
     * Default constructor. 
     */
    public MemberListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent event)  { 
         // TODO Auto-generated method stub
    	 ServletContext servletContext=event.getSession().getServletContext();
    	if(event.getName().equals("user")) {
    		//有用户登陆
    		Integer total=(Integer)servletContext.getAttribute("total");
    		if(total==null) {
    			total=1;
    			servletContext.setAttribute("total", 1);
    		}else {
    			servletContext.setAttribute("total", ++total);
    		}
    	}
    	
    	
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent event)  { 
         // TODO Auto-generated method stub
    	ServletContext servletContext=event.getSession().getServletContext();
    	Integer total=(Integer)servletContext.getAttribute("total");
    	if(total==null) {
    		total=0;
    	}else {
    		total--;
    	}
    	
    	if(total<0) {
    		total=0;
    	}
    	servletContext.setAttribute("total", total);
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent event)  { 
         // TODO Auto-generated method stub
    	HttpSession session=event.getSession();
    	Object o=session.getAttribute("user");
    	if(o!=null) {
    		return;
    	}
    	 ServletContext servletContext=event.getSession().getServletContext();
     	if(event.getName().equals("user")) {
     		//有用户登陆
     		Integer total=(Integer)servletContext.getAttribute("total");
     		if(total==null) {
     			total=1;
     			servletContext.setAttribute("total", 1);
     		}else {
     			servletContext.setAttribute("total", ++total);
     		}
     	}
    }
	
}
