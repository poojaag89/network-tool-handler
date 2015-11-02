<%@page import="edu.umkc.ericsson.bo.ElementInfo"%>
<%@page import="edu.umkc.ericsson.bo.ToolsInfo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html> 
<html>

<head>
  <title>KPI Management Page</title>
  <meta name="description" content="website description" />
  <meta name="keywords" content="website keywords, website keywords" />
  <meta http-equiv="content-type" content="text/html; charset=windows-1252" />
  <link rel="stylesheet" type="text/css" href="css/style.css" />T
  <!-- modernizr enables HTML5 elements and feature detects -->
  <script type="text/javascript" src="js/modernizr-1.5.min.js"></script>
  
</head>

<body>
  <div id="main">
    <header>
	  <div id="banner">
	    <div id="welcome">
	      <h2>KPI Management</h2>
	    </div><!--close welcome-->			  	
	  </div><!--close banner-->	
	</header>
	
		<nav>      
      <div id="menubar">
        <ul id="nav">
          <li><a href="dashboard.html">Home</a></li>
          <li><a href="toolManagement.jsp">Tool Management</a></li>
          <li ><a href="elementManagement.jsp">Element Management</a></li>
          <li class="current"><a href="kpiManagement.html">KPI Management</a></li>
          <li><a href="scheduleManagement.html">Schedule Management</a></li>
          <li ><a href="historyManagement.html">History Management</a></li>
        </ul>
      </div>
    </nav>	
    
	<div id="site_content">		
<form action="KPI_Controller" name="kpi_manage" method="post">
    	<div class="selectOption">
        	<label>Select Tool:</label>
        	<select name="toolNameSelect" id="tools" onchange="document.kpi_manage.submit()">
            	

            	<%
        	ArrayList<ToolsInfo> toolsInfo =(ArrayList<ToolsInfo>)session.getAttribute("toolsInfo");
        	for(ToolsInfo e: toolsInfo)
        	{
        	%>
            	<option value=<%=e.getToolName()  %>  <%if (e.getToolName().equals(session.getAttribute("selectedToolName"))){ %>selected<%} %> ><%=e.getToolName()%></option>
            <%
        	}
            %>
            </select>
        </div><!-- selectOption close-->
        <div id="outerContainer">
        <div class="KPIview">
            
        	 <table id="currentTimeKpi" class="alignCenter">
      <thead>
            	<tr>
            	<th>KPI Id</th>
            	<th>KPI Name</th>
      	<th>Dark Green</th>
      	<th>Green</th>
      	<th>Red</th>
      	<th>Yellow</th>
      	
      	
      	</tr></thead>
      	 <tbody>
                <tr>
                  
                </tr></tbody>           	
      </table><!-- ElementTab-->
               
        </div><!-- elementview CLOSE-->
        
        
        <div class="KPIadd positonCenter">
           
            <table id="elementTable">
          		<tr>
                	<td>
          				KPIName:
                	</td>
               		<td> <input type="text" name="name" class="elementName"/>
                    </td>
                 </tr>
                 <tr>
                 <td>
				KPIId:
                </td>
                <td><input type="text" name="id" class="elementid"/></td>
                </tr>
                    <tr><td>Order:</td><td><input type="text" name="order" class="elementorder"/></td></tr>
                    <tr><td>DarkGreenValue:</td><td><input type="text" name="darkGreen" class="elementdarkgreen"/></td></tr>
                    <tr><td>GreenValue:</td><td><input type="text" name="green" class="elementgreen"/></td></tr>
                    <tr><td>YellowValue:</td><td><input type="text" name="yellow" class="elementyellow"/></td></tr>
                    <tr><td>OrangeValue:</td><td><input type="text" name="orange" class="elementorange"/></td></tr>
                    <tr><td>RedValue:</td><td><input type="text" name="red" class="elementred"/></td></tr>
                  </table>
                  
                       	<span class="button_small displayBlock">
		      <a>Go</a>
		    </span>
                </div><!--elementadd close-->
              <div class="KPIEdit">
              		<span class="selectOption displayBlock">
                        <label>Select KPI:</label>
                        <select>
                            <option selected>Select</option>
                            <option>ATLNGAUS-MME-01</option>
                            <option>ATLNGAUS-MME-02</option>
                            <option>ATLNGAUS-MME-03</option>
                            
                        </select>
        			</span><!-- selectOption close-->
                    
                    <table id="elementTableEdit" class="positonCenter">
          		<tr>
                	<td>
          				KPIName:
                	</td>
               		<td> <input type="text" name="name" class="elementName"/>
                    </td>
                 </tr>
                 
                 <tr><td>Order:</td><td><input type="text" name="order" class="elementorder"/></td></tr>
                    <tr><td>DarkGreenValue:</td><td><input type="text" name="darkGreen" class="elementdarkgreen"/></td></tr>
                    <tr><td>GreenValue:</td><td><input type="text" name="green" class="elementgreen"/></td></tr>
                    <tr><td>YellowValue:</td><td><input type="text" name="yellow" class="elementyellow"/></td></tr>
                    <tr><td>OrangeValue:</td><td><input type="text" name="orange" class="elementorange"/></td></tr>
                    <tr><td>RedValue:</td><td><input type="text" name="red" class="elementred"/></td></tr>
                  </table>
                  <span class="elementEditGo">
                       	<span class="button_small">
                              <a>Go</a>
                            </span>
                   </span><!-- elementEditGo close-->
              </div><!-- elementEdit-->
                <div class="KPIStatus"><!-- Tool status-->
                    <span id="stat">
                        <label>KPI Status:</label>
                        <select>
                        <option selected>Select</option>
                        <option>Enable</option>
                        <option>Disable</option>
                    </select>	
                    </span>
                    <span class="positionLeft" id="goBtn">
                   <span class="button_small" id="go">
                      <a href="#">GO</a>
              		</span></span>
        </div><!-- Toolssstatus close-->
        </div><!--outerContainer close-->
                
        <div class="toolButtons">
	  <span class="button_small" id="viewKPI">
		      <input value="View KPI" class="newBtn" onclick="getKPIdata();"/>
	  </span>
      <span class="button_small" id="addKPI">
		      <a href="#">AddKPI</a>
	  </span>
      
      <span class="button_small" id="editKPI">
		      <a href="#">EditKPI</a>
	  </span>
     
      <span class="button_small" id="KPIStatus">
		      <a href="#">KPIStatus</a>
	  </span>
      </div><!-- buttons close-->
      </form>
	</div><!--close site_content-->  	
  
    <footer>
         <a href="index.html">All Original Content (c) Copyright 2015 HackathonGeeks</a> | <a href="contact.html">Contact</a><br/><br/>
         
   </footer>
  
  </div><!--close main-->
  
  <!-- javascript at the bottom for fast page loading -->
  <script type="text/javascript" src="js/jquery.min.js"></script>
  <script type="text/javascript" src="js/sample.js"></script>
 <script type="text/javascript" src="js/modernizr-1.5.min.js"></script>
  <script type="text/javascript" src="js/sample3.js"></script>
  <script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.2.min.js"></script>
  <script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js"></script>
  
  
</body>
</html>

