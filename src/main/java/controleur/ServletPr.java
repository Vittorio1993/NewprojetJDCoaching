package controleur;

import database.Bd;
import model.ProgrammeType;
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
        name = "ServletPr", 
        urlPatterns = {"/programmetype"}
    )
public class ServletPr extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest requete,
                      HttpServletResponse reponse) throws ServletException, IOException
    {
        String nompt, descpt;
        RequestDispatcher rd;
        nompt =requete.getParameter("nompt");
        descpt =requete.getParameter("descpt");
        System.out.println(nompt);
        
        
        Bd mabd=new Bd();
        try {
            mabd.AjouterProgrammeT(nompt, descpt);
        } catch (Exception ex) {
            Logger.getLogger(ServletPr.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        rd=requete.getRequestDispatcher("AdminCreateProTpe.jsp");
        rd.forward(requete, reponse);
        
    }
    
}
