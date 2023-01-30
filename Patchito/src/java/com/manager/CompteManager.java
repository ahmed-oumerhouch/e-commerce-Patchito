/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manager;

import com.entities.Compte;
import com.service.ConnexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hamza
 */
public class CompteManager {

    private static String queryGetyAll = "select * from compte";
    private static String queryGetPass = "SELECT password FROM compte where email = ?;";
    private static String queryAddAccount = "INSERT INTO `compte` (`username`, `email`, `password`) VALUES (?,?,?);";

    public static ArrayList<Compte> getAll() {
        ArrayList<Compte> mescomptes = new ArrayList<Compte>();
        try {
            PreparedStatement ps = ConnexionBD.getConnexion().prepareStatement(queryGetyAll);
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                Compte c = new Compte();
                c.setUserName(result.getString("USERNAME"));
                c.setEmail(result.getString("EMAIL"));
                c.setPass(result.getString("PASSWORD"));

                mescomptes.add(c);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return mescomptes;
    }

    public static Compte getPassword(String m) {
        Compte compte = null;
        try {
            PreparedStatement ps = ConnexionBD.getConnexion().prepareStatement(queryGetPass);
            ps.setString(1, m);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                compte = new Compte();
                compte.setPass(result.getString("password"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CompteManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return compte;
    }

    public static boolean addAccount(String a, String b, String c) {
        boolean nn = false;
        PreparedStatement ps;
        try {
            ps = ConnexionBD.getConnexion().prepareStatement(queryAddAccount);
            ps.setString(1, a);
            ps.setString(2, b);
            ps.setString(3, c);
            ps.executeUpdate();
            nn = true;
        } catch (SQLException ex) {
            Logger.getLogger(CompteManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nn;
    }

}
