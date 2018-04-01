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
@WebServlet(name = "GestionClient", urlPatterns = {"/GestionClient"})
public class GestionClient extends HttpServlet {
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
        ArrayList<Utilisateur> users = new ArrayList();
        ArrayList<Utilisateur> prospects = new ArrayList();
        ArrayList<Utilisateur> enattente = new ArrayList();
        ArrayList<Utilisateur> valides = new ArrayList();
        try {
            for (Utilisateur utilisateur :Bd.getUtilisateurs()) {
                users.add(utilisateur);
            }
            for (Utilisateur utilisateur :users) {
                // Test si non admin ou coach
                if (!"admin".equals(utilisateur.getType())
                        && !"coach".equals(utilisateur.getType())) {
                    //Ajout en fonction du status
                    if ("Abonné".equals(utilisateur.getStatus())
                            || "Validé".equals(utilisateur.getStatus())) {
                        valides.add(utilisateur);
                    } else if ("En attente".equals(utilisateur.getStatus())) {
                        enattente.add(utilisateur);
                    } else {
                        prospects.add(utilisateur);
                    }
                }
            }
                request.setAttribute("listeValides", valides);
                request.setAttribute("listeProspects", prospects);
                request.setAttribute("listeEnAttente", enattente);
                RequestDispatcher rd = request
                        .getRequestDispatcher("gererclients.jsp");
                rd.forward(request, response);
        } catch (Exception e) {
            RequestDispatcher rd = request
                    .getRequestDispatcher("pageadmin.jsp");
            rd.forward(request, response);
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
        return "Gestion Client";
    }
}
