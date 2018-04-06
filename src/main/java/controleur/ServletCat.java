package controleur;

import database.Bd;
import model.Categorie;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        name = "ServletCat", 
        urlPatterns = {"/ajoutecategorie"}
    )
public class ServletCat extends HttpServlet {
    @Override
     public void doGet(HttpServletRequest requete,
                      HttpServletResponse reponse) throws ServletException, IOException
    {
        String libellecat;
        RequestDispatcher rd;
        libellecat =requete.getParameter("libellecat");

       
        Bd mabd=new Bd();
        try {
            mabd.AjouterCategorie(libellecat);
        } catch (Exception ex) {
            Logger.getLogger(ServletCat.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        rd=requete.getRequestDispatcher("pageadmin.jsp");
        rd.forward(requete, reponse);
        
                
    }
    
}
