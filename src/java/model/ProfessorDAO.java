/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.Professor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Aldeide Brasil
 */
public class ProfessorDAO {

     private static PreparedStatement pstmt = null;
    private static ResultSet rs = null;
    
    public static boolean create(Professor professor) {
        try {
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean update(Professor professor) {
        try {
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean delete(Professor professor) {
        try {
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }  

    public static Professor getProfessorLogin(String login, String password){
        try {
            Professor professor = null;
            System.out.println(login);
            pstmt = Connection.getConnection().prepareStatement(
                      "select * from professor where id=? AND password=?");
            pstmt.setString(1, login);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();
            if(rs.next()){
                professor = new Professor();
                professor.setFname(rs.getString("fname"));
                professor.setLname(rs.getString("lname"));
                professor.setID(rs.getInt("id"));
                professor.setPassword(rs.getString("password"));
                professor.setTitle(rs.getString("title"));
            }
            return professor;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }        
    }
    
}
