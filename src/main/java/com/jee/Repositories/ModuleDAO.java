package com.jee.Repositories;

import com.jee.Beans.Module;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModuleDAO extends CrudRepository<Module, Long> {
    List<Module> getAllByProfesseur(Long id_professeur);
}
