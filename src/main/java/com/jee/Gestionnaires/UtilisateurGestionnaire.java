package com.jee.Gestionnaires;

import com.jee.Beans.Utilisateur;
import com.jee.Exceptions.UserAlreadyExisteException;
import com.jee.Repositories.UtilisateurDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
@CrossOrigin(origins = "http://localhost:3000")
public class UtilisateurGestionnaire {
    @Autowired
    private UtilisateurDAO utilisateurDAO;

    public void ajouterUtilisateur(Utilisateur utilisateur){
        if(utilisateurDAO.findByEmail(utilisateur.getEmail()) != null)
            throw new UserAlreadyExisteException("un utilisateur avec le meme email existe deja");
        utilisateurDAO.save(utilisateur);
    }

    public void modifierUtilisateur(@Valid Utilisateur utilisateur){
        utilisateurDAO.save(utilisateur);
    }

    public void supprimerUtilisateur(Long id){

        utilisateurDAO.deleteById(id);
    }
    public Utilisateur getUtilisateurById(Long id){
        Optional<Utilisateur> utilisateur = utilisateurDAO.findById(id);
        return (Utilisateur) utilisateur.orElse(null);
    }

    public Utilisateur getUtilisateurByEmail(String email){
        return utilisateurDAO.findByEmail(email);
    }

    public List<Utilisateur> getAllUtilisateurs(){
        return (List<Utilisateur>) utilisateurDAO.findAll();
    }





}
