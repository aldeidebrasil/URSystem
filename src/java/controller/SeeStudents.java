/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.servlet.http.HttpServletRequest;
import model.StudentxCourseDAO;
import model.StudentDAO;
import controller.vo.StudentxCourse;
import controller.vo.Student;
import java.util.ArrayList;

/**
 *
 * @author Leticia
 */
public class SeeStudents {
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            String id = request.getParameter("rd");
            
            ArrayList<StudentxCourse> studentxcourse = StudentxCourseDAO.getByIdCourseTerm(id,VerifyTerm.execute());
            ArrayList<Student> listStudents = new ArrayList<Student>();
            
            for(int i = 0; i < studentxcourse.size(); i++){
                Student student = StudentDAO.getById(studentxcourse.get(i).getIdStudent());
                listStudents.add(student);
            } 
            request.setAttribute("listStudents", listStudents);
            return "/seeStudents.jsp";
            
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
    
}
