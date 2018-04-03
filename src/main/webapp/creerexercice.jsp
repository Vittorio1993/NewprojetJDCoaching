
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="database.Bd"%>
<%@page import="model.Utilisateur"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Fitness &mdash; 100% Free Fully Responsive HTML5 Template by FREEHTML5.co</title>
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
        <script type="text/JavaScript" src="js/fctxml.js"></script>
        <!-- FOR IE9 below -->
        <!--[if lt IE 9]>
        <script src="js/respond.min.js"></script>
        <![endif]-->

    </head>
    <body>
        <div id="fh5co-wrapper">
            <div id="fh5co-page">
                <div id="fh5co-header">
                    <header id="fh5co-header-section">
                        <div class="container">
                            <div class="nav-header">
                                <a href="#" class="js-fh5co-nav-toggle fh5co-nav-toggle"><i></i></a>
                                <h1 id="fh5co-logo"><a href="index.html">Fit<span>ness</span></a></h1>
                                <!-- START #fh5co-menu-wrap -->
                                <nav id="fh5co-menu-wrap" role="navigation">
                                    <ul class="sf-menu" id="fh5co-primary-menu">
                                        <li><a href="index.html">Home</a></li>
                                        <li><a href="profil.html">Mon profil</a></li>
                                        <li><a href="schedule.html">Schedule</a></li>
                                        <li><a href="trainer.html">Trainers</a></li>
                                        <li><a href="about.html">About</a></li>
                                        <li class="active"><a href="contact.html">Contact</a></li>
                                    </ul>
                                </nav>
                            </div>
                        </div>
                    </header>		
                </div>
                <!-- end:fh5co-header -->
                <div class="fh5co-parallax" style="background-image: url(images/home-image-3.jpg);" data-stellar-background-ratio="0.5">
                    <div class="overlay"></div>
                    <div class="container">
                        <div class="row">
                            <div class="col-md-8 col-md-offset-2 col-sm-12 col-sm-offset-0 col-xs-12 col-xs-offset-0 text-center fh5co-table">
                                <div class="fh5co-intro fh5co-table-cell animate-box">
                                    <h1 class="text-center">Mon profil</h1>
                                    <p>Gagner en forme, gagner du temps...</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div><!-- end: fh5co-parallax -->
                <!-- end:fh5co-hero -->
                <form action="profilsportif">
                    <div id="fh5co-contact">
                        <div class="container">
                            <!-- Profil de base -->
                            <div class="row">
                                <div class="col-md-8 col-md-offset-2">
                                    <div class="heading-section text-center animate-box">
                                        <h2>Créer ou modifier l'exercice</h2>
                                    </div>
                                </div>
                            </div>


                            <div class="row">
                                <!-- 1ere colonne -->
                                <div class="col-md-6 animate-box">
                                    <div class="row">
                                        <table>

                                        </table>

                                        <%
        Bd b = new Bd();
        ArrayList<String> arrayex = new ArrayList<String>();
        arrayex = b.nomexercise();
        
        for (String nom:arrayex){
        out.print("<input type='radio' name='exercice' value='"+nom+"'onclick ='l_afficherexercice()'>"+"&nbsp&nbsp"+nom+"<br>");
    }
    
        //System.out.println(u.getNomu());
                             
                                        %>

                                        <input type='radio' name='exercice' value='"+nom+"'onclick ="l_afficherexercice()">nom
                                    </div>
                                </div>
                                <!-- 2ere colonne -->
                                <div class="col-md-6 animate-box">
                                    <div class="row">
                                        <!-- Nom Exercice -->
                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <p>Nom Exercice :</p>
                                            </div>
                                        </div>
                                        <div class="col-md-9">
                                            <div class="form-group">
                                                <input type="text" id ="name" class="form-control" name="nome" value="">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <!-- Description -->
                                        <div class="col-md-5">
                                            <div class="form-group">
                                                <p>Description :</p>
                                            </div>
                                        </div>
                                        <div class="col-md-7">
                                            <div class="form-group">
                                                <input type="text" id="descripition" class="form-control" name="description" value="">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <!-- Temps de répetition -->
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <p>Temps de répetition :</p>
                                            </div>
                                        </div>
                                        <div class="col-md-8">
                                            <div class="form-group">
                                                <input type="text" id="tempsrepetition" class="form-control" name="tempsrepetition" value="">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <!-- Nombre de répetition  -->
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <p>Nombre de répetition :</p>
                                            </div>
                                        </div>
                                        <div class="col-md-8">
                                            <div class="form-group">
                                                <input type="text" id="nbrepetition" class="form-control" name="nbrepetition" value="">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <!-- Nombre de répetition  -->
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <p>Lien image :</p>
                                            </div>
                                        </div>
                                        <div class="col-md-8">
                                            <div class="form-group">
                                                <input type="text" id="lienimage" class="form-control" name="lienimage" value="">
                                            </div>
                                        </div>
                                    </div>
                                    <input type="submit" value="Enregistrer" class="btn btn-primary">
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--测试用--></div>

        </form><!--测试用-->







        <!-- END Profil de base -->
        <footer>
            <div id="footer">
                <div class="container">
                    <div class="row">
                        <div class="col-md-4 animate-box">
                            <h3 class="section-title">About Us</h3>
                            <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics.</p>
                        </div>

                        <div class="col-md-4 animate-box">
                            <h3 class="section-title">Our Address</h3>
                            <ul class="contact-info">
                                <li><i class="icon-map-marker"></i>198 West 21th Street, Suite 721 New York NY 10016</li>
                                <li><i class="icon-phone"></i>+ 1235 2355 98</li>
                                <li><i class="icon-envelope"></i><a href="#">info@yoursite.com</a></li>
                                <li><i class="icon-globe2"></i><a href="#">www.yoursite.com</a></li>
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
                            <p>Copyright 2016 Free Html5 <a href="#">Fitness</a>. All Rights Reserved. <br>Made with <i class="icon-heart3"></i> by <a href="#/" target="_blank">Freehtml5</a> / More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></p>
                        </div>
                    </div>
                </div>
            </div>
        </footer>


    </div>
    <!-- END fh5co-page -->

</div>
<!-- END fh5co-wrapper -->

<!-- jQuery -->


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
<!-- Google Map -->
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCefOgb1ZWqYtj7raVSmN4PL2WkTrc-KyA&sensor=false"></script>
<script src="js/google_map.js"></script>

<!-- Main JS (Do not remove) -->
<script src="js/main.js"></script>


</body>
</html>

