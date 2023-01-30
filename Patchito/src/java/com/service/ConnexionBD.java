/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Farid
 */
public class ConnexionBD {

    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
     */
    private static String url = "jdbc:mysql://127.0.0.1:3306/patchito?serverTimezone=UTC";
    //Les identifiants de connection de la bd
    private static String user = "root";
    private static String pwd = "root";
    private static Connection conn = null;

    public static Connection getConnexion() {
        try {
            //chargement du driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //DriverManager est responsable de la sélection de la BD et
            //la création de la connexion

            conn = DriverManager.getConnection(url, user, pwd);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return conn;
    }

    public static void closeConnexion() {
        try {
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}

