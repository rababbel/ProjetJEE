package com.jee.Beans;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Semestre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_semestre;

    @OneToMany(mappedBy = "semestre")
    @JsonIgnore
    private List<Module> liste_modules;

    public Semestre() {

    }

    public Semestre(Long id_semestre, List<Module> liste_modules) {
        this.id_semestre = id_semestre;
        this.liste_modules = liste_modules;
    }

    public Long getId_semestre() {
        return id_semestre;
    }

    public void setId_semestre(Long id_semestre) {
        this.id_semestre = id_semestre;
    }

    public List<Module> getListe_modules() {
        return liste_modules;
    }

    public void setListe_modules(List<Module> liste_modules) {
        this.liste_modules = liste_modules;
    }

}
