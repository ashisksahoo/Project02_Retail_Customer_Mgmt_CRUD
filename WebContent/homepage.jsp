<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style type="text/css"><%@include file="css/bootstrap.min.css" %></style>
<script type="text/javascript"><%@ include file="js/alerts.js" %></script>
<title>Home Page</title>
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
              <div class="navbar-nav ms-auto mb-3 mb-lg-0">
                <a class="btn btn-primary" aria-current="page" href="loginPage">Login</a>
              </div>
            </div>
          </div>
    	</nav>
	</header><br><br>
	<div class="container bg-secondary rounded" style="width:55%">
		<p class="p-2 mb-0 fs-5 text-center text-white">Features  of this Application</p>
		<li class="p-2 mb-0 fs-6 text-white">This Application allows <b>Admin</b> to Login and Logout easily.</li>
		<li class="p-2 mb-0 fs-6 text-white">Using this Application Admin can check all existing Retail Customers Details.</li>
		<li class="p-2 mb-0 fs-6 text-white">This Application allows Admin to insert new Retail Customer.</li>
		<li class="p-2 mb-3 fs-6 text-white">As per requirement Admin can Update or Delete the Retail Customer Details.</li>
	</div><br>
	<footer class="container d-flex justify-content-center">
		<div class="row">
		<h6>&copy; techpalle.com</h6>
		</div>
	</footer>
</div>
</body>
</html>