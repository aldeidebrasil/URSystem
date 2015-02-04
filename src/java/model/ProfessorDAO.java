/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.Professor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Aldeide Brasil
 */
public class ProfessorDAO {

    private static PreparedStatement pstmt = null;
    private static ResultSet rs = null;
    
    public static boolean create(Professor professor) {
        try {
              
            pstmt = Connection.getConnection().prepareStatement(
                    "INSERT INTO professor(id, fname, lname, password, title) VALUES(?,?,?,?,?)");
            pstmt.setInt(1, professor.getID());
            pstmt.setString(2, professor.getFname());
            pstmt.setString(3,professor.getLname());
            pstmt.setString(4, professor.getPassword());
            pstmt.setString(5,professor.getTitle());
            pstmt.executeUpdate();
            pstmt.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean update(Professor professor) {
        try {
             pstmt = Connection.getConnection().prepareStatement(
                    "UPDATE professor SET id = ?, fname = ?, lname=?, password=?, title=? WHERE id = ?");
            pstmt.setInt(1, professor.getID());
            pstmt.setString(2, professor.getFname());
            pstmt.setString(3,professor.getLname());
            pstmt.setString(4, professor.getPassword());
            pstmt.setString(5,professor.getTitle());
            pstmt.setInt(6, professor.getID());
            pstmt.executeUpdate();
            pstmt.close();
            return true;
         } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean delete(Professor professor) {
        try {
             pstmt = Connection.getConnection().prepareStatement(
                    "DELETE FROM professor WHERE id = ?");
            pstmt.setInt(1, professor.getID());
            pstmt.executeUpdate();
            pstmt.close();
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

    public static ArrayList<Professor> getAll() throws SQLException {
        try{
            ArrayList<Professor> listAll = null;
            Professor professor = new Professor();            
            pstmt = Connection.getConnection().prepareStatement(
                    "SELECT * FROM professor ORDER BY id");
            rs = pstmt.executeQuery();           
            
            if (rs.next()) {
                listAll = new ArrayList<Professor>();
                do {                    
                    professor = new Professor();
                    professor.setID(rs.getInt("id"));
                    professor.setFname(rs.getString("fname"));
                    professor.setLname(rs.getString("lname"));
                    professor.setPassword(rs.getString("password"));
                    professor.setTitle(rs.getString("title"));
                    listAll.add(professor);
                } while (rs.next());
            }
            rs.close();
            pstmt.close();
            return listAll;
       } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
     public static Professor getById(int Id) {
        try {
            Professor professor = null;
            pstmt = Connection.getConnection().prepareStatement(
                    "SELECT * FROM professor WHERE id = ?");
            pstmt.setInt(1, Id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                professor = new Professor();
                professor.setID(rs.getInt("id"));
                professor.setFname(rs.getString("fname"));
                professor.setLname(rs.getString("lname"));
                professor.setPassword(rs.getString("password"));
                professor.setTitle(rs.getString("title"));
            }
            rs.close();
            pstmt.close();
            return professor;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }    
public static ArrayList<Integer> getAllId() throws SQLException {
        try{
            ArrayList<Integer> listAllId = null;           
            pstmt = Connection.getConnection().prepareStatement(
                    "SELECT id FROM professor");
            rs = pstmt.executeQuery();           
            
            if (rs.next()) {
                listAllId = new ArrayList<Integer>();
                do {                    
                    listAllId.add(rs.getInt("id"));
                } while (rs.next());
            }
            rs.close();
            pstmt.close();
            return listAllId;
       } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
