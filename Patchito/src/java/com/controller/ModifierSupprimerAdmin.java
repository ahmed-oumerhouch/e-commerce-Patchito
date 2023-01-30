/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;


import com.action.ProduitAction;
import com.entities.Produit;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ahmed
 */
public class ModifierSupprimerAdmin extends HttpServlet {
    static String action;
    static int code;
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
        String msgSuppr = null;
        action = request.getParameter("action");
        code = Integer.parseInt(request.getParameter("code"));
        
        switch (action) {
            case ("Modifier"):
         
                Produit article = ProduitAction.getByCode(code);
                request.setAttribute("article", article);
                request.getRequestDispatcher("administrateurModifier.jsp").forward(request, response);
                break;
                
            case ("Supprimer"):
                if (!ProduitAction.deleteFromProduit(code)) {
                    msgSuppr = "Erreur le produit n'a pas pu etre supprimé!";
                } else {
                    msgSuppr = "Le produit à bien été supprimé!";
                }
                request.setAttribute("msgSuppr", msgSuppr);
                ArrayList<Produit> mesProduits = ProduitAction.afficherTousLesProduits();
                request.setAttribute("mesProduits", mesProduits);
                request.getRequestDispatcher("administrateur.jsp").forward(request, response);  
                break;
            case ("tout"):
                ArrayList<Produit> tout = ProduitAction.afficherTousLesProduits();
                request.setAttribute("mesProduits", tout);
                request.getRequestDispatcher("administrateur.jsp").forward(request, response);  
                break;
        }
        
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
