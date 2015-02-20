/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.vo.Course;
import controller.vo.Professor;
import controller.vo.ProfessorxCourse;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.CourseDAO;
import model.ProfessorDAO;
import model.ProfessorxCourseDAO;

/**
 *
 * @author Aldeide Brasil
 */
public class OpenProfessor {

    static String execute(HttpServletRequest request, HttpSession session) throws SQLException {
                        
        Professor prof = ProfessorDAO.getById((int)session.getAttribute("userid"));
        request.setAttribute ("lname", prof.getTitle() + " " + prof.getLname());
        request.setAttribute ("idProfessor", prof.getID());
                    
        Professor professor = ProfessorDAO.getById(prof.getID());
        ArrayList<ProfessorxCourse> professorxcourse = ProfessorxCourseDAO.getByIdProfessor((int)session.getAttribute("userid"));
        ArrayList<Course> listCoursesTaught = new ArrayList<Course>();
        for(int i=0; i<professorxcourse.size(); i++){
             Course courseTaught = CourseDAO.getById(professorxcourse.get(i).getIdCourse());
             listCoursesTaught.add(courseTaught);
        }
        request.setAttribute("listCoursesTaught", listCoursesTaught);
        request.setAttribute("professorxcourse", professorxcourse);
        request.setAttribute("professor", professor);
        return "welcomeProfessor.jsp";
    }
    
}
