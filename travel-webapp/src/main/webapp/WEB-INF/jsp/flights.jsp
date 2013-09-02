<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Flights</title>
<link rel="stylesheet" href="css/table.css" type="text/css" />
</head>
<body>
	<div style="margin-left: 30px"><img src="images/fsearch.png"></img></div>
	<div id="textz"></div>
	<s:hidden name="on" id="jData1"/>
	<s:hidden name="ret" id="jData2"/>
	<div id="theTable">
		<table id="theQwertyGrid"></table>
	</div>
	<script type="text/javascript" src="js/theQwertyGrid.js"> </script>
	<script>
		function alertME(random) {
			alert(random);
		}
		jQuery(document).ready(function() {
			jQuery("#adverts1").hide();
			var data = JSON.parse(jQuery("#jData1").val());
			jQuery("#textz").html(data.length+" flights found");
			
			theQwerty.grid({
				data: data, 
				wrapperId: "theTable",
				cols: [{name: "flightName", PK: true}, {name: "departTime"}, {name: "arrivalTime"}, {name: "totalFare", sortable: false, type: "int"}],
				headerCols: ["Flight Number", "Departure", "Arrival", "Total Fare"],
				controls: [{headerCaption: "Book Flight", type: "button", func: "alertME", caption: "Book"}],
				paging: true,
				pageSize: [5,10,15],
				style: "width: 100%;"
			});
		});
		
	</script>
</body>

</html>