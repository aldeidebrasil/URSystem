/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.vo.Admin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Aldeide Brasil
 */
public class AdminDAO {
   private static PreparedStatement pstmt = null;
    private static ResultSet rs = null;
    public static Admin getAdminLogin(String login, String password){
        try {
            Admin adm = null;
            pstmt = Connection.getConnection().prepareStatement(
                      "select * from admin where id=? AND password=?");
            pstmt.setString(1, login);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();
            if(rs.next()){
                adm = new Admin();
                adm.setID(rs.getString("id"));
                adm.setPassword(rs.getString("password"));
            }
            return adm;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }        
    }
     public static Admin getById(String Id) {
        try {
            Admin admin = null;
            pstmt = Connection.getConnection().prepareStatement(
                    "SELECT * FROM admin WHERE id = ?");
            pstmt.setString(1, Id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                admin = new Admin();
                admin.setID(rs.getString("id"));
                admin.setPassword(rs.getString("password"));
                
            }
            rs.close();
            pstmt.close();
            return admin;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static boolean updatePassword(Admin admin, String password) {
        try {
             pstmt = Connection.getConnection().prepareStatement(
                    "UPDATE admin SET password=? WHERE id = ?");
            
            pstmt.setString(1, password);
            pstmt.setString(2, admin.getID());
            pstmt.executeUpdate();
            pstmt.close();
            return true;
         } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
