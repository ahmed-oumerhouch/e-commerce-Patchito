/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.action.AdministrateurAction;
import com.action.ProduitAction;
import com.entities.Produit;
import com.manager.ProduitManager;
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
 *  @author ahmed
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, // 10 MB 
        maxFileSize = 1024 * 1024 * 50, // 50 MB
        maxRequestSize = 1024 * 1024 * 100)   	// 100 MB
public class AjouterProduitAdmin extends HttpServlet {

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

        Produit p = new Produit();
        p.setNom(nom);
        p.setModele(modele);
        p.setDescription(description);
        p.setPrix(price);
        p.setQuantity(quantity);
        p.setTaille(taille);
        String msg =null; 
        //boolean v=false;
        if (!ProduitAction.insertProduit(p)) {
            msg = "Erreur le produit n'a pas pu etre ajouté!";
        } else {
            msg = "Le produit à bien été ajouté!";
                     
        }
        Part filePart = request.getPart("pictureProduct");

        String oo;
        try {
            oo = AdministrateurAction.getDernierInsert();

            InputStream fileInputStream = filePart.getInputStream();
            String path = getServletContext().getRealPath("/image" + File.separator + p.getNom() + File.separator + oo+".jpg");
            System.out.println(path);
            boolean vv = uploadFile(fileInputStream, path);
            if (vv == true) {
                request.getRequestDispatcher("administrateur.jsp").forward(request, response);
            }
//            Files.copy(fileInputStream, fileToSave.toPath(), StandardCopyOption.REPLACE_EXISTING);

        } catch (SQLException ex) {
            Logger.getLogger(AjouterProduitAdmin.class.getName()).log(Level.SEVERE, null, ex);
        } 
        request.setAttribute("message", msg);
        ArrayList<Produit> mesProduits = ProduitAction.afficherTousLesProduits();
        request.setAttribute("mesProduits", mesProduits);
        request.getRequestDispatcher("administrateur.jsp").forward(request, response);  

    }

        
        public boolean uploadFile(InputStream a, String b) {
        boolean test = false;
        int count;
        try {
            byte[] byt = new byte[a.available()];
            a.read();
            try (FileOutputStream fops = new FileOutputStream(b)) {
                while ((count = a.read(byt)) != -1) {
                    fops.write(byt, 0, count);
                }
                a.close();
            }
            test = true;
        } catch (IOException ex) {
            Logger.getLogger(AjouterProduitAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }

        return test;
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
