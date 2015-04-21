/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.vo.Course;
import controller.vo.Student;
import controller.vo.StudentxCourse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.CourseDAO;
import model.StudentDAO;
import model.StudentxCourseDAO;

/**
 *
 * @author Aldeide Brasil
 */
public class AddCourseStudent {
     public static String execute(HttpServletRequest request, HttpSession session) throws SQLException, ServletException, IOException{
        String error="";        
        String jsp=""; 
        boolean confirm = false;
        String idCourse = request.getParameter("rd");
        String idStudent = request.getParameter("IdStudent");
        Student student = StudentDAO.getById(Integer.parseInt(idStudent));
        request.setAttribute("student", student);
        if(VerifyTermDate.execute(VerifyTerm.execute())){
        if(VerifyStudentxCourse.execute(idCourse)<10){
            StudentxCourse studentxcourse = new StudentxCourse();
            ArrayList<StudentxCourse> allStudentxcourse = StudentxCourseDAO.getByIdStudent(Integer.parseInt(idStudent));
            Course courseNew = CourseDAO.getById(idCourse);
            if(courseNew.getPrerequisite()!= null){
                for(int i = 0; i<allStudentxcourse.size(); i++){
                    if(allStudentxcourse.get(i).getIdCourse().equals(courseNew.getPrerequisite()) && !allStudentxcourse.get(i).getIdTerm().equals(courseNew.getIdTerm())){
                        confirm = true;
                    }
                }
            }
            if(courseNew.getPrerequisite()== null || confirm == true){
              try{  
               studentxcourse.setIdCourse(idCourse);
               studentxcourse.setIdStudent(Integer.parseInt(idStudent));
               studentxcourse.setIdTerm(VerifyTerm.execute());
               studentxcourse.setYear(""+Calendar.getInstance().get(Calendar.YEAR));
               Boolean create = StudentxCourseDAO.create(studentxcourse);
                if(create == false){
                    String erro = "Sorry! An error occurred during the operation: Register Course.";
                    request.setAttribute("error", erro);
                   jsp = "/error.jsp";
                }else{
                    if(VerifyStudentxCourse.execute(idCourse)==10){
                        courseNew.setStatus("full");
                        CourseDAO.updateStatus(courseNew);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                jsp = "";
            }
            String year = ""+Calendar.getInstance().get(Calendar.YEAR);
            ArrayList<Course> listCourse = new ArrayList<>();
            ArrayList<StudentxCourse> studentxcourseList = StudentxCourseDAO.getBySemester(VerifyTerm.execute(), Integer.parseInt(idStudent),year);
            for(int i=0; i<studentxcourseList.size();i++){
                Course course = CourseDAO.getById(studentxcourseList.get(i).getIdCourse());
                listCourse.add(course);
            }

            CalcBilling.execute(listCourse, request.getSession());
            request.setAttribute("listCourse", listCourse);
            return "allCoursesStudent.jsp";
           }else{
              String erro = "Sorry! You do not have the prerequisite!<br><br>You have to take "+courseNew.getPrerequisite()+" first.";
              request.setAttribute("error", erro);
              jsp = "/error.jsp";
            }
        }else{
        String erro = "Sorry! This course is full.";
        request.setAttribute("error", erro);
        jsp = "/error.jsp";
    }}else{
            String erro = "Sorry! You cannot change your schedule anymore.";
            request.setAttribute("error", erro);
            jsp = "/error.jsp";
        }
         return jsp;
    }

   
}
