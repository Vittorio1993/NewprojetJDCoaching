package controleur;

import database.Bd;
import model.Utilisateur;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*le servlet est pour transferer les donnee de la base*/
@WebServlet(
        name = "InscriptionServlet",
        urlPatterns = {"/inscription"}
)
public class InscriptionServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest requete, HttpServletResponse reponse) throws ServletException, IOException {
        try {
            reponse.setContentType("application/xml;charset=UTF-8");
            reponse.setCharacterEncoding("UTF-8");
            PrintWriter out = reponse.getWriter();
            out.println("<?xml version=\"1.0\"?>");
            String nom, prenom, datenaissance, mail, tel, password, objectif;
            //RequestDispatcher rd;
            nom = requete.getParameter("nom");
            prenom = requete.getParameter("prenom");
            datenaissance = requete.getParameter("date");
            mail = requete.getParameter("mail");
            tel = requete.getParameter("tel");
            password = requete.getParameter("password");           
            objectif = requete.getParameter("objectif");
            //System.out.println(objectif);
            Bd b = new Bd();
            if (b.verifierMail(mail) == 0) {
                Utilisateur m = new Utilisateur(0, nom, prenom, datenaissance, mail, tel, "En attente", password, "client",objectif);
                b.saisirUtilisateur(m);
                out.println("<message>yes</message>");
            } else {
                out.println("<message>Le mail déjà exist</message>");
            }
        } catch (Exception ex) {
            Logger.getLogger(InscriptionServlet
                    .class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
}
