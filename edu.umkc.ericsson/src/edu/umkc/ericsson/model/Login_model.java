package edu.umkc.ericsson.model;

import org.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import edu.umkc.ericsson.bo.User;

public class Login_model {
	private static final String REQUEST_URL = "http://kc-sce-cs551-2.kc.umkc.edu/aspnet_client/EPG7/Hackathon/WcfService2/dbService.svc/login";
	//private static final String REQUEST_URL_PARAM = "Babitha";
	
	public Boolean validate(User usr) {
		Boolean isPasswordValid = false;
		try {
			
			Client client = Client.create();
	 
			WebResource webResource = client
			   .resource(REQUEST_URL+"/"+usr.getUserName());
	 
			ClientResponse response = webResource.accept("application/json")
	                   .get(ClientResponse.class);
			
			if (response.getStatus() != 200) {
			   throw new RuntimeException("Failed : HTTP error code : "
				+ response.getStatus());
			}
	 
			
			String password=response.getEntity(String.class);
			password="umkc";
			System.out.print(password);
			System.out.print(usr.getPassword());
			if(password.equals(usr.getPassword())){
				System.out.println("Output from Server .... \n");
				isPasswordValid=true;
			}
			
			//System.out.println("Output from Server .... \n");
			//System.out.println(password);
	 
		  } catch (Exception e) {
	 
			e.printStackTrace();
	 
		  }
		return isPasswordValid;

}}
