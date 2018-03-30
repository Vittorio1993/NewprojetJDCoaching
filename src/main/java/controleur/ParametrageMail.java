/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import database.Bd;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Utilisateur;
/**
 *
 * @author RHAW
 */
@WebServlet(name = "ParametrageMail", urlPatterns = {"/ParametrageMail"})
public class ParametrageMail extends HttpServlet {
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(final HttpServletRequest request,
            final HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String mailadmin = request.getParameter("mailadmin");
        String mailcoaching = request.getParameter("coaching");
        ArrayList<Utilisateur> coachs = new ArrayList();
        boolean changementMailadmin = false;
        boolean changementMailcoach = false;
        boolean error = false;

        //Test sur les champs de mail et de password
        if (mailadmin == null || mailadmin.length() == 0
                || mailcoaching == null || mailcoaching.length() == 0) {
            error = true;
        }

        //Renvoi page de param�trage
        if (error) {
            request.setAttribute("mailadmin", mailadmin);
            request.setAttribute("mailcoaching", mailcoaching);
            if ("".equals(mailadmin)) {
            request.setAttribute("erreur",
                    "<p class=\"alert alert-danger\">Le mail admin doit �tre renseign�.</p>");
            RequestDispatcher rd = request
                        .getRequestDispatcher("parametragemail.jsp");
            rd.forward(request, response);
            } else if ("".equals(mailcoaching)) {
                    request.setAttribute("erreur",
                            "<p class=\"alert alert-danger\">Le mail coaching doit �tre renseign�.</p>");
                    RequestDispatcher rd = request
                                .getRequestDispatcher("parametragemail.jsp");
                    rd.forward(request, response);
            }
        } else {
            request.setAttribute("ListeCoachs", coachs);
            try {
                //Test Changement Mail Admin
                changementMailadmin = Bd.changementMailAdmin(mailadmin);
                changementMailcoach = Bd.changementMailCoach(mailcoaching);
                if (changementMailadmin || changementMailcoach) {
                    request.setAttribute("changementMail",
                            "<p>Le changement d'adresse mail a �t� effectu�.</p>");
                    RequestDispatcher rd = request
                            .getRequestDispatcher("pageadmin.jsp");
                    rd.forward(request, response);
                }
            } catch (Exception e) {
                RequestDispatcher rd = request
                        .getRequestDispatcher("parametragemail.jsp");
                rd.forward(request, response);
            }
        }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods.
    // Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(final HttpServletRequest request,
            final HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(final HttpServletRequest request,
            final HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Param�trage Mail";
    }
}
