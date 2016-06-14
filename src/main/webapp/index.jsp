<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<%
	String email = "";
	if (request.getCookies() != null) {
		for (Cookie c : request.getCookies()) {
			if (c.getName().equals("email")) {
				email = c.getValue();
				break;
			}
		}
	}
%>

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


		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<!-- Bootstrap core CSS -->

		<!-- Custom styles for this template -->
		<link href="css/adj.css" rel="stylesheet">

		<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
		<!--[if lt IE 9]>
		<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
		<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->

	</head>

  <body >

<div class="login bg-blueblack">
	<div class="login-header">
		<img class="login-logo img-responsive hidden-xs" src="${pageContext.request.contextPath}/images/logo_blue.png" alt="">
		<img class="login-logo-mobile visible-xs" src="${pageContext.request.contextPath}/images/logo_blue.png" alt="">
	</div>
	<div class="login-content">
			<form class="form-horizontal" method="post"
				action="${pageContext.request.contextPath}/LoginServlet.do">
				<c:if test="${not empty requestScope.error}">
			      <div class="has-error">
				</c:if>
				<input type="text" class="form-control input-height"
					placeholder="E-mail" name="login_email" value="<%= email %>"> <input type="password"
					class="form-control space-input input-height"
					placeholder="Wachtwoord" name="login_password"> 
				<c:if test="${not empty requestScope.error}">
		      		<span id="helpBlock" class="help-block">${requestScope.error}</span>
		      		</div>
				</c:if>
					<button class="btn btn-signIn btn-main" type="submit">Aanmelden</button>
			</form>
	</div>
</div>
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>
