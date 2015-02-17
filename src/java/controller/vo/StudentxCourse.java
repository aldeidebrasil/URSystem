/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.vo;

/**
 *
 * @author Aldeide Brasil
 */
public class StudentxCourse {
    private String IdCourse;
    private Integer IdStudent;
    private Integer IdTerm;
    private String year;

    public String getIdCourse() {
        return IdCourse;
    }

    public void setIdCourse(String IdCourse) {
        this.IdCourse = IdCourse;
    }

    public Integer getIdStudent() {
        return IdStudent;
    }

    public void setIdStudent(Integer IdStudent) {
        this.IdStudent = IdStudent;
    }

    public Integer getIdTerm() {
        return IdTerm;
    }

    public void setIdTerm(Integer IdTerm) {
        this.IdTerm = IdTerm;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
    
    
    
}
