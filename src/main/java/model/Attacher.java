/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author zhanghuakai
 */
public class Attacher {
    private int CODEB;
    private int CODEE;
    private Date DATEEFFECT;
    private String ORDRE;
    private String MAXTEMPS;
    private String NUMREPETITION;

    public Attacher(int CODEB, int CODEE, Date DATEEFFECT, String ORDRE, String MAXTEMPS, String NUMREPETITION) {
        this.CODEB = CODEB;
        this.CODEE = CODEE;
        this.DATEEFFECT = DATEEFFECT;
        this.ORDRE = ORDRE;
        this.MAXTEMPS = MAXTEMPS;
        this.NUMREPETITION = NUMREPETITION;
    }

    public int getCODEB() {
        return CODEB;
    }

    public int getCODEE() {
        return CODEE;
    }

    public Date getDATEEFFECT() {
        return DATEEFFECT;
    }

    public String getORDRE() {
        return ORDRE;
    }

    public String getMAXTEMPS() {
        return MAXTEMPS;
    }

    public String getNUMREPETITION() {
        return NUMREPETITION;
    }

    public void setCODEB(int CODEB) {
        this.CODEB = CODEB;
    }

    public void setCODEE(int CODEE) {
        this.CODEE = CODEE;
    }

    public void setDATEEFFECT(Date DATEEFFECT) {
        this.DATEEFFECT = DATEEFFECT;
    }

    public void setORDRE(String ORDRE) {
        this.ORDRE = ORDRE;
    }

    public void setMAXTEMPS(String MAXTEMPS) {
        this.MAXTEMPS = MAXTEMPS;
    }

    public void setNUMREPETITION(String NUMREPETITION) {
        this.NUMREPETITION = NUMREPETITION;
    }
    
    
    
}
