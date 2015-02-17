/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Calendar;

/**
 *
 * @author Aldeide Brasil
 */
public class VerifyTerm {
    public static Integer execute(){
    int month = Calendar.getInstance().get(Calendar.MONTH);
           if(month>=1 && month<=4){
               return 1;
           }else if(month>=5 && month<=7){
               return 3;
           }else if(month>=9 && month<=12){
               return 2;
           }
           return 4;
    
    }
}
