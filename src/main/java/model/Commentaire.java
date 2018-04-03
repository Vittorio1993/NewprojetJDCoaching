/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author RHAW
 */
public class Commentaire {

    /**
     * Code du commentaire.
     */
    private Integer codecom;

    /**
     * Contenu du commentaire.
     */
    private String contenucom;

    /**
     * Date du commentaire.
     */
    private Date datecom;
    /**
     * Code de l'Uilisateur.
     */
    private Integer codeu;

    /**
     * Class Constructor.
     * @param codec code commentaire
     * @param contenuc contenu commentaire
     * @param datec date commentaire
     * @param codeutil code utilisateur
     */
    public Commentaire(final Integer codec, final String contenuc,
            final Date datec, final Integer codeutil) {
        this.codecom = codec;
        this.contenucom = contenuc;
        this.datecom = datec;
        this.codeu = codeutil;
    }

    /**
     * Getter Code commentaire.
     * @return codecom code commentaire
     */
    public final Integer getCodecom() {
        return codecom;
    }

    /**
     * Setter Code commentaire.
     * @param codec code commentaire
     */
    public final void setCodecom(final Integer codec) {
        this.codecom = codec;
    }

    /**
     * Getter Contenu commentaire.
     * @return contenucom contenu commentaire
     */
    public final String getContenucom() {
        return contenucom;
    }

    /**
     * Setter Contenu commentaire.
     * @param contenuc contenu commentaire
     */
    public final void setContenucom(final String contenuc) {
        this.contenucom = contenuc;
    }

    /**
     * Getter Date commentaire.
     * @return datecom date commentaire
     */
    public final Date getDatecom() {
        return datecom;
    }

    /**
     * Setter Date commentaire.
     * @param datec date commentaire
     */
    public final void setDatecom(final Date datec) {
        this.datecom = datec;
    }

    /**
     * Getter Code Utilisateur.
     * @return codeu code utilisateur
     */
    public final Integer getCodeu() {
        return codeu;
    }

    /**
     * Setter Code Utilisateur.
     * @param codeutil code utilisateur
     */
    public final void setCodeu(final Integer codeutil) {
        this.codeu = codeutil;
    }

}
