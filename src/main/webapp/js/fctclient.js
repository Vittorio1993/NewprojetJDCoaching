/**
 * Méthode qui retourne l'objet XMLHttpRequest en fonction du navigateur.
 */
function getXMLHttpRequest()
{
    var xhr = null;

    // Firefox et bien d'autres.
    if (window.XMLHttpRequest)
        xhr = new XMLHttpRequest();
    else

    // Internet Explorer.
    if (window.ActiveXObject)
    {
        try {
            xhr = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e)
        {
            xhr = new ActiveXObject("Microsoft.XMLHTTP");
        }
    }

    // XMLHttpRequest non supporté.
    else
    {
        alert("Votre navigateur ne supporte pas l'objet XmlHttpRequest.");
        xhr = false;
    }

    return xhr;
}

/**
 * Cette méthode "Ajax" permet l'affichage des informations des clients
 */
function l_informations(value) {
    var xhr = getXMLHttpRequest();
    var codeu = document.getElementById(value).value;
    xhr.onreadystatechange = function ()
    {
        // Si l'on a tout reçu et que la requête http s'est bien passée.
        if (xhr.readyState === 4 && xhr.status === 200) {
            if ("lprospects"===value){
                var informations = document.getElementById("linformationsprospects");
            } else if ("lenattente"===value){
                var informations = document.getElementById("linformationsattente");
            } else if ("lvalides"===value) {
                var informations = document.getElementById("linformationsvalides");
            }
            
            informations.innerHTML="";   
            var xml = xhr.responseXML;
            var users = xml.getElementsByTagName("CodeU");
                for (var i = 0; i < users.length; i++) {                   
                    informations.innerHTML="<table class='table table-bordered' style='color:black;'><tr><td>Nom</td><td>Prénom</td><td>Adresse e-mail</td><td>Numéro de téléphone</td><td>Date de naissance</td><td>Objectif</td></tr><tr>"                                    
                            + "<td>" + xhr.responseXML.getElementsByTagName("NomU")[i].firstChild.nodeValue
                            + "</td><td>" + xhr.responseXML.getElementsByTagName("PrenomU")[i].firstChild.nodeValue
                            + "</td><td>" + xhr.responseXML.getElementsByTagName("MailU")[i].firstChild.nodeValue
                            + "</td><td>" + xhr.responseXML.getElementsByTagName("TelU")[i].firstChild.nodeValue
                            + "</td><td>" + xhr.responseXML.getElementsByTagName("DatedeNaissanceU")[i].firstChild.nodeValue
                            + "</td><td>" + xhr.responseXML.getElementsByTagName("ObjectifU")[i].firstChild.nodeValue
                            + "</td></tr></table>";
                }
        }
    };

    // Requête au serveur avec les paramètres éventuels.
    xhr.open("GET", "InformationsClient?codeu=" + codeu, true);
    xhr.send(null);

}

/**
 * Cette méthode "Ajax" permet de passer un prospect en attente
 */
function l_enattente() {
    var xhr = getXMLHttpRequest();
    var codeu = document.getElementById("lprospects").value;
    xhr.onreadystatechange = function ()
    {
        // Si l'on a tout reçu et que la requête http s'est bien passée.
        if (xhr.readyState === 4 && xhr.status === 200)
        {
            window.location.href = "confirmationadmin.jsp";
        };
        
    };
        // Requête au serveur avec les paramètres éventuels.
        xhr.open("GET", "EnattenteServlet?codeu=" + codeu, true);
        xhr.send(null);
}

/**
 * Cette méthode "Ajax" permet de valider un client
 */
function l_valider(value) {
    var xhr = getXMLHttpRequest();
    var boutonvalue = document.getElementById(value);
    var codeu;
    if ("prospect"===boutonvalue) {
            codeu=document.getElementById("lprospects").value;
            } else {
                codeu=document.getElementById("lenattente").value;
            }
    xhr.onreadystatechange = function ()
    {
        // Si l'on a tout reçu et que la requête http s'est bien passée.
        if (xhr.readyState === 4 && xhr.status === 200)
        {
            window.location.href = "confirmationadmin.jsp";
        };
        
    };
    // Requête au serveur avec les paramètres éventuels.
    xhr.open("GET", "ValideServlet?codeu=" + codeu, true);
    xhr.send(null);

}

/**
 * Méthode "Ajax" permettant de changer le mail administrateur
 */
function changement_mail_admin() {
    var xhr = getXMLHttpRequest();
    var emailadmin = document.getElementById("mailadmin").value;
    xhr.onreadystatechange = function ()
    {
        // Si l'on a tout reçu et que la requête http s'est bien passée.
        if (xhr.readyState === 4 && xhr.status === 200)
        {
            window.location.href = "confirmationMailAdmin.jsp";
        };

    };
    // Requête au serveur avec les paramètres éventuels.
    xhr.open("GET", "ParametrageMailAdmin?emailadmin=" + emailadmin, true);
    xhr.send(null);

}

/**
 * Méthode "Ajax" permettant de changer le mail du coach
 */
function changement_mail_coach() {
    var xhr = getXMLHttpRequest();
    var emailcoach = document.getElementById("mailcoaching").value;
    xhr.onreadystatechange = function ()
    {
        // Si l'on a tout reçu et que la requête http s'est bien passée.
        if (xhr.readyState === 4 && xhr.status === 200)
        {
            window.location.href = "confirmationMailCoach.jsp";
        };

    };
    // Requête au serveur avec les paramètres éventuels.
    xhr.open("GET", "ParametrageMailCoach?emailcoach=" + emailcoach, true);
    xhr.send(null);

}