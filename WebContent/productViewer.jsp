<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.org.test.beans.Product" %>
    <%@ page import="java.util.*" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%
    
    List<Product> list = (List<Product>)request.getAttribute("products");
    %>
    <%
    		String path = request.getContextPath();
    
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="<%=path%>/resources/angular.min.js"></script>


<style type="text/css">

td {
	border: 1px solid black;
}

/* The Modal (background) */
	.modal {
	    display: block; /* Hidden by default */
	    position: fixed; /* Stay in place */
	    z-index: 1; /* Sit on top */
	    padding-top: 100px; /* Location of the box */
	    left: 0;
	    top: 0;
	    width: 100%; /* Full width */
	    height: 100%; /* Full height */
	    overflow: auto; /* Enable scroll if needed */
	    background-color: rgb(0,0,0); /* Fallback color */
	    background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
	}
	
	/* Modal Content */
	.modal-content {
	    background-color: #fefefe;
	    margin: auto;
	    padding: 20px;
	    border: 1px solid #888;
	    width: 80%;
	    height: 80%;
	    overflow: auto;
	}
	
	/* The Close Button */
	.close {
	           color: red;
			    float: right;
			    font-size: 32px;
			    font-weight: bold;
			    margin-top: -37px;
			    margin-right: 84px;
	}
	
	.close:hover,
	.close:focus {
	    color: red;
	    text-decoration: none;
	    cursor: pointer;
	}
</style>

<script type="text/javascript">


var app = angular.module("service",[]);
    
    app.controller("homeTab", function($scope, $http, $window){
        
    	$scope.ProductDesc = function(barcode){
    		 $http({
			        method  : 'POST',
			        url     : '<%=path%>/getProductDesc/'+ barcode,
			        contentType: "application/json; charset=utf-8",
			     })
			      .success(function(data) {
			    	   $scope.data = data;
			        	 $scope.MyModal = true;
			      });  		 

			    
			    $scope.closeTermAndCondition = function(){
			    	$scope.MyModal = false;
			    } 
    	}  ;	
    	
    });
</script>
</head>
<body  ng-app="service" ng-controller = "homeTab">
	
	<div id="ModalView" ng-show = "MyModal" class="modal">
		  <!-- Modal content -->
		  <div style="width:  100%">
		   <span class="close" ng-click="closeTermAndCondition()">&times;</span>
		  </div>
		  
		  <div class="modal-content">
		  	 
		  		<div style="padding-left: 36%;"><h3>Product Description</h3></div>		   
			   <table style="margin-left: 34%;margin-top: 10%;">
			   		<tr>
			   		<td>Barcode :</td>
			   		<td>{{data.Barcode}}</td>
			   		</tr>
			   		<tr>
			   		<td>Highest Price :</td>
			   		<td>{{data.HighestPrice}}</td>
			   		</tr>
			   		<tr>
			   		<td>Lowest Price :</td>
			   		<td>{{data.LowestPrice}}</td>
			   		</tr>
			   		<tr>
			   		<td>Ideal Price :</td>
			   		<td>{{data.IdealPrice}}</td>
			   		</tr>
			   		<tr>
			   		<td>Product Description :</td>
			   		<td>{{data.ProductDesc}}</td>
			   		</tr>
			   
			   </table>
		  </div>		
		</div>
		
	<div>
	<div style = "margin-left : 43%"><H3>Product List</H3></div>
	
	<table style="width:100%;border : 1px solid black">
		<thead style="background-color: yellow;">
			<tr>
				<td>Store</td>
				<td>Barcode</td>
				<td>price</td>
				<td>note</td>
			</tr>
		</thead>
	
	<tbody>
		<%for(Product p : list){%>		
			<tr ng-click="ProductDesc('<%=p.getBarcode()%>')" >
				<td><%= p.getStore() %></td>
				<td><%= p.getBarcode() %></td>	
				<td><%for(double price: p.getPrice()) { %> <%= price %>  <%}%></td>
				<td><%= p.getNote() %></td>
			</tr>
		<% } %>
	</tbody>
	</table>
	</div>	
	
</body>
</html>