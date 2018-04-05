package controleur;

import database.Bd;
import model.Utilisateur;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        name = "InscriptionRapide",
        urlPatterns = {"/InscriptionRapide"}
)
public class InscriptionRapide extends HttpServlet {

    /**
     * Servlet.
     * @param requete requete
     * @param reponse reponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doGet(HttpServletRequest requete, HttpServletResponse reponse) throws ServletException, IOException {
        try {
            reponse.setContentType("application/xml;charset=UTF-8");
            reponse.setCharacterEncoding("UTF-8");
            PrintWriter out = reponse.getWriter();
            out.println("<?xml version=\"1.0\"?>");
            String nom, prenom, datenaissance, mail, tel, password, objectif
                    , poids, bras, hanches, poitrine, cuisses, taille;
            nom = requete.getParameter("nom");
            prenom = requete.getParameter("prenom");
            datenaissance = requete.getParameter("date");
            mail = requete.getParameter("mail");
            tel = requete.getParameter("tel");
            password = requete.getParameter("password");
            objectif = requete.getParameter("objectif");
            poids = requete.getParameter("poids");
            bras = requete.getParameter("bras");
            hanches = requete.getParameter("hanches");
            poitrine = requete.getParameter("poitrine");
            cuisses = requete.getParameter("cuisses");
            taille = requete.getParameter("taille");
            Bd bd = new Bd();
            if (bd.verifierMail(mail) == 0) {
                Utilisateur m = new Utilisateur(0, nom, prenom,
                            datenaissance, mail, tel, "Validé",
                                password, "client", objectif);
                bd.saisirUtilisateur(m);
                //Ajout des mensurations de l'utilisateur
                bd.insererMesuration(poids, bras, poitrine, taille,
                        hanches, cuisses);
                RequestDispatcher rd = requete
                        .getRequestDispatcher("GestionClient");
                rd.forward(requete, reponse);
            } else {
                RequestDispatcher rd = requete
                        .getRequestDispatcher("inscriptionrapide.jsp");
                rd.forward(requete, reponse);
            }
        } catch (Exception ex) {
            Logger.getLogger(InscriptionServlet
                    .class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
