
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html class="no-js"> <!--<![endif]-->
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
                                <h1 id="fh5co-logo"><a href="index.jsp">JDC<span>oaching</span></a></h1>
                                <!-- START #fh5co-menu-wrap -->
                                <nav id="fh5co-menu-wrap" role="navigation">
                                    <ul class="sf-menu" id="fh5co-primary-menu">
                                        <li class="active">
                                            <a href="accueilclient.jsp">Home</a>
                                        </li>
                                        <li>
                                            <a class="fh5co-sub-ddown">Déconnecter</a>
                                            <ul class="fh5co-sub-menu">
                                                <li><a href="index.jsp">Déconnecter</a></li>
                                            </ul>
                                        </li>
                                        <li>
                                            <a href="#programme">Programme</a>
                                        </li>
                                        <li><a href="#seance">Séance</a></li>
                                        <li><a href="gestionexercice.jsp">Exercice</a></li>
                                    </ul>
                                </nav>
                            </div>
                        </div>
                    </header>		
                </div>
                <!-- end:fh5co-header -->
                <div class="fh5co-hero">
                    <div class="fh5co-overlay"></div>
                    <div class="fh5co-cover" data-stellar-background-ratio="0.5" style="background-image: url(images/home-image.jpg);">
                        <div class="desc animate-box">
                            <div class="container">
                                <div class="row">
                                    <div class="col-md-7">
                                        <%
                                            out.print("<h2>Bienvenue <br><b>"+(String)session.getAttribute("mail")+"</b></h2>");
                                        %>
                                        
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="copyrights">Collect from <a href="http://www.cssmoban.com/" >ä¼ä¸ç½ç«æ¨¡æ¿</a></div>
                <!-- end:fh5co-hero -->
                <div id="fh5co-schedule-section" class="fh5co-lightgray-section">
                    <div class="container" id="seance">
                        <div class="row">
                            <div class="col-md-8 col-md-offset-2">
                                <div class="heading-section text-center animate-box">
                                    <h2>Séance</h2>
                                    <p>Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean.</p>
                                </div>
                            </div>
                        </div>
                        <div class="row animate-box">
                            <div class="col-md-10 col-md-offset-1 text-center">
                                <ul class="schedule">
                                    <li><a href="#" class="active" data-sched="sunday">Sunday</a></li>
                                    <li><a href="#" data-sched="monday">Monday</a></li>
                                    <li><a href="#" data-sched="tuesday">Tuesday</a></li>
                                    <li><a href="#" data-sched="wednesday">Wednesday</a></li>
                                    <li><a href="#" data-sched="thursday">Thursday</a></li>
                                    <li><a href="#" data-sched="monday">Monday</a></li>
                                    <li><a href="#" data-sched="saturday">Saturday</a></li>
                                </ul>
                            </div>
                            <div class="row text-center">

                                <div class="col-md-12 schedule-container">

                                    <div class="schedule-content active" data-day="sunday">
                                        <div class="col-md-3 col-sm-6">
                                            <div class="program program-schedule">
                                                <img src="images/fit-dumbell.svg" alt="Cycling">
                                                <small>06AM-7AM</small>
                                                <h3>Body Building</h3>
                                                <span>John Doe</span>
                                            </div>
                                        </div>
                                        <div class="col-md-3 col-sm-6">
                                            <div class="program program-schedule">
                                                <img src="images/fit-yoga.svg" alt="">
                                                <small>06AM-7AM</small>
                                                <h3>Yoga Programs</h3>
                                                <span>James Smith</span>
                                            </div>
                                        </div>
                                        <div class="col-md-3 col-sm-6">
                                            <div class="program program-schedule">
                                                <img src="images/fit-cycling.svg" alt="">
                                                <small>06AM-7AM</small>
                                                <h3>Cycling Program</h3>
                                                <span>Rita Doe</span>
                                            </div>
                                        </div>
                                        <div class="col-md-3 col-sm-6">
                                            <div class="program program-schedule">
                                                <img src="images/fit-boxing.svg" alt="Cycling">
                                                <small>06AM-7AM</small>
                                                <h3>Boxing Fitness</h3>
                                                <span>John Dose</span>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- END sched-content -->

                                    <div class="schedule-content" data-day="monday">
                                        <div class="col-md-3 col-sm-6">
                                            <div class="program program-schedule">
                                                <img src="images/fit-yoga.svg" alt="">
                                                <small>06AM-7AM</small>
                                                <h3>Yoga Programs</h3>
                                                <span>James Smith</span>
                                            </div>
                                        </div>
                                        <div class="col-md-3 col-sm-6">
                                            <div class="program program-schedule">
                                                <img src="images/fit-dumbell.svg" alt="Cycling">
                                                <small>06AM-7AM</small>
                                                <h3>Body Building</h3>
                                                <span>John Doe</span>
                                            </div>
                                        </div>
                                        <div class="col-md-3 col-sm-6">
                                            <div class="program program-schedule">
                                                <img src="images/fit-boxing.svg" alt="Cycling">
                                                <small>06AM-7AM</small>
                                                <h3>Boxing Fitness</h3>
                                                <span>John Dose</span>
                                            </div>
                                        </div>
                                        <div class="col-md-3 col-sm-6">
                                            <div class="program program-schedule">
                                                <img src="images/fit-cycling.svg" alt="">
                                                <small>06AM-7AM</small>
                                                <h3>Cycling Program</h3>
                                                <span>Rita Doe</span>
                                            </div>
                                        </div>

                                    </div>
                                    <!-- END sched-content -->

                                    <div class="schedule-content" data-day="tuesday">
                                        <div class="col-md-3 col-sm-6">
                                            <div class="program program-schedule">
                                                <img src="images/fit-dumbell.svg" alt="Cycling">
                                                <small>06AM-7AM</small>
                                                <h3>Body Building</h3>
                                                <span>John Doe</span>
                                            </div>
                                        </div>
                                        <div class="col-md-3 col-sm-6">
                                            <div class="program program-schedule">
                                                <img src="images/fit-yoga.svg" alt="">
                                                <small>06AM-7AM</small>
                                                <h3>Yoga Programs</h3>
                                                <span>James Smith</span>
                                            </div>
                                        </div>
                                        <div class="col-md-3 col-sm-6">
                                            <div class="program program-schedule">
                                                <img src="images/fit-cycling.svg" alt="">
                                                <small>06AM-7AM</small>
                                                <h3>Cycling Program</h3>
                                                <span>Rita Doe</span>
                                            </div>
                                        </div>
                                        <div class="col-md-3 col-sm-6">
                                            <div class="program program-schedule">
                                                <img src="images/fit-boxing.svg" alt="Cycling">
                                                <small>06AM-7AM</small>
                                                <h3>Boxing Fitness</h3>
                                                <span>John Dose</span>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- END sched-content -->

                                    <div class="schedule-content" data-day="wednesday">
                                        <div class="col-md-3 col-sm-6">
                                            <div class="program program-schedule">
                                                <img src="images/fit-yoga.svg" alt="">
                                                <small>06AM-7AM</small>
                                                <h3>Yoga Programs</h3>
                                                <span>James Smith</span>
                                            </div>
                                        </div>
                                        <div class="col-md-3 col-sm-6">
                                            <div class="program program-schedule">
                                                <img src="images/fit-dumbell.svg" alt="Cycling">
                                                <small>06AM-7AM</small>
                                                <h3>Body Building</h3>
                                                <span>John Doe</span>
                                            </div>
                                        </div>
                                        <div class="col-md-3 col-sm-6">
                                            <div class="program program-schedule">
                                                <img src="images/fit-boxing.svg" alt="Cycling">
                                                <small>06AM-7AM</small>
                                                <h3>Boxing Fitness</h3>
                                                <span>John Dose</span>
                                            </div>
                                        </div>
                                        <div class="col-md-3 col-sm-6">
                                            <div class="program program-schedule">
                                                <img src="images/fit-cycling.svg" alt="">
                                                <small>06AM-7AM</small>
                                                <h3>Cycling Program</h3>
                                                <span>Rita Doe</span>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- END sched-content -->

                                    <div class="schedule-content" data-day="thursday">
                                        <div class="col-md-3 col-sm-6">
                                            <div class="program program-schedule">
                                                <img src="images/fit-dumbell.svg" alt="Cycling">
                                                <small>06AM-7AM</small>
                                                <h3>Body Building</h3>
                                                <span>John Doe</span>
                                            </div>
                                        </div>
                                        <div class="col-md-3 col-sm-6">
                                            <div class="program program-schedule">
                                                <img src="images/fit-yoga.svg" alt="">
                                                <small>06AM-7AM</small>
                                                <h3>Yoga Programs</h3>
                                                <span>James Smith</span>
                                            </div>
                                        </div>
                                        <div class="col-md-3 col-sm-6">
                                            <div class="program program-schedule">
                                                <img src="images/fit-cycling.svg" alt="">
                                                <small>06AM-7AM</small>
                                                <h3>Cycling Program</h3>
                                                <span>Rita Doe</span>
                                            </div>
                                        </div>
                                        <div class="col-md-3 col-sm-6">
                                            <div class="program program-schedule">
                                                <img src="images/fit-boxing.svg" alt="Cycling">
                                                <small>06AM-7AM</small>
                                                <h3>Boxing Fitness</h3>
                                                <span>John Dose</span>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- END sched-content -->

                                    <div class="schedule-content" data-day="friday">
                                        <div class="col-md-3 col-sm-6">
                                            <div class="program program-schedule">
                                                <img src="images/fit-yoga.svg" alt="">
                                                <small>06AM-7AM</small>
                                                <h3>Yoga Programs</h3>
                                                <span>James Smith</span>
                                            </div>
                                        </div>
                                        <div class="col-md-3 col-sm-6">
                                            <div class="program program-schedule">
                                                <img src="images/fit-dumbell.svg" alt="Cycling">
                                                <small>06AM-7AM</small>
                                                <h3>Body Building</h3>
                                                <span>John Doe</span>
                                            </div>
                                        </div>
                                        <div class="col-md-3 col-sm-6">
                                            <div class="program program-schedule">
                                                <img src="images/fit-boxing.svg" alt="Cycling">
                                                <small>06AM-7AM</small>
                                                <h3>Boxing Fitness</h3>
                                                <span>John Dose</span>
                                            </div>
                                        </div>
                                        <div class="col-md-3 col-sm-6">
                                            <div class="program program-schedule">
                                                <img src="images/fit-cycling.svg" alt="">
                                                <small>06AM-7AM</small>
                                                <h3>Cycling Program</h3>
                                                <span>Rita Doe</span>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- END sched-content -->

                                    <div class="schedule-content" data-day="saturday">
                                        <div class="col-md-3 col-sm-6">
                                            <div class="program program-schedule">
                                                <img src="images/fit-dumbell.svg" alt="Cycling">
                                                <small>06AM-7AM</small>
                                                <h3>Body Building</h3>
                                                <span>John Doe</span>
                                            </div>
                                        </div>
                                        <div class="col-md-3 col-sm-6">
                                            <div class="program program-schedule">
                                                <img src="images/fit-yoga.svg" alt="">
                                                <small>06AM-7AM</small>
                                                <h3>Yoga Programs</h3>
                                                <span>James Smith</span>
                                            </div>
                                        </div>
                                        <div class="col-md-3 col-sm-6">
                                            <div class="program program-schedule">
                                                <img src="images/fit-cycling.svg" alt="">
                                                <small>06AM-7AM</small>
                                                <h3>Cycling Program</h3>
                                                <span>Rita Doe</span>
                                            </div>
                                        </div>
                                        <div class="col-md-3 col-sm-6">
                                            <div class="program program-schedule">
                                                <img src="images/fit-boxing.svg" alt="Cycling">
                                                <small>06AM-7AM</small>
                                                <h3>Boxing Fitness</h3>
                                                <span>John Dose</span>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- END sched-content -->
                                </div>


                            </div>
                        </div>
                    </div>
                </div>
                <div class="fh5co-parallax" style="background-image: url(images/home-image-3.jpg);" data-stellar-background-ratio="0.5">
                    <div class="overlay"></div>
                    <div class="container">
                        <div class="row">
                            <div class="col-md-8 col-md-offset-2 col-sm-12 col-sm-offset-0 col-xs-12 col-xs-offset-0 text-center fh5co-table">
                                <div class="fh5co-intro fh5co-table-cell animate-box">
                                    <h1 class="text-center">Commit To Be Fit</h1>
                                    <p>Made with love by the fine folks at <a href="#">Freehtml5</a></p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div><!-- end: fh5co-parallax -->
                <div id="fh5co-programs-section">
                    <div class="container" id="programme">
                        <div class="row">
                            <div class="col-md-8 col-md-offset-2">
                                <div class="heading-section text-center animate-box">
                                    <h2>Programmes</h2>
                                    <p>Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean.</p>
                                </div>
                            </div>
                        </div>
                        <div class="row text-center">
                            <div class="col-md-4 col-sm-6">
                                <div class="program animate-box">
                                    <img src="images/fit-dumbell.svg" alt="Cycling">
                                    <h3>Body Combat</h3>
                                    <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. </p>
                                    <span><a href="#" class="btn btn-default">Join Now</a></span>
                                </div>
                            </div>
                            <div class="col-md-4 col-sm-6">
                                <div class="program animate-box">
                                    <img src="images/fit-yoga.svg" alt="">
                                    <h3>Yoga Programs</h3>
                                    <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. </p>
                                    <span><a href="#" class="btn btn-default">Join Now</a></span>
                                </div>
                            </div>
                            <div class="col-md-4 col-sm-6">
                                <div class="program animate-box">
                                    <img src="images/fit-cycling.svg" alt="">
                                    <h3>Cycling Program</h3>
                                    <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. </p>
                                    <span><a href="#" class="btn btn-default">Join Now</a></span>
                                </div>
                            </div>
                            <div class="col-md-4 col-sm-6">
                                <div class="program animate-box">
                                    <img src="images/fit-boxing.svg" alt="Cycling">
                                    <h3>Boxing Fitness</h3>
                                    <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. </p>
                                    <span><a href="#" class="btn btn-default">Join Now</a></span>
                                </div>
                            </div>
                            <div class="col-md-4 col-sm-6">
                                <div class="program animate-box">
                                    <img src="images/fit-swimming.svg" alt="">
                                    <h3>Swimming Program</h3>
                                    <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. </p>
                                    <span><a href="#" class="btn btn-default">Join Now</a></span>
                                </div>
                            </div>
                            <div class="col-md-4 col-sm-6">
                                <div class="program animate-box">
                                    <img src="images/fit-massage.svg" alt="">
                                    <h3>Massage</h3>
                                    <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. </p>
                                    <span><a href="#" class="btn btn-default">Join Now</a></span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>




            <!-- fh5co-blog-section -->
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

    <!-- Main JS (Do not remove) -->
    <script src="js/main.js"></script>

</body>
</html>

