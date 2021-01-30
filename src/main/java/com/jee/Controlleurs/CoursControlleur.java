package com.jee.Controlleurs;

import com.jee.Beans.Cours;
import com.jee.Gestionnaires.CoursGestionnaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
public class CoursControlleur {

    @Autowired
    private CoursGestionnaire coursGestionnaire;

    @GetMapping("/cours")
    public Collection<Cours> getAllCours(){
        Collection<Cours> cours = coursGestionnaire.getAllCours();
        return cours;
    }
    @GetMapping("/cours/{id_cours}")
    public ResponseEntity<?> getCoursById(@PathVariable Long id_cours){
        return new ResponseEntity<>(coursGestionnaire.getCoursById(id_cours), HttpStatus.OK);
    }

    @PostMapping("/ajouterCours")
    public ResponseEntity<?> ajouterCours(@Valid @RequestBody Cours cours){
        coursGestionnaire.ajouterCours(cours);
        return new ResponseEntity<>(cours,HttpStatus.OK);
    }

    @PutMapping("/modifierCours")
    public ResponseEntity<?> modifierCours(@Valid @RequestBody Cours cours){
        coursGestionnaire.modifierCours(cours);
        return new ResponseEntity<>(cours,HttpStatus.OK);
    }

    @DeleteMapping("/supprimerCours/{id_cours}")
    public ResponseEntity<?> supprimerCours(@PathVariable Long id_cours){
        coursGestionnaire.supprimerCours(id_cours);
        return new ResponseEntity<>("Cours supprimer avec succes",HttpStatus.OK);
    }
}
