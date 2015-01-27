/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.DriverManager;

/**
 *
 * @author Aldeide Brasil
 */
public class Connection {
    private static java.sql.Connection conn;
    
    public static void conectar(String url, String user, String password, String driver) {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static java.sql.Connection getConnection() {
        return conn;
    }
    
    public static void destroy() {
        try {
            conn = null;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
