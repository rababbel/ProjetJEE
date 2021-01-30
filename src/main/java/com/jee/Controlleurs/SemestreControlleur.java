package com.jee.Controlleurs;

import com.jee.Beans.Semestre;
import com.jee.Gestionnaires.SemestreGestionnaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
public class SemestreControlleur {

    @Autowired
    private SemestreGestionnaire semestreGestionnaire;

    @PostMapping("/ajouterSemestre")
    public ResponseEntity<?> ajouterSemestre(@Valid @RequestBody Semestre semestre){
        semestreGestionnaire.ajouterSemestre(semestre);
        return new ResponseEntity<Semestre>(semestre, HttpStatus.OK);
    }

    @PutMapping("/modifierSemestre")
    public ResponseEntity<?> modifierSemestre(@Valid @RequestBody Semestre semestre){
        semestreGestionnaire.modifierSemestre(semestre);
        return new ResponseEntity<Semestre>(semestre, HttpStatus.OK);
    }

    @GetMapping("/semestres")
    public Collection<Semestre> getAllSemestres(){
        Collection<Semestre> semestres = semestreGestionnaire.getAllSemestres();
        return semestres;
    }

    @GetMapping("/semestre/{id_semestre}")
    public ResponseEntity<?> getSemestreById(@PathVariable Long id_semestre){
        return new ResponseEntity<Semestre>(semestreGestionnaire.getSemestreById(id_semestre), HttpStatus.OK);
    }

    @DeleteMapping("/supprimerSemestre/{id_semestre}")
    public ResponseEntity<?> supprimerSemestre(@PathVariable Long id_semestre){
        semestreGestionnaire.supprimerSemestre(id_semestre);
        return new ResponseEntity<>("Semestre supprimer avec succes", HttpStatus.OK);
    }
}
