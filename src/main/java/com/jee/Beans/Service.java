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

    @ManyToOne
    @NotNull
    @JoinColumn(nullable = true)
    private Utilisateur utilisateur;

    public Service() {

    }

    public Service(Long id_service, String description) {
        this.id_service = id_service;
        this.description = description;
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
}
