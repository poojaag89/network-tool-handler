<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="edu.umkc.ericsson.bo.ToolsInfo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html> 
<html>

<head>
  <title>Tool Management Page</title>
  <meta name="description" content="website description" />
  <meta name="keywords" content="website keywords, website keywords" />
  <meta http-equiv="content-type" content="text/html; charset=windows-1252" />
  <link rel="stylesheet" type="text/css" href="css/style.css" />
  <!-- modernizr enables HTML5 elements and feature detects -->
  <script type="text/javascript" src="js/modernizr-1.5.min.js"></script>
  
</head>

<body>
  <div id="main">
    <header>
	  <div id="banner">
	    <div id="welcome">
	      <h2>Tool Management</h2>
	    </div><!--close welcome-->			  	
	  </div><!--close banner-->	
	</header>
	
	<nav>      
      <div id="menubar">
        <ul id="nav">  
          <li><a href="dashboard.html">Home</a></li>
          <li class="current"><a href="#">Tool Management</a></li>
          
          <li ><a href="elementManagement.jsp">Element Management</a></li>
          <li><a href="kpiManagement.html">KPI Management</a></li>
          <li><a href="scheduleManagement.jsp">Schedule Management</a></li>
          <li ><a href="historyManagement.html">History Management</a></li>
        </ul>
      </div>
    </nav>	
    
	<div id="site_content">		

    	<div class="selectOption">
        	<label>Select Tool:</label>
        	<select>
        	<%
        	ArrayList<ToolsInfo> toolsInfo =(ArrayList<ToolsInfo>)session.getAttribute("toolsInfo");
        	for(ToolsInfo e: toolsInfo)
        	{
        	%>
            	<option value=<%=e.getToolName() %> ><%=e.getToolName()%></option>
            <%
        	}
            %>
                
                
            </select>
        </div><!-- selectOption close-->
        <div id="outerContainer">
        <div class="view">
            <p id="ToolId">
            	<span class="ToolIdDetails">
        			<label>ToolID:</label>
                    <label>1</label>
           		 </span>
            </p>
        	<table id="ElementTab" class="positionLeft">
            	<tr>
                	<th>ElementId</th>
                    <th>ElementName</th>
                </tr>
                <tr>
                	<td>1</td>
                    <td>ATLNGAUS-MME-01</td>
                </tr>
                <tr>
                	<td>2</td>
                    <td>ATLNGAUS-MME-02</td>
                </tr>
                <tr>
                	<td>3</td>
                    <td>ATLNGAUS-MME-03</td>
                </tr>
                <tr>
                	<td>4</td>
                    <td>KSCYMOEC-MME-01</td>
                </tr>
            </table><!-- ElementTab-->
            
            <table id="KPITab" class="positionLeft">
            	<tr>
                	<th>KPIId</th>
                    <th>KPIName</th>
                </tr>
                <tr>
                	<td>1</td>
                    <td>attach_lte</td>
                </tr>
                <tr>
                	<td>2</td>
                    <td>paging_lte</td>
                </tr>
                <tr>
                	<td>3</td>
                    <td>service_request_lte</td>
                </tr>
                <tr>
                	<td>4</td>
                    <td>Create_Sess_Succ</td>
                </tr>
            </table><!-- KPI Tab-->
             <table id="ScheduleTab" class="positionLeft">
            	<tr>
                	<th>ScheduleID</th>
                    <th>ScheduleName</th>
                </tr>
                <tr>
                	<td>1</td>
                    <td>Day</td>
                </tr>
                
               <tr>
                	<td>2</td>
                    <td>Night</td>
                </tr>
                <tr>
                	<td>3</td>
                    <td>Maintanace</td>
                </tr>
            </table><!--ScheduleTab-->
        </div><!-- view CLOSE-->
         <form action="AddToolInfo" method="post">
        <div class="add">
         
          <table>
          		<tr>
                	<td>Tool Name:</td>
                    <td><input type="text" name="toolName" id="addToolName"/></td>
                </tr>
                <tr>
                	<td>Tool ID:</td>
                    <td><input type="text" name="toolId" id="addToolID"/></td>
                </tr>
            
          </table>
          <span class="positionLeft" id="goBtn">
           <span class="button_small" id="go">
		      <input type="submit" class="newBtn" value="go"/>
	  </span>
      </span>
     
        </div><!-- add close-->
         </form>
        <div class="status">
        	<span id="stat">
        		<label>Tool Status:</label>
        		<select>
            	<option selected>Select</option>
                <option>Enable</option>
                <option>Disable</option>
            </select>	
            </span>
            <span class="positionLeft" id="goBtn">
           <span class="button_small " id="go">
		      <a href="#">GO</a>
	  </span>
        </div><!-- status close-->
        </div><!-- outerContainer close-->
        <div class="toolButtons">
	  <!-- <span class="button_small" id="viewTool">
		      <a href="#">ViewTool</a>
	  </span> -->
      <span class="button_small" id="addTool">
	<!-- TODO sathya -->   <a href="#" onclick="hideElement()">AddTool</a>
	  </span>
     
      <!-- <span class="button_small" id="statusTool">
		      <a href="#">ToolStatus</a>
	  </span> -->
      </div><!-- buttons close-->
    
	</div><!--close site_content-->  	
  
   <footer>
         <a href="index.html">All Original Content (c) Copyright 2015 HackathonGeeks</a> | <a href="contact.html">Contact</a><br/><br/>
         
   </footer> 
  
  </div><!--close main-->
  
  <!-- javascript at the bottom for fast page loading -->
  <script type="text/javascript" src="js/jquery.min.js"></script>
  <script type="text/javascript" src="js/sample.js"></script>
  
  
</body>
</html>
