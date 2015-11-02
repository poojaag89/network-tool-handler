package edu.umkc.ericsson.bo;

public class ElementInfo {
private int elementId;
private String elementName;
private String displayName;
private String toolName;
private String timeZone;
private int active;
private String lastUpdateGMT;
private String upDatedBy;
private String status;
public int getElementId() {
	return elementId;
}
public void setElementId(int elementId) {
	this.elementId = elementId;
}
public String getElementName() {
	return elementName;
}
public void setElementName(String elementName) {
	this.elementName = elementName;
}
public String getDisplayName() {
	return displayName;
}
public void setDisplayName(String displayName) {
	this.displayName = displayName;
}
public String getToolName() {
	return toolName;
}
public void setToolName(String toolName) {
	this.toolName = toolName;
}
public String getTimeZone() {
	return timeZone;
}
public void setTimeZone(String timeZone) {
	this.timeZone = timeZone;
}
public int getActive() {
	return active;
}
public void setActive(int active) {
	this.active = active;
}
public String getLastUpdateGMT() {
	return lastUpdateGMT;
}
public void setLastUpdateGMT(String lastUpdateGMT) {
	this.lastUpdateGMT = lastUpdateGMT;
}
public String getUpDatedBy() {
	return upDatedBy;
}
public void setUpDatedBy(String upDatedBy) {
	this.upDatedBy = upDatedBy;
}
public ElementInfo(int elementId, String elementName, String displayName,
		String toolName, String timeZone, int active, String lastUpdateGMT,
		String upDatedBy) {
	super();
	this.elementId = elementId;
	this.elementName = elementName;
	this.displayName = displayName;
	this.toolName = toolName;
	this.timeZone = timeZone;
	this.active = active;
	this.lastUpdateGMT = lastUpdateGMT;
	this.upDatedBy = upDatedBy;
}
public ElementInfo(String elementname2, int elementId2, String elementStatus,String timeZone) {
	// TODO Auto-generated constructor stub
	this.elementName=elementname2;
	this.elementId=elementId2;
	this.status=elementStatus;
	this.timeZone=timeZone;
}


}
