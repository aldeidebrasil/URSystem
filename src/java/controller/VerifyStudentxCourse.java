/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.vo.Course;
import java.util.Calendar;
import model.StudentxCourseDAO;

/**
 *
 * @author Aldeide Brasil
 */
class VerifyStudentxCourse {
    
    public static int execute(String idCourse){
       String year = ""+Calendar.getInstance().get(Calendar.YEAR);
       int idTerm = VerifyTerm.execute();
       int count = StudentxCourseDAO.getNumberStudents(idCourse, year, idTerm);
       return count;
       }
}
