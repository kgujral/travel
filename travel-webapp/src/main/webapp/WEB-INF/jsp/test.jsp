<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Test page</h1>
	<form action="https://www.ccavenue.com/shopzone/cc_details.jsp">
		<input type="hidden" name="Order_Id" value="123412" />
		<input type="hidden" name="Amount" value="5" />
		<input type="hidden" name="Merchant_Id" value="121212" />
		<input type="submit" />
	</form>	
</body>
</html>