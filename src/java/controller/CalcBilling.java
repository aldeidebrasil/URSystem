/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.vo.Course;
import java.util.ArrayList;

/**
 *
 * @author Aldeide Brasil
 */
public class CalcBilling {
   
    static double execute(ArrayList<Course> listCourse) {
        double bill=0;
        for(int i=0; i<listCourse.size(); i++){
            bill+= listCourse.get(i).getValue();
        }
        return bill;
    }
    
}
