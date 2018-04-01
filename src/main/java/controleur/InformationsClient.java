/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import database.Bd;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Utilisateur;
/**
 *
 * @author RHAW
 */
@WebServlet(name = "InformationsClient", urlPatterns = {"/InformationsClient"})
public class InformationsClient extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        Utilisateur utilisateur = null;
        //Lecture de la requête en UTF-8
        request.setCharacterEncoding("UTF-8");
        //Type de la réponse
        response.setContentType("application/xml;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        String codeu = request.getParameter("codeu");
        PrintWriter out = response.getWriter();
        //Ecriture de la page XML
        out.println("<?xml version=\"1.0\"?>");
        out.println("<liste_informations>");

        //Récupération des utilisateurs en attente
        try {
            utilisateur = Bd.getUser(codeu);
            out.println("<CodeU>" + utilisateur.getCodeu() + "</CodeU>");
            out.println("<NomU>" + utilisateur.getNomu() + "</NomU>");
            out.println("<PrenomU>" + utilisateur.getPrenomu() + "</PrenomU>");
            out.println("<MailU>" + utilisateur.getEmailu() + "</MailU>");
            out.println("<TelU>" + utilisateur.getTelu() + "</TelU>");
            out.println("<DatedeNaissanceU>" + utilisateur.getDatenaissanceu() + "</DatedeNaissanceU>");
            out.println("<ObjectifU>" + utilisateur.getObjectif() + "</ObjectifU>");
        } catch (Exception ex) {
            out.println("<erreur>Erreur - "
                    + ex.getMessage() + "</erreur>");
        }
        out.println("</liste_informations>");
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException,
            IOException {
                doGet(request, response);
    }
}
