package com.jee.Gestionnaires;

import com.jee.Beans.Note_Absence;
import com.jee.Repositories.Note_AbsenceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class Note_AbsenceGestionnaire {
    @Autowired
    private Note_AbsenceDAO note_absenceDAO;

    public void ajouterNoteAbsence(Note_Absence note_absence){

        note_absenceDAO.save(note_absence);
    }

    public void modifierNoteAbsence(@Valid Note_Absence note_absence){
        note_absenceDAO.save(note_absence);
    }

    public HashSet<Note_Absence> getAllByEtudiant(Long id_etudiant){
        HashSet<Note_Absence> note_absences = note_absenceDAO.getAllByEtudiant(id_etudiant);
        return note_absences;
    }

    public HashSet<Note_Absence> getAllByModule(Long id_module){
        HashSet<Note_Absence> note_absences = note_absenceDAO.getAllByModule(id_module);
        return note_absences;
    }

    public List<Note_Absence> getAll(){
        List<Note_Absence> note_absences = (List<Note_Absence>) note_absenceDAO.findAll();
        return note_absences;
    }


    public void deleteNoteAbsence(Long id_note_absence){
        note_absenceDAO.deleteById(id_note_absence);
    }
}
