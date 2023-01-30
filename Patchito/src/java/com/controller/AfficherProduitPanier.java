/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.action.ProduitAction;
import static com.controller.AjouterPanier.email;
import com.entities.Panier;
import com.entities.Produit;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Farid
 */
public class AfficherProduitPanier extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String email_user = (String)request.getSession().getAttribute("email");
        ArrayList<Panier> mesProduitsDuPanier = new ArrayList<Panier>();
        mesProduitsDuPanier = ProduitAction.getyAllProduitPanierUser(email_user);
        ArrayList<Produit> ProduitsPanierUserCurent = new ArrayList<Produit>();
        
        if (mesProduitsDuPanier != null) {
            for (int i = 0; i < mesProduitsDuPanier.size(); i++) {
                ProduitsPanierUserCurent.add(ProduitAction.getByCode(Integer.parseInt(mesProduitsDuPanier.get(i).getCodeProduit())));
            }
        }
        /*session = request.getSession();
        session.setAttribute("panier",ProduitsPanierUserCurent );*/
        request.setAttribute("ProduitsPanierUserCurent", ProduitsPanierUserCurent);
        request.setAttribute("mesProduitsDuPanier", mesProduitsDuPanier);
        request.getRequestDispatcher("panier.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
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
        return "Short description";
    }// </editor-fold>

}
