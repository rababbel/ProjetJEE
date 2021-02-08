package com.jee.Beans;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cours;

    @NotNull
    @Column(nullable = false)
    private String titre;

    @NotNull
    @Column(nullable = false)
    private String chemin_document;

    @ManyToOne
    @NotNull
    @JoinColumn(nullable = true)
    private Module module;

    public Cours() {

    }

    public Cours(Long id_cours, String titre, String chemin_document, Module module) {
        this.id_cours = id_cours;
        this.titre = titre;
        this.chemin_document = chemin_document;
        this.module = module;
    }

    public Cours(String titre){
        this.titre = titre;
    }

    public Long getId_cours() {
        return id_cours;
    }

    public void setId_cours(Long id_cours) {
        this.id_cours = id_cours;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getChemin_document() {
        return chemin_document;
    }

    public void setChemin_document(String chemin_document) {

        this.chemin_document = chemin_document;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }
}
