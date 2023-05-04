<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" import="com.techpalle.model.Customer" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<style type="text/css"><%@include file="css/bootstrap.min.css" %></style>
	<script type="text/javascript"><%@ include file="js/alerts.js" %></script>
	<title>List Page</title>
</head>
<body>
<div style="width:95%; margin:1.5% 2.5% 0 2.5%">
	<header>
		<nav class="navbar navbar-expand-lg navbar-dark bg-secondary text-white">
        	<div class="container-fluid">
            <a class="navbar-brand">Retail Customer Management System</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
              <div class="navbar-nav">
                <a class="nav-link active" aria-current="page" href="listCustomer">Show Customer List</a>
              </div>
              <div class="navbar-nav ms-auto mb-2 mb-lg-0">
                <a class="active btn btn-danger" aria-current="page" href="logoutPage" onclick="logOutAlert()">Logout</a>
              </div>
            </div>
          </div>
    	</nav>
	</header>
	<hr class="mt-0 mb-1">
	<form action="formPage"><button type="submit" class="btn btn-sm btn-success">Add Customer</button></form>
	<hr class="mt-1 mb-0">
	<table class="table table-success table-hover table-bordered border-dark text-center">
        <thead class="table-active">
    		<tr>
      			<th scope="col">ID</th>
      			<th scope="col">Name</th>
      			<th scope="col">Email</th>
      			<th scope="col">Mobile</th>
      			<th scope="col">Action</th>
    		</tr>
    	</thead>
    	<tbody>
    		<c:forEach var="i" items="${list}">
    			<tr>
    				<th scope="row"><c:out value="${i.cid}"></c:out></th>
  					<td><c:out value="${i.cname}"></c:out></td>
  					<td><c:out value="${i.cemail}"></c:out></td>
  					<td><c:out value="${i.cmobile}"></c:out></td>
  					<td class="table-active">
  						<a href="selectCustomerById?showbyid=<c:out value="${i.cid}"></c:out>" class="btn btn-primary btn-sm text-decoration-none">
  							Edit
  						</a>&nbsp;&nbsp;
  						<a href="deleteCustomer?deletebyid=<c:out value="${i.cid}"></c:out>" class="btn btn-danger btn-sm text-decoration-none">
  							Delete
  						</a>
  					</td>
  				</tr>
  			</c:forEach>
    	</tbody>
    </table>
	<footer class="container d-flex justify-content-center">
		<div class="row">
		<h6>&copy; techpalle.com</h6>
		</div>
	</footer>
</div>
</body>
</html>