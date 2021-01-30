package com.jee.Beans;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Note_Absence {
    @Id
    private EtudiantModule etudiantModule;

    private Long note;
    private Long absence;


    public EtudiantModule getEtudiantModule() {
        return etudiantModule;
    }

    public void setEtudiantModule(EtudiantModule etudiantModule) {
        this.etudiantModule = etudiantModule;
    }

    public Long getNote() {
        return note;
    }

    public void setNote(Long note) {
        this.note = note;
    }

    public Long getAbsence() {
        return absence;
    }

    public void setAbsence(Long absence) {
        this.absence = absence;
    }

}
