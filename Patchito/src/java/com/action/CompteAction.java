/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.action;

import com.entities.Compte;
import com.manager.CompteManager;
import java.util.ArrayList;

/**
 *
 * @author Hamza
 */
public class CompteAction {

    public static ArrayList<Compte> getAllCompte() {
        ArrayList<Compte> mescomptes = CompteManager.getAll();
        return mescomptes;
    }

    public static boolean addCompte(String a, String b, String c) {

        return CompteManager.addAccount(a, b, c);
    }

    public static Compte getPassword(String m) {
        Compte reponse = CompteManager.getPassword(m);

        return reponse;
    }
}
