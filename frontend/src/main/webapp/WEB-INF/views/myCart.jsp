

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
  <script>
function goBack() {
    window.history.back();
}
</script>
</head>
<h4 class=" text-danger ">List of available Categories</h4>
<body style="background-color: #ffff99">
<table class= " table table-bordered  table table-hover"  >
	<tr class= "SUCCESS" >
	    
	    <th align="left">Id</th>
	
	
		<th align="left">ProductName</th>
		
		<th align="left">Quantity</th>
		<th align="left">Price</th>
        <th align="left">Proceed</th>
		<th align="left">Delete</th>		
	</tr>
	<c:forEach items="${cartList}" var="cart" varStatus="status">
		<tr class= primary>
			<td>${status.count}</td>
			
			<td>${cart.productName}</td>
			<td>${cart.quantity}</td>
				<td>${cart.price}</td>
				
				
			<td><a href="proceed/${cart.productName}">Proceed</a></td> 
			<td><a href="deletecart/${cart.id}" onclick="return confirm('Are You Sure? Do you Want Delete Produt : ${cart.id} ?')">Delete</a></td>
		</tr>
	</c:forEach>
	<tr style="margin-top: 3em; ">
	<td colspan="3" align="right">Total Amount :</td>
	<td colspan="2">${total}</td>
	</tr>
</table>
<div class="row" style="margin-top:30px;">
<button class="btn btn-success col-xs-2" onclick="goBack()">Go Back</button>

<a href="Proceed/${username}"><button type="button" name="button" class="btn btn-success col-xs-offset-1 col-xs-2"> Place Order </button></a>

<div class="dropdown col-xs-1" style="margin-left: 8em;">
    <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Proceed<span class="caret"></span></button>
    <ul class="dropdown-menu"> 
      <li><a href="OnLinePayment/${email}">On Line Payment</a></li>
     
      <li class="divider"></li>
      <li><a href="cashOnDelivery/${email}">Cash On Delivery</a></li>
    </ul>
    </div>
  </div>
  </div>
  
  </body>
