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
public class Mesuration {

    private int CODEM;
    private Date DATEMESURE;
    private String LIBELLEM;
    private String POIDS;
    private String BRAS;
    private String POITRINE;
    private String TAILLE;
    private String HANCHES;
    private String CUISSES;
    private int CODEU;

    public Mesuration(int CODEM, Date DATEMESURE, String LIBELLEM, String POIDS, String BRAS, String POITRINE, String TAILLE, String HANCHES, String CUISSES, int CODEU) {
        this.CODEM = CODEM;
        this.DATEMESURE = DATEMESURE;
        this.LIBELLEM = LIBELLEM;
        this.POIDS = POIDS;
        this.BRAS = BRAS;
        this.POITRINE = POITRINE;
        this.TAILLE = TAILLE;
        this.HANCHES = HANCHES;
        this.CUISSES = CUISSES;
        this.CODEU = CODEU;
    }

    public int getCODEM() {
        return CODEM;
    }

    public Date getDATEMESURE() {
        return DATEMESURE;
    }

    public String getLIBELLEM() {
        return LIBELLEM;
    }

    public String getPOIDS() {
        return POIDS;
    }

    public String getBRAS() {
        return BRAS;
    }

    public String getPOITRINE() {
        return POITRINE;
    }

    public String getTAILLE() {
        return TAILLE;
    }

    public String getHANCHES() {
        return HANCHES;
    }

    public String getCUISSES() {
        return CUISSES;
    }

    public int getCODEU() {
        return CODEU;
    }

    public void setCODEM(int CODEM) {
        this.CODEM = CODEM;
    }

    public void setDATEMESURE(Date DATEMESURE) {
        this.DATEMESURE = DATEMESURE;
    }

    public void setLIBELLEM(String LIBELLEM) {
        this.LIBELLEM = LIBELLEM;
    }

    public void setPOIDS(String POIDS) {
        this.POIDS = POIDS;
    }

    public void setBRAS(String BRAS) {
        this.BRAS = BRAS;
    }

    public void setPOITRINE(String POITRINE) {
        this.POITRINE = POITRINE;
    }

    public void setTAILLE(String TAILLE) {
        this.TAILLE = TAILLE;
    }

    public void setHANCHES(String HANCHES) {
        this.HANCHES = HANCHES;
    }

    public void setCUISSES(String CUISSES) {
        this.CUISSES = CUISSES;
    }

    public void setCODEU(int CODEU) {
        this.CODEU = CODEU;
    }
    
    
    
    
    

}
