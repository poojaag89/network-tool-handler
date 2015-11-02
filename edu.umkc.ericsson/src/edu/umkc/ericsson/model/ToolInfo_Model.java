package edu.umkc.ericsson.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import org.json.JSONArray;
import org.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import edu.umkc.ericsson.bo.ToolsInfo;

public class ToolInfo_Model {
	private String REQUEST_URL = "http://kc-sce-cs551-2.kc.umkc.edu/aspnet_client/EPG7/Hackathon/WcfService2/dbService.svc/getToolsData/tools";
	public ArrayList<ToolsInfo> getToolInfo(){
		ArrayList<ToolsInfo> tools = new ArrayList<ToolsInfo>();
		try {
			
			Client client = Client.create();
			
			
			
			WebResource webResource = client
			   .resource(REQUEST_URL);
	 
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
                String toolName = o.getString("toolname");
                int toolId=o.getInt("toolId");
                int toolStatus=o.getInt("status");
                
                tools.add(new ToolsInfo(toolId,toolName,toolStatus));						//adding Tools info in to array list
                
            }
			System.out.println("Output from Server .... \n");
			/*System.out.println(password);*/
			return tools;
		}
		catch (Exception e) {
	 
			e.printStackTrace();
	 
		}
		
		return null;
	}

	
	public void add(ToolsInfo newTool){
		 
		 String data = "("+newTool.getToolId()+",'"+newTool.getToolName()+"',"+newTool.getStatus()+",null)/"+newTool.getToolId();		
			
		 REQUEST_URL = "http://kc-sce-cs551-2.kc.umkc.edu/aspnet_client/EPG7/Hackathon/WcfService2/dbService.svc/insertTools/"+data;
		 
		try {
			
			Client client = Client.create();
			WebResource webResource = client.resource(REQUEST_URL);
			System.out.println("Service for add tool"+REQUEST_URL);
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
