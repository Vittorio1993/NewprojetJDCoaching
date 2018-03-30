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
 * Cette méthode "Ajax" permet l'affichage des prospects
 */
function l_prospects() {
    var xhr = getXMLHttpRequest();
    
    xhr.onreadystatechange = function ()
    {
        // Si l'on a tout reçu et que la requête http s'est bien passée.
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

    // Requête au serveur avec les paramètres éventuels.
    xhr.open("GET", "GestionProspects", true);
    xhr.send(null);

}

/**
 * Cette méthode "Ajax" permet l'affichage des informations des prospects
 */
function l_informations() {
    var xhr = getXMLHttpRequest();
    var codeu = document.getElementById("lprospects").value;
    xhr.onreadystatechange = function ()
    {
        // Si l'on a tout reçu et que la requête http s'est bien passée.
        if (xhr.readyState === 4 && xhr.status === 200) {
            var informations = document.getElementById("linformations");
            informations.innerHTML="testt";
            //informations.innerHTML="<table class='table table-bordered'><tr><td>Nom</td><td>Prénom</td><td>Adresse e-mail</td><td>Numéro de téléphone</td><td>Date de naissance</td><td>Objectif</td></tr>";
            var xml = xhr.responseXML;
            var users = xml.getElementsByTagName("CodeU");         
            if (!(informations.children.length > 1)) {
                for (var i = 0; i < users.length; i++) {
                    informations.innerHTML=informations.innerHTML                          
                            + "<tr><td>" + xhr.responseXML.getElementsByTagName("NomU")[i].firstChild.nodeValue
                            + "</td><td>" + xhr.responseXML.getElementsByTagName("PrenomU")[i].firstChild.nodeValue
                            + "</td><td>" + xhr.responseXML.getElementsByTagName("MailU")[i].firstChild.nodeValue
                            + "</td><td>" + xhr.responseXML.getElementsByTagName("TelU")[i].firstChild.nodeValue
                            + "</td><td>" + xhr.responseXML.getElementsByTagName("DatedeNaissanceU")[i].firstChild.nodeValue
                            + "</td><td>" + xhr.responseXML.getElementsByTagName("ObjectifU")[i].firstChild.nodeValue
                            + "</td></tr>";
                }
            }
            informations.innerHTML="</table>";
        }
    };

    // Requête au serveur avec les paramètres éventuels.
    xhr.open("GET", "InformationsClient?codeu=" + codeu, true);
    xhr.send(null);

}