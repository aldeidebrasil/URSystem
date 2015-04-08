/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.vo.Course;
import controller.vo.StudentxCourse;
import java.sql.SQLException;
import java.util.ArrayList;
import model.CourseDAO;
import model.StudentxCourseDAO;

/**
 *
 * @author Aldeide Brasil
 */
public class VerifyCourseNew {
    public static ArrayList<String> execute(ArrayList<Course> listAllTaken) throws SQLException{
        ArrayList<String> idCourseNew = new ArrayList<>();
        ArrayList<String> idAllCourses = new ArrayList<>();
        ArrayList<String> idAllTaken = new ArrayList<>();
        
        ArrayList<Course> listAllCourses = CourseDAO.getAllOpen();
      for(int i=0; i<listAllCourses.size();i++){
          idAllCourses.add(listAllCourses.get(i).getID());
      }
      for(int j=0; j<listAllTaken.size();j++){
          idAllTaken.add(listAllTaken.get(j).getID());
      }
       idAllCourses.removeAll(idAllTaken);
      for(int k=0; k<idAllCourses.size();k++){
          idCourseNew.add(idAllCourses.get(k));
      }
      
      
       return idCourseNew;
       }
    }
    

