<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  

<h2 align="center" style="margin-top: 0em; margin-bottom: -2em;">${product.product_Name}</h2>


<div style="margin: 0px 10px 0px 300px">

<form:form>
<table>
<tr>
<td>
<img src="<c:url value="/images/products/${product.product_Id}.jpg"/>" alt="${product.product_Id}" width="250" height="250">
</td>
<tr><td>Product Name : ${product.product_Name}</td><br></tr>
<tr><td>Product Description : ${product.description}</td><br></tr>
<tr><td>Product Price : ${product.product_Price}</td><br></tr>
<tr><td>Product Available : ${product.product_Stock}</td></tr>
<tr><td><a href="../addToCart/${email}/${product.product_Id}"><input style="color:green;" type="button" name="button" value="Add To Cart"/></a></td></tr>
<tr><td><button class="btn-btn-primary" onclick="goBack()">Go Back</button></td></tr>
</table>
</form:form>
</div>


<script>
function goBack() {
    window.history.back();
}
</script>





 </body>
</html>