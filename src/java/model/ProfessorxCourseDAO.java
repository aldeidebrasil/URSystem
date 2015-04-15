/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.vo.Course;
import controller.vo.ProfessorxCourse;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Aldeide Brasil
 */
public class ProfessorxCourseDAO {
    private static PreparedStatement pstmt = null;
    private static ResultSet rs = null;
    
     public static ArrayList<ProfessorxCourse> getByIdProfessor(Integer Id) throws SQLException {
         try{
            ArrayList<ProfessorxCourse> listAll = null;
            ProfessorxCourse professorxcourse = null;            
            pstmt = Connection.getConnection().prepareStatement(
                    "SELECT * FROM professorxcourse WHERE idProfessor = ?");
            pstmt.setInt(1, Id);
            rs = pstmt.executeQuery();           
            
            if (rs.next()) {
                listAll = new ArrayList<ProfessorxCourse>();
                do {                    
                    professorxcourse = new ProfessorxCourse();
                    professorxcourse.setIdProfessor(rs.getInt("idProfessor"));
                    professorxcourse.setIdCourse(rs.getString("idCourse"));
                    professorxcourse.setIdTerm(rs.getInt("idTerm"));
                    professorxcourse.setYear(rs.getString("year"));
                    listAll.add(professorxcourse);
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
    public static ProfessorxCourse getByIdCourse(String IdCourse) throws SQLException {
         try{
         
            ProfessorxCourse professorxcourse = null;            
            pstmt = Connection.getConnection().prepareStatement(
                    "SELECT * FROM professorxcourse WHERE idCourse = ? ");
            pstmt.setString(1, IdCourse);
            rs = pstmt.executeQuery();           
            
            if (rs.next()) {
                    professorxcourse = new ProfessorxCourse();
                    professorxcourse.setIdProfessor(rs.getInt("idProfessor"));
                    professorxcourse.setIdCourse(rs.getString("idCourse"));
                    professorxcourse.setIdTerm(rs.getInt("idTerm"));
                    professorxcourse.setYear(rs.getString("year"));
                
            }
            rs.close();
            pstmt.close();
            return professorxcourse;
       } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static boolean create(ProfessorxCourse professorxcourse) {
        try {
              
            pstmt = Connection.getConnection().prepareStatement(
                    "INSERT INTO professorxcourse(idCourse, idProfessor, idTerm, year) VALUES(?,?,?,?)");
            pstmt.setString(1, professorxcourse.getIdCourse());
            pstmt.setInt(2, professorxcourse.getIdProfessor());
            pstmt.setInt(3, professorxcourse.getIdTerm());
            pstmt.setString(4, professorxcourse.getYear());
            
            pstmt.executeUpdate();
            pstmt.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public static boolean updateByCourse(ProfessorxCourse professorxcourse, String idCourse) {
        try {
             pstmt = Connection.getConnection().prepareStatement(
                    "UPDATE  professorxcourse SET idCourse = ?, idProfessor = ?, idTerm=?, year=? WHERE idCourse = ?");
            pstmt.setString(1, professorxcourse.getIdCourse());
            pstmt.setInt(2, professorxcourse.getIdProfessor());
            pstmt.setInt(3, professorxcourse.getIdTerm());
            pstmt.setString(4, professorxcourse.getYear());
            pstmt.setString(5, idCourse);
            pstmt.executeUpdate();
            pstmt.close();
            return true;
         } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
   
     public static boolean delete(ProfessorxCourse professorxcourse) {
        try {
             pstmt = Connection.getConnection().prepareStatement(
                    "DELETE FROM professorxcourse WHERE idCourse = ?");
            pstmt.setString(1, professorxcourse.getIdCourse());
            pstmt.executeUpdate();
            pstmt.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }  

    public static boolean deleteByIdProfessor(int idOld) {
        try {
             pstmt = Connection.getConnection().prepareStatement(
                    "DELETE FROM professorxcourse WHERE idProfessor = ?");
            pstmt.setInt(1, idOld);
            pstmt.executeUpdate();
            pstmt.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static int countCourseByProfessor(int idProfessor, int idTerm, String year) {
        try {
            int count = 0;
                        
            pstmt = Connection.getConnection().prepareStatement(
                     "SELECT COUNT(idCourse) FROM professorxcourse WHERE idProfessor = ? AND idTerm = ? AND year=?");
            pstmt.setInt(1, idProfessor);
            pstmt.setInt(2, idTerm);
            pstmt.setString(3, year);
            rs = pstmt.executeQuery();
            
            if(rs.next()){
                 
                count = rs.getInt("count(idCourse)");
            }   
            return count;
       } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
}
