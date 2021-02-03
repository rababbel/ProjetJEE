package com.jee.Repositories;

import com.jee.Beans.Utilisateur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurDAO extends CrudRepository<Utilisateur, Long> {
    Utilisateur findByEmail(String email);
    Utilisateur findByNom(String nom);
    Utilisateur findByTel(String tel);
}
