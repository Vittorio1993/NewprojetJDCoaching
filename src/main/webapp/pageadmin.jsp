<%-- 
    Document   : pageadmin
    Created on : 29 mars 2018, 09:08:59
    Author     : RHAW
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>


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
            String changementmail = "";
            if(request.getAttribute("changementMail") != null) { 
                changementmail = (String) request.getAttribute("changementMail");
            }
            %>
            <div id="fh5co-wrapper">
                <div id="fh5co-page">
                    <div id="fh5co-header">

                        <header id="fh5co-header-section">
                            <div class="container">
                                <div class="nav-header">
                                    <a href="#" class="js-fh5co-nav-toggle fh5co-nav-toggle"><i></i></a>
                                    <h1 id="fh5co-logo"><a href="index.html">JD<span>Coaching</span></a></h1>
                                    <!-- START #fh5co-menu-wrap -->
                                    <nav id="fh5co-menu-wrap" role="navigation">
                                        <ul class="sf-menu" id="fh5co-primary-menu">
                                            <li><a href="parametragemail.jsp">Paramétrage des mails</a></li>
                                            <li><a  href="GestionClient">Gérer Clients</a></li>
                                            <li><a  href="inscriptionrapide.jsp">Inscrire Client</a></li>
                                            <li><a  href="AdminCreateCat.jsp">Ajouter catégorie</a></li>
                                            <li><a href="AdminCreateProTpe.jsp">Ajouter Programme</a></li>
                                            <li>
                                            <a class="fh5co-sub-ddown">Déconnecter</a>
                                            <ul class="fh5co-sub-menu">
                                                <li><a href="index.jsp">Déconnecter</a></li>
                                            </ul>
                                        </li>
                                        </ul>
                                    </nav>
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
                                            <h1 class="text-center">Administration</h1>
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
                                            <span><a><%=changementmail%></a></span>
                                        </div>
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
        </body>
    </html>
</f:view>
