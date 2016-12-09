<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <!DOCTYPE html>
 <%@include file="/WEB-INF/views/common-header.jsp" %>
 <%@taglib uri = "http://www.springframework.org/tags/form" prefix="form" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<html lang="en">
<head>
<title>Login Page</title>
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
	background-size:100% 700px;
}




</style>
</head>
<body>
 <c:if test="${login}">
		<c:set var="s" scope="application" value="9" />
	</c:if>
	
	<c:if test="${logout}">
		<c:set var="s" scope="application" value="10" />
	</c:if>
	
	<div>
	<c:if test="${s eq 9}">
<div class="alert alert-danger  col-xs-3 col-xs-offset-3">
  <strong>${error}</strong> 
</div>
 </c:if></div>
 
 <div>
	<c:if test="${s eq 10}">
<div class="alert alert-success  col-xs-3 col-xs-offset-3">
  <strong>${errormessage1}</strong> 
</div>
 </c:if></div>
 
 
 <div class="container col-md-7 col-md-offset-4" style="margin-top:100px;">
  <h2>Login Here</h2>
	
  <form:form action="login" method="post" class="form-horizontal">
    <div class="form-group">
      <label class="control-label col-sm-2" for="email">Email:</label>
      <div class="col-sm-3">
        <input type="text" class="form-control" id="email" required="true" name="email" placeholder="Enter email">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="pwd">Password:</label>
      <div class="col-sm-3">
        <input type="password" class="form-control" id="password" name="password" required="true" placeholder="Enter password">
      </div>
    </div>
    <div class="form-group">
      <div class="col-sm-offset-2 col-sm-10">
        <div class="checkbox">
          <label><input type="checkbox"> Remember me</label>
        </div>
      </div>
    </div>
 
		
				
    
    <div class="form-group ">
      <div class="col-sm-offset-2 col-sm-5">
        <button type="submit" class="btn btn-success">Submit</button>
        <a href="index" class="btn btn-danger">Cancel</button></a>
        <input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
      </div>
    </div>
    
  
  </form:form>
  
</div>
</body>

</html>

