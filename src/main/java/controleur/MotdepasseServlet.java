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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import password.SendMail;

/**
 *
 * @author zhanghuakai
 */
@WebServlet(
        name = "motdepasse",
        urlPatterns = {"/motdepasse"}
)
public class MotdepasseServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest requete, HttpServletResponse reponse) throws ServletException, IOException {
        try {

            String mail;
            //RequestDispatcher rd;
            mail = requete.getParameter("mail");

            Bd b = new Bd();
            String[] info = b.consulterUtilisateur(mail);
            String motdepasse = info[0];
            SendMail s = new SendMail();
            s.mail(mail, motdepasse);
            
            RequestDispatcher rd = requete
                    .getRequestDispatcher("connexion.html");
            rd.forward(requete, reponse);

        } catch (Exception ex) {
            Logger.getLogger(InscriptionServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
