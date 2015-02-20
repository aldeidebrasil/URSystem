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
    public static ArrayList<Course> execute(ArrayList<Course> listAllTaken) throws SQLException{
        ArrayList<Course> listAllCourses = CourseDAO.getAll();
       if(listAllTaken.removeAll(listAllCourses)){
            return listAllTaken;
       }
       return listAllCourses;
    }
    
}
