/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author zhanghuakai
 */
public class Exercice {
    private int CODEE;
    private String LIBELLEE;
    private String DUREEE;
    private String LIENIMAGE;
    private String REPETE;
    private String DESCRIPTION;

    public Exercice(String LIBELLEE, String DUREEE, String LIENIMAGE, String REPETE, String DESCRIPTION) {
        this.LIBELLEE = LIBELLEE;
        this.DUREEE = DUREEE;
        this.LIENIMAGE = LIENIMAGE;
        this.REPETE = REPETE;
        this.DESCRIPTION = DESCRIPTION;
    }

    public int getCODEE() {
        return CODEE;
    }

    public String getLIBELLEE() {
        return LIBELLEE;
    }

    public String getDUREEE() {
        return DUREEE;
    }

    public String getLIENIMAGE() {
        return LIENIMAGE;
    }


    public String getREPETE() {
        return REPETE;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setCODEE(int CODEE) {
        this.CODEE = CODEE;
    }

    public void setLIBELLEE(String LIBELLEE) {
        this.LIBELLEE = LIBELLEE;
    }

    public void setDUREEE(String DUREEE) {
        this.DUREEE = DUREEE;
    }

    public void setLIENIMAGE(String LIENIMAGE) {
        this.LIENIMAGE = LIENIMAGE;
    }

    public void setREPETE(String REPETE) {
        this.REPETE = REPETE;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

   
    
            
    
}
