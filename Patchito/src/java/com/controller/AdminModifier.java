/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.action.AdministrateurAction;
import com.action.ProduitAction;
import com.entities.Produit;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author ahmed
 */
 
public class AdminModifier extends HttpServlet {

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
        String nom = request.getParameter("select");
        String modele = request.getParameter("modele");
        
        double price = Double.parseDouble(request.getParameter("prix"));
        
        String description = request.getParameter("Description");
        String taille = request.getParameter("Taille");
        int quantity = Integer.parseInt(request.getParameter("Quantite"));
        int code = Integer.parseInt(request.getParameter("codearticle"));
        Produit p = new Produit();
        p.setNom(nom);
        p.setModele(modele);
        p.setDescription(description);
        p.setPrix(price);
        p.setQuantity(quantity);
        p.setTaille(taille);
        p.setCode(code);
        String msg =null; 
         
        //boolean v=false;
        if (ProduitAction.updateProduit(p) == false) {
            
            msg = "Erreur le produit n'a pas pu etre modifié!";
            Produit article = ProduitAction.getByCode(p.getCode());
            request.setAttribute("article", article);
            request.setAttribute("message", msg);
            request.getRequestDispatcher("administrateurModifier.jsp").forward(request, response);  
        } else {
            msg = "Le produit à bien été modifié!";
            request.setAttribute("message", msg);
            request.getRequestDispatcher("administrateurModifier.jsp").forward(request, response);  
                     
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
