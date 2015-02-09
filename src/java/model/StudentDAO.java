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
import java.util.ArrayList;
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
              
            pstmt = Connection.getConnection().prepareStatement(
                    "INSERT INTO STUDENT(id, fname, lname, password, major) VALUES(?,?,?,?,?)");
            pstmt.setInt(1, student.getID());
            pstmt.setString(2, student.getFname());
            pstmt.setString(3,student.getLname());
            pstmt.setString(4, student.getPassword());
            pstmt.setString(5,student.getMajor());
            pstmt.executeUpdate();
            pstmt.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean update(Student student) {
        try {
             pstmt = Connection.getConnection().prepareStatement(
                    "UPDATE STUDENT SET id = ?, fname = ?, lname=?, password=?, major=? WHERE id = ?");
            pstmt.setInt(1, student.getID());
            pstmt.setString(2, student.getFname());
            pstmt.setString(3,student.getLname());
            pstmt.setString(4, student.getPassword());
            pstmt.setString(5,student.getMajor());
            pstmt.setInt(6, student.getID());
            pstmt.executeUpdate();
            pstmt.close();
            return true;
         } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean delete(Student student) {
        try {
             pstmt = Connection.getConnection().prepareStatement(
                    "DELETE FROM student WHERE id = ?");
            pstmt.setInt(1, student.getID());
            pstmt.executeUpdate();
            pstmt.close();
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

    public static ArrayList<Student> getAll() throws SQLException {
        try{
            ArrayList<Student> listAll = null;
            Student student = new Student();            
            pstmt = Connection.getConnection().prepareStatement(
                    "SELECT * FROM student ORDER BY id");
            rs = pstmt.executeQuery();           
            
            if (rs.next()) {
                listAll = new ArrayList<Student>();
                do {                    
                    student = new Student();
                    student.setID(rs.getInt("id"));
                    student.setFname(rs.getString("fname"));
                    student.setLname(rs.getString("lname"));
                    student.setPassword(rs.getString("password"));
                    student.setMajor(rs.getString("major"));
                    student.setBilling(rs.getDouble("billing"));
                    listAll.add(student);
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
    
     public static Student getById(int Id) {
        try {
            Student student = null;
            pstmt = Connection.getConnection().prepareStatement(
                    "SELECT * FROM student WHERE id = ?");
            pstmt.setInt(1, Id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                student = new Student();
                student.setID(rs.getInt("id"));
                student.setFname(rs.getString("fname"));
                student.setLname(rs.getString("lname"));
                student.setPassword(rs.getString("password"));
                student.setMajor(rs.getString("major"));
                student.setBilling(rs.getDouble("billing"));
           }
            rs.close();
            pstmt.close();
            return student;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
     public static ArrayList<Integer> getAllId() throws SQLException {
        try{
            ArrayList<Integer> listAllId = null;
            pstmt = Connection.getConnection().prepareStatement(
                    "SELECT id FROM student");
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
      public static boolean updatePassword(Student student, String password) {
        try {
             pstmt = Connection.getConnection().prepareStatement(
                    "UPDATE STUDENT SET password=? WHERE id = ?");
            
            pstmt.setString(1, student.getPassword());
            pstmt.setInt(2, student.getID());
            pstmt.executeUpdate();
            pstmt.close();
            return true;
         } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}