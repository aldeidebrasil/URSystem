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
public class ProfessorxCourse {
    private Integer idProfessor;
    private String idCourse;
    private Integer idTerm;
    private String year;

    public Integer getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(Integer idProfessor) {
        this.idProfessor = idProfessor;
    }

    public String getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(String idCourse) {
        this.idCourse = idCourse;
    }

    public Integer getIdTerm() {
        return idTerm;
    }

    public void setIdTerm(Integer idTerm) {
        this.idTerm = idTerm;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
    
}
