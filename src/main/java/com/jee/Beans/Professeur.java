package com.jee.Beans;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Professeur extends Personne{
    @ManyToOne
    @NotNull
    @JoinColumn(nullable = true)
    private Departement departement;

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
