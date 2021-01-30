package com.jee.Beans;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Utilisateur extends Personne{
    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Type_Utilisateur type_utilisateur;

    @OneToMany(mappedBy = "etudiantModule.utilisateur")
    private List<Note_Absence> notes_absences = new ArrayList<Note_Absence>();

    public Utilisateur() {
        super();
    }

    public Utilisateur(Long id, String nom, String prenom, String email, String tel, String password, Type_Utilisateur type_utilisateur) {
        super(id, nom, prenom, email, tel);
        this.password = password;
        this.type_utilisateur = type_utilisateur;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Type_Utilisateur getType_utilisateur() {
        return type_utilisateur;
    }

    public void setType_utilisateur(Type_Utilisateur type_utilisateur) {
        this.type_utilisateur = type_utilisateur;
    }

    public List<Note_Absence> getNotes_absences() {
        return notes_absences;
    }

    public void setNotes_absences(List<Note_Absence> notes_absences) {
        this.notes_absences = notes_absences;
    }

}
