package edu.umkc.ericsson.model;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import edu.umkc.ericsson.bo.ElementInfo;
import edu.umkc.ericsson.bo.ToolsInfo;

public class ElementInfo_Model {
	private String REQUEST_URL="http://kc-sce-cs551-2.kc.umkc.edu/aspnet_client/EPG7/Hackathon/WcfService2/dbElement.svc/getElementsData/" ;
	
	public ArrayList<ElementInfo> getElements(String toolName){
		ArrayList<ElementInfo> tools = new ArrayList<ElementInfo>();
		try {
			
			Client client = Client.create();
			WebResource webResource = client
			   .resource(REQUEST_URL+toolName);
	 
			ClientResponse response = webResource.accept("application/json")
	                   .get(ClientResponse.class);
			
			if (response.getStatus() != 200) {
			   throw new RuntimeException("Failed : HTTP error code : "
				+ response.getStatus());
			}
			//System.out.println(response.getEntity(String.class));
			
			JSONArray jsonresp=new JSONArray(response.getEntity(String.class));
	
            int length= jsonresp.length();
            for(int in=0;in<length;in++) {
                JSONObject o = jsonresp.getJSONObject(in);
                String elementname = o.getString("elementname");
                int elementId=o.getInt("elementId");
                String elementStatus=o.getString("status");
                String timeZone=o.getString("timezone");
                tools.add(new ElementInfo(elementname,elementId,timeZone,elementStatus));						//adding Tools info in to array list
                 
            }
			System.out.println("Output from Server .... \n");
			/*System.out.println(password);*/
			return tools;
		}
		catch (Exception e) {
	 
			e.printStackTrace();
	 
		}
		tools.add(new ElementInfo(1, "Dummy", toolName, toolName, toolName, 1, toolName, toolName));
		return null;
	}

	}


