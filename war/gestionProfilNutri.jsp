<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%@ page import="java.util.*"%>
<%@ page import="java.lang.*"%> 

<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>

<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon" href="../../assets/ico/favicon.ico">

<title>Book à Mémé - Profil Nutritionnel</title>

<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/theme.css" rel="stylesheet">

<link href="css/typeahead.css" rel="stylesheet">

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
          <a class="navbar-brand" href="planning.html" style="color:white;"><strong>Book à Mémé</strong></a>
        </div>
        <div class="navbar-collapse collapse">
		  
          <form class="navbar-form navbar-right">
          	<s:if test="user==null">
		    <a href="<%=userService.createLoginURL("/planning.action")%>" class="btn btn-success">Connexion</a>
          	</s:if>
          	<s:else>
		    <a href="<%= userService.createLogoutURL("/index.action")%>" class="btn btn-danger">D&eacute;connexion</a>
          	</s:else>
            <!--<input type="text" class="form-control" placeholder="Search...">-->
          </form>
		  
          <ul class="nav navbar-nav navbar-right">
            <li><a href="planning.action">Planning des Repas</a></li>
            <li class="active_link"><a href="#">Profil Nutritionnel</a></li>
            <li><a href="contact.action">Contact</a></li>
            <s:if test="user!=null">
              <li><a href="#"><span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;<%=user%></a></li>
          	</s:if>
          </ul>
		  
        </div>

      </div>
    </div>




    <div class="container">
		<div class="page-header">
			<h1>Gestion du profil nutritionnel</h1>
		</div>
		
		<div>
			<h4>Veuillez renseigner vos pr&eacute;f&eacute;rences et donn&eacute;es nutritionnelles :</h4>
		</div>
		
		<div>
			<s:form action="saveProfilNutri" cssClass="navbar-form" theme="simple">
			
			<ul>
			<!-- 
				<li>Allergies : <s:select list="listeAlergies" name="alergie" cssClass="form-control" label="Allergies" labelposition="top" labelSeparator=""/></li>
			 -->
				<li>Allergies : <s:textfield name="alergie" id="alergie"/> </li>
				
				<li>Aliments exclus &nbsp; <a href="gestionAlimentsExclus.action" class="btn btn-success">Modifier</a></li>
				
				<li>Pr&eacute;f&eacute;rences <s:select list="listePreferences" name="preferences" cssClass="form-control" label="Preferences" labelposition="top" labelSeparator=""/></li>
				<li>Motivations<s:select list="listeMotivations" name="motivations" cssClass="form-control" label="Motivations" labelposition="top" labelSeparator=""/></li>
			</ul>
			
			<p>&nbsp;</p>
			
			<br>
			
			<s:submit value="Enregistrer" align="center" cssClass="btn btn-success" />
			
			</s:form>
		</div>
		
		<br>
		<hr>
			<center>
			<a href="http://www.dpt-info.univ-nantes.fr/1326208903095/0/fiche___pagelibre/" target="_blank">Master 2 ATAL</a> - <a href="http://univ-nantes.fr" target="_blank">Universit&eacute; de Nantes</a><br>
			Code source de l'application disponible sur <a href="https://github.com/allinard/WebBookaMeme">GitHub</a>
			</center>
			<br>
	</div>


<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src="js/bootstrap.js"></script>
    <script src="js/transition.js"></script>
    <script src="../../assets/js/docs.min.js"></script>
	
<script type="text/javascript">
    function getfile(){
        document.getElementById('hiddenfile').click();
    }
    function getvalue(){
        document.getElementById('selectedfile').innerHTML=document.getElementById('hiddenfile').value;
    }
</script>



</body>
</html>
