/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.action;

import com.entities.Administrateur;
import com.entities.Compte;
import com.entities.Produit;
import com.manager.AdministrateurManager;
import com.manager.CompteManager;
import com.manager.ProduitManager;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Farid
 */
public class AdministrateurAction {
    
    public static ArrayList<Administrateur> getAllCompte()
    {
        ArrayList<Administrateur> mescomptes = AdministrateurManager.getAll();
        return mescomptes;
    }
    public static boolean insert(Produit p  ) throws   SQLException, IOException {

        return ProduitManager.insert(p);
    }
    public static String getDernierInsert() throws   SQLException, IOException {

        return ProduitManager.getDernierInsert();
    }
}
