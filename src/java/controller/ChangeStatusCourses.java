/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.vo.Course;
import java.sql.SQLException;
import java.util.ArrayList;
import model.CourseDAO;

/**
 *
 * @author Aldeide Brasil
 */
class ChangeStatusCourses {
    
    static void execute() throws SQLException {
        ArrayList<Course> listCourses = CourseDAO.getAll();
        for(int i=0; i<listCourses.size(); i++){
            int student = VerifyStudentxCourse.execute(listCourses.get(i).getID());
          if(student <= 3){
                    listCourses.get(i).setStatus("canceled");
                    CourseDAO.updateStatus(listCourses.get(i));
                
            }else if(student >= 10){
                listCourses.get(i).setStatus("full");
                CourseDAO.updateStatus(listCourses.get(i));
            }else{
                listCourses.get(i).setStatus("open");
                CourseDAO.updateStatus(listCourses.get(i));
            }
           
            
        }        
    }

    static void executeCanceled() throws SQLException {
        ArrayList<Course> listCourses = CourseDAO.getAllCanceled();
        if(listCourses!=null){
        for(int i=0; i<listCourses.size(); i++){
                listCourses.get(i).setStatus("open");
                CourseDAO.updateStatus(listCourses.get(i));
        }    
     }
    }
    
}
