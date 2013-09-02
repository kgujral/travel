<%@taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment</title>
</head>
<body>
<div style="margin-left: 30px"><img src="images/payment.png"></img></div>

<% if(session.getAttribute("user") == null) { %>
<div>
	<h3><a id="reset_button" href="secure.html" style="margin: 0px 0px 0px 30px;padding-top:8px ;">Login</a> or enter information below!</h3>
</div>
<%} %>
<div id="hotelForm" style="clear:both" >
<s:form  action='checkout' method="post" style="height: auto; margin-left: 10px">
	<div class="yjformfields reservation cB" style="margin-top: 30px;float: left;width:32%; height: auto;">
		<div class="cBt">
			<div></div>
		</div>
		<fieldset class="destination_pack_legend" style="height: auto;">
			<legend class="destination_pack_legend"><span>Information</span></legend>
			<div><span style="color: #E36300; font-weight: bold; margin-right: 40px">First Name :</span><s:textfield class="input" name="user.firstName" label="Name"/></div>
			<div style="clear: both"></div>
			<div><span style="color: #E36300; font-weight: bold; margin-right: 42px">Last Name :</span><s:textfield class="input" name="user.lastName"/></div>
			<div style="clear: both"></div>
			<div><span style="color: #E36300; font-weight: bold; margin-right: 73px">Email :</span><s:textfield class="input" name="user.email"/></div>
			<div style="clear: both"></div>
			<div><span style="color: #E36300; font-weight: bold; margin-right: 48px">Phone No :</span><s:textfield class="input" name="user.phoneNumber"/></div>
			<input type="hidden" name="user.name" />
		</fieldset>
		<div class="cBb">
			<div></div>
		</div>
	</div>
				
	<div class="yjformfields reservation cB" style="margin-top: 30px;float: left;width:52%; height: auto;">
		<div class="cBt">
			<div></div>
		</div>
		<fieldset class="destination_pack_legend" style="height: auto;">
			<legend class="destination_pack_legend"><span>Information</span></legend>
			<div><span style="color: #E36300; font-weight: bold; margin-right: 40px">Quantity :</span>
				<select id="qty" style="padding-left: 5px" onchange="change()" name="quantity">
				<option>1</option>
				<option>2</option>
				<option>3</option>
				<option>4</option>
				<option>5</option>
				</select>
			</div>
			<div style="clear: both"></div>
			<div><span style="color: #E36300; font-weight: bold; margin-right: 16px">Coupon Code :</span><s:textfield class="input"  />
			<input type="button" value="Apply" onclick="alert('Invalid Coupon Code')" />
			</div>
			<div style="clear: both"></div>
			<div><h2 style="color: green">Price:  Rs.<label style="display: inline; color: green" id="priceQty"></label></h2></div>
			<s:hidden id="dealPrice" name="deal.dealPrice" />
		</fieldset>
		<div class="cBb">
			<div></div>
		</div>
	</div>
	
	<div style="float: right; margin: 0px 85px 0px 30px">
		<s:submit style="margin-right: 10px; text-transform: none;" id="submit_button" value=" Proceed To Payment" />
	</div>
</s:form>
</div>
<div style="clear:both;"></div>


<s:hidden name="imageUrl" id="hiddenImageUrl" />
<!-- <div>
<img style="float: left; position:absolute; left: 0; top: 0;" src="images/seal.png" width="200px" height="150px" ></img>
</div> -->
<div id="holder" style="margin: 0px 10px 25px 10px">

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

</div>


</div>

<script type="text/javascript">
	
	jQuery(document).ready(function() {
		jQuery("#adverts1").hide();
		jQuery("#dealImg").attr("src",jQuery("#hiddenImageUrl").val());
		jQuery("#priceQty").html(jQuery("#dealPrice").val());
	});
	
	function change() {
		var totalPrice = jQuery("#qty").val() * jQuery("#dealPrice").val();
		jQuery("#priceQty").html(totalPrice+"/-");
		Cufon.replace("#priceQty");
	}
</script>
</body>
</html>