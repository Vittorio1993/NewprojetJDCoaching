/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import database.Bd;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Bilan;
import model.Utilisateur;

/**
 *
 * @author zhanghuakai
 */
@WebServlet(
        name = "profilcondition",
        urlPatterns = {"/profilcondition"}
)
public class ProfilconditionServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest requete, HttpServletResponse reponse) throws ServletException, IOException {
        try {
            reponse.setContentType("application/xml;charset=UTF-8");
            reponse.setCharacterEncoding("UTF-8");
            PrintWriter out = reponse.getWriter();
            out.println("<?xml version=\"1.0\"?>");

            String fcrepos, fcflexions, fcallogee,gainage,jambegauche,jambedroite,crunch,pompes,squat,dips;

            //RequestDispatcher rd;
//            nom = requete.getParameter("nom");
//            prenom = requete.getParameter("prenom");
//            datenaissance = requete.getParameter("date");
//            tel = requete.getParameter("tel");
//            password = requete.getParameter("password");
//            mail = (String) requete.getSession().getAttribute("mail");
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

//            poids = requete.getParameter("poids");
//            bras = requete.getParameter("bras");
//            hanches = requete.getParameter("hanches");
//            poitrine = requete.getParameter("poitrine");
//            cuisses = requete.getParameter("cuisses");
//            taille = requete.getParameter("taille");
            Bd b = new Bd();
//            b.updateUtilisateur(nom, prenom, datenaissance, mail, tel, password);
//            b.insererMesuration(poids, bras, poitrine, taille, hanches, cuisses);
            //Integer i = null;
            Integer codeu = Integer.parseInt(requete.getSession().getAttribute("codeu").toString());
            //System.out.println("AAA" + codeu);

            b.insererBilan(codeu, "firstbilan", "0", " ", fcallogee, fcflexions, fcrepos);
            int codegainage = b.cherchecodeexercise("gainage");
            int codepompes = b.cherchecodeexercise("pompes");
            int codejambegauchedevant = b.cherchecodeexercise("jambe gauche devant");
            int codejambedroitedevant = b.cherchecodeexercise("jambe droite devant");
            int codesquat = b.cherchecodeexercise("squat");
            int codecrunch = b.cherchecodeexercise("crunch");
            int codedips = b.cherchecodeexercise("dips");

            int codeb = b.consulterBilan(codeu);
            System.out.println(codeb + "AA");
//            int codeb1 = b.chercherfirstbilan(codeu);
//            System.out.println(codeb1 + "BB");

            b.insererAttacher(codeb, codegainage, "1", gainage, null);
            b.insererAttacher(codeb, codepompes, "2", null, pompes);
            b.insererAttacher(codeb, codejambegauchedevant, "3", null, jambegauche);
            b.insererAttacher(codeb, codejambedroitedevant, "4", null, jambedroite);
            b.insererAttacher(codeb, codesquat, "5", null, squat);
            b.insererAttacher(codeb, codecrunch, "6", crunch, null);
            b.insererAttacher(codeb, codedips, "7", dips, null);
            RequestDispatcher rd = requete
                    .getRequestDispatcher("accueilclient.jsp");
            rd.forward(requete, reponse);

        } catch (Exception ex) {
            Logger.getLogger(InscriptionServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
