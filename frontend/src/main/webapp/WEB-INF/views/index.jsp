<html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<head>
<title>CARREFOUR</title>
<style>
header
    {
	 background-color:#4682B4;
	 width:1348px;
	 height:160px;
	 border:solid blue;
	 margin:10px 80px 50px 50px;
	 padding:10px;s
	 color:white;
	 position:relative;
	 right:50px;
    }
.col-100 
    {
	 width:100%;
	 height:100px;
	 clear:both;
	 display:table;
	}
.col-80
    {
	 width:95%;
	 height:20px;
	 float:left;
	 clear:both;
	 margin:0px;
	}
.col-45
    {
	 width:25%;
	 height:80px;
	 float:right;
	 clear:both;
	 padding:2px;
     margin:0px;	
     text-align: right;	 
	}
	.img{
	 padding:0px;
	 margin:0px 0px 0px 10px;
	 }
input[type="text"]
    {    position:relative;
        left:130px;
	 width:750px;
          top:20px;
	 height:36px;
       border-radius:10px;
}
.navbar{

    width: 1265px;
    position:relative;
    left:-60px;
    margin-top: -50px;
    margin-left: 60px;
    margin-right: 300px;
background-color:yellow;
}
p
{
font-color:red;
font-size:120%;
font-type:italic;
    }
.sin
{
width:40px;  
height:21px;
 align:center;
position:relative;
top:-67px;
left:995px;
}
</head>
</style>
<body>
<header>
<div class="col-100">
<div class="col-80">
<img src=<c:url value="/images/timthumb.jpg" /> width="200" height="140">
<label><input type="text" value=""></label>
<div class="sin">
<button type="button" class="btn btn-info">
      <span class="glyphicon glyphicon-search"></span> Search
    </button>
</div>
</div>
<div class="col-45">
<label><img src=<c:url value="/images/facebook.png" /> class="img" width="20%" height="45px"></label><br><br>
<label><img src=<c:url value="/images/TWITTER.png" />  width="20%" height="45px"></label>
</div>
</div>
</header>
<style>
    /* Remove the navbar's default margin-bottom and rounded borders */
    .navbar {
        right:10px;
      margin-bottom: 0;
      border-radius: 0;
    }
    
    /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
    .row.content {height: 450px}
    
    /* Set gray background color and 100% height */
    .sidenav {
      padding-top: 20px;
      height: 100%;
      
    }
    
    /* Set black background color, white text and some padding */
    footer {
      background-color:yellow;
      color: white;
      padding: 15px;
      width:1348px;
    }
    
    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height:auto;}

  </style>
</head>
<body>
<%@include file="/WEB-INF/views/common-header1.jsp" %>
<div class="container-fluid text-center">
  <div class="row content">
    <div class="col-sm-2 sidenav">
<br>
<br>
<br>
<br>
      <p><a href="#">Track order</a></p>
      <p><a href="#">24x7 Customer Care</a></p>
      <p><a href="#">Offer Zone</a></p>
<br>
<div class="psp">
<img src=<c:url value="/images/sha.jpg" /> width="200" height="230">
      </div>
</div>
    <div class="col-sm-8 text-left">
<body style=background-color="Lavender">
      <center><h1>Welcome To Shopping Cart</h1></center>
      <hr>
<div id="myCarousel" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
  
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner" role="listbox">
    <div class="item active">
      <img src=<c:url value="/images/sh6.jpg" /> alt="Chania" width="1000" height="20">
      <div class="carousel-caption">
       
      </div>
    </div>

    <div class="item">
      <img src=<c:url value="/images/shopping.jpg" /> alt="Chania" width="1000" height="600">
      <div class="carousel-caption">
      </div>
    </div>

    <div class="item">
      <center><img src=<c:url value="/images/shu.jpg" /> alt="Flower"width="1000" height="500"></center>
      <div class="carousel-caption">
       
      </div>
    </div>

</div>

  
  <!-- Left and right controls -->
  <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
       
  
 </div>
<center><h4>Variety Collection</h4></center>
</div>
    <div class="col-lg-2 sidenav">
      <div class="well">
        <p>Insane Offers</p>
</div>
<div class="cost">
<img src=<c:url value="/images/mobile.jpg" /> width="200" height="230">
<br>
<img src=<c:url value="/images/tv1.jpg" /> width="200" height="230">
      </div>
</div>
    </div>
  </div>
  <div class="row">
  <%@include file="/WEB-INF/views/Productitems.jsp" %>
  </div>
<footer><div class="container-fluid text-center">
  <h4>Policies:Terms Of Use|Security|Return|Infringement&nbsp;&nbsp;<span class="glyphicon glyphicon-copyright-mark"></span>&nbsp;2016-2025 CARREFOUR.COM</h4>
</div>
</footer>
</body>
	</html>