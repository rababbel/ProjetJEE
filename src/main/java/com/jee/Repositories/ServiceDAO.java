package com.jee.Repositories;

import com.jee.Beans.Service;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceDAO extends CrudRepository<Service, Long> {

}
