/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.action;

import com.entities.Panier;
import com.entities.Produit;
import com.manager.ProduitManager;
import java.util.ArrayList;

/**
 *
 * @author Farid
 */
public class ProduitAction {

    public static ArrayList<Produit> afficherTousLesProduits() {
        ArrayList<Produit> listProduits = ProduitManager.getAllProduit();
        return listProduits;
    }
        public static ArrayList<Panier> getyAllProduitPanierUser(String email) {
        ArrayList<Panier> listProduits = ProduitManager.getyAllProduitPanierUser(email);
        return listProduits;
    }

    public static Produit getByCode(int code) {
        Produit produit = ProduitManager.getProduitBycode(code);
        return produit;
    }

    public static ArrayList<Produit> getByName(String name) {
        ArrayList<Produit> listProduits = ProduitManager.getByName(name);
        return listProduits;
    }
    
    public static boolean insertBaket(String code,String email ) {
        boolean retour = false;
        if (ProduitManager.insertBaket(code,email)) {
            retour = true;
        }
        return retour;
    }
        public static boolean insertProduit(Produit p) {
        boolean retour = false;
        if (ProduitManager.insert(p)) {
            retour = true;
        }
        return retour;
    }
    public static boolean updateProduit(Produit p) {
        boolean retour =ProduitManager.miseAjour(p) ;

        return retour;
    }

    public static boolean deleteFromPanier(int produit_id) {
        boolean retour = false;

        if (ProduitManager.deleteFromPanier(produit_id)) {
            retour = true;
        }
        return retour;
    }
        public static boolean deleteFromProduit(int code) {
        boolean retour = false;

        if (ProduitManager.deleteFromProduit(code)) {
            retour = true;
        }
        return retour;
    }
    public static boolean deleteAllPanier(String e) {
        boolean retour = false;

        if (ProduitManager.deleteAllPanier(e)) {
            retour = true;
        }
        return retour;
    }
        

}
