/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manager;

import com.entities.Administrateur;
import com.entities.Compte;
import com.service.ConnexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Farid
 */
public class AdministrateurManager {

    private static String queryGetyAll = "select * from administrateur";

    public static ArrayList<Administrateur> getAll() {
        ArrayList<Administrateur> mescomptesAdministrateur = new ArrayList<Administrateur>();
        try {
            PreparedStatement ps = ConnexionBD.getConnexion().prepareStatement(queryGetyAll);
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                Administrateur admin = new Administrateur();
                admin.setEmail(result.getString("USERNAME"));
                admin.setPassword(result.getString("PASSWORD"));

                mescomptesAdministrateur.add(admin);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return mescomptesAdministrateur;
    }
}
