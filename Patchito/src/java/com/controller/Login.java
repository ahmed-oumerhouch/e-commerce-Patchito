/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.action.AdministrateurAction;
import com.action.CompteAction;
import com.action.ProduitAction;
import com.entities.Administrateur;
import com.entities.Compte;
import com.entities.Produit;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Farid
 */
public class Login extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        HttpSession session;

        response.setContentType("text/html;charset=UTF-8");
        ArrayList<Compte> CompteManager;
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String sauvegarde = request.getParameter("sauvegarde");
        ArrayList<Compte> mescomptes = CompteAction.getAllCompte();
        ArrayList<Administrateur> mescomptesAdmin = AdministrateurAction.getAllCompte();
        boolean userConnecte = false, adminconnecte = false, connecte = false;

        for (int i = 0; i < mescomptesAdmin.size(); i++) {
            if (email.equals(AdministrateurAction.getAllCompte().get(i).getEmail()) && password.equals(AdministrateurAction.getAllCompte().get(i).getPassword())) {
                session = request.getSession();
                session.setAttribute("nom", mescomptesAdmin.get(i).getEmail());
                i = mescomptesAdmin.size();
                adminconnecte = true;
                userConnecte = true;
                ArrayList<Produit> mesProduits = ProduitAction.afficherTousLesProduits();
                request.setAttribute("mesProduits", mesProduits);
                request.getRequestDispatcher("administrateur.jsp").include(request, response);
            }
        }
        if (adminconnecte == false) {
            for (int i = 0; i < mescomptes.size(); i++) {
                if (email.equals(mescomptes.get(i).getEmail()) && password.equals(mescomptes.get(i).getPass())) {
                    session = request.getSession();
                    session.setAttribute("nom", mescomptes.get(i).getUserName());
                    session.setAttribute("email", mescomptes.get(i).getEmail());
                    i = mescomptes.size();
                    userConnecte = true;
                    if (sauvegarde != null) {
                        if (sauvegarde.equals("yes")) {
                            Cookie emailCookie = new Cookie("email", email);
                            Cookie passwordCookie = new Cookie("password", password);
                            emailCookie.setMaxAge(60*60*24);
                            passwordCookie.setMaxAge(60*60*24);
                            response.addCookie(emailCookie);
                            response.addCookie(passwordCookie);
                        }
                    }
                    request.getRequestDispatcher("acceuil.jsp").include(request, response);
                }
            }
        }
        if (userConnecte == false) {
            out.println("identifiant ou mot de passe invalide");
            request.getRequestDispatcher("login.jsp").include(request, response);
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
