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
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Bilan;

@WebServlet(
        name = "deleteexercice",
        urlPatterns = {"/deleteexercice"}
)
public class DeleteexerciceServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest requete, HttpServletResponse reponse) throws ServletException, IOException {
        try {
            reponse.setContentType("application/xml;charset=UTF-8");
            reponse.setCharacterEncoding("UTF-8");
//            PrintWriter out = reponse.getWriter();
//            out.println("<?xml version=\"1.0\"?>");
            System.out.println("AAAA");
            String nome;
            //RequestDispatcher rd;
            nome = requete.getParameter("nome");
            System.out.println(nome + "AAAA");

            Bd b = new Bd();
            b.deleteExercice(nome);
///?????           b.insererMesuration(poids, bras, poitrine, taille, hanches, cuisses);

        } catch (Exception ex) {
            Logger.getLogger(InscriptionServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
