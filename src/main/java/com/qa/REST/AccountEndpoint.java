package com.qa.REST;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.BusinessRules;

@Path("/account")
public class AccountEndpoint {

	@Inject
	private BusinessRules service;
	
	@Path("/getAllAccounts")
	@GET
	@Produces({"application/json"})
	public String getAllAccounts() {
		
		return service.getAllAccounts();
	}
	
	@Path("/getAnAccount/{id}")
	@GET
	@Produces({"application/json"})
	public String findAnAccount(@PathParam("id")Long id) {
		
		return service.getAnAccount(id);
	}
	
	@Path("/createAnAccount")
	@PUT
	@Produces({"application/json"})
	public String createAnAccount(String account) {
		
		return service.createAccount(account);	
	}
	
	@Path("/updateAnAccount")
	@PUT
	@Produces({"application/json"})
	public String updateAnAccount(Long id, String account) {
		
		return service.updateAccount(id, account);
	}
	
	@Path("/deleteAnAccount/{id}")
	@DELETE
	@Produces({"application/json"})
	public String deleteAnAccount(@PathParam("id")Long id) {
		
		return service.deleteAccount(id);
	}
	
}
