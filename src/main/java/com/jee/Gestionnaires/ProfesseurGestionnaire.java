package com.jee.Gestionnaires;

import com.jee.Beans.Professeur;
import com.jee.Repositories.ProfesseurDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesseurGestionnaire {
    @Autowired
    private ProfesseurDAO professeurDAO;

    public Professeur getProfesseurById(Long id){
        Optional<Professeur> professeur = professeurDAO.findById(id);
        return professeur.orElse(null);
    }
    public List<Professeur> getAllProfesseur(){
        return (List<Professeur>) professeurDAO.findAll();
    }

    public boolean isExist(Long id){
        return professeurDAO.existsById(id);
    }
    public boolean isExistByEmail(String email){
        return professeurDAO.existsByEmail(email);
    }

    public Professeur getProfesseurByEmail(String email){
        System.out.println(professeurDAO.getProfesseurByEmail(email));
        return professeurDAO.getProfesseurByEmail(email);
    }
}
