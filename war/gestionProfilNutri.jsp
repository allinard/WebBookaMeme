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

</head>


<body>


<h2>Gestion du profil nutritionnel</h2>

<p>Veuillez renseigner vos pr&eacute;f&eacute;rences et donn&eacute;es nutritionnelles :</p>

<s:form action="gestionProfilNutri.action" method="post" cssClass="navbar-form" theme="simple">

<ul>
	<li>Allergies : <s:select list="listeAlergies" name="alergie" cssClass="form-control" label="Allergies" labelposition="top" labelSeparator=""/></li>
	<li>Aliments exclus<a href="gestionAlimentsExclus.action" class="btn btn-success">Modifier</a></li>
	
	<li>Pr&eacute;f&eacute;rences <s:select list="listePreferences" name="preferences" cssClass="form-control" label="Preferences" labelposition="top" labelSeparator=""/></li>
	<li>Motivations<s:select list="listeMotivations" name="motivation" cssClass="form-control" label="Motivations" labelposition="top" labelSeparator=""/></li>
</ul>

<p>&nbsp;</p>

<br>

<s:submit method="save" value="Enregistrer" align="center" cssClass="btn btn-success" />

</s:form>

</body>
</html>
