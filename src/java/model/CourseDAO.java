/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.vo.Course;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Leticia
 */
public class CourseDAO {
    
    private static PreparedStatement pstmt = null;
    private static ResultSet rs = null;
    
    public static boolean create(Course course) {
        try {
              
            pstmt = Connection.getConnection().prepareStatement(
                    "INSERT INTO course(id, name, department, prerequisite, value, idTerm, status, year) VALUES(?,?,?,?,?,?,?,?)");
            pstmt.setString(1, course.getID());
            pstmt.setString(2, course.getName());
            pstmt.setString(3, course.getDepartment());
            pstmt.setString(4, course.getPrerequisite());
            pstmt.setDouble(5, course.getValue());
            pstmt.setInt   (6, course.getIdTerm());
            pstmt.setString(7, course.getStatus());
            pstmt.setString(8, course.getYear());
            pstmt.executeUpdate();
            pstmt.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean update(Course course) {
        try {
             pstmt = Connection.getConnection().prepareStatement(
                    "UPDATE  course SET id = ?, name = ?, department = ?, prerequisite = ?, value = ?, idTerm = ?, status = ?, year = ? WHERE id = ?");
            pstmt.setString(1, course.getID());
            pstmt.setString(2, course.getName());
            pstmt.setString(3, course.getDepartment());
            pstmt.setString(4, course.getPrerequisite());
            pstmt.setDouble(5, course.getValue());
            pstmt.setInt(6, course.getIdTerm());
            pstmt.setString(7, course.getStatus());
            pstmt.setString(8, course.getYear());
            pstmt.setString(9, course.getID());
            pstmt.executeUpdate();
            pstmt.close();
            return true;
         } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean delete(Course course) {
        try {
             pstmt = Connection.getConnection().prepareStatement(
                    "DELETE FROM course WHERE id = ?");
            pstmt.setString(1, course.getID());
            pstmt.executeUpdate();
            pstmt.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }  

    public static ArrayList<Course> getAll() throws SQLException {
        try{
            ArrayList<Course> listAll = null;
            Course course = new Course();            
            pstmt = Connection.getConnection().prepareStatement(
                    "SELECT * FROM course ORDER BY id");
            rs = pstmt.executeQuery();           
            
            if (rs.next()) {
                listAll = new ArrayList<Course>();
                do {                    
                    course = new Course();
                    course.setID(rs.getString("id"));
                    course.setName(rs.getString("name"));
                    course.setDepartment(rs.getString("department"));
                    course.setPrerequisite(rs.getString("prerequisite"));
                    course.setValue(rs.getDouble("value"));
                    course.setIdTerm(rs.getInt("idTerm"));
                    course.setStatus(rs.getString("status"));
                    course.setYear(rs.getString("year"));
                    listAll.add(course);
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
    
     public static Course getById(String Id) {
        try {
            Course course = null;
            pstmt = Connection.getConnection().prepareStatement(
                    "SELECT * FROM course WHERE id = ?");
            pstmt.setString(1, Id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                course = new Course();
                course.setID(rs.getString("id"));
                course.setName(rs.getString("name"));
                course.setDepartment(rs.getString("department"));
                course.setPrerequisite(rs.getString("prerequisite"));
                course.setValue(rs.getDouble("value"));
                course.setIdTerm(rs.getInt("idTerm"));
                course.setStatus(rs.getString("status"));
                course.setYear(rs.getString("year"));
            }
            rs.close();
            pstmt.close();
            return course;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }    
     public static ArrayList<String> getAllId() throws SQLException {
        try{
            ArrayList<String> listAllId = null;           
            pstmt = Connection.getConnection().prepareStatement(
                    "SELECT id FROM course");
            rs = pstmt.executeQuery();           
            
            if (rs.next()) {
                listAllId = new ArrayList<String>();
                do {                    
                    listAllId.add(rs.getString("id"));
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
   public static ArrayList<Course> getByDepartment(String Department) throws SQLException {
         try{
            ArrayList<Course> listAll = null;
            Course course = new Course();            
            pstmt = Connection.getConnection().prepareStatement(
                    "SELECT * FROM course WHERE department = ?");
            pstmt.setString(1, Department);
            rs = pstmt.executeQuery();           
            
            if (rs.next()) {
                listAll = new ArrayList<Course>();
                do {                    
                    course = new Course();
                    course.setID(rs.getString("id"));
                    course.setName(rs.getString("name"));
                    course.setDepartment(rs.getString("department"));
                    course.setPrerequisite(rs.getString("prerequisite"));
                    course.setValue(rs.getDouble("value"));
                    course.setIdTerm(rs.getInt("idTerm"));
                    course.setStatus(rs.getString("status"));
                    course.setYear(rs.getString("year"));
                    listAll.add(course);
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
    public static Course prerequisite(String IdCourse){
        try{
            Course course = new Course();            
            pstmt = Connection.getConnection().prepareStatement(
                    "SELECT * FROM course WHERE prerequisite = ?");
            pstmt.setString(1, IdCourse);
            rs = pstmt.executeQuery();           
            
            if (rs.next()) {
                    course.setID(rs.getString("id"));
                    course.setName(rs.getString("name"));
                    course.setDepartment(rs.getString("department"));
                    course.setPrerequisite(rs.getString("prerequisite"));
                    course.setValue(rs.getDouble("value"));
                    course.setIdTerm(rs.getInt("idTerm"));
                    course.setStatus(rs.getString("status"));
                    course.setYear(rs.getString("year"));
                    
                }
            rs.close();
            pstmt.close();
            return course;
       } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

