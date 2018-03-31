/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import database.Bd;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "GestionValides", urlPatterns = {"/GestionValides"})
public class GestionValides extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Utilisateur> lutilisateurs = new ArrayList();
        //Lecture de la requ�te en UTF-8
        request.setCharacterEncoding("UTF-8");
        //Type de la r�ponse
        response.setContentType("application/xml;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        //Ecriture de la page XML
        out.println("<?xml version=\"1.0\"?>");
        out.println("<liste_valides>");

        //R�cup�ration des utilisateurs en attente
        try {
            lutilisateurs = Bd.getUtilisateurs();
            //Ajout des utilisateurs en attente dans l'ArrayList
            for (Utilisateur u : lutilisateurs) {
                if ("Valid�".equals(u.getStatus())) {
                    out.println("<CodeU>" + u.getCodeu() + "</CodeU>");
                    out.println("<NomU>" + u.getNomu() + "</NomU>");
                    out.println("<PrenomU>" + u.getPrenomu() + "</PrenomU>");
                    out.println("<MailU>" + u.getEmailu() + "</MailU>");
                }
            }
        } catch (Exception ex) {
            out.println("<erreur>Erreur - "
                    + ex.getMessage() + "</erreur>");
        }
        out.println("</liste_valides>");
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException,
            IOException {
                doGet(request, response);
    }
}

