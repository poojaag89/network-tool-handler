package edu.umkc.ericsson.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import org.json.JSONArray;
import org.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import edu.umkc.ericsson.bo.ElementInfo;


public class AddElement_model {
	private String REQUEST_URL = "http://kc-sce-cs551-2.kc.umkc.edu/aspnet_client/EPG7/Hackathon/WcfService2/dbService.svc/getToolsData/tools";
	
	public void add(ElementInfo elementTool){
	System.out.print("hai1");
		//(1,'ATLNGAUS-MME-01','ATL-MME-01','ET','UMKC',null,1,'enable')
		 
		 String data = "("+elementTool.getElementId()+",'"+elementTool.getElementName()+"','"+elementTool.getElementName()+"','"+elementTool.getTimeZone()+"','UMKC',"+null+",'"+elementTool.getToolName()+"',1)";		
			
		 REQUEST_URL = "http://kc-sce-cs551-2.kc.umkc.edu/aspnet_client/EPG7/Hackathon/WcfService2/dbElement.svc/insertElements/"+data+"/"+elementTool.getElementId();
		 System.out.print("hai2");
		 System.out.print(REQUEST_URL);
		 System.out.print("hai3");
		try {
			
			Client client = Client.create();
	 
			
			WebResource webResource = client
			.resource(REQUEST_URL);
			
			ClientResponse response = webResource.accept("application/json")
	                   .get(ClientResponse.class);
			
			if (response.getStatus() != 200) {
			   throw new RuntimeException("Failed : HTTP error code : "+ response.getStatus());
			}
			else{
				System.out.println("Dataposted");
			}
			//System.out.println(response.getEntity(String.class));
			
			
		}
		catch (Exception e) {
	 
			e.printStackTrace();
	 
		}
	 }
}
