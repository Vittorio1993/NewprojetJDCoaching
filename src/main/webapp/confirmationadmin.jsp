<%-- 
    Document   : confirmationadmin.jsp
    Created on : 1 avr. 2018, 21:22:54
    Author     : RHAW
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
            <title>Confirmation</title>
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
			<div class="fh5co-overlay"></div>
                    <div class="fh5co-cover" data-stellar-background-ratio="0.5" style="background-color: black">
                        <div class="desc animate-box">		
                            <div class="container">
                                <div class="row">
                                    <%
                                    String changement="";
                                    if(request.getAttribute("ChangementOK") != null) { 
                                        changement = (String) request.getAttribute("ChangementOK");
                                    }
                                    %>
                                    <h1>Le changement de statut du client à <%=changement%> a été pris en compte.</h1>
                                    <span><a href="GestionClient">Retour à la gestion des clients</a></span>
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
