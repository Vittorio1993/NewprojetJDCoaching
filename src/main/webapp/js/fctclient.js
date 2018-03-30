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
 * Cette méthode "Ajax" permet l'affichage des informations clients
 */
function l_information()

{
    var v1 = document.getElementById("mail").value;
    var v2 = document.getElementById("password").value;
    var xhr = getXMLHttpRequest();

    xhr.onreadystatechange = function ()
    {

        // Si l'on a tout reçu et que la requête http s'est bien passée.
        if (xhr.readyState === 4 && xhr.status === 200)
        {

            var xml = xhr.responseXML;
            var noeudNom = xml.getElementsByTagName("message");
            var elt = document.getElementById("messageconnexion");
            var texte = noeudNom[0].firstChild.nodeValue;
          
            if (texte === "yes") {
                
                window.location.href = "accueilclient.jsp";
            }else if(texte === "non"){
                
                window.location.href = "pageadmin.jsp";
            }else if(texte === "yn"){
                
                window.location.href = "#";
            }else {
                elt.innerHTML = texte;
            }



        }
    };

    // Requête au serveur avec les paramètres éventuels.
    xhr.open("GET", "/connexion?mail=" + v1 + "&password=" + v2, true);
    xhr.send(null);

}