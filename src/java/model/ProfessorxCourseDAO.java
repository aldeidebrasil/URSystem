/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.Course;
import controller.ProfessorxCourse;
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
   
    
}
