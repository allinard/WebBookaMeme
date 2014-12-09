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

<title>Book à Mémé - Aliments exclus</title>

<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/theme.css" rel="stylesheet">

<link href="css/typeahead.css" rel="stylesheet">

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
          <a class="navbar-brand" href="map.html" style="color:white;"><strong>Book à Mémé</strong></a>
        </div>
        <div class="navbar-collapse collapse">
		  
          <form class="navbar-form navbar-right">
		    <button type="button" class="btn btn-success">Connexion</button>
            <!--<input type="text" class="form-control" placeholder="Search...">-->
          </form>
		  
          <ul class="nav navbar-nav navbar-right">
            <li><a href="planning.html">Planning des Repas</a></li>
            <li class="active_link"><a href="gestionProfilNutri.action">Profil Nutritionnel</a></li>
          </ul>
		  
        </div>

      </div>
    </div>




    <div class="container">
		<div class="page-header">
			<h1>Gestion des aliments exclus</h1>
		</div>
		
		<div>
			<h4>Veuillez renseigner les aliments a exclure de votre alimentation :</h4>
		</div>
		
		<div>
			<s:form action="gestionAlimentsExclus.action" method="post" cssClass="navbar-form" theme="simple">
			
			<ul>
				<li>Huitres <s:checkbox name="huitres" fieldValue="false" label="Huitres"/></li>
				<li>Moules <s:checkbox name="moules" fieldValue="false" label="Moules"/></li>
				<li>Morue <s:checkbox name="morue" fieldValue="false" label="Morue"/></li>
				<li> Blé (gluten) <s:checkbox name="ble" fieldValue="false" label="Gluten"/></li>
				<li> Porc <s:checkbox name="porcorc" fieldValue="false" label="Porc"/></li>
				<li> Viande <s:checkbox name="viande" fieldValue="false" label="Viande"/></li>
				<li> Animal <s:checkbox name="animal" fieldValue="false" label="Animal"/></li>
				<li> Fruits de mer <s:checkbox name="fruitmer" fieldValue="false" label="Fruits de mer"/></li>
				<li> Poissons <s:checkbox name="poissons" fieldValue="false" label="Poissons"/></li>
				<li> Fruits <s:checkbox name="fruits" fieldValue="false" label="Fruits"/></li>
				<li> Legumes <s:checkbox name="legumes" fieldValue="false" label="Legumes"/></li>
				<li> Fruits a coque <s:checkbox name="fruitscoque" fieldValue="false" label="Fruits a coque"/></li>
			</ul>
			
			<p>&nbsp;</p>
			
			<br>
			
			<s:submit method="save" value="Enregistrer" align="center" cssClass="btn btn-success" />
			
			</s:form>
		</div>
		
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