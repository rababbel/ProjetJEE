package com.jee.Beans;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class Edt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEdt;

    @NotNull
    @Column(nullable = false)
    private String titre;

    @NotNull
    @Column(nullable = false)
    private String saison;

    @NotNull
    @Column(nullable = false)
    private String chemin;

    public Edt() {

    }

    public Edt(Long idEdt, String titre, String saison, String chemin) {
        this.idEdt = idEdt;
        this.titre = titre;
        this.saison = saison;
        this.chemin = chemin;
    }

    public Long getIdEdt() {
        return idEdt;
    }

    public void setIdEdt(Long idEdt) {
        this.idEdt = idEdt;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getSaison() {
        return saison;
    }

    public void setSaison(String saison) {
        this.saison = saison;
    }

    public String getChemin() {
        return chemin;
    }

    public void setChemin(String chein) {
        this.chemin = chemin;
    }
}
