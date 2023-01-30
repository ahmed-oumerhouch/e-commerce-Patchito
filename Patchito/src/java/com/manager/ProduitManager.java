/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manager;

import com.entities.Compte;
import com.entities.Panier;
import com.entities.Produit;
import com.service.ConnexionBD;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import static jdk.nashorn.internal.objects.NativeMath.round;

/**
 *
 * @author ahmed
 */
public class ProduitManager {

    private static String queryGetyAll = "select * from produit";
    private static String queryGetyAllProduitPanierUser = "select * from panier where email=?";
    private static String queryGetByName = "select * from produit where name=?";
    private static String queryInsert = "INSERT INTO `produit` (`name`,`modele`,`price`,`description`,`taille`,`quantity`) VALUES(?,?,?,?,?,?)";
    private static String queryInsertBasket = "INSERT INTO `panier` (`code`,`email`) VALUES(?,?)";
    private static String queryDelete = "DELETE FROM panier WHERE `panier_id` = ?";
    private static String queryDeleteFromProduit = "DELETE FROM produit WHERE `code` = ?";
    private static String queryGetProduitByCode = "select * from produit WHERE `code` = ? ";
    private static String queryDeleteAllPanier = "DELETE FROM panier WHERE `email`= ?; ";
    private static String queryUpadateElement = "UPDATE `produit` SET `name`  = ?, `modele`=?, `price`= ?, `description`= ?, `taille` = ?, `quantity`= ?  WHERE `code` = ?";
    
    public static ArrayList<Produit> getAllProduit() {
        ArrayList<Produit> mesproduits = null;
        try {
            PreparedStatement ps = ConnexionBD.getConnexion().prepareStatement(queryGetyAll);
            ResultSet result = ps.executeQuery();
            mesproduits = new ArrayList();
            while (result.next()) {
                Produit p = new Produit();
                p.setCode(result.getInt("code"));
                p.setNom(result.getString("name"));
                p.setModele(result.getString("modele"));
                Double prix =  Math.round(result.getDouble("price")* 100.0)/100.0;   
                p.setPrix(prix);
                p.setDescription(result.getString("description"));
                p.setTaille(result.getString("taille"));
                p.setQuantity(result.getInt("quantity"));
                mesproduits.add(p);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ConnexionBD.closeConnexion();
        return mesproduits;
    }

    public static Produit getProduitBycode(int code) {
        Produit p = null;
        PreparedStatement ps;
        try {
            ps = ConnexionBD.getConnexion().prepareStatement(queryGetProduitByCode);
            ps.setInt(1, code);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                p = new Produit();
                p.setCode(result.getInt("code"));
                p.setNom(result.getString("name"));
                p.setModele(result.getString("modele"));
                Double prix =  Math.round(result.getDouble("price")* 100.0)/100.0;   
                p.setPrix(prix);
                p.setDescription(result.getString("description"));
                p.setTaille(result.getString("taille"));
                p.setQuantity(result.getInt("quantity"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ConnexionBD.closeConnexion();
        return p;
    }

    public static ArrayList<Produit> getByName(String name) {
        ArrayList<Produit> mesProduits = null;
        try {
            PreparedStatement ps = ConnexionBD.getConnexion().prepareStatement(queryGetByName);
            ps.setString(1, name);
            ResultSet result = ps.executeQuery();
            if (result.isBeforeFirst()) {
                mesProduits = new ArrayList<Produit>();
            }
            while (result.next()) {
                Produit p = new Produit();
                p.setCode(result.getInt("code"));
                p.setNom(result.getString("name"));
                p.setModele(result.getString("modele"));
                Double prix =  Math.round(result.getDouble("price")* 100.0)/100.0;   
                p.setPrix(prix);
                p.setDescription(result.getString("description"));
                p.setTaille(result.getString("taille"));
                p.setQuantity(result.getInt("quantity"));
                mesProduits.add(p);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ConnexionBD.closeConnexion();
        return mesProduits;
    }

    
    public static ArrayList<Panier> getyAllProduitPanierUser(String email) {
        ArrayList<Panier> nonPanier = null;
        try {
            PreparedStatement ps = ConnexionBD.getConnexion().prepareStatement(queryGetyAllProduitPanierUser);
            ps.setString(1, email);
            ResultSet result = ps.executeQuery();
            if (result.isBeforeFirst()) {
                nonPanier = new ArrayList<Panier>();
            }
            while (result.next()) {
                Panier produitPanier = new Panier();
                produitPanier.setPanier_id(result.getInt("panier_id"));
                produitPanier.setCodeProduit(result.getString("code"));
                produitPanier.setEmail(result.getString("email"));
                nonPanier.add(produitPanier);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ConnexionBD.closeConnexion();
        return nonPanier;
    }

    public static boolean insert(Produit p) {
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;
        try {
            ps = ConnexionBD.getConnexion().prepareStatement(queryInsert);
            ps.setString(1, p.getNom());
            ps.setString(2,p.getModele());
            ps.setDouble(3, p.getPrix());
            ps.setString(4, p.getDescription());
            ps.setString(5, p.getTaille());
            ps.setInt(6, p.getQuantity());
            nbLigne = ps.executeUpdate();


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("nb ligne " + nbLigne);
        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnexion();

        return retour;
    }
    private static String queryGetDernierInsert = "SELECT MAX(code) FROM produit";
        public static String getDernierInsert() {
        String p =null;
        PreparedStatement ps;
        try {
            ps = ConnexionBD.getConnexion().prepareStatement(queryGetDernierInsert);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
 
                p = Integer.toString(result.getInt("MAX(code)"));

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ConnexionBD.closeConnexion();
        return p;
    }
    public static boolean insertBaket(String code, String email) {
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;
        try {
            ps = ConnexionBD.getConnexion().prepareStatement(queryInsertBasket);
            ps.setString(1, code);
            ps.setString(2, email);
            nbLigne = ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("nb ligne " + nbLigne);
        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnexion();
        return retour;
    }

    public static boolean deleteFromPanier(int produit_id) {
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;
        try {
            ps = ConnexionBD.getConnexion().prepareStatement(queryDelete);
            ps.setInt(1, produit_id);
            nbLigne = ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("nb ligne " + nbLigne);
        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnexion();
        return retour;
    }
        public static boolean deleteFromProduit(int code) {
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;
        try {
            ps = ConnexionBD.getConnexion().prepareStatement(queryDeleteFromProduit);
            ps.setInt(1, code);
            nbLigne = ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("nb ligne " + nbLigne);
        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnexion();
        return retour;
    }
        public static boolean deleteAllPanier(String email) {
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;
        try {
            ps = ConnexionBD.getConnexion().prepareStatement(queryDeleteAllPanier);
            ps.setString(1, email);
            nbLigne = ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("nb ligne " + nbLigne);
        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnexion();
        return retour;
    }


    public static boolean miseAjour(Produit p) {
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;
        try {
            ps = ConnexionBD.getConnexion().prepareStatement(queryUpadateElement);
            ps.setString(1, p.getNom());
            ps.setString(2,p.getModele());
            ps.setDouble(3, p.getPrix());
            ps.setString(4, p.getDescription());
            ps.setString(5, p.getTaille());
            ps.setInt(6, p.getQuantity());
            ps.setInt(7, p.getCode());

            nbLigne = ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("nb ligne " + nbLigne);
        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnexion();
        return retour;
    }

}
