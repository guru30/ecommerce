<html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<style>
.navbar-default .navbar-text {
  color: #999 !important;
}
.navbar {
	margin-bottom: 0;
	border-radius: 0;
	width:1365px;
	background-color:yellow;
}
</style>
<body>
	<c:if test="${ch}">
		<c:set var="s" scope="application" value="0" />
	</c:if>

	<c:if test="${Ifadminlogged}">
		<c:set var="s" scope="application" value="1" />
	</c:if>

	<c:if test="${Defaultpage}">
		<c:set var="s" scope="application" value="0" />
	</c:if>

	<c:if test="${isLoggedInUser}">
		<c:set var="s" scope="application" value="2" />
</c:if>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index">Home</a>&nbsp;
				<a class="navbar-brand" href="aboutus">AboutUs</a>&nbsp;
				<a class="navbar-brand" href="contactus">Contactus</a>
        <a class="navbar-brand" data-toggle="dropdown" href="">Categories
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="listedItem.jsp">Mobiles and Tablets</a></li>
          <li><a href="listedItem.jsp">Laptops and Accesories</a></li>
          <li><a href="listedItem.jsp">Men's and Women's Wear </a></li>
<li><a href="listedItem.jsp">Bags and Lauggages</a></li>
<li><a href="listedItem.jsp">Mens and Womens Watches</a></li>
<li><a href="listedItem.jsp">Sports Accessories</a></li>
        </ul>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
				
			<c:if test="${s eq 1}">
			<li><a href="managepage"><span class="glyphicon glyphicon-log-in"></span>AdminManage</a></li>
</c:if>


				</ul>
				<ul class="nav navbar-nav navbar-right">
				
				
				<c:if test="${s eq 2}">
				
					<li><a href="myCart/${email}"><span class="glyphicon glyphicon-shopping-cart ">
					</span>MyCart(${numberOfProduct})</a></li>
				</c:if>
				
				<c:if test="${s eq 2}">
			<li><a style = "color:black">Welcome ${email}</a></li>
						<li style="display: inline-block"><a href="logout"><span
								class="glyphicon glyphicon-log-in"></span> LogOut</a></li>
				</c:if>
				
					<c:if test="${s eq 1}">
						<li>  <a style = "color:black"  >Welcome ${username}</a></li>
					</c:if>
					
					<c:if test="${s eq 1}">
					
						<li style="display: inline-block"><a href="logout"><span
								class="glyphicon glyphicon-log-in"></span> LogOut</a></li>
								
					</c:if>
					
					
					
					<c:if test="${s eq 0}">
					
					
						<li><a href="Loginpage"><span
								class="glyphicon glyphicon-log-in"></span> Login</a></li>
<li><a href="registeruser" ><span
							class="glyphicon glyphicon-share">Sign Up</a></span></li>
							
							
					</c:if>
					
				</ul>
			</div>
		</div>
	</nav>
	
</body>

</html>