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
            ArrayList<Utilisateur> users = new ArrayList();
            int lastuser=0;
            if(request.getAttribute("listeProspects") != null) { 
                prospects = (ArrayList<Utilisateur>) request.getAttribute("listeProspects");
            }
            if(request.getAttribute("listeEnAttente") != null) { 
                enattente = (ArrayList<Utilisateur>) request.getAttribute("listeEnAttente");
            }
            if(request.getAttribute("listeValides") != null) { 
                valides = (ArrayList<Utilisateur>) request.getAttribute("listeValides");
            }
            if(request.getAttribute("LastUser") != null) { 
                            lastuser = (int) request.getAttribute("LastUser");
            }
            if(request.getAttribute("listeUsers") != null) { 
                users = (ArrayList<Utilisateur>) request.getAttribute("listeUsers");
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
                        <div class="fh5co-parallax" style="background-image: url(images/home-image-3.jpg);" data-stellar-background-ratio="0.5">
                            <div class="overlay"></div>
                            <div class="container">
                                <div class="row">
                                    <div class="col-md-8 col-md-offset-2 col-sm-12 col-sm-offset-0 col-xs-12 col-xs-offset-0 text-center fh5co-table">
                                        <div class="fh5co-intro fh5co-table-cell animate-box">
                                            <h1 class="text-center">Gestion des clients</h1>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
			<div class="fh5co-contact">
                            <div class="desc animate-box">		
                                <div class="container">
                                    <div class="row">
                                        <div>
                                            <div>
                                                <br>    
                                                <p>Nombre de clients prospects : <%=prospects.size()%></p>
                                                <h2>Liste des clients prospects :</h2>
                                                <select id="lprospects" style="color:black;" onclick="affichage_infos(this.id);">
                                                <%
                                                    for(Utilisateur u : prospects) {
                                                        if (u.getCodeu()!=lastuser){
                                                            out.println("<option value=" + u.getCodeu() + ">" + u.getNomu() + "--" + u.getPrenomu() + "--" + u.getEmailu() + "</option>");                                        
                                                        } else {
                                                            out.println("<option  style=\"background-color:yellow;\" value=" + u.getCodeu() + ">" + u.getNomu() + "--" + u.getPrenomu() + "--" + u.getEmailu() + "</option>");
                                                        }
                                                    }
                                                %>
                                                </select>
                                                <input class="btn btn-primary" type="submit" value="Passer en attente" onclick="l_enattente()">
                                                <input class="btn btn-primary"  id ="prospect" type="submit" value="Valider" onclick="l_valider(this.id)">
                                            </div>
                                            <br>
                                            <div id="linformationsprospects" ></div>                                     
                                            <br>
                                            <div id="linformationspersonnellesprospects" ></div>
                                            <div>
                                                <p>Nombre de clients en attente : <%=enattente.size()%></p>
                                                <h2>Liste des clients en attente :</h2>
                                                <select id="lenattente" style="color:black;" onclick="affichage_infos(this.id)">
                                                <%
                                                    for(Utilisateur u : enattente) {
                                                        if (u.getCodeu()!=lastuser){
                                                            out.println("<option value=" + u.getCodeu() + ">" + u.getNomu() + "--" + u.getPrenomu() + "--" + u.getEmailu() + "</option>");
                                                        } else {
                                                            out.println("<option  style=\"background-color:yellow;\" value=" + u.getCodeu() + ">" + u.getNomu() + "--" + u.getPrenomu() + "--" + u.getEmailu() + "</option>");
                                                        }                                                                
                                                    }
                                                %>
                                                </select>
                                                <input class="btn btn-primary"  id ="enattente" type="submit" value="Valider" onclick="l_valider(this.id)">
                                            </div>
                                            <br>
                                            <div id="linformationsattente" ></div>
                                            <br>
                                            <div id="linformationspersonnellesattente" ></div>
                                            <div>
                                                <p>Nombre de clients valid�s : <%=valides.size()%></p>
                                                <h2>Liste des clients valid�s :</h2>
                                                <select id="lvalides" style="color:black;" onclick="affichage_infos(this.id)">
                                                <%
                                                    for(Utilisateur u : valides) {
                                                        if("Valide".equals(u.getStatus())) {
                                                            out.println("<option value=" + u.getCodeu() + " style=\"background-color: green;\">" + u.getNomu() + "--" + u.getPrenomu() + "--" + u.getEmailu() + "</option>");
                                                        } else {
                                                            out.println("<option value=" + u.getCodeu() + " style=\"background-color: grey;\">" + u.getNomu() + "--" + u.getPrenomu() + "--" + u.getEmailu() + "</option>");
                                                        }
                                                    }
                                                %>
                                                </select>
                                            </div>
                                            <br>
                                            <div id="linformationsvalides" ></div>
                                            <br>
                                            <div id="linformationspersonnellesvalides" ></div>
                                            <br>
                                            <div>
                                                <h2>Suppression d'un client :</h2>
                                                <select id="lsuppression" style="color:black;">
                                                <%
                                                    for(Utilisateur u : users) {
                                                            out.println("<option value=" + u.getCodeu() + ">" + u.getNomu() + "--" + u.getPrenomu() + "--" + u.getEmailu() + "</option>");
                                                    }
                                                %>
                                                </select>
                                                <input class="btn btn-primary"  id ="supress" type="submit" value="Supprimer" onclick="suppress_client()">
                                            </div>
                                        </div>
                                    <span><a href="pageadmin.jsp">Retour � la page d'administration</a></span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <footer>
                <div id="footer">
                    <div class="container">
                        <div class="row">
                            <div class="col-md-4 animate-box">
                                <h3 class="section-title">About Us</h3>
                                <p>RHAW</p>
                            </div>

                            <div class="col-md-4 animate-box">
                                <h3 class="section-title">Our Address</h3>
                                <ul class="contact-info">
                                    <li><i class="icon-map-marker"></i>2 Rue du Doyen-Gabriel-Marty 
                                        31042 Toulouse Cedex 9</li>
                                    <li><i class="icon-phone"></i>+ 1235 2355 98</li>
                                    <li><i class="icon-envelope"></i><a href="#">rhaw@rhaw.com</a></li>
                                    <li><i class="icon-globe2"></i><a href="#">https://jdcoaching.herokuapp.com/</a></li>
                                </ul>
                            </div>
                            <div class="col-md-4 animate-box">
                                <h3 class="section-title">Drop us a line</h3>
                                <form class="contact-form">
                                    <div class="form-group">
                                        <label for="name" class="sr-only">Name</label>
                                        <input type="name" class="form-control" id="name" placeholder="Name">
                                    </div>
                                    <div class="form-group">
                                        <label for="email" class="sr-only">Email</label>
                                        <input type="email" class="form-control" id="email" placeholder="Email">
                                    </div>
                                    <div class="form-group">
                                        <label for="message" class="sr-only">Message</label>
                                        <textarea class="form-control" id="message" rows="7" placeholder="Message"></textarea>
                                    </div>
                                    <div class="form-group">
                                        <input type="submit" id="btn-submit" class="btn btn-send-message btn-md" value="Send Message">
                                    </div>
                                </form>
                            </div>
                        </div>
                        <div class="row copy-right">
                            <div class="col-md-6 col-md-offset-3 text-center">
                                <p class="fh5co-social-icons">
                                    <a href="#"><i class="icon-twitter2"></i></a>
                                    <a href="#"><i class="icon-facebook2"></i></a>
                                    <a href="#"><i class="icon-instagram"></i></a>
                                    <a href="#"><i class="icon-dribbble2"></i></a>
                                    <a href="#"><i class="icon-youtube"></i></a>
                                </p>
                                <p>Copyright RHAW</p>
                            </div>
                        </div>
                    </div>
                </div>
        </footer>
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
