package controleur;

import database.Bd;
import model.ProgrammeType;
import java.io.IOException;
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
        mabd.AjouterProgrammeT(nompt, descpt);
        
        rd=requete.getRequestDispatcher("Confirmation.jsp");
        rd.forward(requete, reponse);
        
    }
    
}
