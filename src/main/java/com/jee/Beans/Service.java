package com.jee.Beans;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_service;

    @NotNull
    @Column(nullable = false)
    private String description;

    @Column
    private String reponse;

    @Column
    private boolean accepte;

    @ManyToOne
    @NotNull
    @JoinColumn(nullable = true)
    private Utilisateur utilisateur;

    public Service() {

    }

    public Service(Long id_service, String description, Utilisateur utilisateur) {
        this.id_service = id_service;
        this.description = description;
        this.utilisateur = utilisateur;
    }

    public Long getId_service() {
        return id_service;
    }

    public void setId_service(Long id_service) {
        this.id_service = id_service;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public boolean isAccepte() {
        return accepte;
    }

    public void setAccepte(boolean accepte) {
        this.accepte = accepte;
    }
}
