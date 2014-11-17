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

    <title>Nant'Alertes</title>

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
          <a class="navbar-brand" href="#" style="color:rgb(140,184,224);"><img height="40px" style="margin-top:-10px;" src="img/logo.png"></a>
        </div>

      </div>
    </div>

    <div class="container">
		<div class="page-header">
			<h1>Bienvenue sur <img src="img/logo2.png" height="67px" style="margin-top:-6px;"></h1>
		</div>
		<div class="lead">
			Un probl&egrave;me dans votre rue ?
			Personne ne s'en occupe ?
			<br>
			<i>(chauss&eacute;e endommag&eacute;e, signalisation d&eacute;faillante, d&eacute;t&eacute;rioration diverse, ...)</i>
			<br>
			<br>
			Gr&acirc;ce &agrave; Nant' Alertes, vous pouvez &agrave; pr&eacute;sent signaler les probl&egrave;mes que vous avez rencontr&eacute;s dans l'agglom&eacute;ration Nantaise
			pour qu'ils soient regl&eacute;s au plus vite.
			<br>
			<br>
		</div>
		<p>
			<center>
				<s:actionerror />
					<table>
						<tr>
							<td>
								<a href="<%= UserServiceFactory.getUserService().createLoginURL("/map.action") %>" class="btn btn-lg btn-success btn-nav">Se Connecter</a>&nbsp;&nbsp;
							</td>
							<td>
				    			&nbsp;&nbsp;<a href="/map.action" class="btn btn-lg btn-primary">Continuer</a>
							</td>
						</tr>
					</table>
				    
				<p></p>
				<br>
				<br>
				Il faut &ecirc;tre connect&eacute; pour poster une alerte.
			<center>
			<br>
			<hr>
			Adeline GRANET, Alexis LINARD, Carl GOUBEAU - <a href="http://www.dpt-info.univ-nantes.fr/1326208903095/0/fiche___pagelibre/" target="_blank">Master ATAL</a> - <a href="http://univ-nantes.fr" target="_blank">Universit&eacute; de Nantes</a><br>
			Code source de l'application disponible sur <a href="https://github.com/allinard/appliWeb">GitHub</a>
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
