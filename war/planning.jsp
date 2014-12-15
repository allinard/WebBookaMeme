<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>
<%@ page import="java.util.GregorianCalendar" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Date" %>


<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="../../assets/ico/favicon.ico">

    <title>Book &Agrave;  M&eacute;m&eacute;</title>

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
			final Calendar date = new GregorianCalendar();
		    date.setTime(new Date());
		 	
		//ici on va juste décrementer la date jusqu'a tomber sur le premier jour de la semaine.
		    while (date.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
		         date.add(Calendar.DAY_OF_WEEK,-1);
		    }
			
		Calendar date2 = (Calendar)date.clone();
		Calendar today = (Calendar)date.clone();
		
			UserService userService = UserServiceFactory.getUserService();
			User user = userService.getCurrentUser();
			if(user==null){
			    String redirectURL = "/index.action";
			    response.sendRedirect(redirectURL);
			}
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
          <a class="navbar-brand" href="planning.action" style="color:white;"><strong>Book &Agrave; M&eacute;m&eacute;</strong></a>
        </div>
        <div class="navbar-collapse collapse">
		  
          <form class="navbar-form navbar-right">
          	<s:if test="user==null">
		    <a href="<%=userService.createLoginURL("/planning.action")%>" class="btn btn-success">Connexion</a>
          	</s:if>
          	<s:else>
		    <a href="<%= userService.createLogoutURL("/planning.action")%>" class="btn btn-danger">D&eacute;connexion</a>
          	</s:else>
            <!--<input type="text" class="form-control" placeholder="Search...">-->
          </form>
		  
          <ul class="nav navbar-nav navbar-right">
            <li class="active_link" ><a href="#">Planning des Repas</a></li>
            <li><a href="gestionProfilNutri.action">Profil Nutritionnel</a></li>
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
			<h1>Planning des Repas</h1>
		</div>


		<div>
			<center>
			<ul class="pagination">
				<li><a href="#"><span aria-hidden="true">&laquo;</span><span class="sr-only">Previous</span></a></li>
				<li><a href="#">Planning du <%= date2.get(Calendar.DAY_OF_MONTH) %>/<%= date2.get(Calendar.MONTH)+1 %> <% date2.add(Calendar.DAY_OF_WEEK,6); %> au <%= date2.get(Calendar.DAY_OF_MONTH) %>/<%= date2.get(Calendar.MONTH)+1 %></a></li>
				<li><a href="#"><span aria-hidden="true">&raquo;</span><span class="sr-only">Next</span></a></li>
			  </ul>
			  </center>
		</div>



		<div>
			<ul class="nav nav-tabs">
			  <li role="presentation"<%if(today.equals(date)){ %> class="active"<%} %>><a data-toggle="tab" href="#lundi">Lundi <%= date.get(Calendar.DAY_OF_MONTH) %>/<%= date.get(Calendar.MONTH)+1 %></a></li>
			  <% date.add(Calendar.DAY_OF_WEEK,1); %>
			  <li role="presentation"<%if(today.equals(date)){ %> class="active"<%} %>><a data-toggle="tab" href="#mardi">Mardi  <%= date.get(Calendar.DAY_OF_MONTH) %>/<%= date.get(Calendar.MONTH)+1 %></a></li>
			  <% date.add(Calendar.DAY_OF_WEEK,1); %>
			  <li role="presentation"<%if(today.equals(date)){ %> class="active"<%} %>><a data-toggle="tab" href="#mercredi">Mercredi  <%= date.get(Calendar.DAY_OF_MONTH) %>/<%= date.get(Calendar.MONTH)+1 %></a></li>
			  <% date.add(Calendar.DAY_OF_WEEK,1); %>
			  <li role="presentation"<%if(today.equals(date)){ %> class="active"<%} %>><a data-toggle="tab" href="#jeudi">Jeudi  <%= date.get(Calendar.DAY_OF_MONTH) %>/<%= date.get(Calendar.MONTH)+1 %></a></li>
			  <% date.add(Calendar.DAY_OF_WEEK,1); %>
			  <li role="presentation"<%if(today.equals(date)){ %> class="active"<%} %>><a data-toggle="tab" href="#vendredi">Vendredi  <%= date.get(Calendar.DAY_OF_MONTH) %>/<%= date.get(Calendar.MONTH)+1 %></a></li>
			  <% date.add(Calendar.DAY_OF_WEEK,1); %>
			  <li role="presentation"<%if(today.equals(date)){ %> class="active"<%} %>><a data-toggle="tab" href="#samedi">Samedi  <%= date.get(Calendar.DAY_OF_MONTH) %>/<%= date.get(Calendar.MONTH)+1 %></a></li>
			  <% date.add(Calendar.DAY_OF_WEEK,1); %>
			  <li role="presentation"<%if(today.equals(date)){ %> class="active"<%} %>><a data-toggle="tab" href="#dimanche">Dimanche  <%= date.get(Calendar.DAY_OF_MONTH) %>/<%= date.get(Calendar.MONTH)+1 %></a></li>
			</ul>

			<div class="tab-content">
				<div class="tab-pane active in" id="lundi">					
					<h4>
						D&eacute;jeuner &nbsp;
						<a href="#" title="Modifier &agrave; la main" onclick="
							document.getElementById('lundi11').innerHTML='<textarea>'+document.getElementById('lundi11').innerHTML+'</textarea>';
							document.getElementById('lundi12').innerHTML='<textarea>'+document.getElementById('lundi12').innerHTML+'</textarea>';
							document.getElementById('lundi13').innerHTML='<textarea>'+document.getElementById('lundi13').innerHTML+'</textarea>';
							document.getElementById('lundi1').innerHTML='<button class=\'btn btn-success\'>Sauvegarder</button>';
						">
							<span class="label label-success">
								<span class="glyphicon glyphicon-pencil"></span>
							</span>
						</a> &nbsp;
						<a href="#" title="Charger un nouveau repas">
							<span class="label" style="background-color: #428BCA;">
								<span class="glyphicon glyphicon-refresh"></span>
							</span>
						</a>
					</h4>
					<div class="row">
						<div class="col-sm-4">
							<div class="panel panel-default">
							  <div class="panel-heading">
								<h3 class="panel-title">Entr&eacute;e</h3>
							  </div>
							  <div class="panel-body" id="lundi11">
								Items ...
							  </div>
							</div>
						</div>
						<div class="col-sm-4">
							<div class="panel panel-default">
							  <div class="panel-heading">
								<h3 class="panel-title">Plat de R&eacute;sistance</h3>
							  </div>
							  <div class="panel-body" id="lundi12">
								Items ...
							  </div>
							</div>
						</div>
						<div class="col-sm-4">
							<div class="panel panel-default">
							  <div class="panel-heading">
								<h3 class="panel-title">Dessert</h3>
							  </div>
							  <div class="panel-body" id="lundi13">
								Items ...
							  </div>
							</div>
						</div>
					</div>
					<div id="lundi1">
					</div>
					<hr>

					<h4>
						Diner &nbsp;
						<a href="#" title="Modifier &agrave; la main" onclick="
							document.getElementById('lundi21').innerHTML='<textarea>'+document.getElementById('lundi21').innerHTML+'</textarea>';
							document.getElementById('lundi22').innerHTML='<textarea>'+document.getElementById('lundi22').innerHTML+'</textarea>';
							document.getElementById('lundi23').innerHTML='<textarea>'+document.getElementById('lundi23').innerHTML+'</textarea>';
							document.getElementById('lundi2').innerHTML='<button class=\'btn btn-success\'>Sauvegarder</button>';
						">
							<span class="label label-success">
								<span class="glyphicon glyphicon-pencil"></span>
							</span>
						</a> &nbsp;
						<a href="#" title="Charger un nouveau repas">
							<span class="label" style="background-color: #428BCA;">
								<span class="glyphicon glyphicon-refresh"></span>
							</span>
						</a>
					</h4>
					<div class="row">
						<div class="col-sm-4">
							<div class="panel panel-default">
							  <div class="panel-heading">
								<h3 class="panel-title">Entr&eacute;e</h3>
							  </div>
							  <div class="panel-body" id="lundi21">
								Items ...
							  </div>
							</div>
						</div>
						<div class="col-sm-4">
							<div class="panel panel-default">
							  <div class="panel-heading">
								<h3 class="panel-title">Plat de R&eacute;sistance</h3>
							  </div>
							  <div class="panel-body" id="lundi22">
								Items ...
							  </div>
							</div>
						</div>
						<div class="col-sm-4">
							<div class="panel panel-default">
							  <div class="panel-heading">
								<h3 class="panel-title">Dessert</h3>
							  </div>
							  <div class="panel-body" id="lundi23">
								Items ...
							  </div>
							</div>
						</div>
					</div>
					
					<div id="lundi2">
					</div>
				</div>

				<div class="tab-pane" id="mardi">
					nyahhh2
				</div>

				<div class="tab-pane" id="mercredi">
					nyahhh3
				</div>

				<div class="tab-pane" id="jeudi">
					nyahhh4
				</div>

				<div class="tab-pane" id="vendredi">
					nyahhh5
				</div>

				<div class="tab-pane" id="samedi">
					nyahhh6
				</div>

				<div class="tab-pane" id="dimanche">
					nyahhh7
				</div>
			</div>
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
