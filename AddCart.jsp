<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style>
body {
  font-family: Arial;
  font-size: 17px;
  padding: 8px;
}

* {
  box-sizing: border-box;
}

.row {
  display: -ms-flexbox; /* IE10 */
  display: flex;
  -ms-flex-wrap: wrap; /* IE10 */
  flex-wrap: wrap;
  margin: 0 -16px;
}

.col-25 {
  -ms-flex: 25%; /* IE10 */
  flex: 25%;
}

.col-50 {
  -ms-flex: 50%; /* IE10 */
  flex: 50%;
}

.col-75 {
  -ms-flex: 75%; /* IE10 */
  flex: 75%;
}

.col-25,
.col-50,
.col-75 {
  padding: 0 16px;
}

.container {
  background-color: #f2f2f2;
  padding: 5px 20px 15px 20px;
  border: 1px solid lightgrey;
  border-radius: 3px;
}

input[type=text] {
  width: 100%;
  margin-bottom: 20px;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 3px;
}

label {
  margin-bottom: 10px;
  display: block;
}

.icon-container {
  margin-bottom: 20px;
  padding: 7px 0;
  font-size: 24px;
}

.btn {
  background-color: #4CAF50;
  color: white;
  padding: 12px;
  margin: 10px 0;
  border: none;
  width: 100%;
  border-radius: 3px;
  cursor: pointer;
  font-size: 17px;
}

.btn:hover {
  background-color: #45a049;
}

a {
  color: #2196F3;
}

hr {
  border: 1px solid lightgrey;
}

span.price {
  float: right;
  color: grey;
}
table {
    /* cellspacing */
    border-collapse: collapse;
    border-spacing: 0;
}
th, td {
    /* cellpadding */
    
    width:25%;
    text-align: center;
}

/* Responsive layout - when the screen is less than 800px wide, make the two columns stack on top of each other instead of next to each other (also change the direction - make the "cart" column go on top) */
@media (max-width: 800px) {
  .row {
    flex-direction: column-reverse;
  }
  .col-25 {
    margin-bottom: 20px;
  }
}
</style>
</head>
<body>
    <%@ include file="header.jsp"%>
        <%@ include file="navbar.jsp"%>


<div >
    <div class="container">
      <h4>Cart
        <span class="price" style="color:black">
          <i class="fa fa-shopping-cart"></i>
          <b>4</b>
        </span>
      </h4>

      <table >
      	      	

      	<tr>
      		<th style="text-align:center;">Item Image :
      		</th>
      		<th style="text-align:center;">
      			Item Name :
      		</th>
      		<th style="text-align:center;">
      			Item Quantity :
      		</th>
      		<th style="text-align:center;">
      			Item Price :
      		</th>
      		<th>

      		</th>
      	</tr>
		<c:forEach items="${obj}" var="obj">
      	<tr>
      		<form name ='CartForm' action='RemoveCart' method='post'>
      		<td style="text-align:left;"><img src='${obj.get(1)}' style="width: 80%;height:90%;" alt="Grocery Image">
      		</td>
      		<td>${obj.get(0)}
      			<input type="hidden" name = "naming" style='border: none;border-color: transparent;' value="${obj.get(0)}"/>
      		</td>
      		<td>
      			<span ><%out.print(request.getParameter("quantity"));%>
      		</td>
      		<td>${obj.get(2)}
      			      	<input disabled type="hidden" name = "pricing" style='border: none;border-color: transparent;' value="${obj.get(2)}"/>
      		</td>
      		<td>
      				<input type='submit' name='RemoveCart' value='Remove Item' class='btnbuy' />
      		</td>
      	</form>

      	</tr>
      	</c:forEach>
      	<tr>
      		<td></td><td></td><th style="text-align:right;">Total Amount:</th><th></th>
      		<th><form action='./cart.jsp' method='post'>
				<input type='submit' name='CheckOut' value='CheckOut' class='btnbuy' />
      		</form></th>
  </tr>
      </table>
        
     
      
     
    </div>
  </div>
  <br><br>
  <%@ include file="footer.jsp"%>  
  </body>
</html>