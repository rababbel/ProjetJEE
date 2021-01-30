package com.jee.Repositories;

import com.jee.Beans.Semestre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SemestreDAO extends CrudRepository<Semestre, Long> {
}
