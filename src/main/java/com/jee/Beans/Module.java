package com.jee.Beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_module;

    @NotNull
    @Column(nullable = false)
    private String nom_module;

    @OneToMany(mappedBy = "module")
    @JsonIgnore
    private List<Cours> liste_cours;

    @ManyToOne
    @NotNull
    @JoinColumn(nullable = true)
    private Semestre semestre;

    @ManyToOne
    @NotNull
    @JoinColumn(nullable = true)
    private Professeur professeur;
    /*
    @OneToMany(mappedBy = "module")
    private Set<Note_Absence> notes_absences = new HashSet<Note_Absence>();
    */
    public Module() {

    }

    public Module(Long id_module, String nom_module, List<Cours> liste_cours, Semestre semestre) {
        this.id_module = id_module;
        this.nom_module = nom_module;
        this.liste_cours = liste_cours;
        this.semestre = semestre;
    }

    public Long getId_module() {
        return id_module;
    }

    public void setId_module(Long id_module) {
        this.id_module = id_module;
    }

    public String getNom_module() {
        return nom_module;
    }

    public void setNom_module(String nom_module) {
        this.nom_module = nom_module;
    }

    public List<Cours> getListe_cours() {
        return liste_cours;
    }

    public void setListe_cours(List<Cours> liste_cours) {
        this.liste_cours = liste_cours;
    }

    public Semestre getSemestre() {
        return semestre;
    }

    public void setSemestre(Semestre semestre) {
        this.semestre = semestre;
    }

    public Professeur getProfesseur() {
        return professeur;
    }

    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }
    /*
    public Set<Note_Absence> getNotes_absences() {
        return notes_absences;
    }

    public void setNotes_absences(Set<Note_Absence> notes_absences) {
        this.notes_absences = notes_absences;
    }*/
}
