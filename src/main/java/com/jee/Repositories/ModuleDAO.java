package com.jee.Repositories;

import com.jee.Beans.Module;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleDAO extends CrudRepository<Module, Long> {

}
