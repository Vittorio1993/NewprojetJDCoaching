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
    private String LIENVEDIO;
    private String REPETE;
    private String DESCRIPTIO;

    public Exercice(String LIBELLEE, String DUREEE, String LIENIMAGE, String LIENVEDIO, String REPETE, String DESCRIPTIO) {
        this.LIBELLEE = LIBELLEE;
        this.DUREEE = DUREEE;
        this.LIENIMAGE = LIENIMAGE;
        this.LIENVEDIO = LIENVEDIO;
        this.REPETE = REPETE;
        this.DESCRIPTIO = DESCRIPTIO;
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

    public String getLIENVEDIO() {
        return LIENVEDIO;
    }

    public String getREPETE() {
        return REPETE;
    }

    public String getDESCRIPTIO() {
        return DESCRIPTIO;
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

    public void setLIENVEDIO(String LIENVEDIO) {
        this.LIENVEDIO = LIENVEDIO;
    }

    public void setREPETE(String REPETE) {
        this.REPETE = REPETE;
    }

    public void setDESCRIPTIO(String DESCRIPTIO) {
        this.DESCRIPTIO = DESCRIPTIO;
    }

   
    
            
    
}
