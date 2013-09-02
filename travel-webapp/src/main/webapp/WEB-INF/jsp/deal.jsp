<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"> 
<%@taglib prefix="s" uri="/struts-tags" %>

<html>

<head>
	<title><s:property value="deal.name"/> </title>
	<link rel="stylesheet" type="text/css" href="css/jquery.hrzAccordion.defaults.css" />
</head>


<body>
<s:hidden name="imageUrl" id="hiddenImageUrl" />

<!-- <div>
<img style="float: left; position:absolute; left: 0; top: 0;" src="images/seal.png" width="200px" height="150px" ></img>
</div> -->
<div id="holder" style="margin: 25px 10px">

<!-- Start of deals -->
<img id="dealImg" style="float: left" class="border" src="" width="300px" height="225px" ></img>
<h2 style="text-align: left; padding-top: 10px"> <s:property value="deal.name"/> </h2>
<h2 style="text-align: left;"><s:property value="deal.hotel.name"/> </h2>
<div style="float: left; text-align: left; overflow: hidden;">
<h4 style="color: green">Inclusions:</h4>
<ul>
	<s:iterator value="inclusionList">
		<li><s:property /></li>
	</s:iterator>
</ul>
<h3 style="color: green">Book now only for Rs. <s:property value="deal.dealPrice"/>/-</h3>
<s:form action="payment">
<s:hidden name="deal.id" />
<s:submit id="reset_button"  style="float: right;padding: 0px 10px; margin-right: 0px; text-transform: none;" value="Buy now!" />
</s:form>
</div>

<div style="clear:both;"></div>

<div style="margin-top: 10px">

<ul class="tabs">
    <li><a val="#tab1">Info</a></li>
    <li><a val="#tab2">Location</a></li>
    <li><a val="#tab3">Terms</a></li>
</ul>

<div class="tab_container">
    <div id="tab1" class="tab_content">
    	<h4>About <s:property value="deal.name"/></h4>
        <s:property value="deal.longDescription"/>
    </div>
    <div id="tab2" class="tab_content">
       <s:property value="deal.hotel.name"/>
       <s:property value="deal.hotel.address"/>
       <s:property value="deal.hotel.locality"/>
       <s:property value="deal.hotel.city"/>
       <s:property value="deal.hotel.state"/>
       <s:property value="deal.hotel.country"/>
    </div>
    <div id="tab3" class="tab_content">
    <h4>Terms & Conditions:</h4>
	<ul>
		<li>Booking is applicable on Twin Sharing Basis.</li>
		<li>The Price mentioned is on per person per night basis.</li>
		<li>Voucher is valid from 1st July 2011 to 31st August 2011.</li>
		<li>Once the voucher is sold it is non refundable & Non Changeable</li>
		<li>One voucher code will be applicable for only one person. Booking will be valid for a couple traveling together.</li>
		<li>Bookings are dependent on subject to availability with the hotel.</li>
		<li>1.03% Taxes Extra.</li>
	</ul>
    </div>
</div>

<div style="clear:both;"></div>

</div>
</div>

<!-- end of deals -->

<script>
	jQuery("#adverts1").hide();
	
	function rightDeals(heading, imgUrl, oldPrice, newPrice, readMoreUrl) {
		var div = jQuery("#rightDeals");
		div.append("<div class=\"yjnewsflash\"><a href=\""+readMoreUrl+"\"><img src=\""+imgUrl+"\" border=\"0\" height=\"47px\"	align=\"left\" title=\""+heading+"\" width=\"65px\" alt=\""+heading+"\" /></a><div class=\"yjnf_descr\"><a class=\"yjnewsflash_title\" href=\""+readMoreUrl+"\">"+heading+"</a><br /><p class=\"rprice\"><span class=\"old\">Original Price: Rs. "+oldPrice+"</span></p><p class=\"rprice\">You Pay: Rs. "+newPrice+"/-</p></div><span class=\"yjnsreadon\"><a class=\"yjns_rm\" href=\""+readMoreUrl+"\">more</a></span></div>");
	}
	
	
	jQuery(document).ready(function() {
		jQuery('#dialog').dialog({
			autoOpen: false,
			width: 600,
		});

		// Dialog Link
		jQuery('#dialog_link').click(function(){
			jQuery('#dialog').dialog('open');
			return false;
		});

		
		
		
		
		
		jQuery("#dealImg").attr("src",jQuery("#hiddenImageUrl").val())
		
		jQuery(".tab_content").hide(); //Hide all content
		jQuery("ul.tabs li:first").addClass("active").show(); //Activate first tab
		jQuery(".tab_content:first").show(); //Show first tab content

		//On Click Event
		jQuery("ul.tabs li a").click(function(event) {
			event.preventDefault();
			jQuery("ul.tabs li").removeClass("active"); //Remove any "active" class
			jQuery(this).parent().addClass("active"); //Add "active" class to selected tab
			jQuery(".tab_content").hide(); //Hide all tab content

			var activeTab = jQuery(this).attr("val"); //Find the href attribute value to identify the active tab + content
			jQuery(activeTab).fadeIn(); //Fade in the active ID content
			return false;
		});
	});
	/* sliderDeals("Taj Mahal, Agra", "images/deal/travel4.jpg", "Taj Mahal is imba", "TAJ MAHAL IS SUPER IMBA","#"); */
</script>

</body>

</html>
	