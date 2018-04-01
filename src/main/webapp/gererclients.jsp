<%-- 
    Document   : gererclients
    Created on : 29 mars 2018, 18:39:37
    Author     : RHAW
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Utilisateur"%>

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
            <title>Gestion des clients</title>
        </head>
        <body>
            <%  
            ArrayList<Utilisateur> prospects = new ArrayList();
            ArrayList<Utilisateur> enattente = new ArrayList();
            ArrayList<Utilisateur> valides = new ArrayList();
            if(request.getAttribute("listeProspects") != null) { 
                prospects = (ArrayList<Utilisateur>) request.getAttribute("listeProspects");
            }
            if(request.getAttribute("listeEnAttente") != null) { 
                enattente = (ArrayList<Utilisateur>) request.getAttribute("listeEnAttente");
            }
            if(request.getAttribute("listeValides") != null) { 
                valides = (ArrayList<Utilisateur>) request.getAttribute("listeValides");
            }
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
			<div class="fh5co-overlay"></div>
			<div class="fh5co-cover" data-stellar-background-ratio="0.5" style="background-color: black">
                            <div class="desc animate-box">		
                                <div class="container">
						<div class="row">
							<div>
                                                            <div>
                                                            <p>Liste des clients prospects :</p>
                                                            <select id="lprospects" style="color:black;" onclick="l_informations(this.id);">
                                                            <%
                                                                for(Utilisateur u : prospects) {
                                                                    out.println("<option value=" + u.getCodeu() + ">" + u.getNomu() + "--" + u.getPrenomu() + "--" + u.getEmailu() + "</option>");
                                                                }
                                                            %>
                                                            </select>
                                                            <input class="btn btn-primary" type="submit" value="Passer en attente" onclick="l_enattente()">
                                                            <input class="btn btn-primary"  id ="prospect" type="submit" value="Valider" onclick="l_valider(this.id)">
                                                            </div>
                                                            <br>
                                                            <div id="linformationsprospects" ></div>
                                                            <br>
                                                            <div>
                                                                <p>Liste des clients en attente :</p>
                                                                <select id="lenattente" style="color:black;" onclick="l_informations(this.id)">
                                                                <%
                                                                    for(Utilisateur u : enattente) {
                                                                        out.println("<option value=" + u.getCodeu() + ">" + u.getNomu() + "--" + u.getPrenomu() + "--" + u.getEmailu() + "</option>");
                                                                    }
                                                                %>
                                                                <input class="btn btn-primary"  id ="enattente" type="submit" value="Valider" onclick="l_valider(this.id)">
                                                                </select>
                                                            </div>
                                                            <br>
                                                            <div id="linformationsattente" ></div>
                                                            <div>
                                                                <p>Liste des clients valid�s :</p>
                                                                <select id="lvalides" style="color:black;" onclick="l_informations(this.id)">
                                                                <%
                                                                    for(Utilisateur u : valides) {
                                                                        if("Valid�".equals(u.getStatus())) {
                                                                            out.println("<option value=" + u.getCodeu() + " style=\"background-color:red;\">" + u.getNomu() + "--" + u.getPrenomu() + "--" + u.getEmailu() + "</option>");
                                                                        } else {
                                                                            out.println("<option value=" + u.getCodeu() + " style=\"background-color:green;\">" + u.getNomu() + "--" + u.getPrenomu() + "--" + u.getEmailu() + "</option>");
                                                                        }
                                                                    }
                                                                %>
                                                                </select>
                                                            </div>
                                                            <br>
                                                            <div id="linformationsvalides" ></div>
                                                            <br>
                                                        </div>
                                                <span><a href="pageadmin.jsp">Retour � la page d'administration</a></span>
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
