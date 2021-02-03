package com.jee.Repositories;

import com.jee.Beans.EtudiantModule;
import com.jee.Beans.Note_Absence;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Note_AbsenceDAO extends CrudRepository<Note_Absence, EtudiantModule> {

    @Query("select n_a from Note_Absence n_a where n_a.etudiantModule.utilisateur.id = ?1 and n_a.etudiantModule.utilisateur.type_utilisateur = 'ETUDIANT'")
    List<Note_Absence> getAllByEtudiant(Long id_etudiant);

    @Query("select n_a from Note_Absence n_a where n_a.etudiantModule.module.id_module = ?1 and n_a.etudiantModule.utilisateur.type_utilisateur = 'ETUDIANT'")
    List<Note_Absence> getAllByModule(Long id_module);

}
