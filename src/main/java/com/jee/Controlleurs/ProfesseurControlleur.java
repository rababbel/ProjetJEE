package com.jee.Controlleurs;

import com.jee.Beans.Professeur;
import com.jee.Gestionnaires.ProfesseurGestionnaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ProfesseurControlleur {

    @Autowired
    private ProfesseurGestionnaire professeurGestionnaire;

    @GetMapping("/professeurs")
    private ResponseEntity<?> getAllProfesseurs(){
        return new ResponseEntity<>(professeurGestionnaire.getAllProfesseur(), HttpStatus.OK);
    }

    @GetMapping("/professeur/{email}")
    //@RolesAllowed({"PROFESSEUR"})
    private ResponseEntity<?> getProfesseurByEmail(@PathVariable String email){
        return new ResponseEntity<Professeur>(professeurGestionnaire.getProfesseurByEmail(email), HttpStatus.OK);
    }
}
