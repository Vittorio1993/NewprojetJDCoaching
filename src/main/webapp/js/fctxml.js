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
 * Cette m�thode "Ajax" affiche le message de connexion
 */
function l_inscription()

{
    var v1 = document.getElementById("nom").value;
    var v2 = document.getElementById("prenom").value;
    var v3 = document.getElementById("date").value;
    var v4 = document.getElementById("mail").value;
    var v5 = document.getElementById("tel").value;
    var v6 = document.getElementById("password").value;
    var v7 = document.getElementById("objectif").options[document.getElementById("objectif").selectedIndex].value;

    var xhr = getXMLHttpRequest();

    xhr.onreadystatechange = function ()
    {

        // Si l'on a tout re�u et que la requ�te http s'est bien pass�e.
        if (xhr.readyState === 4 && xhr.status === 200)
        {

            var xml = xhr.responseXML;
            var noeudNom = xml.getElementsByTagName("message");
            var elt = document.getElementById("messageinscription");
            var texte = noeudNom[0].firstChild.nodeValue;
          

            //alert(v7);
            if (texte === "yes") {
                window.location.href = "connexion.html";
            } else {
                elt.innerHTML = texte;
            }
        }
    };

    // Requ�te au serveur avec les param�tres �ventuels.
    xhr.open("GET", "/inscription?nom=" + v1 + "&prenom=" + v2 + "&date=" + v3 + "&mail=" + v4 + "&tel=" + v5 + "&password=" + v6+ "&objectif=" + v7, true);
    xhr.send(null);

}




/**
 * Cette m�thode "Ajax" affiche le message de connexion
 */
function l_connexion()

{
    var v1 = document.getElementById("mail").value;
    var v2 = document.getElementById("password").value;
    var xhr = getXMLHttpRequest();

    xhr.onreadystatechange = function ()
    {

        // Si l'on a tout re�u et que la requ�te http s'est bien pass�e.
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

    // Requ�te au serveur avec les param�tres �ventuels.
    xhr.open("GET", "/connexion?mail=" + v1 + "&password=" + v2, true);
    xhr.send(null);

}