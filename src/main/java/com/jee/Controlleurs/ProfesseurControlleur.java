package com.jee.Controlleurs;

import com.jee.Gestionnaires.ProfesseurGestionnaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfesseurControlleur {

    @Autowired
    private ProfesseurGestionnaire professeurGestionnaire;

    @GetMapping("/professeurs")
    public ResponseEntity<?> getAllProfesseurs(){
        return new ResponseEntity<>(professeurGestionnaire.getAllProfesseur(), HttpStatus.OK);
    }
}
