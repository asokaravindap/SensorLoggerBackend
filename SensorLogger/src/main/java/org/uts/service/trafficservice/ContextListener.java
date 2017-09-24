package org.uts.service.trafficservice;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.uts.service.trafficservice.beans.PropertiesParams;
import org.uts.service.trafficservice.db.*;

public class ContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent servletContextEvent) {
    	
    	Properties properties = new Properties();
    	PropertiesParams propertiesObj = new PropertiesParams();
    	
    	try {
			properties.load(servletContextEvent.getServletContext().getResourceAsStream("/WEB-INF/service.properties"));		    
			
			propertiesObj.setdbPath(properties.getProperty("DBPath"));
			propertiesObj.setuserName(properties.getProperty("UserName"));
			propertiesObj.setpassword(properties.getProperty("Password"));
			
    	} catch (IOException e) {
			e.printStackTrace();
		}
    	
        if(!MySQLConnector.getInstance().isInitialized()){
            try {
            	MySQLConnector.getInstance().init(propertiesObj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}