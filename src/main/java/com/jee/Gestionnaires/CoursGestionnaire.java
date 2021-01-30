package com.jee.Gestionnaires;

import com.jee.Beans.Cours;
import com.jee.Repositories.CoursDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class CoursGestionnaire {

    @Autowired
    private CoursDAO coursDAO;

    public void ajouterCours(Cours cours){
        coursDAO.save(cours);
    }
    public void modifierCours(@Valid Cours cours){
        coursDAO.save(cours);
    }

    public void supprimerCours(Long id_cours){
        coursDAO.deleteById(id_cours);
    }
    public Cours getCoursById(Long id_cours){
        Optional<Cours> cours = coursDAO.findById(id_cours);
        return cours.orElse(null);
    }
    public List<Cours> getAllCours(){
        return (List<Cours>) coursDAO.findAll();
    }
}
