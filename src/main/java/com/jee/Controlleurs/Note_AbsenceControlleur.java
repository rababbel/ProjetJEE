package com.jee.Controlleurs;

import com.jee.Beans.Note_Absence;
import com.jee.Gestionnaires.Note_AbsenceGestionnaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.Collection;

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

    @GetMapping("/noteAbsenceEtudiant/{id_etudiant}")
    @RolesAllowed({"ETUDIANT"})
    public Collection<Note_Absence> getAllNoteAbsenceByEtudiant(@PathVariable Long id_etudiant){
        Collection<Note_Absence> note_absences = note_absenceGestionnaire.getAllByEtudiant(id_etudiant);
        return note_absences;
    }


    @GetMapping("/noteAbsenceModule/{id_module}")
    @RolesAllowed({"ADMINISTRATEUR","PROFESSEUR"})
    public Collection<Note_Absence> getAllNoteAbsenceByModule(@PathVariable Long id_module){
        Collection<Note_Absence> note_absences = note_absenceGestionnaire.getAllByModule(id_module);
        return note_absences;
    }

    @GetMapping("/noteAbsence")
    public Collection<Note_Absence> getAllNoteAbsence(){
        Collection<Note_Absence> note_absences = note_absenceGestionnaire.getAll();
        return note_absences;
    }

    @DeleteMapping("/supprimerNoteAbsence/{id_note_absence}")
    @RolesAllowed({"ADMINISTRATEUR"})
    public ResponseEntity<?> supprimerNoteAbsence(Long id_note_absence){
        note_absenceGestionnaire.deleteNoteAbsence(id_note_absence);
        return new ResponseEntity<>("Suppression avec succes", HttpStatus.OK);
    }

}
