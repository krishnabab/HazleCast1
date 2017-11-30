package com.att.cache.HazleCast1.service.rs;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import com.att.cache.HazleCast1.model.HelloWorld;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

 
@Api
@Path("/service")
@Produces({MediaType.APPLICATION_JSON})
public interface RestService {
	
	@GET
	@Path("/hello")
	@Produces({MediaType.APPLICATION_JSON})
	@ApiOperation(
			value = "Respond Hello <name>!",
			notes = "Returns a JSON object with a string to say hello. "
					+ "Uses 'world' if a name is not specified",
			response = HelloWorld.class
	)
	@ApiResponses(
			value = {
					@ApiResponse(code = 404, message = "Service not available"),
					@ApiResponse(code = 500, message = "Unexpected Runtime error")
					})
	public Response getQuickHello(
			@QueryParam("name")
			String name);
	
	@PUT
	@Path("/update")
	@Produces({MediaType.TEXT_PLAIN})
	public String updateCache();
	
	@GET
	@Path("/getcachesize")
	@Produces({MediaType.TEXT_PLAIN})
	public String getCacheSize();
	
	@GET
	@Path("/show")
	@Produces({MediaType.TEXT_PLAIN})
	public String showCache();
	
	@DELETE
	@Path("/delete")
	@Produces({MediaType.TEXT_PLAIN})
	public String deleteFromCache();
}