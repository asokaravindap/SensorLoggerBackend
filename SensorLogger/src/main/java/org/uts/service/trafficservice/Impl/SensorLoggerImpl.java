package org.uts.service.trafficservice.Impl;

import javax.ws.rs.core.Response;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.uts.service.trafficservice.SensorLogger;
import org.uts.service.trafficservice.beans.SensorReadings;
import org.uts.service.trafficservice.db.MySQLConnector;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SensorLoggerImpl implements SensorLogger{
	
	private Log log = LogFactory.getLog(SensorLoggerImpl.class);

	public Response logReadings(SensorReadings readings) {
		
		log.info("Message received from : " + readings.getmacaddress());
		
		if(MySQLConnector.getInstance().isInitialized()){
			Connection connection = MySQLConnector.getInstance().getConnection();
			try {
				Statement stmt = connection.createStatement();
				stmt.executeUpdate("INSERT INTO sensorreadings (mac,lat,lon,accx,accy,accz,gyrx,gyry,gyrz,bluetooth) VALUES ('"+readings.getmacaddress()+"','"+readings.getlatitude()+"','"+readings.getlongitude()+"','"+readings.getaccx()+"','"+readings.getaccy()+"','"+readings.getaccz()+"','"+readings.getgyrx()+"','"+readings.getgyry()+"','"+readings.getgyrz()+"','"+readings.getbluetooth()+"')");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return Response.ok().build();
	}

}
