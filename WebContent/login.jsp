<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style type="text/css"><%@include file="css/bootstrap.min.css" %></style>
<script type="text/javascript"><%@ include file="js/alerts.js" %></script>
<title>Admin Login Page</title>
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
		</div>
	</nav>
</header><br>
<div class="container rounded" style="width:60%">
	<div class="text-center bg-secondary rounded">
		<label class="h5 text-white mt-1 mb-1">Admin Login</label>
	</div>
	<form action="validateAdmin" method="post">
		<table class="table table-success table-borderless">
			<tbody>
				<tr>
					<td>
						<div class="mb-0">
						<label for="tbNameLog" class="form-label">Username</label>
						<input type="text" name="tbNameLog" class="form-control" placeholder="enter admin name">
						</div>
					</td>
				</tr>
				<tr>
					<td>
						<div class="mb-0">
						<label for="tbPassLog" class="form-label">Password</label>
						<input type="password" name="tbPassLog" class="form-control" placeholder="enter admin password">
						</div>
					</td>
				</tr>
				<tr>
					<td>
						<div class="mb-0">
						<button type="submit" class="form-control" onclick="showListAlert()">login</button>
						</div>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
	</div>
</div>
</body>
</html>