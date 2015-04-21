/**
 *
 * @author CMarcelo
 */

package controller;

import controller.vo.Admin;
import controller.vo.Course;
import controller.vo.ProfessorxCourse;
import controller.vo.StudentxCourse;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.AdminDAO;
import model.CourseDAO;
import model.ProfessorxCourseDAO;
import model.StudentxCourseDAO;





public class DeleteCourse {
    public static String execute(HttpServletRequest request, HttpSession session) {
        String jsp = "";
        Admin admin = AdminDAO.getById((String)session.getAttribute("userid"));
        
        try {

            String Id = request.getParameter("id");
            Course course = CourseDAO.getById(Id); 
            ProfessorxCourse professorxcourse = ProfessorxCourseDAO.getByIdCourse(Id);
            ArrayList<StudentxCourse> studentxcourse = StudentxCourseDAO.getByIdCourse(Id);
            if(professorxcourse!=null){
                if(studentxcourse!=null){
                    for(int i=0; i<studentxcourse.size(); i++){
                        StudentxCourseDAO.delete(studentxcourse.get(i));
                    }
                }
                Course coursePre = CourseDAO.prerequisite(course.getID());
                if(coursePre!=null){
                    Course coursePre2 = CourseDAO.getById(coursePre.getID());
                   if(coursePre2!=null){
                    coursePre2.setPrerequisite(null);
                    CourseDAO.update(coursePre2);
                   }
                }
            boolean deleteProfessorxCourse = ProfessorxCourseDAO.delete(professorxcourse);
            if(deleteProfessorxCourse){
                
                boolean delete = CourseDAO.delete(course);
                if(delete != false){
                    jsp = ListCourses.execute(request, session);
                }else{
                    request.setAttribute("admin", admin);
                    String erro = "An error occurred during the operation Delete Course!";
                    request.setAttribute("error", erro);
                    jsp = "/errorAdmin.jsp";
            }
           
            } else{
                request.setAttribute("admin", admin);
                String erro = "An error occurred during the operation Delete Course!";
                request.setAttribute("error", erro);
                jsp = "/errorAdmin.jsp";
            }
          }else{
                if(studentxcourse!=null){
                    for(int i=0; i<studentxcourse.size(); i++){
                        StudentxCourseDAO.delete(studentxcourse.get(i));
                    }
                }
                Course coursePre = CourseDAO.prerequisite(course.getID());
                if(coursePre!=null){
                    Course coursePre2 = CourseDAO.getById(coursePre.getID());
                    if(coursePre2!=null){
                    coursePre2.setPrerequisite(null);
                    CourseDAO.update(coursePre2);
                    }
                }
                boolean delete = CourseDAO.delete(course);
                if(delete != false){
                    jsp = ListCourses.execute(request, session);
                }else{
                    request.setAttribute("admin", admin);
                    String erro = "An error occurred during the operation Delete Course!";
                    request.setAttribute("error", erro);
                    jsp = "/errorAdmin.jsp";
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("admin", admin);
                    String erro = "An error occurred during the operation Delete Course!";
                    request.setAttribute("error", erro);
                    jsp = "/errorAdmin.jsp";
                
        }
        return jsp;
    }
}
