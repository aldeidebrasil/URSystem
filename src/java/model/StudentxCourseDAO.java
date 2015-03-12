/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.vo.StudentxCourse;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Aldeide Brasil
 */
public class StudentxCourseDAO {
    private static PreparedStatement pstmt = null;
    private static ResultSet rs = null;
    
     public static boolean create(StudentxCourse studentxcourse) {
        try {
              
            pstmt = Connection.getConnection().prepareStatement(
                    "INSERT INTO studentxcourse(idCourse, idStudent, idTerm, year) VALUES(?,?,?,?)");
            pstmt.setString(1, studentxcourse.getIdCourse());
            pstmt.setInt(2, studentxcourse.getIdStudent());
            pstmt.setInt(3, studentxcourse.getIdTerm());
            pstmt.setString(4, studentxcourse.getYear());
            pstmt.executeUpdate();
            pstmt.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
  
    public static ArrayList<StudentxCourse> getByIdCourse(String Id) {
        try {
            
           ArrayList<StudentxCourse> listAll = null;
            StudentxCourse studentxcourse = new StudentxCourse();            
            pstmt = Connection.getConnection().prepareStatement(
                     "SELECT * FROM studentxcourse WHERE idCourse = ?");
            pstmt.setString(1, Id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                listAll = new ArrayList<StudentxCourse>();
                do {                    
                studentxcourse = new StudentxCourse();
                studentxcourse.setIdCourse(rs.getString("idCourse"));
                studentxcourse.setIdStudent(rs.getInt("idStudent"));
                studentxcourse.setYear(rs.getString("year"));
                studentxcourse.setIdTerm(rs.getInt("idTerm"));
               listAll.add(studentxcourse);
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
    public static ArrayList<StudentxCourse> getByIdCourseTerm(String Id, int IdTerm) {
        try {
            
           ArrayList<StudentxCourse> listAll = null;
            StudentxCourse studentxcourse = new StudentxCourse();            
            pstmt = Connection.getConnection().prepareStatement(
                     "SELECT * FROM studentxcourse WHERE idCourse = ? AND idTerm = ?");
            pstmt.setString(1, Id);
            pstmt.setInt(2, IdTerm);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                listAll = new ArrayList<StudentxCourse>();
                do {                    
                studentxcourse = new StudentxCourse();
                studentxcourse.setIdCourse(rs.getString("idCourse"));
                studentxcourse.setIdStudent(rs.getInt("idStudent"));
                studentxcourse.setYear(rs.getString("year"));
                studentxcourse.setIdTerm(rs.getInt("idTerm"));
               listAll.add(studentxcourse);
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
    public static ArrayList<StudentxCourse>getByIdStudent(Integer Id) {
        try {
            ArrayList<StudentxCourse> listAll = new ArrayList<StudentxCourse>();
            StudentxCourse studentxcourse = new StudentxCourse();            
            pstmt = Connection.getConnection().prepareStatement(
                    "SELECT * FROM studentxcourse WHERE idStudent = ?");
            pstmt.setInt(1, Id);
            rs = pstmt.executeQuery();           
            if (rs.next()) {
                do {                    
                studentxcourse = new StudentxCourse();
                studentxcourse.setIdCourse(rs.getString("idCourse"));
                studentxcourse.setIdStudent(rs.getInt("idStudent"));
                studentxcourse.setYear(rs.getString("year"));
                studentxcourse.setIdTerm(rs.getInt("idTerm"));
                listAll.add(studentxcourse);
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
     public static ArrayList<StudentxCourse> getBySemester(Integer IdTerm, Integer IdStudent, String Year) throws SQLException {
        try {
            ArrayList<StudentxCourse> listAll = null;
            StudentxCourse studentxcourse = new StudentxCourse();            
            pstmt = Connection.getConnection().prepareStatement(
                     "SELECT * FROM studentxcourse WHERE idTerm = ? AND idStudent= ? AND year = ?");
            pstmt.setInt(1, IdTerm);
            pstmt.setInt(2, IdStudent);
            pstmt.setString(3, Year);
                rs = pstmt.executeQuery();
                if (rs.next()) {
                listAll = new ArrayList<StudentxCourse>();
                do {                    
    
                studentxcourse = new StudentxCourse();
                studentxcourse.setIdCourse(rs.getString("idCourse"));
                studentxcourse.setIdStudent(rs.getInt("idStudent"));
                studentxcourse.setYear(rs.getString("year"));
                studentxcourse.setIdTerm(rs.getInt("idTerm"));
                listAll.add(studentxcourse);
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
    
}
