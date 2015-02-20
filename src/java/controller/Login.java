/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.vo.StudentxCourse;
import controller.vo.ProfessorxCourse;
import controller.vo.Admin;
import controller.vo.Professor;
import controller.vo.Student;
import controller.vo.Course;
import model.ProfessorDAO;
import model.AdminDAO;
import model.StudentDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.CourseDAO;
import model.StudentxCourseDAO;
import model.ProfessorxCourseDAO;

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
        HttpSession session = request.getSession(true);
        
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
                        session.setAttribute("userid",adm.getID());
                        jsp = "/welcomeAdmin.jsp";
                    }
                    }catch (Exception e) {
                    e.printStackTrace();
                    jsp = "";
                    }

                    }else{
                        session.setAttribute("userid",prof.getID());
                        request.setAttribute ("lname", prof.getTitle() + " " + prof.getLname());
                        request.setAttribute ("idProfessor", prof.getID());
                      
                        Professor professor = ProfessorDAO.getById(prof.getID());
                        ArrayList<ProfessorxCourse> professorxcourse = ProfessorxCourseDAO.getByIdProfessor(prof.getID());
                        ArrayList<Course> listCoursesTaught = new ArrayList<Course>();
                        for(int i=0; i<professorxcourse.size(); i++){
                             Course courseTaught = CourseDAO.getById(professorxcourse.get(i).getIdCourse());
                             listCoursesTaught.add(courseTaught);
                        }
                        request.setAttribute("listCoursesTaught", listCoursesTaught);
                        request.setAttribute("professorxcourse", professorxcourse);
                        request.setAttribute("professor", professor);
                        
                        jsp = "/welcomeProfessor.jsp";
                    }
            
                }catch (Exception e) {
                e.printStackTrace();
                jsp = "";
                }               
            }               
            else{ 
                session.setAttribute("userid",usr.getID());
                System.out.println("userid");
                Student student = StudentDAO.getById(usr.getID());
                ArrayList<StudentxCourse> studentxcourse = StudentxCourseDAO.getByIdStudent(usr.getID());
                String year = "" + Calendar.getInstance().get(Calendar.YEAR);
                ArrayList<StudentxCourse> studentxcourseTerm = StudentxCourseDAO.getBySemester(VerifyTerm.execute(),usr.getID(),year);
                ArrayList<Course> listAllTaken = new ArrayList<Course>();
                for(int i=0; i<studentxcourse.size(); i++){
                    Course courseTaken = CourseDAO.getById(studentxcourse.get(i).getIdCourse());
                    listAllTaken.add(courseTaken);
                }
                ArrayList <Course> listAllCourses = CourseDAO.getAll();
                ArrayList<Course> listCoursesDepartment = CourseDAO.getByDepartment(student.getMajor());
                ArrayList<Course> listNew = VerifyCourseNew.execute(listAllTaken);
                ArrayList<Course> listTerm =  new ArrayList<Course>();
                for(int i=0; i<studentxcourseTerm.size(); i++){
                    Course courseTaken = CourseDAO.getById(studentxcourseTerm.get(i).getIdCourse());
                   listAllTaken.add(courseTaken);
                }
                request.setAttribute("listNew",listNew);
                request.setAttribute("listTerm",listTerm);        
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
