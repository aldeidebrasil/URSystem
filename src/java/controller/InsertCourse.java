/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.vo.Course;
import javax.servlet.http.HttpServletRequest;
import model.CourseDAO;

/**
 *
 * @author Aldeide Brasil
 */
public class InsertCourse {
    static String execute(HttpServletRequest request) {        
        
        String error="";        
        String jsp=""; 
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String department = request.getParameter("department");
        String prerequisite = request.getParameter("prerequisite");
        Double value = Double.parseDouble(request.getParameter("value"));
        Integer idTerm = Integer.parseInt(request.getParameter("idterm"));
        String year  = request.getParameter("year");
        String status = request.getParameter("status");
        
        Course course = new Course();  
        try {
            
           course.setID(id);
           course.setName(name);
           course.setDepartment(department);
           course.setPrerequisite(prerequisite);
           course.setValue(value);
           course.setIdTerm(idTerm);
           course.setStatus(status);
           course.setYear(year);
            Boolean create = CourseDAO.create(course);
            if(create != false){
                jsp = ListCourses.execute(request);
               
            }else{
                String erro = "ERROR!";
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
