<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ include file= "common-header.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Carrefour</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
body
{
	margin:0px;
	padding:0px; 
        background-image:url(images/cag.jpg);
	background-repeat:no-repeat;
	background-size:100% 1000px;
}
.extent
{
	width:350px;
	height:350px;
	text-align:center;
	background-color:rgba(0, 0, 153,0.7);
	border-radius:4px;
	margin:0 auto;
	margin-top:20px;
position:relative;
right:-290px;
bottom:280px;
}	
input[type="email"]
{       text-align: center;
	height:30px;
	width:240px;
        padding:2px;
        margin-top: 40px;
	
}
input[type="feedback"]
{       text-align: center;
	height:30px;
	width:240px;
        padding:2px;
        margin-top: 40px;
	
}
input[type="lname"]
{       text-align: center;
	height:30px;
	width:240px;
        padding:2px;
        margin-top: 40px;
	
}
input[type="fname"]
{       text-align: center;
	height:30px;
	width:240px;
        padding:2px;
        margin-top: 40px;
	
}
.btnd
{
	padding:15px;
background-color:red;
	border-radius:10px;
	border:none;
}
.but
{
position:relative;
top:80px;
}

</style>
</head>
<h1 align="center"> <font color="red">CONTACT US</h1></font>
<body>
<div class="but">

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button type="button" class="btn btn-danger">Track Record</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<button class="btn btn-danger dropdown-toggle" type="button" data-toggle="dropdown">Contact
    <span class="caret"></span></button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<button type="button" class="btn btn-danger">Media Release</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<button type="button" class="btn btn-danger">Locations</button><BR><br><br>
<font color="black"><H2>Customer Support</H2><BR>

Email:cs@EasyShop.com.<BR>

Support No:+914422260061<BR>

Our customer support is open Monday to Saturday: 9am to 7pm (excluding public holidays).<BR>

You can also Chat with us using link located at the bottom-right corner of the website.</font><p>
<div class="extent">

<form>
<div class="input">
<input type="fname" name="fname" placeholder="FirstName" /><br>
<input type="lname" name="lname" placeholder="LastName" /><br>
<input type="email" name="email" placeholder="Email" /><br>
<input type="feedback" name="Feedback" placeholder="Feedback" />
</div>
<br>
<button class="btnd">Submit</button>
</form>
</div>
</body>
</head>
</html>

