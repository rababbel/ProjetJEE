package com.jee.Controlleurs;

import com.jee.Beans.Type_Utilisateur;
import com.jee.Beans.Utilisateur;
import com.jee.Gestionnaires.ProfesseurGestionnaire;
import com.jee.Gestionnaires.UtilisateurGestionnaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

import java.util.Collection;

import static com.jee.Beans.Type_Utilisateur.*;

@RestController
public class UtilisateurControlleur {
    @Autowired
    private UtilisateurGestionnaire utilisateurGestionnaire;
    @Autowired
    private ProfesseurGestionnaire professeurGestionnaire;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping("/inscription")
    @RolesAllowed({"PROFESSEUR", "ETUDIANT", "ADMINISTRATEUR"})
    public ResponseEntity<?> ajouterUtilisateur(@Valid @RequestBody Utilisateur utilisateur){
        utilisateur.setPassword(passwordEncoder.encode(utilisateur.getPassword()));
        if (utilisateur.getType_utilisateur() == PROFESSEUR && professeurGestionnaire.isExistByEmail(utilisateur.getEmail())){
            utilisateurGestionnaire.ajouterUtilisateur(utilisateur);
        }else if (utilisateur.getType_utilisateur() == ETUDIANT || utilisateur.getType_utilisateur() == ADMINISTRATEUR){
            utilisateurGestionnaire.ajouterUtilisateur(utilisateur);
        }else {
            return new ResponseEntity<>("Professeur n'existe pas ", HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(utilisateur, HttpStatus.OK);
    }

    @PutMapping("/modifierProfil")
    public ResponseEntity<?> modifierUtilisateur(@Valid @RequestBody Utilisateur utilisateur){
        utilisateurGestionnaire.modifierUtilisateur(utilisateur);
        return new ResponseEntity<>(utilisateur,HttpStatus.OK);
    }

    @DeleteMapping("/supprimerUtilisateur/{id}")
    public ResponseEntity<?> supprimerUtilisateur(@PathVariable Long id){
        utilisateurGestionnaire.supprimerUtilisateur(id);
        return new ResponseEntity<>("utilisateur supprimer avec succes", HttpStatus.OK);
    }

    @GetMapping("/utilisateurs")
    public Collection<Utilisateur> getAllUtilisateurs(){
        Collection<Utilisateur> utilisateurs = utilisateurGestionnaire.getAllUtilisateurs();

        return utilisateurs;
    }

    @GetMapping("/utilisateur/{CNI}")
    public ResponseEntity<?> getUtilisateurByCNI(@PathVariable Long CNI){
        Utilisateur utilisateur = utilisateurGestionnaire.getUtilisateurById(CNI);
        return new ResponseEntity<Utilisateur>(utilisateur,HttpStatus.OK);
    }
    @GetMapping("/utilisateur/{email}")
    public ResponseEntity<?> getUtilisateurByEmail(@PathVariable String email){
        Utilisateur utilisateur = utilisateurGestionnaire.getUtilisateurByEmail(email);
        return new ResponseEntity<Utilisateur>(utilisateur,HttpStatus.OK);
    }

}
