/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.vo.Course;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.CourseDAO;

/**
 *
 * @author Aldeide Brasil
 */
public class UpdateCourse {
     public static String execute(HttpServletRequest request,HttpSession session) {
        String jsp = "";
        try {
            // 
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String department = request.getParameter("department");
            String prerequisite = request.getParameter("prerequisite");
            Double value = Double.parseDouble(request.getParameter("value"));
            Integer idTerm = Integer.parseInt(request.getParameter("idterm"));
            String status = request.getParameter("status");
            String year = request.getParameter("year");
            
            Course course = new Course();
            course.setID(id);
            course.setName(name);
            course.setDepartment(department);
            course.setPrerequisite(prerequisite);
            course.setValue(value);
            course.setIdTerm(idTerm);
            course.setStatus(status);
            course.setYear(year);
            Boolean update = CourseDAO.update(course);
            if(update!=false)
                jsp = ListCourses.execute(request, session);
            else{
                String erro = "Error Update";
                request.setAttribute("error", erro);
                jsp = "/error.jsp";
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
}
