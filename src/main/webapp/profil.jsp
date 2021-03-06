
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="database.Bd"%>
<%@page import="model.Utilisateur"%>
<%@page import="model.Mesuration"%>
<%@page import="model.Bilan"%>
<%@page import="model.Attacher"%>
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
                                <h1 id="fh5co-logo"><a href="index.html">JD<span>COACHING</span></a></h1>
                                <!-- START #fh5co-menu-wrap -->
                                <nav id="fh5co-menu-wrap" role="navigation">
                                    <ul class="sf-menu" id="fh5co-primary-menu">
                                        <li><a href="accueilclient.jsp">Home</a></li>
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
                <form action="profildebase">
                    <div id="fh5co-contact">
                        <div class="container">
                            <!-- Profil de base -->
                            <div class="row">
                                <div class="col-md-8 col-md-offset-2">
                                    <div class="heading-section text-center animate-box">
                                        <h2>Profil de base</h2>
                                    </div>
                                </div>
                            </div>
                            <%
        Bd b = new Bd();
        String mail = (String)session.getAttribute("mail");
        Utilisateur u = b.donneeUtilisateur(mail);
        //System.out.println(u.getNomu());
                             
                            %>


                            <div class="row">
                                <!-- 1ere colonne -->
                                <div class="col-md-6 animate-box">
                                    <div class="row">
                                        <!-- Nom -->
                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <p>Nom :</p>
                                            </div>
                                        </div>
                                        <div class="col-md-9">
                                            <div class="form-group">
                                                <% out.print("<input type='text' class='form-control' name='nom' value="+u.getNomu()+">");%>
                                            </div>
                                        </div>
                                        <!-- Telephone -->
                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <p>Téléphone :</p>
                                            </div>
                                        </div>
                                        <div class="col-md-9">
                                            <div class="form-group">
                                                <% out.print("<input type='text' class='form-control' name='tel' value="+u.getTelu()+">");%>
                                            </div>
                                        </div>
                                        <!-- Email -->
                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <p>Email :</p>
                                            </div>
                                        </div>
                                        <div class="col-md-9">
                                            <div class="form-group">
                                                <% out.print("<input type='text'  class='form-control' name='mail' disabled value="+u.getEmailu()+">");%>
                                            </div>
                                        </div>
                                        <!-- Objectif -->
                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <p>Objectif :</p>
                                            </div>
                                        </div>
                                        <div class="col-md-9">
                                            <div class="form-group">
                                                <% out.print("<input type='text' class='form-control' disabled value="+u.getObjectif()+">");%>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- 2ere colonne -->
                                <div class="col-md-6 animate-box">
                                    <div class="row">
                                        <!-- Prenom -->
                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <p>Prénom :</p>
                                            </div>
                                        </div>
                                        <div class="col-md-9">
                                            <div class="form-group">
                                                <% out.print("<input type='text' class='form-control' name='prenom' value="+u.getPrenomu()+">");%>
                                            </div>
                                        </div>
                                        <!-- Date de naissance -->
                                        <div class="col-md-5">
                                            <div class="form-group">
                                                <p>Date de naissance :</p>
                                            </div>
                                        </div>
                                        <div class="col-md-7">
                                            <div class="form-group">
                                                <% out.print("<input type='date' class='form-control' name='date' value="+u.getDatenaissanceu()+">");%>
                                            </div>
                                        </div>
                                        <!-- Mot de passe -->
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <p>Mot de passe :</p>
                                            </div>
                                        </div>
                                        <div class="col-md-8">
                                            <div class="form-group">
                                                <% out.print("<input type='text' class='form-control' name='password' value="+u.getPassword()+">");%>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </div>

                        </div>
                        <p style="text-align: center;">
                            <input type="submit" value="Enregistrer" class="btn btn-primary">
                        </p>
                        <!--测试用--></div>

                </form><!--测试用-->




                <%
                        
                       int codeu = Integer.parseInt(session.getAttribute("codeu").toString());
                       Bilan bi = b.donneeBilancondition(codeu);
                       int codebilan=bi.getCODEB();
                       //System.out.println(u.getNomu()); 
                %>
                <form action="profilcondition"><!--- 测试用-->
                    <!-- Profil condition -->
                    <div id="fh5co-contact">
                        <div class="container">
                            <div class="row">
                                <div class="col-md-8 col-md-offset-2">
                                    <div class="heading-section text-center animate-box">
                                        <h2>Profil condition</h2>
                                    </div>
                                </div>
                            </div>
                            <!-- 1ere colonne -->
                            <div class="col-md-6 animate-box">
                                <div class="row">
                                    <!-- Age -->
                                    <div class="col-md-3">
                                        <div class="form-group">
                                            <p>Age :</p>
                                        </div>
                                    </div>
                                    <div class="col-md-9">
                                        <div class="form-group">
                                            <% 
                                                String birthday = u.getDatenaissanceu();
                                                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                                                String cYear = sdf.format(new Date()).substring(0,4);
                                                String birthYear = birthday .substring(0,4);
                                                int age = Integer.parseInt(cYear) - Integer.parseInt(birthYear);
                                                out.print("<input type='text' class='form-control' disabled placeholder="+age+">");
                                            %>
                                        </div>
                                    </div>

                                    <!-- fc après 30 flexions complètes en 45 sec -->
                                    <div class="col-md-3">
                                        <div class="form-group">
                                            <p>fc après 30 flexions complètes en 45 sec :</p>
                                        </div>
                                    </div>
                                    <div class="col-md-9">
                                        <div class="form-group">
                                            <% out.print("<input type='text' class='form-control' name='fcflexions' value="+bi.getFCFLEXIONS()+">");%>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- 2ere colonne -->
                            <div class="col-md-6 animate-box">
                                <div class="row">
                                    <!-- Fréquence cardiaque au repos -->
                                    <div class="col-md-7">
                                        <div class="form-group">
                                            <p>Fréquence cardiaque au repos :</p>
                                        </div>
                                    </div>
                                    <div class="col-md-5">
                                        <div class="form-group">
                                            <% out.print("<input type='text' class='form-control' name='fcrepos' value="+bi.getFCREPOS()+">");%>
                                        </div>
                                    </div>
                                    <!-- Fréquence cardiaque cible -->
                                    <div class="col-md-7">
                                        <div class="form-group">
                                            <p>Fréquence cardiaque cible :</p>
                                        </div>
                                    </div>
                                    <div class="col-md-5">
                                        <div class="form-group">
                                            <input type="text" class="form-control" disabled placeholder="fréquence">
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
                                            <% out.print("<input type='text' class='form-control' name='fcallogee' value="+bi.getFCALLONGEE()+">");%>                                         
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <p style="text-align: center;">
                        <!--<input type="submit" value="Enregistrer" class="btn btn-primary">-->
                    </p>
                    </from>
                    <%
                       
                            String gainage = b.donneeBilanperformence(codebilan,4);
                             String pompes = b.donneeBilanperformence(codebilan,5);
                              String jambegauche = b.donneeBilanperformence(codebilan,6);
                               String jambedroite = b.donneeBilanperformence(codebilan,7);
                                String squat = b.donneeBilanperformence(codebilan,8);
                                 String crunch = b.donneeBilanperformence(codebilan,9);
                                  String dips = b.donneeBilanperformence(codebilan,10);
                           
                                                                
                            
                            //System.out.println(u.getNomu()); 
                    %>
                    <!-- Bilan de performance -->
                    <!--<form action="bilanperformance">-->

                        <div class="container">
                            <div class="row">
                                <div class="col-md-8 col-md-offset-2">
                                    <div class="heading-section text-left animate-box">
                                        <h3>Bilan de performance</h3>
                                        <p>Efectuer le maximum de répétitions ou tenir le plus longtemps possibles pour chaque exercice</p>
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
                                                <% out.print("<input type='text' class='form-control' name='gainage' value="+gainage+">");%>   

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
                                                <% out.print("<input type='text' class='form-control' name='jambegauche' value="+jambegauche+">");%>  

                                            </div>
                                        </div>
                                        <div class="col-md-5">
                                            <div class="form-group">
                                                <% out.print("<input type='text' class='form-control' name='jambedroite' value="+jambedroite+">");%>  
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
                                                <% out.print("<input type='text' class='form-control' name='crunch' value="+crunch+">");%>  

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
                                                <% out.print("<input type='text' class='form-control' name='pompes' value="+pompes+">");%>  

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
                                                <% out.print("<input type='text' class='form-control' name='squat' value="+squat+">");%> 

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
                                                <% out.print("<input type='text' class='form-control' name='dips' value="+dips+">");%> 

                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>
                        <p style="text-align: center;">
                            <input type="submit" value="Enregistrer" class="btn btn-primary">
                        </p>
                    </form>



                    <!-- Mensuration -->
                    <%
                       
        Mesuration m = b.donneeMesuration(codeu);
        //System.out.println(u.getNomu()); 
                    %>
                    <form action="mesuration"><!--- 测试用-->
                        <div id="fh5co-contact">
                            <div class="container">
                                <div class="row">
                                    <div class="col-md-8 col-md-offset-2">
                                        <div class="heading-section text-left animate-box">
                                            <h3>Mensuration</h3>
                                            <p>Remplissez que pour l'objectif minceur</p>
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
                                                <% out.print("<input type='text' class='form-control' name='bras' value="+m.getBRAS()+">");%>
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
                                                <% out.print("<input type='text' class='form-control' name='poitrine' value="+m.getPOITRINE()+">");%>

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
                                                <% out.print("<input type='text' class='form-control' name='taille' value="+m.getTAILLE()+">");%>                                            
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
                                                <% out.print("<input type='text' class='form-control' name='hanches' value="+m.getHANCHES()+">");%>
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
                                                <% out.print("<input type='text' class='form-control' name='cuisses' value="+m.getCUISSES()+">");%>                                               
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
                                                <% out.print("<input type='text' class='form-control' name='poids' value="+m.getPOIDS()+">");%>                                              
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
                                                <input type="submit" value="Enregistrer" class="btn btn-primary">
                                            </p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        </div>
                    </form>


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
        <!-- Google Map -->
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCefOgb1ZWqYtj7raVSmN4PL2WkTrc-KyA&sensor=false"></script>
        <script src="js/google_map.js"></script>

        <!-- Main JS (Do not remove) -->
        <script src="js/main.js"></script>

    </body>
</html>

