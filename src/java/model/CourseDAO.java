/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.Course;
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
                    "INSERT INTO course(id, nameCourse, departament, prerequisite, value, term, status, idProfessor) VALUES(?,?,?,?,?,?,?,?)");
            pstmt.setString(1, course.getID());
            pstmt.setString(2, course.getNameCourse());
            pstmt.setString(3, course.getDepartament());
            pstmt.setString(4, course.getPrerequisite());
            pstmt.setDouble(5, course.getValue());
            pstmt.setString(6, course.getTerm());
            pstmt.setString(7, course.getStatus());
            pstmt.setInt(8, course.getIDProfessor());
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
                    "UPDATE  course SET id = ?, nameCourse = ?, departament = ?, prerequisite = ?, value = ?, term = ?, status = ?, idProfessor = ? WHERE id = ?");
            pstmt.setString(1, course.getID());
            pstmt.setString(2, course.getNameCourse());
            pstmt.setString(3, course.getDepartament());
            pstmt.setString(4, course.getPrerequisite());
            pstmt.setDouble(5, course.getValue());
            pstmt.setString(6, course.getTerm());
            pstmt.setString(7, course.getStatus());
            pstmt.setInt(8, course.getIDProfessor());
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
                    course.setNameCourse(rs.getString("nameCourse"));
                    course.setDepartament(rs.getString("departament"));
                    course.setPrerequisite(rs.getString("prerequisite"));
                    course.setValue(rs.getDouble("value"));
                    course.setTerm(rs.getString("term"));
                    course.setStatus(rs.getString("status"));
                    course.setIDProfessor(rs.getInt("idProfessor"));
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
                course.setNameCourse(rs.getString("nameCourse"));
                course.setDepartament(rs.getString("departament"));
                course.setPrerequisite(rs.getString("prerequisite"));
                course.setValue(rs.getDouble("value"));
                course.setTerm(rs.getString("term"));
                course.setStatus(rs.getString("status"));
                course.setIDProfessor(rs.getInt("idProfessor"));
            }
            rs.close();
            pstmt.close();
            return course;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }    
    
}
