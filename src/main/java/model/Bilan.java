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
public class Bilan {

    private int CODEB;
    private int CODEP;
    private int CODEU;
    private String LIBELLEB;
    private String NUMSEMAINEB;
    private String COMMENTAIRECOACHB;
    private String FCALLONGEE;
    private String FCFLEXIONS;
    private String FCREPOS;
    private Date DateB;

    public Bilan(int CODEB, int CODEP, int CODEU, String LIBELLEB, String NUMSEMAINEB, String COMMENTAIRECOACHB, String FCALLONGEE, String FCFLEXIONS, String FCREPOS, Date DateB) {
        this.CODEB = CODEB;
        this.CODEP = CODEP;
        this.CODEU = CODEU;
        this.LIBELLEB = LIBELLEB;
        this.NUMSEMAINEB = NUMSEMAINEB;
        this.COMMENTAIRECOACHB = COMMENTAIRECOACHB;
        this.FCALLONGEE = FCALLONGEE;
        this.FCFLEXIONS = FCFLEXIONS;
        this.FCREPOS = FCREPOS;
        this.DateB = DateB;
    }

    public int getCODEB() {
        return CODEB;
    }

    public int getCODEP() {
        return CODEP;
    }

    public int getCODEU() {
        return CODEU;
    }

    public String getLIBELLEB() {
        return LIBELLEB;
    }

    public String getNUMSEMAINEB() {
        return NUMSEMAINEB;
    }

    public String getCOMMENTAIRECOACHB() {
        return COMMENTAIRECOACHB;
    }

    public String getFCALLONGEE() {
        return FCALLONGEE;
    }

    public String getFCFLEXIONS() {
        return FCFLEXIONS;
    }

    public String getFCREPOS() {
        return FCREPOS;
    }

    public Date getDateB() {
        return DateB;
    }

    public void setCODEB(int CODEB) {
        this.CODEB = CODEB;
    }

    public void setCODEP(int CODEP) {
        this.CODEP = CODEP;
    }

    public void setCODEU(int CODEU) {
        this.CODEU = CODEU;
    }

    public void setLIBELLEB(String LIBELLEB) {
        this.LIBELLEB = LIBELLEB;
    }

    public void setNUMSEMAINEB(String NUMSEMAINEB) {
        this.NUMSEMAINEB = NUMSEMAINEB;
    }

    public void setCOMMENTAIRECOACHB(String COMMENTAIRECOACHB) {
        this.COMMENTAIRECOACHB = COMMENTAIRECOACHB;
    }

    public void setFCALLONGEE(String FCALLONGEE) {
        this.FCALLONGEE = FCALLONGEE;
    }

    public void setFCFLEXIONS(String FCFLEXIONS) {
        this.FCFLEXIONS = FCFLEXIONS;
    }

    public void setFCREPOS(String FCREPOS) {
        this.FCREPOS = FCREPOS;
    }

    public void setDateB(Date DateB) {
        this.DateB = DateB;
    }
    
}
