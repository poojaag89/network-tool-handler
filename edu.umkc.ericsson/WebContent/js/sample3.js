function getElementdata()
{
	
	var e = document.getElementById("tools");
	
	var strUser = e.options[e.selectedIndex].value;
	
$(document).ready(function () {	 
		 var returnedJson; 
		  var returnData;
		  var urlname="http://kc-sce-cs551-2.kc.umkc.edu/aspnet_client/EPG7/Hackathon/WcfService2/dbElement.svc/getElementsData/"+strUser;
		  alert(urlname);
	            $.ajax({
	     
	                url: urlname,
	                async: false,
	                dataType: 'json',
	                success: function (data) {
	                    returnData = data;
	                }
	            });

		 var arrayReturn = [], results = returnData;
	            for (var i = 0, len = results.length; i < len; i++) {
	            	
	                var result = results[i];
	               
	                arrayReturn.push([result.elementId,result.displayname, result.timezone]);
	            }
		 
	    $('#ElementTab').dataTable({

	            "aaData": arrayReturn,
	            "aoColumns": [
	                { "sTitle": "ElementId" },
	                { "sTitle": "ElementName" },
					{ "sTitle": "TimeZone"}
					
	                ]

	            });
	 });
}
function editData()
{
	var e = document.getElementById("editelement");
	var e1= document.getElementById("elename").value;
	var e2= document.getElementById("timezone").value;
	
	var ele = e.options[e.selectedIndex].value;
	alert(ele);
	alert(e1);
	alert(e2);
	 var returnedJson; 
	  var returnData;
	  var urlname="http://kc-sce-cs551-2.kc.umkc.edu/aspnet_client/EPG7/Hackathon/WcfService2/dbElement.svc/editElements/"+e1+"/"+e2+"/"+ele;
	  alert(urlname);
           $.ajax({
    
               url: urlname,
               async: false,
               dataType: 'json',
               success: function (data) {
                   returnData = data;
               }
           });
	
}

function getKPIdata()
{
var e = document.getElementById("tools");
	
	var strUser = e.options[e.selectedIndex].value;
	
$(document).ready(function () {	 
		 var returnedJson; 
		  var returnData;
		  var urlname="http://kc-sce-cs551-2.kc.umkc.edu/aspnet_client/EPG7/Hackathon/WcfService2/currentKPI.svc/getKPIs/"+strUser;
		  alert(urlname);
		  alert('hai');
	            $.ajax({
	     
	                url: urlname,
	                async: false,
	                dataType: 'json',
	                success: function (data) {
	                 returnData = data;
	                }
	            });

		 var arrayReturn = [], results = returnData;
	            for (var i = 0, len = results.length; i < len; i++) {
	                var result = results[i];
	               alert(result.id);
	                arrayReturn.push([result.id,result.name,result.dg, result.g,result.r,result.y]);
	            }
		 
	    $('#currentTimeKpi').dataTable({

	            "aaData": arrayReturn,
	            "aoColumns": [
	                          { "sTitle": "KPI Id" },
	                          { "sTitle": "KPI Name" },
	                          { "sTitle": "Dark Green" },
	           				{ "sTitle": "Green"},
	           				{ "sTitle": "Red"},
	           				{ "sTitle": "Yellow"}
	           				
	                          ]

	            });
	 });

}



