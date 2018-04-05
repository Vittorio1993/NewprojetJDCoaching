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
            String nom, prenom, datenaissance, tel, password, mail,
                    fcrepos, fcflexions, fcallogee,
                    gainage, jambegauche, jambedroite, crunch, pompes,
                    squat, dips, poids, bras, hanches, poitrine, cuisses,
                    taille, objectif;
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

            fcrepos = requete.getParameter("fcrepos");
            fcflexions = requete.getParameter("fcflexions");
            fcallogee = requete.getParameter("fcallogee");
            gainage = requete.getParameter("gainage");
            jambegauche = requete.getParameter("jambegauche");
            jambedroite = requete.getParameter("jambedroite");
            crunch = requete.getParameter("crunch");
            pompes = requete.getParameter("pompes");
            squat = requete.getParameter("squat");
            dips = requete.getParameter("dips");

            Bd b = new Bd();
            if (b.verifierMail(mail) == 0) {
                Utilisateur m = new Utilisateur(0, nom, prenom,
                            datenaissance, mail, tel, "Valide",
                                password, "client", objectif);
                b.saisirUtilisateur(m);
                String[] infos;
                infos = b.consulterUtilisateur(mail);
                Integer codeu = Integer.parseInt(infos[2]);
                //Ajout des mensurations de l'utilisateur
                b.insererMesuration(codeu, poids, bras, poitrine, taille,
                        hanches, cuisses);
                // Ajout du premier bilan
                b.insererBilan(codeu, "firstbilan", "0", " ",
                        fcallogee, fcflexions, fcrepos);
                int codegainage = b.cherchecodeexercise("gainage");
                int codepompes = b.cherchecodeexercise("pompes");
                int codejambegauchedevant = b.cherchecodeexercise("jambe gauche devant");
                int codejambedroitedevant = b.cherchecodeexercise("jambe droite devant");
                int codesquat = b.cherchecodeexercise("squat");
                int codecrunch = b.cherchecodeexercise("crunch");
                int codedips = b.cherchecodeexercise("dips");
                int codeb = b.consulterBilan(codeu);

                b.insererAttacher(codeb, codegainage, "1", gainage, null);
                b.insererAttacher(codeb, codepompes, "2", null, pompes);
                b.insererAttacher(codeb, codejambegauchedevant,
                        "3", null, jambegauche);
                b.insererAttacher(codeb, codejambedroitedevant,
                        "4", null, jambedroite);
                b.insererAttacher(codeb, codesquat, "5", null, squat);
                b.insererAttacher(codeb, codecrunch, "6", crunch, null);
                b.insererAttacher(codeb, codedips, "7", dips, null);
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
