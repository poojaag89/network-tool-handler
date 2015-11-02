<!DOCTYPE html> 
<%@page import="edu.umkc.ericsson.bo.ScheduleInfo"%>
<%@page import="java.util.List"%>
<html>

<head>
  <title>Schedule Management Page</title>
  <meta name="description" content="website description" />
  <meta name="keywords" content="website keywords, website keywords" />
  <meta http-equiv="content-type" content="text/html; charset=windows-1252" />
  <link rel="stylesheet" type="text/css" href="css/style.css" />T
  <!-- modernizr enables HTML5 elements and feature detects -->
  <script type="text/javascript" src="js/modernizr-1.5.min.js"></script>
  
  <style>
  .scheduleview,#ScheduleTab{display:block !important;}
  #ScheduleTab{width: 602px !important;}
  #go{float: left;
    margin: 0 auto;
    text-align: center;
    width: 90px;}
    #scheduleSubmit{color: #fff;
    height: 29px;
    width: 70px;margin-left: 20px;}
    .marginTop20{margin-top:20px !important;}
    .marginLefta{ margin-left:385px !important;} 
  </style>

  
</head>


<body>
  <div id="main">
    <header>
	  <div id="banner">
	    <div id="welcome">
	      <h2>Schedule Management</h2>
	    </div><!--close welcome-->			  	
	  </div><!--close banner-->	
	</header>
	
	<nav>      
      <div id="menubar">
        <ul id="nav">
          <li><a href="dashboard.html">Home</a></li>
          <li><a href="toolManagement.html">Tool Management</a></li>
          <li><a href="elementManagement.html">Element Management</a></li>
          <li><a href="kpiManagement.html">KPI Management</a></li>
          <li class="current"><a href="#">Schedule Management</a></li>
          <li><a href="historyManagement.html">History Management</a></li> 
        </ul>
      </div>
    </nav>	
    
	<div id="site_content">		

    	
        <div id="outerContainer"><!--outerContainer-->
                <%if(session.getAttribute("Message")==null)
        	{%>
        	<p>No Message</p>
        <% }
        else{%>
        
        <%=session.getAttribute("Message")%><%} %>
        <div class="scheduleview">
          <form action="UpdateSchedule">  
        	<table id="ScheduleTab" class="ScheduleTab">
            	<tr>
                	<th>ScheduleId</th>
                    <th>ScheduleName</th>
                    <th>StartHour</th>
                     <th>EndHour</th>
                    
                </tr>
              
                
            </table><!-- ElementTab-->
               <span class="button_small marginTop20 marginLefta" id="go"> <a href="#" class="add-schedule">AddSchedule</a></span>
      			<input id="scheduleSubmit" type="submit" value="Submit" class="button_small" onclick="clearMessage()">
      			</form>
        </div><!-- elementview CLOSE-->
        

       
        
        <div class="scheduleadd">
           
            <table id="scheduleTable">
          		<tr>
                	<td>
          				ScheduleName:
                	</td>
               		<td> <input type="text" name="name" class="scheduleName" val=""/>
                    </td>
                 </tr>
                 <tr>
                 <td>
				ScheduleId:
                </td>
                <td><input type="text" name="id" class="scheduleid" val=""/></td>
                </tr>
                <tr>
                 <td>
				StartHour:
                </td>
                <td><input type="text" name="time" class="starthour" val=""/></td>
                </tr>
                <tr>
                 <td>
				EndHour:
                </td>
                <td><input type="text" name="time" class="endhour" val=""/></td>
                </tr>
                  </table>
                  
                       	<span class="button_small displayBlock">
		      <a>Go</a>
		    </span>
                </div><!--elementadd close-->
              <div class="scheduleEdit">
              		
                    <table id="scheduleTableEdit" class="positonCenter">
          		<tr>
                	<td>
          				ScheduleName:
                	</td>
               		<td> <input type="text" name="name" class="scheduleName" val=""/>
                    </td>
                 </tr>
                 
                 <td>
				StartHour:
                </td>
                <td><input type="text" name="time" class="starthour" val=""/></td>
                </tr>
                
                 <td>
				EndHour:
                </td>
                <td><input type="text" name="time" class="endthour" val=""/></td>
                </tr>
                  </table>
                  <span class="scheduleEditGo">
                       	<span class="button_small displayBlock">
                              <a>Go</a>
                            </span>
                   </span><!-- elementEditGo close-->
              </div><!-- elementEdit-->
                <div class="scheduleStatus"><!-- Tool status-->
                    <span id="stat">
                        <label>Schedule Status:</label>
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
       </div><!--outerContainer-->         
        <div class="toolButtons">
	  
      </div><!-- buttons close-->
	</div><!--close site_content-->  	
  
    <footer>
         <a href="index.html">All Original Content (c) Copyright 2015 HackathonGeeks</a> | <a href="contact.html">Contact</a><br/><br/>
         
   </footer>
  
  </div><!--close main-->
  
  <!-- javascript at the bottom for fast page loading -->
  <script type="text/javascript" src="js/jquery.min.js"></script>
  <script type="text/javascript" src="js/sample.js"></script>
  <script type="text/javascript">function clearMessage() {
	validateSchedule();
	<%
	session.removeAttribute("Message");
	%>
	}
  	function validateSchedule(e){
  		var scheduleLength;
  		var table = document.getElementById('ScheduleTab'), 
  	    rows = table.getElementsByTagName('tr'),
  	    i, j, cells, customerId;

  	for (i = 0, j = rows.length; i < j; ++i) {
  	    cells = rows[i].getElementsByTagName('td');
  	    if (!cells.length) {
  	        continue;
  	    }
  	    scheduleId = cells[0].getElementsByTagName("input")[0].value;
  	    scheduleName = cells[1].getElementsByTagName("input")[0].value;
  	    startHour = cells[2].getElementsByTagName("input")[0].value;
  	    endHour = cells[3].getElementsByTagName("input")[0].value;
  	    Length=endHour-startHour;
  	    if(Length<0){
  	    	starthour=24-startHour;
  	    	Length=starthour+endHour;
  	    }
  	    scheduleLength=length+scheduleLength;
  	    //id=scheduleId.getElementsByTagName("input");
  	    
  	}
  	if(scheduleLength==24){
  		return true;
  	}
  	else
  		{
  		e.preventDefault();
  		return false;
  		}
  	}
  </script>
