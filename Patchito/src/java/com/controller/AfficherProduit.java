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
 * @author Farid
 */
public class AfficherProduit extends HttpServlet {

    static String name;

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
        name = request.getParameter("name");
        ArrayList<Produit> mesProduits = new ArrayList<Produit>();
    
        //mesProduits = ProduitAction.getByName("name");
        switch (name) {
            case ("Shop"):
                mesProduits = ProduitAction.afficherTousLesProduits();
                //urlRetour = "shop.jsp";
                break;
            case ("Shoes"):
                mesProduits = ProduitAction.getByName("Shoes");
                //urlRetour = "shoes.jsp";
                break;
            case ("Bag"):
                mesProduits = ProduitAction.getByName("Bag");
                //urlRetour = "bags.jsp";
                break;
            case ("Clothes"):
                mesProduits = ProduitAction.getByName("Clothes");
                //urlRetour = "clothes.jsp";
                break;
            case ("Scarf"):
                mesProduits = ProduitAction.getByName("Scarf");
                //urlRetour = "scarf.jsp";
                break;
            case ("Accessory"):
                mesProduits = ProduitAction.getByName("Accessory");
                //urlRetour = "accessory.jsp";
                break;
        }

        request.setAttribute("mesProduits", mesProduits);
        request.getRequestDispatcher("Produits.jsp").forward(request, response);
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
