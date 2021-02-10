package com.jee.Controlleurs;

import com.jee.Beans.Departement;
import com.jee.Gestionnaires.DepartementGestionnaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class DepartementControlleur {

    @Autowired
    private DepartementGestionnaire departementGestionnaire;

    @GetMapping("/departement/{id_departement}")
    @RolesAllowed({"ADMINISTRATEUR"})
    public ResponseEntity<?> getDepartement(@PathVariable Long id_departement){
        Departement departement = departementGestionnaire.getDepartementById(id_departement);
        return new ResponseEntity<Departement>(departement, HttpStatus.OK);
    }

}
