 $(document).ready(function () {
		
	 
		 var returnedJson; 
		  var returnData;
	            $.ajax({
	                url: "http://kc-sce-cs551-2.kc.umkc.edu/aspnet_client/EPG7/Hackathon/WcfService2/dbService.svc/getHistoryData",
	                async: false,
	                dataType: 'json',
	                success: function (data) {
	                    returnData = data;
	                }
	            });

		 var arrayReturn = [], results = returnData;
	            for (var i = 0, len = results.length; i < len; i++) {
	                var result = results[i];
	                arrayReturn.push([ result.type, result.name, result.date, "UMKC"]);
	            }
		 
	    $('#ElementTab').dataTable({

	            "aaData": arrayReturn,
	            "aoColumns": [
	                { "sTitle": "Entity Type" },
	                { "sTitle": "Entity Name" },
					{ "sTitle": "Last Updated Time"},
					{ "sTitle" :"Last Updated By"}
	                ]

	            });
	 });
