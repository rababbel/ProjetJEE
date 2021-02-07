package com.jee.Repositories;

import com.jee.Beans.Module;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModuleDAO extends CrudRepository<Module, Long> {
    @Query("select m from Module m where m.professeur.id = ?1")
    List<Module> getAllByProfesseur(Long id_professeur);

    @Query("select m from Module m where m.semestre.id_semestre = ?1")
    List<Module> getAllBySemeste(Long id_semestre);
}
