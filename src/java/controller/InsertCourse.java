/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
        String term = request.getParameter("term");
        String status = request.getParameter("status");
        Integer idProfessor = Integer.parseInt(request.getParameter("idProfessor"));
       
        
        
        Course course = new Course();  
        try {
           course.setID(id);
           course.setName(name);
           course.setDepartment(department);
           course.setPrerequisite(prerequisite);
           course.setValue(value);
           course.setTerm(term);
           course.setStatus(status);
           course.setIDProfessor(idProfessor);
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