<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style type="text/css"><%@include file="css/bootstrap.min.css" %></style>
<script type="text/javascript"><%@ include file="js/alerts.js" %></script>
<title>Customer Form Page</title>
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
            </div>
          </div>
    	</nav>
	</header>
	<hr class="mt-0 mb-1">
    <div class="container" style="width:60%">
    	<c:if test="${customer == null}">
			<form action="insertCustomer" method="post">
			<table class="table table-success table-hover table-borderless">
            	<tr>
            		<td>
            			<div class="text-center bg-secondary rounded">
            				<label class="h3 text-white mt-1 mb-1">Add Customer Form</label>
            			</div>
            		</td>
            	</tr>
              </table>
		</c:if>
		<c:if test="${customer != null}">
			<form action="updateCustomer" method="post">
			<table class="table table-success table-hover table-borderless">
            	<tr>
            		<td>
            			<div class="text-center bg-secondary rounded text-white">
            				<label class="h3 mt-1 mb-1">Edit Customer Form</label>
            				<h5>based on <i>Customer ID</i></h5>
            			</div>
            		</td>
            	</tr>
              </table>
		</c:if>
             <table class="table table-success table-hover table-borderless">
                <tbody>
                	<tr>
                        <td>
                            <div class="mb-0" hidden="hidden">
                            	<input value="<c:out value="${customer.cid}"></c:out>" type="text" name="tbId" class="form-control">
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div class="mb-0">
                                <label for="tbName" class="form-label">Customer Name</label>
                                <input value="<c:out value="${customer.cname}"></c:out>" type="text" name="tbName" class="form-control" placeholder="enter cusromer name" required>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div class="mb-0">
                                <label for="tbEmail" class="form-label">Customer Email address</label>
                                <input value="<c:out value="${customer.cemail}"></c:out>" type="email" name="tbEmail" class="form-control" placeholder="enter customer email">
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div class="mb-0">
                                <label for="tbMobile" class="form-label">Customer Mobile Number</label>
                                <div class="input-group flex-nowrap">
                                  <span class="input-group-text" id="addon-wrapping">(+91)</span>
                                  <input value="<c:out value="${customer.cmobile}"></c:out>" type="tel" name="tbMobile" class="form-control" placeholder="enter customer mobile number" aria-describedby="addon-wrapping">
                                </div>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div class="col-md-12 text-center">
                                <button type="submit" class="btn btn-primary">Save Details</button>
                            </div>
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>
    </div>
    <footer class="container d-flex justify-content-center">
		<div class="row"><h6>&copy; techpalle.com</h6></div>
	</footer>
</div>

</body>
</html>
