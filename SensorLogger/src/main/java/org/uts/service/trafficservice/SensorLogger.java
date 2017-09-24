package org.uts.service.trafficservice;

import javax.jws.WebService;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import org.uts.service.trafficservice.beans.SensorReadings;

@WebService
@Path("/service")
@Produces("application/json")
@Consumes("application/json")
public interface SensorLogger {

	@POST
    @Path("/log")
    public Response logReadings(SensorReadings readings);
	
}