<script>

$(document).ready(function(){
	
    var counter = 0;
    <% List<ScheduleInfo> displayschedule = (List<ScheduleInfo>)session.getAttribute("schedule"); 
    	for(ScheduleInfo e:displayschedule){
		System.out.println(e.getStartTime()+" "+e.getScheduleName());
		String name=e.getScheduleName();
    %>
    counter++;
    newRow = jQuery('<tr><td><input type="text" value="'+<%=e.getScheduleId()%>+'" name="scheduleid' +
            counter + '"/></td><td><input type="text" value="<%=e.getScheduleName()%>" name="schedulename' +
            counter + '"/></td><td><input type="text" value="'+<%=e.getStartTime()%>+'" name="starthour' +
            counter + '"/><td><input type="text" value="'+<%=e.getEndTime()%>+'" name="endhour' +
            counter + '"/></tr>');
    jQuery('table.ScheduleTab').append(newRow);
    <%
    
    	}%>
    /* newRow = jQuery('<tr><td><input type="text" value="2" name="scheduleid' +
            counter + '"/></td><td><input type="text" value="Night" name="schedulename' +
            counter + '"/></td><td><input type="text" value="0" name="starthour' +
            counter + '"/><td><input type="text" value="3" name="endhour' +
            counter + '"/></tr>');
    jQuery('table.ScheduleTab').append(newRow); */
    jQuery('a.add-schedule').click(function(event){
    	
        event.preventDefault();
        counter++;
        var newRow = jQuery('<tr><td><input type="text" value="" name="scheduleid'  +
            counter + '"/></td><td><input type="text" value="" name="schedulename' +
            counter + '"/></td><td><input type="text" value="" name="starthour' +
            counter + '"/><td><input type="text" value="" name="endhour' +
            counter + '"/></tr>');
        jQuery('table.ScheduleTab').append(newRow);
        
    });
    $("#scheduleSubmit").click(function() {
    	//alert("click");
    	var empty=false;
    	$("#ScheduleTab input").each(function(){
    		
    		if($(this).val()=='')
    			{
    			empty=true;
    			
    			}
    		
    	});     
        if(empty)
        	{
        	//alert("error");
        	return false;
        	
        	}else
        		{
        		alert("submit");
        		var i=1;
        		
        		return true;
        		
        		}
        
        
        
    });
});
</script>
  
</body>
</html>