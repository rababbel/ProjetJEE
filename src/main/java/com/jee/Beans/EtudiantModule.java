package com.jee.Beans;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class EtudiantModule implements Serializable {
    @ManyToOne
    @JoinColumn(name = "id_etudiant")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "id_module")
    private Module module;


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
