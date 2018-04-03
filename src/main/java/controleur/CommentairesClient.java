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
import model.Commentaire;
/**
 *
 * @author RHAW
 */
@WebServlet(name = "CommentairesClient", urlPatterns = {"/CommentairesClient"})
public class CommentairesClient extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Commentaire> coms = new ArrayList();
        //Lecture de la requête en UTF-8
        request.setCharacterEncoding("UTF-8");
        //Type de la réponse
        response.setContentType("application/xml;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        String codeu = request.getParameter("codeu");
        PrintWriter out = response.getWriter();
        //Ecriture de la page XML
        out.println("<?xml version=\"1.0\"?>");
        out.println("<liste_commentaires>");

        //Récupération des commentaires sur les utilisateurs
        try {
            coms = Bd.getCommentaires(codeu);
            for (Commentaire com : coms) {
                out.println("<CodeCom>" + com.getCodecom() + "</CodeCom>");
                out.println("<ContenuCom>" + com.getContenucom() + "</ContenuCom>");
                out.println("<DateCom>" + com.getDatecom() + "</DateCom>");
            }
        } catch (Exception ex) {
            out.println("<erreur>Erreur - "
                    + ex.getMessage() + "</erreur>");
        }
        out.println("</liste_commentaires>");
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException,
            IOException {
                doGet(request, response);
    }
}
