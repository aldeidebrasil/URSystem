/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.ProfessorDAO;
import model.AdminDAO;
import model.StudentDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.CourseDAO;
import model.StudentxCourseDAO;

/**
 *
 * @author Aldeide Brasil
 */
public class Login {
    @SuppressWarnings("static-access")
    public static String execute(HttpServletRequest request) {        
        
        String error="";        
        String jsp="";        
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        
       
        Student usr = new Student();
        StudentDAO usrDAO = new StudentDAO();        
        try {
            usr = usrDAO.getStudentLogin(login, password);
            if(usr == null){
                Professor prof = new Professor();
                ProfessorDAO profDAO = new ProfessorDAO();        
                try{
                    prof = profDAO.getProfessorLogin(login,password);
                    if(prof== null){
                    Admin adm = new Admin();
                    AdminDAO admDAO = new AdminDAO();
                    try{
                    adm = admDAO.getAdminLogin(login,password);
                    if(adm == null){
                        error="User not found!";
                        request.setAttribute("error", error);
                        jsp = "/error.jsp";
                    }else{
                        //request.setAttribute("fname", usr.getFname());
                        jsp = "/welcomeAdmin.jsp";
                    }
                    }catch (Exception e) {
                    e.printStackTrace();
                    jsp = "";
                    }

                    }else{
                        
                        request.setAttribute ("lname", prof.getTitle() + " " + prof.getLname());
                        request.setAttribute ("idProfessor", prof.getID());
                      
                        jsp = "/welcomeProfessor.jsp";
                    }
            
                }catch (Exception e) {
                e.printStackTrace();
                jsp = "";
                }               
            }               
            else{ 
                Student student = StudentDAO.getById(usr.getID());
                ArrayList<StudentxCourse> studentxcourse = StudentxCourseDAO.getByIdStudent(usr.getID());
                ArrayList<Course> listAllTaken = new ArrayList<Course>();
                for(int i=0; i<studentxcourse.size(); i++){
                    Course courseTaken = CourseDAO.getById(studentxcourse.get(i).getIdCourse());
                    listAllTaken.add(courseTaken);
                }
                
                ArrayList <Course> listAllCourses = CourseDAO.getAll();
                ArrayList<Course> listCoursesDepartment = CourseDAO.getByDepartment(student.getMajor());
                request.setAttribute("listCoursesDepartment", listCoursesDepartment);
                request.setAttribute("listAllCourses", listAllCourses);
                request.setAttribute("listCoursesTaken", listAllTaken);
                request.setAttribute("studentxcourse", studentxcourse);
                request.setAttribute("student", student);
                jsp = "/welcomeStudent.jsp";
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;        
     }
    
}
