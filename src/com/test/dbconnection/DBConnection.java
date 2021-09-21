/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author Ahsan
 */
public class DBConnection {
    
     private static Connection con;

    static {

        try {

            Class.forName("org.sqlite.JDBC");
       
            // DriverManager.getConnection("jdbc:sqlite:src/com/test/db/BookStore.db");
            con = DriverManager.getConnection("jdbc:sqlite:src/com/test/sqlitedatabase/Student.db");

            System.out.println("Sqlite Connection Has ESTABLISHED!\n");

        } catch (Exception e) {

            System.out.println("Failed Connection!\n");

            e.printStackTrace();
        }
        
      //  C:\Users\Ahsan\Documents\NetBeansProjects\ SwingFirstTaskBySirRaheem\src\com\registerationform\sqlitedatabase\RegisterationForm.db

    }

    public static Connection getDBConnection() {

        return con;
    }
}
