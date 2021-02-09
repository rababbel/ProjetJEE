package com.jee.Controlleurs;

import com.jee.Gestionnaires.ProfesseurGestionnaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/professeur")
    @RolesAllowed({"PROFESSEUR"})
    private ResponseEntity<?> getProfesseurByEmail(@RequestBody String email){
        return new ResponseEntity<>(professeurGestionnaire.getProfesseurByEmail(email), HttpStatus.OK);
    }
}
