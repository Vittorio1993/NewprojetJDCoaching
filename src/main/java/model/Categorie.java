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
public class Categorie{ 
        public Integer CODECA; 
        public String LIBELLECA; 

    public Categorie(Integer CODECA, String LIBELLECA) {
        this.CODECA = CODECA;
        this.LIBELLECA = LIBELLECA;
    }

    public Categorie() {
      
    }

    public Categorie(String libellecat) {
         this.LIBELLECA = LIBELLECA;
    }

    public Integer getCODECA() {
        return CODECA;
    }

    public String getLIBELLECA() {
        return LIBELLECA;
    }

    public void setCODECA(Integer CODECA) {
        this.CODECA = CODECA;
    }

    public void setLIBELLECA(String LIBELLECA) {
        this.LIBELLECA = LIBELLECA;
    }

}
