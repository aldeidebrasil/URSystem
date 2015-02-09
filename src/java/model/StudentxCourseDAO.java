/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.StudentxCourse;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Aldeide Brasil
 */
public class StudentxCourseDAO {
    private static PreparedStatement pstmt = null;
    private static ResultSet rs = null;
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
           ArrayList<StudentxCourse> listAll = null;
            StudentxCourse studentxcourse = new StudentxCourse();            
            pstmt = Connection.getConnection().prepareStatement(
                    "SELECT * FROM studentxcourse WHERE idStudent = ?");
            pstmt.setInt(1, Id);
            rs = pstmt.executeQuery();           
            
            if (rs.next()) {
                listAll = new ArrayList<StudentxCourse>();
                do {                    
    
                studentxcourse = new StudentxCourse();
                studentxcourse.setIdCourse(rs.getString("idCourse"));
                studentxcourse.setIdStudent(rs.getInt("idStudent"));
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
