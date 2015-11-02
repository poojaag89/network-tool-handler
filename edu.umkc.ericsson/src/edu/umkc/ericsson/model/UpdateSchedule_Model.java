package edu.umkc.ericsson.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import edu.umkc.ericsson.bo.ScheduleInfo;




public class UpdateSchedule_Model {

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
		deleteSchedule();
		addSchedule(oldSchedule);
		
		return true;

	}

	private void deleteSchedule() {
		// TODO Auto-generated method stub
		String REQUEST_URL;
		/*http://localhost/aspnet_client/EPG7/Hackathon/WcfService2/dbService.svc/deleteSch
*/				REQUEST_URL = "http://kc-sce-cs551-2.kc.umkc.edu/aspnet_client/EPG7/Hackathon/WcfService2/dbService.svc/deleteSch";
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
			}}
		


		catch (Exception execp) {

			execp.printStackTrace();

		}

	}
		
	

	private boolean addSchedule(ArrayList<ScheduleInfo> newSchedule) {
		String REQUEST_URL;
		try{
			for(ScheduleInfo e:newSchedule){
				String data = "("+e.getScheduleId()+",'"+e.getScheduleName()+"',"+e.getStartTime()+","+e.getEndTime()+",null,'UMKC')/"+e.getScheduleId();		
				/*http://localhost/aspnet_client/EPG7/Hackathon/WcfService2/dbService.svc/deleteSch
*/				REQUEST_URL = "http://kc-sce-cs551-2.kc.umkc.edu/aspnet_client/EPG7/Hackathon/WcfService2/dbService.svc/InsertSchedule/"+data;
				System.out.println(REQUEST_URL);
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
					}}
				//System.out.println(response.getEntity(String.class));



				catch (Exception execp) {

					execp.printStackTrace();

				}

			}
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
		// TODO Auto-generated method stub


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

	public List<ScheduleInfo> getSchedule() {
		// TODO Auto-generated method stub
		String REQUEST_URL = "http://kc-sce-cs551-2.kc.umkc.edu/aspnet_client/EPG7/Hackathon/WcfService2/dbService.svc/getScheduleData";
		
			List<ScheduleInfo> schedule = new ArrayList<ScheduleInfo>();
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
	                String scheduleName = o.getString("name");
	                int scheduleId=o.getInt("id");
	                int startTime=o.getInt("start");
	                int endTime=o.getInt("end");
	                
	                schedule.add(new ScheduleInfo(scheduleName,startTime,endTime,scheduleId));						//adding Tools info in to array list
	                
	            }
				System.out.println("Output from Server .... \n");
				/*System.out.println(password);*/
				return schedule;
			}
			catch (Exception e) {
		 	e.printStackTrace();
				return null;
			}
		}
	

}
