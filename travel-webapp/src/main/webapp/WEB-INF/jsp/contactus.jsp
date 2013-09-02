<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"> 
<%@taglib prefix="s" uri="/struts-tags" %>

<html>

<head>
	<title>Contact Us</title>
</head>
<body>
<div style="width: 100%; margin: 20px 20px">
	<h1>Contact Us</h1>
</div>
<div id="ContactUsForm">
<s:form  action='contactus' method="post" style="height: auto;" name="myForm">
	<div class="yjformfields reservation cB" style="margin: 30px 0px 50px 30px;float: left;width:50%; height: auto;">
		<div class="cBt">
			<div></div>
		</div>
		
		<fieldset class="destination_pack_legend" style="height: auto; width: 400px">
			<legend class="destination_pack_legend"><span>Contact Details</span></legend>
			<s:label name="msg" cssStyle="color: green"/>
			<div><span style="color: #E36300; font-weight: bold; margin-right: 20px">Full Name :</span> <s:textfield class="input" name="contactUsForm.name"/></div>
			<div><span style="color: #E36300; font-weight: bold; margin-right: 39px">Subject :</span><s:textfield class="input" name="contactUsForm.subject"/></div>
			<div><span style="color: #E36300; font-weight: bold; margin-right: 52px">Email :</span><s:textfield class="input" name="contactUsForm.email"/></div>
			<div><label style="display: inline;vertical-align: top;color: #E36300; font-weight: bold; margin-right: 28px">Comment :</label><s:textarea class="input" name="contactUsForm.comment"/></div>
			<div style="clear: both"></div>
			<div style="float: right; margin-bottom: 0px">
				<s:submit id="reset_button" name="Submit" value="Submit" style="margin-right: 10px"/>
				<s:reset id="reset_button" value="Reset" style="margin-right: 10px"/>
			</div>
		</fieldset>
		<div class="cBb">
			<div></div>
		</div>
	</div>
</s:form>
</div>
<div style="float: right;margin:40px 100px 0 0" >
	<h2>You can reach us at :-</h2>
	<br />
	<h3><span style="padding-bottom: 100px">Address :</span>
	<span style="color: green">&nbsp;&nbsp;&nbsp;C-3/55, IIIrd Floor, Janak Puri<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;New Delhi-110058</span></h3>
	<br/>	
	<h3>Phone no:<span style="color: green">&nbsp;&nbsp;&nbsp;+91 - 8860558695</span></h3>
	<br/>
	<h3>E-mail :<span style="color: green;">
	&nbsp;&nbsp;&nbsp;admin@tripexotica.com
	<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ravikumar@tripexotica.com
	<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;flights@tripexotica.com
	<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;b2b@tripexotica.com
	</span></h3>
</div>

<script>
	jQuery(document).ready(function() {
		jQuery("#adverts1").hide();
	});
	
	  var frmvalidator  = new Validator("myForm");

	  frmvalidator.addValidation("contactUsForm.name","req","Please enter your Name");
	  frmvalidator.addValidation("contactUsForm.name","alpha","Name can contain alphabetic chars only");
	  frmvalidator.addValidation("contactUsForm.email","req", "Please enter your E-Mail");
	  frmvalidator.addValidation("contactUsForm.email","email", "Enter a valid e-mail address");
	  frmvalidator.addValidation("contactUsForm.comment","req","Please enter the comment");	  
</script>
</body>
</html>
	