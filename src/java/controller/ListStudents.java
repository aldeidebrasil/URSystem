/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import model.StudentDAO;

/**
 *
 * @author Aldeide Brasil
 */
public class ListStudents {
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            ArrayList<Student> listStudents = StudentDAO.getAll();
            if(listStudents != null){
                request.setAttribute("listStudents", listStudents);
                jsp = "/allStudents.jsp";    
            }else{
                String erro="There is no Students to show!";
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
