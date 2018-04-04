<%-- 
    Document   : inscriptionrapide
    Created on : 29 mars 2018, 15:33:34
    Author     : RHAW
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Utilisateur"%>
<%@page import="database.Bd"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<f:view>
    <html>
        <head>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <meta name="description" content="Free HTML5 Template by FREEHTML5" />
            <meta name="keywords" content="free html5, free template, free bootstrap, html5, css3, mobile first, responsive" />

            <!-- Facebook and Twitter integration -->
            <meta property="og:title" content=""/>
            <meta property="og:image" content=""/>
            <meta property="og:url" content=""/>
            <meta property="og:site_name" content=""/>
            <meta property="og:description" content=""/>
            <meta name="twitter:title" content="" />
            <meta name="twitter:image" content="" />
            <meta name="twitter:url" content="" />
            <meta name="twitter:card" content="" />

            <!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
            <link rel="shortcut icon" href="favicon.ico">

            <link href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,700,900' rel='stylesheet' type='text/css'>

            <!-- Animate.css -->
            <link rel="stylesheet" href="css/animate.css">
            <!-- Icomoon Icon Fonts-->
            <link rel="stylesheet" href="css/icomoon.css">
            <!-- Bootstrap  -->
            <link rel="stylesheet" href="css/bootstrap.css">
            <!-- Superfish -->
            <link rel="stylesheet" href="css/superfish.css">

            <link rel="stylesheet" href="css/style.css">


            <!-- Modernizr JS -->
            <script src="js/modernizr-2.6.2.min.js"></script>
            <!-- FOR IE9 below -->
            <!--[if lt IE 9]>
            <script src="js/respond.min.js"></script>
            <![endif]-->
            <title>Inscription Rapide</title>
        </head>
        <body>
            <%
            %>
            <div id="fh5co-wrapper">
		<div id="fh5co-page">
		<div id="fh5co-header">
			<header id="fh5co-header-section">
				<div class="container">
					<div class="nav-header">
						<h1 id="fh5co-logo"><a href="pageadmin.jsp">JD<span>Coaching</span></a></h1>
					</div>
				</div>
			</header>		
		</div>
		<!-- end:fh5co-header -->
		<div class="fh5co-hero">
                        <div class="fh5co-parallax" style="background-image: url(images/home-image-3.jpg);" data-stellar-background-ratio="0.5">
                            <div class="overlay"></div>
                            <div class="container">
                                <div class="row">
                                    <div class="col-md-8 col-md-offset-2 col-sm-12 col-sm-offset-0 col-xs-12 col-xs-offset-0 text-center fh5co-table">
                                        <div class="fh5co-intro fh5co-table-cell animate-box">
                                            <h1 class="text-center">Inscription rapide d'un client</h1>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
			<div class="fh5co-contact">
                            <div class="desc animate-box">
					<div class="container">
						<div class="row">
                                                    <br>
                                                    <p>Formulaire d'inscription : </p>
                                                    <table style="border-collapse:separate; border-spacing:0px 10px;">
                                                        <tr>
                                                            <th>Nom : </th>
                                                            <th><input id="nom" type="text" name="nom"  style="color:black;" required></th>
                                                        </tr>
                                                        <tr>
                                                            <th>Prenom : </th>
                                                            <th><input id="prenom" type="text" name="prenom" style="color:black;" required></th>
                                                        </tr>
                                                        <tr>
                                                            <th>Date de naissance : </th>
                                                            <th><input id="date" type="date" name="date" style="color:black;" required></th>
                                                        </tr>
                                                        <tr>
                                                            <th>Email : </th>
                                                            <th><input id="mail" type="mail" name="mail" style="color:black;" required></th>
                                                        </tr>
                                                        <tr>
                                                            <th>Téléphone : </th>
                                                            <th><input id="tel" type="text" name="tel" style="color:black;" required></th>
                                                        </tr>
                                                        <tr>
                                                            <th>Password : </th>
                                                            <th><input id="password" type="password" name="password" style="color:black;" required></th>
                                                        </tr>
                                                        <tr>
                                                            <th>Objectif : </th>
                                                            <th><select id="objectif" style="color:black;" required="required">
                                                                    <option value ="Sportif" style="color:black;">Sportif</option>
                                                                    <option value ="Minceur" style="color:black;">Minceur</option>
                                                                </select></th>
                                                        </tr>
                                                    </table>
                                                    <br>
                                                    <p><input class="btn btn-primary" type="submit" value="Inscrire" onclick="l_inscription_rapide()"></p>
                                                    <br>        
                                                    <span><a href="pageadmin.jsp">Retour à la page d'administration</a></span>
						</div>
					</div>
				</div>
			</div>
		</div>
            </div>
         </div>
        <script src="js/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script src="js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script src="js/jquery.waypoints.min.js"></script>
	<!-- Stellar -->
	<script src="js/jquery.stellar.min.js"></script>
	<!-- Superfish -->
	<script src="js/hoverIntent.js"></script>
	<script src="js/superfish.js"></script>

	<!-- Main JS (Do not remove) -->
	<script src="js/main.js"></script>
        <script type="text/JavaScript" src="/js/fctclient.js"></script>
        </body>
    </html>
</f:view>
