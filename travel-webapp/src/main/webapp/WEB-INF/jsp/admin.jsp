<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"> 
<%@taglib prefix="s" uri="/struts-tags" %>
<html>

<head>
	<title>Login</title>
</head>
<body>
<div style="width: 100%; margin: 20px 20px">
	<h1>Login</h1>
</div>
<div id="LoginForm">
<s:form  action='login' method="post" style="height: auto;">
	<div class="yjformfields reservation cB" style="margin: 30px 0px 50px 30px;float: left;width:50%; height: auto;">
		<div class="cBt">
			<div></div>
		</div>
		
		<fieldset class="destination_pack_legend" style="height: auto; width: 400px">
			<legend class="destination_pack_legend"><span>Login details</span></legend>
			<s:label name="msg" cssStyle="color: green"/>
			<label>User Id :</label> <s:textfield class="input" name="user.name"/>
			<label>Password :</label><s:password class="input" name="user.password"/>
			<div style="float: right; margin: 0px 30px 30px 0px">
				<s:submit id="reset_button" name="Login" value="Login" style="margin-right: 10px"/>
				<s:reset id="reset_button" value="Reset" style="margin-right: 30px"/>
			</div>
		</fieldset>
		<div class="cBb">
			<div></div>
		</div>
	</div>
</s:form>
</div>


<script>
	jQuery(document).ready(function() {
		jQuery("#adverts1").hide();
	});
</script>

</body>

</html>
	