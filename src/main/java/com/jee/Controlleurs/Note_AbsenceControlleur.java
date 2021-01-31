package com.jee.Controlleurs;

import com.jee.Beans.EtudiantModule;
import com.jee.Beans.Note_Absence;
import com.jee.Gestionnaires.Note_AbsenceGestionnaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.Collection;
import java.util.Optional;

@RestController
public class Note_AbsenceControlleur {

    @Autowired
    private Note_AbsenceGestionnaire note_absenceGestionnaire;

    @PostMapping("/ajouterNoteAbsence")
    @RolesAllowed({"PROFESSEUR"})
    public ResponseEntity<?> ajouterNoteAbsence(@Valid @RequestBody Note_Absence note_absence){
        note_absenceGestionnaire.ajouterNoteAbsence(note_absence);
        return new ResponseEntity<Note_Absence>(note_absence, HttpStatus.OK);
    }

    @PutMapping("/modifierNoteAbsence")
    @RolesAllowed({"PROFESSEUR"})
    public ResponseEntity<?> modifierNoteAbsence(@Valid @RequestBody Note_Absence note_absence){
        note_absenceGestionnaire.modifierNoteAbsence(note_absence);
        return new ResponseEntity<Note_Absence>(note_absence,HttpStatus.OK);
    }

    @GetMapping("/NotesAbsences/{etudiantModule}")
    @RolesAllowed({"PROFESSEUR", "ETUDIANT", "ADMINISTRATEUR"})
    public Collection<Note_Absence> getAllNoteAbsenceByEtudiantModule(EtudiantModule etudiantModule){
        Collection<Note_Absence> note_absences = note_absenceGestionnaire.getAllNoteAbsenceByEtudiantModule(etudiantModule);
        return note_absences;
    }


    @DeleteMapping("/supprimerNoteModule/{etudiantModule}")
    @RolesAllowed({"ADMINISTRATEUR"})
    public ResponseEntity<?> supprimerNoteAbsence(EtudiantModule etudiantModule){
        note_absenceGestionnaire.deleteNoteAbsence(etudiantModule);
        return new ResponseEntity<>("Suppression avec succes", HttpStatus.OK);
    }

}
