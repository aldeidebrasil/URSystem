/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.vo.Course;
import controller.vo.Professor;
import controller.vo.ProfessorxCourse;
import controller.vo.Student;
import controller.vo.StudentxCourse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.CourseDAO;
import model.ProfessorDAO;
import model.ProfessorxCourseDAO;
import model.StudentDAO;
import model.StudentxCourseDAO;

/**
 *
 * @author Aldeide Brasil
 */
public class OpenProfessor {
    
    static String execute(HttpServletRequest request, HttpSession session) throws SQLException {
        String jsp = "";
         if(!VerifyTermDate.execute(VerifyTerm.execute())){
           ChangeStatusCourses.execute();
        }                
        Professor prof = ProfessorDAO.getById((int)session.getAttribute("userid"));
        request.setAttribute ("lname", prof.getTitle() + " " + prof.getLname());
        request.setAttribute ("idProfessor", prof.getID());
                
        Professor professor = ProfessorDAO.getById(prof.getID());
        ArrayList<ProfessorxCourse> professorxcourse = ProfessorxCourseDAO.getByIdProfessor((int)session.getAttribute("userid"));
        ArrayList<Course> listCoursesTaught = new ArrayList<Course>();
        if(professorxcourse!=null){
        for(int i=0; i<professorxcourse.size(); i++){
             Course courseTaught = CourseDAO.getById(professorxcourse.get(i).getIdCourse());
             listCoursesTaught.add(courseTaught);
        }
        Map<Course,ArrayList<Student>> mapStudent = null;
       if(listCoursesTaught!=null){
        mapStudent = new HashMap();
        for(int j=0; j<listCoursesTaught.size();j++){
            ArrayList<StudentxCourse> studentxcourse = StudentxCourseDAO.getByIdCourseTerm(listCoursesTaught.get(j).getID(),VerifyTerm.execute());
            ArrayList<Student> listStudents = new ArrayList<Student>();
            if(studentxcourse!=null){
                for(int i = 0; i < studentxcourse.size(); i++){
                    Student student = StudentDAO.getById(studentxcourse.get(i).getIdStudent());
                    listStudents.add(student);
                }
                mapStudent.put(listCoursesTaught.get(j), listStudents);
            }else{
                mapStudent.put(listCoursesTaught.get(j), null);
            }
        }
        
        request.setAttribute("mapStudent", mapStudent);
        request.setAttribute("listCoursesTaught", listCoursesTaught);
        request.setAttribute("professorxcourse", professorxcourse);
        request.setAttribute("professor", professor);
        jsp = "/welcomeProfessor.jsp";
        
        
     }
        }else{
        request.setAttribute("mapStudent", null);
        request.setAttribute("listCoursesTaught", null);
        request.setAttribute("professorxcourse", null);
        request.setAttribute("professor", professor);
        jsp =  "/welcomeProfessor.jsp";
            
        }
        return jsp;
    }
    
     static String executeAlert(HttpServletRequest request, HttpSession session, String confirm) throws SQLException {
                        
        Professor prof = ProfessorDAO.getById((int)session.getAttribute("userid"));
        request.setAttribute ("lname", prof.getTitle() + " " + prof.getLname());
        request.setAttribute ("idProfessor", prof.getID());
                
        Professor professor = ProfessorDAO.getById(prof.getID());
        ArrayList<ProfessorxCourse> professorxcourse = ProfessorxCourseDAO.getByIdProfessor((int)session.getAttribute("userid"));
        ArrayList<Course> listCoursesTaught = new ArrayList<Course>();
        if(professorxcourse!=null){
        for(int i=0; i<professorxcourse.size(); i++){
             Course courseTaught = CourseDAO.getById(professorxcourse.get(i).getIdCourse());
             listCoursesTaught.add(courseTaught);
        }
        Map<Course,ArrayList<Student>> mapStudent = null;
       if(listCoursesTaught!=null){
        mapStudent = new HashMap();
        for(int j=0; j<listCoursesTaught.size();j++){
        ArrayList<StudentxCourse> studentxcourse = StudentxCourseDAO.getByIdCourseTerm(listCoursesTaught.get(j).getID(),VerifyTerm.execute());
        ArrayList<Student> listStudents = new ArrayList<Student>();
       if(studentxcourse!=null){
            for(int i = 0; i < studentxcourse.size(); i++){
                Student student = StudentDAO.getById(studentxcourse.get(i).getIdStudent());
                listStudents.add(student);
            }
            mapStudent.put(listCoursesTaught.get(j), listStudents);
            
           }
        }
       }
        request.setAttribute("ok", confirm);
        request.setAttribute("mapStudent", mapStudent);
        request.setAttribute("listCoursesTaught", listCoursesTaught);
        request.setAttribute("professorxcourse", professorxcourse);
        request.setAttribute("professor", professor);
        return "/welcomeProfessor.jsp";
     }else{
            request.setAttribute("ok", confirm);
        request.setAttribute("mapStudent", null);
        request.setAttribute("listCoursesTaught", null);
        request.setAttribute("professorxcourse", null);
        request.setAttribute("professor", professor);
        return "/welcomeProfessor.jsp";
    }
   }
}
