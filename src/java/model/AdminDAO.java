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
            System.out.println(login);
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
    
}
