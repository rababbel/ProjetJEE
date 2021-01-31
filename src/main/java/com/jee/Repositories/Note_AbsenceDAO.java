package com.jee.Repositories;

import com.jee.Beans.EtudiantModule;
import com.jee.Beans.Note_Absence;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Note_AbsenceDAO extends CrudRepository<Note_Absence, EtudiantModule> {

}
