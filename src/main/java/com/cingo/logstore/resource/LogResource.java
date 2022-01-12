package com.cingo.logstore.resource;

import com.cingo.logstore.repostory.LogRepository;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("log")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LogResource {
	
	@Context
	private HttpServletRequest httpRequest;
    private final LogRepository repository = new LogRepository();
	
    @GET
    public List getLogs() {
    	return this.repository.findAllOrdened();
    }
}
