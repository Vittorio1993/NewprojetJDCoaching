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
 * Cette méthode "Ajax" affiche le message de connexion
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

        // Si l'on a tout reçu et que la requête http s'est bien passée.
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

    // Requête au serveur avec les paramètres éventuels.
    xhr.open("GET", "/inscription?nom=" + v1 + "&prenom=" + v2 + "&date=" + v3 + "&mail=" + v4 + "&tel=" + v5 + "&password=" + v6 + "&objectif=" + v7, true);
    xhr.send(null);

}




/**
 * Cette méthode "Ajax" affiche le message de connexion
 */
function l_connexion()

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
            } else if (texte === "non") {

                window.location.href = "pageadmin.jsp";
            } else if (texte === "yn") {

                window.location.href = "#";
            } else {
                elt.innerHTML = texte;
            }
        }
    };

    // Requête au serveur avec les paramètres éventuels.
    xhr.open("GET", "/connexion?mail=" + v1 + "&password=" + v2, true);
    xhr.send(null);

}

/**
 * Cette méthode "Ajax" affiche le message de connexion
 */
function l_afficherexercice() {

    var radio = document.getElementsByName("exercice");

    var selectvalue = null;   //  selectvalue?radio?????

    for (var i = 0; i < radio.length; i++) {

        if (radio[i].checked === true) {

            selectvalue = radio[i].value;

            break;

        }

    }

    var xhr = getXMLHttpRequest();
    xhr.open("GET", "/informationexercice?nome=" + selectvalue, true);
    xhr.send(null);


    xhr.onreadystatechange = function ()
    {

        // Si l'on a tout reçu et que la requête http s'est bien passée.
        if (xhr.readyState === 4 && xhr.status === 200)
        {

            var xml = xhr.responseXML;
            var noeudNom1 = xml.getElementsByTagName("libellee");
            var libellee = noeudNom1[0].firstChild.nodeValue;

            var noeudNom2 = xml.getElementsByTagName("description");
            var description = noeudNom2[0].firstChild.nodeValue;

            var noeudNom3 = xml.getElementsByTagName("tempsrepetition");
            var tempsrepetition = noeudNom3[0].firstChild.nodeValue;

            var noeudNom4 = xml.getElementsByTagName("repete");
            var nbrepetition = noeudNom4[0].firstChild.nodeValue;

            var noeudNom5 = xml.getElementsByTagName("lienimage");
            var lienimage = noeudNom5[0].firstChild.nodeValue;


            var nome1 = document.getElementById("nome");
            var description1 = document.getElementById("description");
            var tempsrepetition1 = document.getElementById("tempsrepetition");
            var nbrepetition1 = document.getElementById("nbrepetition");
            var lienimage1 = document.getElementById("lienimage");

            nome1.value = libellee;
            description1.value = description;
            tempsrepetition1.value = tempsrepetition;
            nbrepetition1.value = nbrepetition;
            lienimage1.value = lienimage;
        }
    };


}





