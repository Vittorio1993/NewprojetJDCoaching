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

/**
 *
 * @author zhanghuakai
 */
@WebServlet(
        name = "creerexercice",
        urlPatterns = {"/creerexercice"}
)
public class CreerexerciceServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest requete, HttpServletResponse reponse) throws ServletException, IOException {
        try {
            reponse.setContentType("application/xml;charset=UTF-8");
            reponse.setCharacterEncoding("UTF-8");
//            PrintWriter out = reponse.getWriter();
//            out.println("<?xml version=\"1.0\"?>");

            String nome, description, tempsrepetition, nbrepetition, lienimage;
            //RequestDispatcher rd;
            nome = requete.getParameter("nome1");
            description = requete.getParameter("description1");
            tempsrepetition = requete.getParameter("tempsrepetition1");
            nbrepetition = requete.getParameter("nbrepetition1");
            lienimage = requete.getParameter("lienimage1");

            System.out.println(nome);
            System.out.println(description);

            Bd b = new Bd();
            b.insererExercice(nome, tempsrepetition, lienimage, nbrepetition, description);
            RequestDispatcher rd = requete
                    .getRequestDispatcher("gestionexercice.jsp");
            rd.forward(requete, reponse);
        } catch (Exception ex) {
            Logger.getLogger(InscriptionServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
