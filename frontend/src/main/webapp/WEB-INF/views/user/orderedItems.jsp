<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="table-outer productMainDiv" ng-controller="orderedItemsCtrl">
<p style="font-size:35px;font-weight:bold;text-align:center;text-decoration:underline;">Products delivered</p>
<div class="btn-group-vertical">

								<a	onclick= window.history.back() 
									class="btn btn-lg btn-primary">
									<span></span> Back</a>
							</div><br><br>
	<c:choose>
		<c:when test="${not empty noProductsinHistory}">
			<h2 style="margin: auto; text-align: center;">${noProductsinHistory}</h2>
		</c:when>
		<c:otherwise>
			<table class="table table-hover table-reponsive table-cart">
				<thead>
						<tr class="table-primary">

						<th>Product Image</th>
						<th>Product Name</th>
						<th>Product Quantity</th>
						<th>Total Price</th>
						
					</tr>
				</thead>
				<tbody>

					<%-- 	<c:forEach items="${cartItems}" var="c"> --%>


					<tr ng-repeat="item in orderedItems|filter:searchProduct">
						
						<td><img src="${images}/product/{{item.productId}}.png"
							class="cart-Image img-thumbnail"></td>
						<td>{{item.productName}}</td>
						<td>{{item.quantity}}</td>
						<td><span class="fa fa-inr"></span> {{item.totalPrice}}</td>
						
							
						
					</tr>
					<%-- 	<%
							i++;
						%> --%>
					<%-- </c:forEach> --%>
				</tbody>
			</table>
			
		</c:otherwise>
	</c:choose>
</div>
</body>
</html>