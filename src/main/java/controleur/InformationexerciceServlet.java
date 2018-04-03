/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

/**
 *
 * @author zhanghuakai
 */

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
        name = "InformationexerciceServlet",
        urlPatterns = {"/informationexercice"}
)
public class InformationexerciceServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest requete, HttpServletResponse reponse) throws ServletException, IOException {
        try {
            reponse.setContentType("application/xml;charset=UTF-8");
            reponse.setCharacterEncoding("UTF-8");
            PrintWriter out = reponse.getWriter();
            out.println("<?xml version=\"1.0\"?>");
            String nomexercice;
            //RequestDispatcher rd;
            nomexercice = requete.getParameter("nome");
            
            Bd b = new Bd(); 
            b.donneeExercice(nomexercice);
            
            
            
            if (b.verifierMail(nomexercice) == 0) {
                Utilisateur m = new Utilisateur(0, nom, prenom, datenaissance, mail, tel, "En attente", password, "client",objectif);
                b.saisirUtilisateur(m);
                out.println("<message>yes</message>");
            }else{
                out.println("<message>Le mail déjà exist</message>");
            }
        } catch (Exception ex) {
            Logger.getLogger(InscriptionServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        } 

}
