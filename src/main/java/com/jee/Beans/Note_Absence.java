package com.jee.Beans;

import javax.persistence.*;


@Entity
public class Note_Absence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_note_absense;

    private Float note;
    private Long absence;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "id_module")
    private Module module;

    public Note_Absence() {

    }

    public Note_Absence(Long id_note_absense, Float note, Long absence, Utilisateur utilisateur, Module module) {
        this.id_note_absense = id_note_absense;
        this.note = note;
        this.absence = absence;
        this.utilisateur = utilisateur;
        this.module = module;
    }

    public Long getId_note_absense() {
        return id_note_absense;
    }

    public void setId_note_absense(Long id_note_absense) {
        this.id_note_absense = id_note_absense;
    }

    public Float getNote() {
        return note;
    }

    public void setNote(Float note) {
        this.note = note;
    }

    public Long getAbsence() {
        return absence;
    }

    public void setAbsence(Long absence) {
        this.absence = absence;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }
}
