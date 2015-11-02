package edu.umkc.ericsson;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import edu.umkc.ericsson.bo.ScheduleInfo;
	

public class Test {
	
		private static final String REQUEST_URL = "http://kc-sce-cs551-2.kc.umkc.edu/aspnet_client/EPG7/Hackathon/WcfService2/dbService.svc/getToolsData/tools";
		//private static final String REQUEST_URL_PARAM = "Babitha";
		
		public static void main(String[] args) {
			ArrayList<ScheduleInfo> oldSchedule =new ArrayList<ScheduleInfo>();
					oldSchedule.add(new ScheduleInfo(7,9));
					oldSchedule.add(new ScheduleInfo(9,11));
					oldSchedule.add(new ScheduleInfo(11,12));
					Test t = new Test();
					System.out.println(t.schedule(oldSchedule));
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
	                    String desc = o.getString("toolname");
	                    System.out.println(desc);
	}
					System.out.println("Output from Server .... \n");
					/*System.out.println(password);*/
				}
				catch (Exception e) {
			 
					e.printStackTrace();
			 
				  }
			
		}

		public boolean schedule(ArrayList<ScheduleInfo> oldSchedule)
		{
			List<ScheduleInfo> newSchedule =new ArrayList<>();
			for (ScheduleInfo e:oldSchedule){
				if (e.getStartTime()>e.getEndTime()){
					newSchedule.add(new ScheduleInfo(e.getStartTime(),23));
					newSchedule.add(new ScheduleInfo(0,e.getEndTime()));
				}
				else{
					newSchedule.add(new ScheduleInfo(e.getStartTime(),e.getEndTime()));
				}
			}
			newSchedule.sort(scheduleComparator);
			
			for (int i=1;i<newSchedule.size();i++){
				if(newSchedule.get(i-1).getEndTime()>=newSchedule.get(i).getStartTime()){
					return false;
				}
				System.out.println(newSchedule.get(i).getStartTime()+","+newSchedule.get(i).getEndTime());
				
			}
			return true;
		}
		
		public static Comparator<ScheduleInfo> scheduleComparator 
        = new Comparator<ScheduleInfo>() {

		public int compare(ScheduleInfo schedule1, ScheduleInfo schedule2) {
		
		
		Integer endtime1=schedule1.getEndTime();
		Integer endtime2=schedule2.getEndTime();
		//ascending order
		return endtime1.compareTo(endtime2);
		
		//descending order
		//return fruitName2.compareTo(fruitName1);
		}
		};
		
}