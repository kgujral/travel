<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"> 
<%@taglib prefix="s" uri="/struts-tags" %>
<html>

<head>
	<title>Redirecting to Payment Gateway</title>
</head>
<body>
<center>
<div style="width: 100%; margin: 40px 0px 0px 20px">
	<h2>Redirecting to secure payment gateway...</h2>
</div>
<div><img src="images/loading.gif" /></div>
<div style="width: 100%; margin: 0px 0px 10px 20px">
	<div><h2>Powered by..</h2><a href="http://www.theqwerty.in" target="_blank"><img src="images/theQwerty.png" height="100" width="150" /></a></div>
</div>
</center>
<div>
	<form id="pay" action="https://www.ccavenue.com/shopzone/cc_details.jsp" method="post">
		<s:hidden name="Order_Id" />
		<s:hidden name="Amount" />
		<s:hidden name="Merchant_Id" />
		<s:hidden name="Checksum" />
		<s:hidden name="Redirect_Url" />
		<s:hidden name="billing_cust_name" />
		<s:hidden name="billing_cust_tel" />
		<s:hidden name="billing_cust_email"	/>
		
		<s:hidden name="billing_cust_address" value="" />
		<s:hidden name="billing_cust_country" value="" />
		<s:hidden name="billing_zip_code" value="" />
		<s:hidden name="billing_cust_state" value="" />
		<s:hidden name="billing_cust_city" value="" />
		<s:hidden name="billing_cust_notes" value="" />
		<s:hidden name="delivery_cust_name" value="" />
		<s:hidden name="delivery_cust_address" value="" />
		<s:hidden name="delivery_cust_tel" value="" />
		<s:hidden name="delivery_zip_code" value="" />
		<s:hidden name="delivery_cust_state" value="" />
		<s:hidden name="delivery_cust_city" value="" />
		<s:submit />
	</form>
</div>
<script>
	jQuery("#adverts1").hide();
	jQuery(document).ready(function() {
		jQuery("#pay").submit();		
	});
	
</script>

</body>
</html>
	