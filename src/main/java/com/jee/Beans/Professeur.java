package com.jee.Beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Professeur extends Personne{
    @ManyToOne
    @NotNull
    @JoinColumn(nullable = true)
    private Departement departement;

    @OneToMany(mappedBy = "professeur")
    @JsonIgnore
    private List<Module> liste_modules;

    public Professeur() {

    }

    public Professeur(Long id, String nom, String prenom, String email, String tel, Departement departement) {
        super(id, nom, prenom, email, tel);
        this.departement = departement;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

}
