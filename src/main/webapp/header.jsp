<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page import="java.util.*" %>    
<!DOCTYPE html>
<html lang="en">
	<head>
		<title>IPASS</title>

		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
		<meta name="description" content="">
		<meta name="author" content="Matthias van Dijk">


		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
		<!-- Bootstrap core CSS -->

		<!-- Custom styles for this template -->
		<link href="${pageContext.request.contextPath}/css/adj.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/css/form-css.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/simple-bar.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/css/bootstrap-clockpicker.min.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/css/bootstrap-datepicker3.min.css" rel="stylesheet">

		<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
		<!--[if lt IE 9]>
		<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
		<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->

	</head>

  <body >

		<nav id="custom-menu" class="navbar navbar-default">
			<div class="container-fluid">

					<div class="navbar-header">
						<a class="navbar-brand" href="#">
							<img alt="Brand" class="img-responsive navbar-logo" src="${pageContext.request.contextPath}/images/logo_white.png">
						</a>
						<a href="#menu-toggle" class="btn btn-default navbar-btn pull-right" id="menu-toggle"><span class="glyphicon glyphicon-menu-hamburger" aria-hidden="true"></span></a>
					</div>

					<div class="navbar-collapse">
						<div class="nav-text-margin navbar-right">

						</div>

						<ul class="nav navbar-nav pull-account-right right-navbar-nav">
							<li>
								<a href="#" class="dropdown-toggle account-menu" data-toggle="dropdown">
									<span class="glyphicon glyphicon-user user-icon" aria-hidden="true"></span>
									<span class="capitalize">${user.voornaam} ${user.achternaam}</span>
								</a>
								<ul class="dropdown-menu dropdown-menu-right">
									<li><a href="#"><i class="dropdown-icon fa fa-cog"></i>Instellingen</a></li>
									<li class="divider"></li>
									<li><a href="${pageContext.request.contextPath}/uitloggen/"><i class="dropdown-icon fa fa-power-off"></i>Uitloggen</a></li>
								</ul>
							</li>
						</ul>

					</div>

			</div>
		</nav>
	<div id="wrapper">
		<!-- Sidebar -->
		<div id="sidebar-wrapper">
			<ul class="sidebar-nav">
				<c:if test="${user.getClass().name == \"model.domain.Slb\"}">
					<li><a href="${pageContext.request.contextPath}/slb/">Dashboard</a></li>
					<li><a href="${pageContext.request.contextPath}/slb/student_toevoegen/">Student toevoegen</a></li>
				</c:if>
				<c:if test="${user.getClass().name == \"model.domain.Student\"}">
				    <li><a href="${pageContext.request.contextPath}/student/">Dashboard</a></li>
				</c:if>
			</ul>
		</div>
		<!-- /#sidebar-wrapper -->