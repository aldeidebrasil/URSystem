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
               System.out.println("i"+i);
               System.out.println("size"+listCourse.size());
               System.out.println("list"+listCourse.get(i).getID());
               System.out.println("value"+listCourse.get(i).getValue());
                bill= bill + listCourse.get(i).getValue();
                System.out.println(bill);
        }
        return bill;
    }
    
}
