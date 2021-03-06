<%-- 
    Document   : parametragemail
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
            <title>Page d'accueil</title>
        </head>
        <body>
            <%    
            String mail = "";
            if(request.getAttribute("emailadmin") == null) { 
                mail = (String) session.getAttribute("mail");
            } else {
                mail = (String) request.getAttribute("emailadmin");
                session.setAttribute("mail",mail);
                mail = (String) session.getAttribute("mail");
            }
            ArrayList<Utilisateur> coachs = new ArrayList();
            if(request.getAttribute("ListeCoachs") != null) { 
                coachs = (ArrayList<Utilisateur>) request.getAttribute("ListeCoachs");
            }

            for (Utilisateur utilisateur :Bd.getUtilisateurs()) {
                if ("coach".equals(utilisateur.getType())) {
                coachs.add(utilisateur);
                }
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
                                            <h1 class="text-center">Param�trage des adresses mail</h1>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
			<div class="fh5co-contact">
                            <div class="desc animate-box">
					<div class="container">
						<div class="row">
							<div class="col-md-7">
                                                                <br>
                                                                Email Administrateur : <input type="email" id ="mailadmin" name="mailadmin" style="color:black;" value="<%=mail%>">
                                                                <input class="btn btn-primary" type="submit" value="Changer" onclick="changement_mail_admin()">
                                                                <br>
                                                                <br>
                                                                Informations du coach :
                                                                <br>
                                                                <div class="table-responsive">                                                                     
                                                                        <%
                                                                            out.println("<table class='table table-bordered'>");
                                                                            out.println("<tr><td>Nom</td><td>Pr�nom</td><td>Adresse e-mail</td><td>Nouvelle adresse</td><td>Option</td></tr>");
                                                                            for(Utilisateur u : coachs) {
                                                                                out.println("<tr><td>" + u.getNomu() + "</td><td>" + u.getPrenomu()+ "</td><td>" + u.getEmailu()+ "</td>");
                                                                                out.println("<td><input type=\"email\" id =\"mailcoaching\" name=\"mailcoaching\" style=\"color:black;\" value="+ u.getEmailu() +"></td>");                                                                    
                                                                                out.println("<td><input class=\"btn btn-primary\" type=\"submit\" value=\"Changer\" onclick=\"changement_mail_coach()\"></td>");
                                                                                out.println("</tr>");
                                                                            }
                                                                            out.println("</table>");
                                                                        %>
                                                                </div>
                                                                <br>        
                                                                <span><a href="pageadmin.jsp">Retour � la page d'administration</a></span>
							</div>
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
