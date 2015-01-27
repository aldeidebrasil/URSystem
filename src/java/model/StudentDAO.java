/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.Student;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Connection;

/**
 *
 * @author Aldeide Brasil
 */
public class StudentDAO {

     private static PreparedStatement pstmt = null;
    private static ResultSet rs = null;
    
    public static boolean create(Student student) {
        try {
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean update(Student usuario) {
        try {
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean delete(Student student) {
        try {
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }  

    public static Student getStudentLogin(String login, String password){
        try {
            Student student = null;
            System.out.println(login);
            pstmt = Connection.getConnection().prepareStatement(
                      "select * from student where id=? AND password=?");
            pstmt.setString(1, login);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();
            if(rs.next()){
                student = new Student();
                student.setFname(rs.getString("fname"));
                student.setLname(rs.getString("lname"));
                student.setID(rs.getInt("id"));
                student.setPassword(rs.getString("password"));
                student.setMajor(rs.getString("major"));
            }
            return student;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }        
    }
       
}
