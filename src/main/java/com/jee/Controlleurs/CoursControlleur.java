package com.jee.Controlleurs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jee.Beans.Cours;
import com.jee.Gestionnaires.CoursGestionnaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.Collection;
import java.util.HashMap;

@RestController
@CrossOrigin(origins = "*")
public class CoursControlleur {

    @Autowired
    private CoursGestionnaire coursGestionnaire;

    @GetMapping("/cours")
    @RolesAllowed({"ADMINISTRATEUR","ETUDIANT"})
    public Collection<Cours> getAllCours(){
        Collection<Cours> cours = coursGestionnaire.getAllCours();
        return cours;
    }

    @GetMapping("/Modulecours/{id_module}")
    @RolesAllowed({"ADMINISTRATEUR","ETUDIANT"})
    public Collection<Cours> getAllCoursByModule(@PathVariable Long id_module){
        Collection<Cours> cours = coursGestionnaire.getAllCoursByModule(id_module);
        return cours;
    }

    @GetMapping("/cours/{id_cours}")
    @RolesAllowed({"ETUDIANT", "ADMINISTRATEUR"})
    public ResponseEntity<?> getCoursById(@PathVariable Long id_cours){
        return new ResponseEntity<>(coursGestionnaire.getCoursById(id_cours), HttpStatus.OK);
    }

    @PostMapping("/ajouterCours")
    @RolesAllowed({"ADMINISTRATEUR"})
    @JsonIgnoreProperties(ignoreUnknown = true)
    public ResponseEntity<?> ajouterCours(@RequestParam (value = "file") MultipartFile file, @RequestParam("idModule") Long idModule, @RequestParam("titre") String titre){
        coursGestionnaire.ajouterCours(file,idModule, titre);
        return new ResponseEntity<>("cours ajouter avec succes",HttpStatus.OK);
    }


    @PutMapping("/modifierCours")
    @RolesAllowed({"ADMINISTRATEUR"})
    @JsonIgnoreProperties(ignoreUnknown = true)
    public ResponseEntity<?> modifierCours(@RequestParam (value = "file", required = false) MultipartFile file, @RequestParam("idModule") Long idModule, @RequestParam("titre") String titre, @RequestParam("id_cours") Long idCours){
        coursGestionnaire.modifierCours(file,idModule,titre,idCours);
        return new ResponseEntity<>("cours modifie avec succes",HttpStatus.OK);
    }

        @DeleteMapping("/supprimerCours/{id_cours}")
    @RolesAllowed({"ADMINISTRATEUR"})
    public ResponseEntity<?> supprimerCours(@PathVariable Long id_cours){
        coursGestionnaire.supprimerCours(id_cours);
        return new ResponseEntity<>("Cours supprimer avec succes",HttpStatus.OK);
    }
}
