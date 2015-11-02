// JavaScript Document

$(document).ready(function() { 
	/*var returnData;
	var returnJson;
	alert("in sample.js");
	$.ajax({
		
		url:"http://kc-sce-cs551-2.kc.umkc.edu/aspnet_client/EPG7/Hackathon/WcfService2/dbService.svc/getScheduleData",
		async:false,
		dataType:'json',
		success: function(JSONdata){
			alert("in sample.js sucess");
		    returnData=JSONdata;
		    
		},
		error: function(ts){
			debugger;
			alert("in sample.js error");
			alert(ts.responseText);
		}
		
	});
	var arrayReturn = [], results=returndata
	for (var i=0,len=results.length;i<len;i++)
		{
		var result = results[i];
		alert(result.schId);
		}
*/	$("#viewTool").click(function(){
		$("#outerContainer div").css("display","none");
		$(".view").css("display","block");
	});
	$("#addTool").click(function(){
		$("#outerContainer div").css("display","none");
		$(".add").css("display","block");
	});
	$("#statusTool").click(function(){
		$("#outerContainer div").css("display","none");
		$(".status").css("display","block");
	});
	
	/*******pooja changes*/
	$("#outerContainer div").css("display","none");

  $("#viewElement").click(function(){
              
               $("#outerContainer div").css("display","none");
			    $(".elementview").css("display","block");
               
               
       });
	   
	   $("#addElement").click(function(){
              $("#outerContainer div").css("display","none");
               $(".elementadd").css("display","block");
               
       });
	   
	    $("#editElement").click(function(){
               $("#outerContainer div").css("display","none");
               $(".elementEdit").css("display","block");
               
       });
	
	
	$("#elementStatus").click(function(){
              $("#outerContainer div").css("display","none");
               $(".elemStatus").css("display","block");
               
       });
	   
	   /******************element end***********/
	   
	    $("#viewKPI").click(function(){
               
               $("#outerContainer div").css("display","none");
			   $(".KPIview").css("display","block");
               
               
       });
	   
	   $("#addKPI").click(function(){
              $("#outerContainer div").css("display","none");
               $(".KPIadd").css("display","block");
               
       });
	   
	    $("#editKPI").click(function(){
               $("#outerContainer div").css("display","none");
               $(".KPIEdit").css("display","block");
               
       });
	
	
	$("#KPIStatus").click(function(){
              $("#outerContainer div").css("display","none");
               $(".KPIStatus").css("display","block");
               
       });
	   
	   
	   
	    /*******pooja changes for scheduleManagement*/
	   
	   $("#outerContainer div").css("display","none");
	   
	   $("#viewSchedule").click(function(){
               
               $("#outerContainer div").css("display","none");
			   $(".scheduleview").css("display","block");
			   
		});
		
		$("#addSchedule").click(function(){
               $("#outerContainer div").css("display","none");
               $(".scheduleadd").css("display","block");
               
       });
	   
	    $("#editSchedule").click(function(){
               $("#outerContainer div").css("display","none");
               $(".scheduleEdit").css("display","block");
               
       });
	
	
	$("#scheduleStatus").click(function(){
               $("#outerContainer div").css("display","none");
               $(".scheduleStatus").css("display","block");
               
       });
	   /************history************/
	   $(".viewUpdateHis").click(function(){
		  
		   $("#outerContainerHis").css("display","block");
	   });
	   
	   $("#viewSchedule").click(function(){
		    $("#kpiDisplay").css("display","block");
		    
		    });  
});






