/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import database.Bd;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Utilisateur;

/**
 *
 * @author zhanghuakai
 */
@WebServlet(
        name = "profilsportif",
        urlPatterns = {"/profilsportif"}
)
public class ProfilsportifServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest requete, HttpServletResponse reponse) throws ServletException, IOException {
        try {
            reponse.setContentType("application/xml;charset=UTF-8");
            reponse.setCharacterEncoding("UTF-8");
            PrintWriter out = reponse.getWriter();
            out.println("<?xml version=\"1.0\"?>");

            String nom, prenom, datenaissance, tel, password, mail,
                    fcrepos, fcflexions, fcallogee,
                    gainage, jambegauche, jambedroite, crunch, pompes, squat, dips,
                    poids, bras, hanches, poitrine, cuisses, taille;
            //RequestDispatcher rd;
            nom = requete.getParameter("nom");
            prenom = requete.getParameter("prenom");
            datenaissance = requete.getParameter("date");
            tel = requete.getParameter("tel");
            password = requete.getParameter("password");
            mail = (String) requete.getSession().getAttribute("mail");
//            fcrepos = requete.getParameter("fcrepos");
//            fcflexions = requete.getParameter("fcflexions");
//            fcallogee = requete.getParameter("fcallogee");
//            gainage = requete.getParameter("gainage");
//            jambegauche = requete.getParameter("jambegauche");
//            jambedroite = requete.getParameter("jambedroite");
//            crunch = requete.getParameter("crunch");
//            pompes = requete.getParameter("pompes");
//            squat = requete.getParameter("squat");
//            dips = requete.getParameter("dips");
            poids = requete.getParameter("poids");
            bras = requete.getParameter("bras");
            hanches = requete.getParameter("hanches");
            poitrine = requete.getParameter("poitrine");
            cuisses = requete.getParameter("cuisses");
            taille = requete.getParameter("taille");

//            System.out.println(mail);
//            System.out.println(nom);
//            System.out.println(prenom);
//            System.out.println(datenaissance);
//            System.out.println(mail);
//            System.out.println(tel);
//            System.out.println(password);
            Bd b = new Bd();
//?????            b.updateUtilisateur(nom, prenom, datenaissance, mail, tel, password);
            b.insererMesuration(poids, bras, poitrine, taille, hanches, cuisses);
            out.println("<message>yes</message>");

        } catch (Exception ex) {
            Logger.getLogger(InscriptionServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
