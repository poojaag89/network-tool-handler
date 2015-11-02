package edu.umkc.ericsson.bo;

public class ToolsInfo {
private int toolId;
private String toolName;
private int status;

public ToolsInfo(int toolId, String toolName, int status) {
	super();
	this.toolId = toolId;
	this.toolName = toolName;
	this.status = status;
}
public int getToolId() {
	return toolId;
}
public void setToolId(int toolId) {
	this.toolId = toolId;
}
public String getToolName() {
	return toolName;
}
public void setToolName(String toolName) {
	this.toolName = toolName;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}
}
