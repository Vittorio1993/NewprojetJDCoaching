/**
 * M�thode qui retourne l'objet XMLHttpRequest en fonction du navigateur.
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

    // XMLHttpRequest non support�.
    else
    {
        alert("Votre navigateur ne supporte pas l'objet XmlHttpRequest.");
        xhr = false;
    }

    return xhr;
}

/**
 * Cette m�thode "Ajax" permet l'affichage des prospects
 */
function l_prospects() {
    var xhr = getXMLHttpRequest();
    
    xhr.onreadystatechange = function ()
    {
        // Si l'on a tout re�u et que la requ�te http s'est bien pass�e.
        if (xhr.readyState === 4 && xhr.status === 200) {
            var l_prospect = document.getElementById("lprospects");
            l_prospect.innerHTML="";
            var xml = xhr.responseXML;
            var users = xml.getElementsByTagName("NomU");         
            if (!(l_prospect.children.length > 1)) {
                for (var i = 0; i < users.length; i++) {
                    l_prospect.innerHTML=l_prospect.innerHTML
                            + "<option value="+xhr.responseXML.getElementsByTagName("CodeU")[i].firstChild.nodeValue+">"
                            + xhr.responseXML.getElementsByTagName("NomU")[i].firstChild.nodeValue
                            + "--"
                            + xhr.responseXML.getElementsByTagName("PrenomU")[i].firstChild.nodeValue
                            + "--"
                            + xhr.responseXML.getElementsByTagName("MailU")[i].firstChild.nodeValue
                            +"</option> ";
                }
            }
        }
    };

    // Requ�te au serveur avec les param�tres �ventuels.
    xhr.open("GET", "GestionProspects", true);
    xhr.send(null);

}

/**
 * Cette m�thode "Ajax" permet l'affichage des informations des clients
 */
function l_informations(value) {
    var xhr = getXMLHttpRequest();
    var codeu = document.getElementById(value).value;
    xhr.onreadystatechange = function ()
    {
        // Si l'on a tout re�u et que la requ�te http s'est bien pass�e.
        if (xhr.readyState === 4 && xhr.status === 200) {
            alert(value);
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
                    informations.innerHTML="<table class='table table-bordered'><tr><td>Nom</td><td>Pr�nom</td><td>Adresse e-mail</td><td>Num�ro de t�l�phone</td><td>Date de naissance</td><td>Objectif</td></tr><tr>"                                    
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

    // Requ�te au serveur avec les param�tres �ventuels.
    xhr.open("GET", "InformationsClient?codeu=" + codeu, true);
    xhr.send(null);

}

/**
 * Cette m�thode "Ajax" permet de passer un prospect en attente
 */
function l_attente() {
    var xhr = getXMLHttpRequest();
    xhr.onreadystatechange = function ()
    {
        // Si l'on a tout re�u et que la requ�te http s'est bien pass�e.
        if (xhr.readyState === 4 && xhr.status === 200) {
           
        }
    };

    // Requ�te au serveur avec les param�tres �ventuels.
    xhr.open("GET", "InformationsClient?codeu=" + codeu, true);
    xhr.send(null);

}

/**
 * Cette m�thode "Ajax" permet de valider 
 */
function l_valider() {
    var xhr = getXMLHttpRequest();
    xhr.onreadystatechange = function ()
    {
        // Si l'on a tout re�u et que la requ�te http s'est bien pass�e.
        if (xhr.readyState === 4 && xhr.status === 200) {
           
        }
    };

    // Requ�te au serveur avec les param�tres �ventuels.
    xhr.open("GET", "InformationsClient?codeu=" + codeu, true);
    xhr.send(null);

}

/**
 * Cette m�thode "Ajax" permet l'affichage des clients en attente
 */
function l_enattente() {
    var xhr = getXMLHttpRequest();
    
    xhr.onreadystatechange = function ()
    {
        // Si l'on a tout re�u et que la requ�te http s'est bien pass�e.
        if (xhr.readyState === 4 && xhr.status === 200) {
            var l_prospect = document.getElementById("lenattente");
            l_prospect.innerHTML="";
            var xml = xhr.responseXML;
            var users = xml.getElementsByTagName("NomU");         
            if (!(l_prospect.children.length > 1)) {
                for (var i = 0; i < users.length; i++) {
                    l_prospect.innerHTML=l_prospect.innerHTML
                            + "<option value="+xhr.responseXML.getElementsByTagName("CodeU")[i].firstChild.nodeValue+">"
                            + xhr.responseXML.getElementsByTagName("NomU")[i].firstChild.nodeValue
                            + "--"
                            + xhr.responseXML.getElementsByTagName("PrenomU")[i].firstChild.nodeValue
                            + "--"
                            + xhr.responseXML.getElementsByTagName("MailU")[i].firstChild.nodeValue
                            +"</option> ";
                }
            }
        }
    };

    // Requ�te au serveur avec les param�tres �ventuels.
    xhr.open("GET", "GestionEnAttente", true);
    xhr.send(null);

}

/**
 * Cette m�thode "Ajax" permet l'affichage des clients valid�s
 */
function l_valides() {
    var xhr = getXMLHttpRequest();
    
    xhr.onreadystatechange = function ()
    {
        // Si l'on a tout re�u et que la requ�te http s'est bien pass�e.
        if (xhr.readyState === 4 && xhr.status === 200) {
            var l_prospect = document.getElementById("lvalides");
            l_prospect.innerHTML="";
            var xml = xhr.responseXML;
            var users = xml.getElementsByTagName("NomU");         
            if (!(l_prospect.children.length > 1)) {
                for (var i = 0; i < users.length; i++) {
                    l_prospect.innerHTML=l_prospect.innerHTML
                            + "<option value="+xhr.responseXML.getElementsByTagName("CodeU")[i].firstChild.nodeValue+">"
                            + xhr.responseXML.getElementsByTagName("NomU")[i].firstChild.nodeValue
                            + "--"
                            + xhr.responseXML.getElementsByTagName("PrenomU")[i].firstChild.nodeValue
                            + "--"
                            + xhr.responseXML.getElementsByTagName("MailU")[i].firstChild.nodeValue
                            +"</option> ";
                }
            }
        }
    };

    // Requ�te au serveur avec les param�tres �ventuels.
    xhr.open("GET", "GestionValides", true);
    xhr.send(null);

}

/**
 * Cette m�thode "Ajax" permet de charger la gestion client
 */
function gestion_client() {

    //l_prospects();
    //l_enattente();
    l_valides();
    
}