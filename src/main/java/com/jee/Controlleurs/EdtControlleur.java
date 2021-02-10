package com.jee.Controlleurs;

import com.jee.Beans.Edt;
import com.jee.Gestionnaires.EdtGestionnaire;
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
public class EdtControlleur {
    @Autowired
    private EdtGestionnaire edtGestionnaire;

    @PostMapping("/ajouterEdt")
    @RolesAllowed({"ADMINISTRATEUR"})
    public ResponseEntity<?> ajouterEdt(@RequestParam (value = "file") MultipartFile file, @RequestParam("titre") String titre, @RequestParam("saison") String saison){
        edtGestionnaire.ajouterEdt(file,titre,saison);
        return new ResponseEntity<>("emploi du temps ajouter avec succes", HttpStatus.OK);
    }

    @PutMapping("/modifierEdt")
    @RolesAllowed({"ADMINISTRATEUR"})
    public ResponseEntity<?> modifierEdt(@RequestParam (value = "file", required = false) MultipartFile file, @RequestParam("titre") String titre, @RequestParam("saison") String saison, @RequestParam("idEdt") Long idEdt){
        edtGestionnaire.modifierEdt(file,titre,saison,idEdt);
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

    @DeleteMapping("/supprimerEdt/{idEdt}")
    public ResponseEntity<?> supprimerEdt(@PathVariable Long idEdt){
        edtGestionnaire.supprimerEdt(idEdt);
        return new ResponseEntity<>("Emploi du temps supprimer avec succes", HttpStatus.OK);
    }

}
