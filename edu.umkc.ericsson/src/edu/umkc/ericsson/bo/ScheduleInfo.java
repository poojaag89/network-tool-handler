package edu.umkc.ericsson.bo;

public class ScheduleInfo {
	public ScheduleInfo(String scheduleName, int startTime, int endTime,
			int scheduleId) {
		super();
		this.scheduleName = scheduleName;
		this.startTime = startTime;
		this.endTime = endTime;
		this.scheduleId = scheduleId;
	}
	private String scheduleName;
	private int startTime;
	private int endTime;
	private int scheduleId;
	public int getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}
	public ScheduleInfo(int startTime, int endTime) {
		// TODO Auto-generated constructor stub
		this.startTime=startTime;
				this.endTime=endTime;
	
	}
	public ScheduleInfo() {
		// TODO Auto-generated constructor stub
	}
	
	public String getScheduleName() {
		return scheduleName;
	}
	public void setScheduleName(String scheduleName) {
		this.scheduleName = scheduleName;
	}
	public int getStartTime() {
		return startTime;
	}
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}
	public int getEndTime() {
		return endTime;
	}
	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}
	
}
