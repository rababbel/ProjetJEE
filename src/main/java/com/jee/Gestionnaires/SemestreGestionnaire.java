package com.jee.Gestionnaires;

import com.jee.Beans.Semestre;
import com.jee.Repositories.SemestreDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class SemestreGestionnaire {
    @Autowired
    private SemestreDAO semestreDAO;

    public void ajouterSemestre(Semestre semestre){

        semestreDAO.save(semestre);
    }
    public void modifierSemestre(@Valid Semestre semestre){

        semestreDAO.save(semestre);
    }

    public void supprimerSemestre(Long id_semestre){

        semestreDAO.deleteById(id_semestre);
    }
    public Semestre getSemestreById(Long id_semestre){
        Optional<Semestre> semestre = semestreDAO.findById(id_semestre);
        return (Semestre) semestre.orElse(null);
    }
    public List<Semestre> getAllSemestres(){

        return (List<Semestre>) semestreDAO.findAll();
    }
}
