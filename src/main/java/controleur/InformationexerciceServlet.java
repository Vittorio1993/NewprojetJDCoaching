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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Exercice;


/*le servlet est pour transferer les donnee de la base*/
@WebServlet(
        name = "InformationexerciceServlet",
        urlPatterns = {"/informationexercice"}
)
public class InformationexerciceServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest requete, HttpServletResponse reponse) throws ServletException, IOException {

        reponse.setContentType("application/xml;charset=UTF-8");
        reponse.setCharacterEncoding("UTF-8");
        PrintWriter out = reponse.getWriter();
        out.println("<?xml version=\"1.0\"?>");
        out.println("<liste_exercices>");
        String nomexercice;
        //RequestDispatcher rd;
        nomexercice = requete.getParameter("nome");
        

        Bd b = new Bd();
        
        Exercice e;
        try {
            e = b.donneeExercice(nomexercice);
            System.out.println(e.getLIBELLEE()+"AAABBB");
            out.println("<libellee>"+e.getLIBELLEE()+"</libellee>");
            out.println("<tempsrepetition>"+e.getDUREEE()+"</tempsrepetition>");
            out.println("<lienimage>" + e.getLIENIMAGE() + "</lienimage>");           
            out.println("<repete>" + e.getREPETE() + "</repete>");
            out.println("<description>" + e.getDESCRIPTION() + "</description>");
        } catch (Exception ex) {
            Logger.getLogger(InformationexerciceServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        out.println("</liste_exercices>");

    }

}
