package com.jee.Repositories;

import com.jee.Beans.Departement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartementDAO extends CrudRepository<Departement, Long> {
}
