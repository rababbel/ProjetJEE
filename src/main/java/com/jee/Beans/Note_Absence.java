package com.jee.Beans;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Note_Absence {
    @Id
    private EtudiantModule etudiantModule;

    private Float note;
    private Long absence;

    public Note_Absence(EtudiantModule etudiantModule, Float note) {
        this.etudiantModule = etudiantModule;
        this.note = note;
    }

    public Note_Absence(EtudiantModule etudiantModule, Long absence) {
        this.etudiantModule = etudiantModule;
        this.absence = absence;
    }

    public Note_Absence() {
    }

    public EtudiantModule getEtudiantModule() {
        return etudiantModule;
    }

    public void setEtudiantModule(EtudiantModule etudiantModule) {
        this.etudiantModule = etudiantModule;
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

}
