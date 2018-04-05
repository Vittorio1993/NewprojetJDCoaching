package controleur;

import database.Bd;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * @author RHAW
 */
@WebServlet(name = "ConnexionServlet", urlPatterns = {"/connexion"})
//le servlet est pour vérifier le compte et récupérer des donées des utilisateurs
public class ConnexionServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest requete, HttpServletResponse reponse) throws ServletException, IOException {
        try {
            reponse.setContentType("application/xml;charset=UTF-8");
            reponse.setCharacterEncoding("UTF-8");
            PrintWriter out = reponse.getWriter();
            out.println("<?xml version=\"1.0\"?>");
            String mail, password;
            mail = requete.getParameter("mail");
            requete.getSession().setAttribute("mail", mail);
            password = requete.getParameter("password");
            Bd b = new Bd();
            String[] pa = null;
            pa = b.consulterUtilisateur(mail);

            requete.getSession().setAttribute("codeu", pa[2]);
            System.out.println(pa[2]);
                    
            
       

            if (password.equals(pa[0]) && pa[1].equals("client")) {

                out.println("<message>yes</message>");
            } else if (password.equals(pa[0]) && pa[1].equals("admin")) {
                out.println("<message>non</message>");
            } else if (password.equals(pa[0]) && pa[1].equals("coach")) {
                out.println("<message>yn</message>");
            } else {
                out.println("<message>Le mail ou mot de passe n'est pas correct</message>");
            }
        } catch (Exception ex) {
            Logger.getLogger(ConnexionServlet.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }
}
