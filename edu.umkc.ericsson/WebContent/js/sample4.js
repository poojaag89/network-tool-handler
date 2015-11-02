/**
 * 
 */

 $(document).ready(function () {	 
	  
	 var d1 = new Date();
	 var d2=d1.toUTCString();
	 document.getElementById("kpiTime").innerHTML=d2;
	 var returnedJson; 
	  var returnData;
	  var urlname="http://kc-sce-cs551-2.kc.umkc.edu/aspnet_client/EPG7/Hackathon/WcfService2/currentKPI.svc/getCurrentKPI";
	 
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
            
               arrayReturn.push([result.name,result.dg, result.g,result.r,result.y,result.toolname]);
           }
	 
   $('#currentTimeKpi').dataTable({

           "aaData": arrayReturn,
           "aoColumns": [
               { "sTitle": "KPI Name" },
               { "sTitle": "Dark Green" },
				{ "sTitle": "Green"},
				{ "sTitle": "Red"},
				{ "sTitle": "Yellow"},
				{ "sTitle": "Tool Name"}
               ]

           });
  });