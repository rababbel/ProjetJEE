package com.jee.Controlleurs;

import com.jee.Beans.Edt;
import com.jee.Gestionnaires.EdtGestionnaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.Collection;
import java.util.HashMap;

@RestController
public class EdtControlleur {
    @Autowired
    private EdtGestionnaire edtGestionnaire;

    @PostMapping("/ajouterEdt")
    @RolesAllowed({"ADMINISTRATEUR"})
    public ResponseEntity<?> ajouterEdt(@Valid @RequestBody HashMap<String,Object> map){
        edtGestionnaire.ajouterEdt(map);
        return new ResponseEntity<>("emploi du temps ajouter avec succes", HttpStatus.OK);
    }

    @PostMapping("/modifierEdt")
    @RolesAllowed({"ADMINISTRATEUR"})
    public ResponseEntity<?> modifierEdt(@Valid @RequestBody HashMap<String,Object> map){
        edtGestionnaire.ajouterEdt(map);
        return new ResponseEntity<>("emploi du temps modifier avec succes", HttpStatus.OK);
    }

    @GetMapping("/edt/{idEdt}")
    @RolesAllowed({"ETUDIANT", "ADMINISTRATEUR","PROFESSEUR"})
    public ResponseEntity<?> getEdtByIdEdt(@PathVariable Long idEdt){
        return new ResponseEntity<>(edtGestionnaire.getEdtByIdEdt(idEdt),HttpStatus.OK);
    }

    @GetMapping("/edts")
    @RolesAllowed({"ETUDIANT", "ADMINISTRATEUR","PROFESSEUR"})
    public Collection<Edt> getAllEdts(){
        Collection<Edt> edts = edtGestionnaire.getAllEdts();
        return edts;
    }

    public ResponseEntity<?> supprimerEdt(@PathVariable Long idEdt){
        edtGestionnaire.supprimerEdt(idEdt);
        return new ResponseEntity<>("Emploi du temps supprimer avec succes", HttpStatus.OK);
    }

}
