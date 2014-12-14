<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="../../assets/ico/favicon.ico">

    <title>Book &Agrave; M&eacute;m&eacute;</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/theme.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy this line! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
	<script type="text/javascript">
    	  function init() {
		  
			<%
			UserService userService = UserServiceFactory.getUserService();
			User user = userService.getCurrentUser();
			%>
    	  }
	</script>
  </head>

  <body onload="document.getElementById('basicMap').style.height=((document.getElementById('sidebar').offsetHeight-document.getElementById('navbar').offsetHeight)+'px');init();" onresize="document.getElementById('basicMap').style.height=((document.getElementById('sidebar').offsetHeight-document.getElementById('navbar').offsetHeight)+'px');">

    <div id="navbar" class="navbar navbar-inverse navbar-fixed-top" role="navigation" style="box-shadow: -5px 5px 8px grey;">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#" style="color:white;">Book &Agrave; M&eacute;m&eacute;</a>
        </div>

      </div>
    </div>

    <div class="container">
		<div class="page-header">
			<h1>Bienvenue sur Book à Mémé!</h1>
		</div>
		<div class="lead">
			Envie de manger équilibré ?
			Bienvenue sur Book à Mémé !
		</div>
		<p>
			<center>
          	<s:if test="user==null">
		    	<a href="<%=userService.createLoginURL("/planning.action")%>" class="btn btn-lg btn-success">Connexion</a>
          	</s:if>
          	<s:else>
	          	<span class="badge"><span class="glyphicon glyphicon-user" style="font-size:60px;"></span></span><br>
	          	<span style="font-size:22px;"><%=user%></span>
	          	<br><br>
	          	<table>
	          		<td>
	          			<tr>
	          				<a href="<%= userService.createLogoutURL("/index.action")%>" class="btn btn-lg btn-default">D&eacute;connexion</a>
	          			</tr>
	          			<tr>
	           				&nbsp;&nbsp;<a href="planning.action" class="btn btn-lg btn-primary">Continuer</a>
	          			</tr>
	          		</td>
	          	</table>
          	</s:else>
				    
				<p></p>
				<br>
				<br>
				Il faut &ecirc;tre connect&eacute; pour utiliser le site.
			<center>
			<br>
			<hr>
			<a href="http://www.dpt-info.univ-nantes.fr/1326208903095/0/fiche___pagelibre/" target="_blank">Master 2 ATAL</a> - <a href="http://univ-nantes.fr" target="_blank">Universit&eacute; de Nantes</a><br>
			Code source de l'application disponible sur <a href="https://github.com/allinard/WebBookaMeme">GitHub</a>
		</p>
    </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src="../../dist/js/bootstrap.min.js"></script>
    <script src="../../assets/js/docs.min.js"></script>
  </body>
</html>
