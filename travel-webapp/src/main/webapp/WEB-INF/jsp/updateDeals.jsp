<%@taglib prefix="s" uri="/struts-tags" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin</title>

</head>
<body>
<div style="width: 100%; margin: 20px 20px">
	<h1>Admin Panel</h1>
	<i><u><a id="showHotel">Add Hotel Details / Deal Details</a></u></i>
	<!-- <i><u><a id="showDeal" >Add new Deal</a></u></i> -->
</div>
<div id="hotelForm">
<h2 style="margin: 0px 20px"><span>Add new Hotel Details</span></h2>
<s:form  action='saveHotel' method="post" enctype="multipart/form-data" style="height: auto;">
	<div class="yjformfields reservation cB" style="margin-top: 30px;float: left;width:32%; height: auto;">
		<div class="cBt">
			<div></div>
		</div>
		<fieldset class="destination_pack_legend" style="height: auto;">
			<legend class="destination_pack_legend"><span>Address Information</span></legend>
			<div class="move" style="margin-right: 10px"><label>Name :</label> <s:textfield class="input" name="hotel.name" label="Name"/></div>
			<div class="move" style="margin-right: 10px"><label>Building No. :</label><s:textfield class="input" name="hotel.address"/></div>
			<div class="move" style="margin-right: 10px"><label>Locality :</label> <s:textfield class="input" name="hotel.locality"/></div>
			<div class="move" style="margin-right: 10px"><label>City :</label><s:textfield class="input" name="hotel.city"/></div>
			<div class="move" style="margin-right: 10px"><label>State : </label><s:textfield class="input" name="hotel.state"/></div>
			<div class="move" style="margin-right: 10px"><label>Country : </label><s:textfield class="input" name="hotel.country"/></div>
			<div class="move" style="margin-right: 10px"><label>Country Code : </label><s:textfield class="input" name="hotel.countryCode"/></div>
			<div class="move" style="margin-right: 10px"><label>Zip :</label> <s:textfield class="input" name="hotel.zip"/></div>
		</fieldset>
		<div class="cBb">
			<div></div>
		</div>
	</div>
					
	<div class="yjformfields reservation cB" style="margin-top: 30px;float: left;width:25%; height: auto;">
		<div class="cBt">
			<div></div>
		</div>
		<fieldset class="destination_pack_legend" style="height: auto;">
			<legend><span>Contact Information</span></legend>
			<!-- Need to map differently -->
			<label>Phone Numbers : </label><s:textfield id="phn" class="input" name="hotelPhoneNumbers"/>
				<a id="addPhn" style="float: right; margin-right: 25px"  onclick="addMore('phn','addPhn')">Add more</a>
			
			<%--<s:textfield class="input" name="hotelPhoneNumbers"/> 
				<a style="float: right; margin-right: 35px" >Remove</a> --%>			
					
			<label>Fax Numbers : </label><s:textfield id="fax" class="input" name="hotelFaxNumbers"/>
				<a id="addFax" style="float: right; margin-right: 25px"  onclick="addMore('fax','addFax')">Add more</a>
			
			<label>Emails : </label><s:textfield id="email" class="input" name="hotelEmails"/>
				<a id="addEmail" style="float: right; margin-right: 25px"  onclick="addMore('email','addEmail')">Add more</a>
			
			<label>WebSites : </label><s:textfield id="website" class="input" name="hotelWebsites"/>
				<a id="addWebsite" style="float: right; margin-right: 25px"  onclick="addMore('website','addWebsite')">Add more</a>
			<!-- Need to map differently ends  -->
			
		</fieldset>
		<div class="cBb">
			<div></div>
		</div>
	</div>
	<div class="yjformfields reservation cB" style="margin-top: 30px;float: left;width:33%; height: auto;">
		<div class="cBt">
			<div></div>
		</div>
		<fieldset class="destination_pack_legend" style="height: auto;">
			<legend><span>Additional Information</span></legend>
			<label>Chain : </label><s:textfield class="input" name="hotel.chain"/>
			<label>Overview : </label><s:textfield class="input" name="hotel.overview"/>
			<label>Rating :</label> <s:textfield class="input" name="hotel.rating"/>
			<label>Upload Images : </label><s:file id="hotelImg" class="input"  name="hotelFileUpload"/>
				<a id="addHotelImg" style="float: right; margin-right: 25px"  onclick="addMore('hotelImg','addHotelImg')">Add more</a>
		</fieldset>
		<div class="cBb">
			<div></div>
		</div>
	</div>
	
	<div style="float: right; margin: 0px 0px 30px 30px">
		<s:submit id="reset_button" name="Submit" value="Save" style="margin-right: 10px"/>
		<s:reset id="reset_button" value="Reset" style="margin-right: 10px"/>
		<input id="reset_button" type="button" value="Cancel" style="margin-right: 10px"/>
	</div>
