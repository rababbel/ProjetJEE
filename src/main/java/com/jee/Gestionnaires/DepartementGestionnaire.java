package com.jee.Gestionnaires;

import com.jee.Beans.Departement;
import com.jee.Repositories.DepartementDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartementGestionnaire {
    @Autowired
    private DepartementDAO departementDAO;

    public Departement getDepartementById(Long id){
        Optional<Departement> departement = departementDAO.findById(id);
        return departement.orElse(null);
    }
    public List<Departement> getAllDepartements(){
        return (List<Departement>) departementDAO.findAll();
    }
}
