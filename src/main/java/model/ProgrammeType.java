/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author utilisateur
 */
public class ProgrammeType {
     private Integer CODEPT; 
    private String NOMPT; 
    private String DESCRIPTIONPT; 

    public ProgrammeType(Integer CODEPT, String NOMPT, String DESCRIPTIONPT) {
        this.CODEPT = CODEPT;
        this.NOMPT = NOMPT;
        this.DESCRIPTIONPT = DESCRIPTIONPT;
    }

    public ProgrammeType() {
        
    }

    public ProgrammeType(String nompt, String descpt) {
        this.NOMPT = NOMPT;
        this.DESCRIPTIONPT = DESCRIPTIONPT;
    }

    public Integer getCODEPT() {
        return CODEPT;
    }

    public String getNOMPT() {
        return NOMPT;
    }

    public String getDESCRIPTIONPT() {
        return DESCRIPTIONPT;
    }

    public void setCODEPT(Integer CODEPT) {
        this.CODEPT = CODEPT;
    }

    public void setNOMPT(String NOMPT) {
        this.NOMPT = NOMPT;
    }

    public void setDESCRIPTIONPT(String DESCRIPTIONPT) {
        this.DESCRIPTIONPT = DESCRIPTIONPT;
    }

}