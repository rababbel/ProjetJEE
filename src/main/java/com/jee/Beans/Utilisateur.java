package com.jee.Beans;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Utilisateur extends Personne{
    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ROLE role;

    @OneToMany(mappedBy = "etudiantModule.utilisateur")
    private List<Note_Absence> notes_absences = new ArrayList<Note_Absence>();

    @OneToMany(mappedBy = "utilisateur")
    @JsonIgnore
    private List<Service> liste_services;

    public Utilisateur() {
        super();
    }

    public Utilisateur(Long id, String nom, String prenom, String email, String tel, String password, ROLE ROLE) {
        super(id, nom, prenom, email, tel);
        this.password = password;
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ROLE getRole() {
        return role;
    }

    public void setRole(ROLE role) {
        this.role = role;
    }

    public List<Note_Absence> getNotes_absences() {
        return notes_absences;
    }

    public void setNotes_absences(List<Note_Absence> notes_absences) {
        this.notes_absences = notes_absences;
    }

    public List<Service> getListe_services() {
        return liste_services;
    }

    public void setListe_services(List<Service> liste_services) {
        this.liste_services = liste_services;
    }
}
