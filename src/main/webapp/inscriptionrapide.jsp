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
                                                    </div>
                                                    <!-- Profil sportif -->
                                                    <div class="row">
                                                        <div class="col-md-8 col-md-offset-2">
                                                            <div class="heading-section text-center animate-box">
                                                                <h2>Profil sportif :</h2>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <!-- 1ere colonne -->
                                                    <div class="col-md-6 animate-box">
                                                        <div class="row">

                                                            <!-- fc après 30 flexions complètes en 45 sec -->
                                                            <div class="col-md-3">
                                                                <div class="form-group">
                                                                    <p>fc après 30 flexions complètes en 45 sec :</p>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-9">
                                                                <div class="form-group">
                                                                    <input type="text" class="form-control" name="fcflexions" placeholder="fc après 30 flexions complètes en 45 sec" required>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <!-- 2ere colonne -->
                                                    <div class="col-md-6 animate-box">
                                                        <div class="row">
                                                            <!-- Fréquence cardiaque au repas -->
                                                            <div class="col-md-7">
                                                                <div class="form-group">
                                                                    <p>Fréquence cardiaque au repos :</p>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-5">
                                                                <div class="form-group">
                                                                    <input type="text" class="form-control" name="fcrepos" placeholder="fréquence" required>
                                                                </div>
                                                            </div>
                                                                  <!--fc 1 min après exercice allongée -->
                                                            <div class="col-md-3">
                                                                <div class="form-group">
                                                                    <p>fc 1 min après exercice allongée :</p>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-9">
                                                                <div class="form-group">
                                                                    <input type="text" class="form-control" name="fcallogee" placeholder="fc après 30 flexions complètes en 45 sec" required>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <!-- Bilan de performance -->
                                                <div class="container">
                                                    <div class="row">
                                                        <div class="col-md-8 col-md-offset-2">
                                                            <div class="heading-section text-left animate-box">
                                                                <h3>Bilan de performance</h3>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <!-- 1ere colonne -->
                                                    <div class="col-md-6 animate-box">
                                                        <div class="row">
                                                            <!-- Gainage -->
                                                            <div class="row">
                                                                <div class="col-md-6">
                                                                    <div class="form-group">
                                                                        <img src="images/gainage.png" alt="gainage" style="width: 100%;" />
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-6">
                                                                    <div class="form-group">
                                                                        <p>Gainage :</p>
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-5">
                                                                    <div class="form-group">
                                                                        <input type="text" class="form-control" name="gainage" placeholder="Gainage" required>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <!-- Fentes avant -->
                                                            <div class="row">
                                                                <div class="col-md-6">
                                                                    <div class="form-group">
                                                                        <img src="images/fentes_avant.png" alt="fentes avant" style="width: 100%;" />
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-6">
                                                                    <div class="form-group">
                                                                        <p>Fentes avant :</p>
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-5">
                                                                    <div class="form-group">
                                                                        <input type="text" class="form-control" name="jambegauche" placeholder="jambe gauche devant" required>
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-5">
                                                                    <div class="form-group">
                                                                        <input type="text" class="form-control" name="jambedroite" placeholder="jambe droite devant" required>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <!-- Crunch -->
                                                            <div class="row">
                                                                <div class="col-md-6">
                                                                    <div class="form-group">
                                                                        <img src="images/crunch.png" alt="crunch" style="width: 100%;" />
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-6">
                                                                    <div class="form-group">
                                                                        <p>Crunch :</p>
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-5">
                                                                    <div class="form-group">
                                                                        <input type="text" class="form-control" name="crunch" placeholder="Crunch" required>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <!-- 2ere colonne -->
                                                    <div class="col-md-6 animate-box">
                                                        <div class="row">
                                                            <!-- 1/2 pompes -->
                                                            <div class="row">
                                                                <div class="col-md-6">
                                                                    <div class="form-group">
                                                                        <img src="images/pompes.png" alt="pompes" style="width: 100%;" />
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-6">
                                                                    <div class="form-group">
                                                                        <p>1/2 pompes :</p>
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-5">
                                                                    <div class="form-group">
                                                                        <input type="text" class="form-control" name="pompes" placeholder="1/2 pompes" required>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <!-- 1/2 squat -->
                                                            <div class="row">
                                                                <div class="col-md-6">
                                                                    <div class="form-group">
                                                                        <img src="images/squat.png" alt="squat" style="width: 100%;" />
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-6">
                                                                    <div class="form-group">
                                                                        <p>1/2 squat :</p>
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-5">
                                                                    <div class="form-group">
                                                                        <input type="text" class="form-control" name="squat" placeholder="1/2 squat" required>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <!-- Dips -->
                                                            <div class="row">
                                                                <div class="col-md-6">
                                                                    <div class="form-group">
                                                                        <img src="images/dips.png" alt="dips" style="width: 100%;" />
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-6">
                                                                    <div class="form-group">
                                                                        <p>Dips :</p>
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-5">
                                                                    <div class="form-group">
                                                                        <input type="text" class="form-control" name="dips" placeholder="Dips" required>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                <div id="fh5co-contact">
                                                    <div class="container">
                                                        <div class="row">
                                                            <div class="col-md-8 col-md-offset-2">
                                                                <div class="heading-section text-left animate-box">
                                                                    <h3>Mensuration</h3>
                                                                    <p>A ne remplir que pour l'objectif minceur</p>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <!-- 1ere colonne -->
                                                        <div class="col-md-6 animate-box">
                                                            <div class="row">
                                                                <!-- Bras -->
                                                                <div class="col-md-3">
                                                                    <div class="form-group">
                                                                        <p>Bras :</p>
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-9">
                                                                    <div class="form-group">
                                                                        <input type="text" name="bras" class="form-control" placeholder="Bras" required>
                                                                    </div>
                                                                </div>
                                                                <!-- Poitrine -->
                                                                <div class="col-md-3">
                                                                    <div class="form-group">
                                                                        <p>Poitrine :</p>
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-9">
                                                                    <div class="form-group">
                                                                        <input type="text" class="form-control" name="poitrine" placeholder="Poitrine" required>
                                                                    </div>
                                                                </div>
                                                                <!-- Taille -->
                                                                <div class="col-md-3">
                                                                    <div class="form-group">
                                                                        <p>Taille :</p>
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-9">
                                                                    <div class="form-group">
                                                                        <input type="text" class="form-control" name="taille" placeholder="Taille" required>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <!-- 2ere colonne -->
                                                        <div class="col-md-6 animate-box">
                                                            <div class="row">
                                                                <!-- Hanches -->
                                                                <div class="col-md-3">
                                                                    <div class="form-group">
                                                                        <p>Hanches :</p>
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-9">
                                                                    <div class="form-group">
                                                                        <input type="text" class="form-control" name="hanches" placeholder="Hanches" required>
                                                                    </div>
                                                                </div>
                                                                <!-- Cuisses -->
                                                                <div class="col-md-3">
                                                                    <div class="form-group">
                                                                        <p>Cuisses :</p>
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-9">
                                                                    <div class="form-group">
                                                                        <input type="text" class="form-control" name="cuisses" placeholder="Cuisses" required>
                                                                    </div>
                                                                </div>
                                                                <!-- Poids -->
                                                                <div class="col-md-3">
                                                                    <div class="form-group">
                                                                        <p>Poids :</p>
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-9">
                                                                    <div class="form-group">
                                                                        <input type="text" class="form-control" name="poids" placeholder="Poids" required>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>

                                                <!-- Bouton enregistrer -->
                                                <div class="container">
                                                    <div class="col-md-12 animate-box">
                                                        <div class="row">
                                                            <div class="col-md-12">
                                                                <div class="form-group">
                                                                    <p style="text-align: center;">
                                                                        <input type="submit" value="Inscrire" class="btn btn-primary" onclick="l_inscription_rapide()">
                                                                    </p>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                                    <span><a href="pageadmin.jsp">Retour à la page d'administration</a></span>
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