</s:form>
</div>
<div id="dealForm" style="display: none;">
<s:form action='saveDeal' method="post" enctype="multipart/form-data">
	<h2 style="margin: 0px 20px"><span>Add a new Deal</span></h2>
	<div class="yjformfields reservation cB" style="margin: 30px 10px;float: left;width:45%; height: auto;">
		<div class="cBt">
			<div></div>
		</div>
		<fieldset class="destination_pack_legend" style="height: auto;">
			<legend><span>Deal Information</span></legend>
			<div class="move" style="margin-right: 10px"><label>Name : </label><s:textfield class="input" name="deal.name"/></div>
			<div class="move" style="margin-right: 10px"><label>Choose Hotel : </label><s:select list="hotels" listKey="id" listValue="name" name="hotelId"></s:select></div>
			<div style="clear: both"></div>
			<div class="move" style="margin-right: 10px"><label>Original Price : </label><s:textfield class="input" name="deal.oldPrice"/></div>
			<div class="move" style="margin-right: 10px"><label>Deal Price : </label><s:textfield class="input" name="deal.dealPrice"/></div>
			<div style="clear: both"></div>
			<div class="move" style="margin-right: 10px"><label>Inclusions : </label><s:textarea class="input" name="deal.inclusions" /></div>
			<div class="move" style="margin-right: 10px"><label>Exclusions : </label><s:textarea class="input" name="deal.exclusions" /></div>
			<div style="clear: both"></div>
			<div class="move" style="margin-right: 10px"><label>Short Description : </label><s:textarea class="input"  name="deal.shortDescription" /></div>
			<div class="move" style="margin-right: 10px"><label>Long Description : </label><s:textarea class="input" name="deal.longDescription" /></div>
		</fieldset>
		<div class="cBb">
			<div></div>
		</div>
	</div>		
	<div class="yjformfields reservation cB" style="margin-top: 30px;float: left;width:35%; height: auto;">
		<div class="cBt">
			<div></div>
		</div>
		<fieldset class="destination_pack_legend" style="height: auto;">
			<legend><span>Additional Information</span></legend>
			<div style="float: left;margin-right: 10px"><label>Featured Deal?</label><s:select list="featured" name="featured" /></div>
			<div style="float: left;margin-right: 10px"><label>Slider Deal?</label><s:select list="featured" name="slider" /></div>			
			<div style="float: left;margin-right: 10px"><label>Deal Bought Count</label><s:textfield name="deal.dealAnalytics.boughtCount" /></div>
			<div style="float: left;margin-right: 10px"><label>Deal Category : </label><s:select size="5" value="" multiple="true" list="dealCategories" listKey="id" listValue="dealType" name="dealTypes"/></div>
			<div style="clear: both;"></div>
			<div style="float: left;">
			<label>Upload Images : </label><s:file id="dealImg" class="input" name="dealFileUpload"/>
							<a id="addDealImg" style="float: right; margin-right: 25px"  onclick="addMore('dealImg','addDealImg')">Add more</a>
			</div>
		</fieldset>
		<div class="cBb">
			<div></div>
		</div>
	</div>
	<div style="float: right; margin-right: 250px">
		<s:submit id="reset_button" name="Submit" value="Save" style="margin-right: 10px"/>
		<s:reset id="reset_button" value="Reset" style="margin-right: 10px"/>
		<input id="reset_button" type="button" value="Cancel" style="margin-right: 10px"/>
	</div>
	</s:form>
</div>
<script type="text/javascript">

	jQuery(document).ready(function() {
		jQuery("#adverts1").hide();
	});
	
	
	jQuery("#showHotel").click(function() {
		jQuery("#hotelForm").slideToggle();
		jQuery("#dealForm").slideToggle();
	});

	/* jQuery("#showDeal").click(function() {
		jQuery("#dealForm").slideToggle();
		jQuery("#hotelForm").slideUp();
	});
 */
	
	
	
	jQuery("#hotelDetails").click(function() {
		jQuery("#optional").toggle();
		jQuery("#optionalVal").val($("#optional").is(":hidden"));
		
	});
	
</script>
</body>
</html>