package com.jee.Beans;

public class Edt {
    private Long idEdt;
    private String titre;
    private String saison;
    private String chemain;

    public Edt() {

    }

    public Edt(Long idEdt, String titre, String saison, String chemain) {
        this.idEdt = idEdt;
        this.titre = titre;
        this.saison = saison;
        this.chemain = chemain;
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

    public String getChemain() {
        return chemain;
    }

    public void setChemain(String chemain) {
        this.chemain = chemain;
    }
}
