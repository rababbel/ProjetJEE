package com.jee.Beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_departement;
    @NotNull
    @Column(nullable = false)
    private String nom_departement;

    @OneToMany(mappedBy = "departement")
    @JsonIgnore
    private List<Professeur> liste_professeurs;

    public Departement() {

    }

    public Departement(Long id_departement, String nom_departement, List liste_professeurs) {
        this.id_departement = id_departement;
        this.nom_departement = nom_departement;
        this.liste_professeurs = liste_professeurs;
    }

    public Long getId_departement() {
        return id_departement;
    }

    public void setId_departement(Long id_departement) {
        this.id_departement = id_departement;
    }

    public String getNom_departement() {
        return nom_departement;
    }

    public void setNom_departement(String nom_departement) {
        this.nom_departement = nom_departement;
    }

    public List getListe_professeurs() {
        return liste_professeurs;
    }

    public void setListe_professeurs(List liste_professeurs) {
        this.liste_professeurs = liste_professeurs;
    }

}
