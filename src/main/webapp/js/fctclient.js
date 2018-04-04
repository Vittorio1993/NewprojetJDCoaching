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
 * Cette méthode "Ajax" permet l'affichage des commentaires sur les clients
 */
function l_commentaires(value) {
    var xhr = getXMLHttpRequest();
    var codeu = document.getElementById(value).value;
    xhr.onreadystatechange = function ()
    {
        // Si l'on a tout reçu et que la requête http s'est bien passée.
        if (xhr.readyState === 4 && xhr.status === 200) {
            if ("lprospects"===value){
                var commentaires = document.getElementById("linformationspersonnellesprospects");
            } else if ("lenattente"===value){
                var commentaires = document.getElementById("linformationspersonnellesattente");
            } else if ("lvalides"===value) {
                var commentaires = document.getElementById("linformationspersonnellesvalides");
            }
              
            var xml = xhr.responseXML;
            var coms = xml.getElementsByTagName("nuplet");
            commentaires.innerHTML ="";
            
            for (var i = 0; i < coms.length; i++) {
                commentaires.innerHTML = commentaires.innerHTML + "<table class='table table-bordered' style='color:black;'><tr><td>Commentaire</td><td>Date</td><td>Action</td></tr>"
                    + "<tr>"
                    + "<td>"
                    + xhr.responseXML.getElementsByTagName("ContenuCom")[i].firstChild.nodeValue
                    + "</td><td>"
                    + xhr.responseXML.getElementsByTagName("DateCom")[i].firstChild.nodeValue
                    + "</td>"
                    + "<td>"
                    + "<input class=\"btn btn-primary\"  id =\""
                    + xhr.responseXML.getElementsByTagName("CodeCom")[i].firstChild.nodeValue
                    + "\" type=\"submit\" value=\"Supprimer\" onclick=\"supprimer_com(this.id)\">"
                    + "</td>"
                    + "</tr>"
                    + "</table>"
                   
            }
            commentaires.innerHTML = commentaires.innerHTML
                    + "<br>"
                    + "<table style='border-collapse:separate;'>"
                        + "<tr>"
                            + "<td>"
                                + "Ajouter nouveau commentaire : "
                            + "</td>"
                            + "<td>"
                                + "<input id=\"ajoutcom"
                                + value
                                +"\""
                                + " type=\"text\" name=\"ajoutcom\""
                                + " style=\"color:black;\">"
                            + "</td>"
                        + "</tr>"
                        + "<tr>"
                            + "<td>"
                                + "<input class=\"btn btn-primary\" type=\"submit\" id=\"ajoutbtn"
                                + value
                                + "\""
                                +" value=\"Ajouter\" onclick=\"ajout_com("
                                + codeu
                                + ","
                                + "this.id)\">"
                            + "</td>"
                        + "</tr>"
                    + "</table>"
                    + "<br>";
        }
    };

    // Requête au serveur avec les paramètres éventuels.
    xhr.open("GET", "CommentairesClient?codeu=" + codeu, true);
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

/**
 * Affichage des informations clients
 */
function affichage_infos(value) {
    
    l_informations(value);
    l_commentaires(value);
};

/**
 * Suppression d'un commentaire sur un client
 */
function supprimer_com(value){
    var xhr = getXMLHttpRequest();
    var codecom = value;
    xhr.onreadystatechange = function ()
    {
        // Si l'on a tout reçu et que la requête http s'est bien passée.
        if (xhr.readyState === 4 && xhr.status === 200)
        {
            window.location.href = "confirmationSuppressionCommentaire.jsp";
        };
    };
    // Requête au serveur avec les paramètres éventuels.
    xhr.open("GET", "SuppressionCommentaireClient?codecom=" + codecom, true);
    xhr.send(null);

};

/**
 * Ajout d'un commentaire sur un client
 */
function ajout_com(value,input){
    var xhr = getXMLHttpRequest();
    var com;
    if ("ajoutbtnlprospects"===input) {
        com=document.getElementById("ajoutcomlprospects").value;
    } else if ("ajoutbtnlenattente"===input) {
        com=document.getElementById("ajoutcomlenattente").value;
    } else if ("ajoutbtnlvalides"===input) {
        com=document.getElementById("ajoutcomlvalides").value;
    }
    xhr.onreadystatechange = function ()  
    {
        // Si l'on a tout reçu et que la requête http s'est bien passée.
        if (xhr.readyState === 4 && xhr.status === 200)
        {
            if(com!==""){
                window.location.href = "confirmationAjoutCommentaire.jsp";
            }else {
                window.location.href = "GestionClient";
            };
        };
    };
    // Requête au serveur avec les paramètres éventuels.
    xhr.open("GET", "AjoutCommentaireClient?contenucom=" + com + "&codeu=" + value, true);
    xhr.send(null);

};

/**
 * Suppression d'un client
 */
function suppress_client(){
    var xhr = getXMLHttpRequest();
    var codeu=document.getElementById("lsuppression").value;
    xhr.onreadystatechange = function ()  
    {
        // Si l'on a tout reçu et que la requête http s'est bien passée.
        if (xhr.readyState === 4 && xhr.status === 200)
        {
            if(codeu!==""){
                window.location.href = "confirmationSuppressionClient.jsp";
            }else {
                window.location.href = "GestionClient";
            };
        };
    };
    // Requête au serveur avec les paramètres éventuels.
    xhr.open("GET", "SuppressionClient?codeu=" + codeu, true);
    xhr.send(null);

};

/**
 * Fonction permettant l'inscription rapide d'un utilisateur
 */
function l_inscription_rapide()

{
    var v1 = document.getElementById("nom").value;
    var v2 = document.getElementById("prenom").value;
    var v3 = document.getElementById("date").value;
    var v4 = document.getElementById("mail").value;
    var v5 = document.getElementById("tel").value;
    var v6 = document.getElementById("password").value;
    var v7 = document.getElementById("objectif").options[document.getElementById("objectif").selectedIndex].value;
    alert(v7);
    var xhr = getXMLHttpRequest();

    xhr.onreadystatechange = function ()
    {

        // Si l'on a tout reçu et que la requête http s'est bien passée.
        if (xhr.readyState === 4 && xhr.status === 200)
        {
            window.location.href = "pageadmin.jsp";
        }
    };

    // Requête au serveur avec les paramètres éventuels.
    xhr.open("GET", "InscriptionRapide?nom=" + v1 + "&prenom=" + v2 + "&date=" + v3 + "&mail=" + v4 + "&tel=" + v5 + "&password=" + v6 + "&objectif=" + v7, true);
    xhr.send(null);

}