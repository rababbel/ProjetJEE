package com.jee.Repositories;

import com.jee.Beans.Cours;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoursDAO extends CrudRepository<Cours, Long> {
    Cours findByTitre(String titre);
    @Query("select c from Cours c where c.module.id_module =?1")
    List<Cours> getAllByModule(Long id_module);
}
