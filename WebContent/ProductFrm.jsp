<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page session="true"%>
    <%
    		String path = request.getContextPath();
    
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="<%=path%>/resources/angular.min.js"></script>

<script type="text/javascript">


var app = angular.module("service",[]);
    
    app.controller("homeTab", function($scope, $window){
        
    	$scope.ProductList = function(){
    		$window.location.href = "<%=path%>/GetProductList";
    	}  ;	
    	
    });
    




</script>
<style type="text/css">		
			
			#input-box{
				    border-radius: 4px;
				    border-style: none;
				    border: 1px solid cadetblue;
				    width: 198px;
				    height: 26px;
			}
			
			
		</style>
		
</head>
<body  ng-app="service" ng-controller = "homeTab">
	
	<div style="cursor: pointer;    font-weight: bold;"  ng-click='ProductList();'>Product List</div>
	
	
	<div style="margin-left :42%"><H3> Product Entry  </H3> </div>
	<form style="margin-left:33%" name="ProductSubmit" action="SaveProduct">	
		<table>
			<tr> 
				<td>Product Store : </td>
				<td><input id='input-box'  type="text"  name="store" value="" >  </td>
			</tr>
			<tr> 
				<td>Product Barcode :</td>
				<td><input id='input-box'  type="text"  name="Barcode" value="" > </td>
			</tr>
			<tr> 
				<td>Product Price : </td>
				<td><input id='input-box'  type="text"  name="price" value="">  </td>
			</tr>
			<tr> 
				<td>Note : </td>
				<td><textarea id='input-box'  name="note"></textarea> </td>
			</tr>
				
		</table>
		<button style="margin-left: 19%;margin-top: 10%;" type="submit" name="Submit"  value ="Submit">Submit</button>
	</form>
</body>
</html>