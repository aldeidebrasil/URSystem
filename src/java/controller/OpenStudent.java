/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.vo.Course;
import controller.vo.Student;
import controller.vo.StudentxCourse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.CourseDAO;
import model.StudentDAO;
import model.StudentxCourseDAO;

/**
 *
 * @author Aldeide Brasil
 */
public class OpenStudent {
    
    static String execute(HttpServletRequest request, HttpSession session) throws SQLException {
                String jsp="";
                Student student = StudentDAO.getById((int)session.getAttribute("userid"));
                ArrayList<StudentxCourse> studentxcourse = StudentxCourseDAO.getByIdStudent((int) session.getAttribute("userid"));
                String year = "" + Calendar.getInstance().get(Calendar.YEAR);
                ArrayList<StudentxCourse> studentxcourseTerm = StudentxCourseDAO.getBySemester(VerifyTerm.execute(),(int) session.getAttribute("userid"),year);
                ArrayList<Course> listAllTaken = new ArrayList<>();
                ArrayList<Course> listTerm =  new ArrayList<Course>();
                
                if(studentxcourse != null && studentxcourseTerm != null){
                    for(int i=0; i<studentxcourse.size(); i++){
                    Course courseTaken = CourseDAO.getById(studentxcourse.get(i).getIdCourse());
                    listAllTaken.add(courseTaken);
                    }
                    for(int i=0; i<studentxcourseTerm.size(); i++){
                    Course courseTerm = CourseDAO.getById(studentxcourseTerm.get(i).getIdCourse());
                    listTerm.add(courseTerm);
                    }
                
                }
                ArrayList <Course> listAllCourses = CourseDAO.getAll();
                ArrayList<Course> listCoursesDepartment = CourseDAO.getByDepartment(student.getMajor());
                ArrayList<String> idCourseNew = VerifyCourseNew.execute(listAllTaken);
                ArrayList<Course> listNew = new ArrayList<>();
                for(int k=0; k<idCourseNew.size(); k++){
                    listNew.add(CourseDAO.getById(idCourseNew.get(k)));
                }
                request.setAttribute("listNew",listNew);
                request.setAttribute("listTerm",listTerm);        
                request.setAttribute("listCoursesDepartment", listCoursesDepartment);
                request.setAttribute("listAllCourses", listAllCourses);
                request.setAttribute("listCoursesTaken", listAllTaken);
   
                request.setAttribute("studentxcourse", studentxcourse);
                request.setAttribute("student", student);
                jsp = "/welcomeStudent.jsp";
                return jsp;
    }
    
}
