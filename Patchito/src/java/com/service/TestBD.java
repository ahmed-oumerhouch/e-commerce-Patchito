/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.entities.Panier;
import com.manager.ProduitManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Farid
 */
public class TestBD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String sql = "select * from produit";
        try {
            PreparedStatement ps = ConnexionBD.getConnexion().prepareStatement(sql);
            ResultSet result = ps.executeQuery();
            //Optionnel : Renvoyer un booléen qui indique 
            //si la position courante du curseur se trouve
            //avant la première ligne
            if (result.isBeforeFirst()) {
                //La méthode next() pour se déplacer sur le suivant
                while (result.next()) {
                    System.out.println(result.getString("name"));
                }
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ArrayList<Panier> panier = ProduitManager.getyAllProduitPanierUser("farid514@farid514.farid514");
        for (int i = 0; i < panier.size(); i++) {
            System.out.println(panier.get(i).getCodeProduit());
        }
        ConnexionBD.closeConnexion();

    }

}
