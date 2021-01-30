package com.assignment.restAssginment2;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/fullname")
public class StringOperations {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String concatenate(String firstName, String lastName) {
		return firstName+lastName;
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String uppercase(String string) {
		return string.toUpperCase();
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String lowercase(String string) {
		return string.toLowerCase();
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public int length(String string) {
		return string.length();
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public boolean compare(String string1, String string2) {
		return string1.equals(string2);
	}
	
}
