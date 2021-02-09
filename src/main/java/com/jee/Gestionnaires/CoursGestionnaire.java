package com.jee.Gestionnaires;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jee.Beans.Cours;
import com.jee.Beans.Module;
import com.jee.Exceptions.FileAdditionFailedException;
import com.jee.Repositories.CoursDAO;
import com.jee.Repositories.ModuleDAO;
import com.jee.Utils.UtilMethodes;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class CoursGestionnaire {

    @Autowired
    private CoursDAO coursDAO;
    @Autowired
    private ModuleDAO moduleDAO;

    public void ajouterCours(MultipartFile file, Long idModule, String titre)
    {
        System.out.println(idModule);
        System.out.println(titre);
        Cours cours = new Cours();
        if(file != null){
            String absoultePath = UtilMethodes.sauvegarderFichier(file);
            cours.setChemin_document(absoultePath);
        }
        Module module = moduleDAO.findById(idModule).orElse(null);
        cours.setTitre(titre);
        cours.setModule(module);
        coursDAO.save(cours);
    }

    public void modifierCours(MultipartFile file, Long idModule, String titre, Long idCours){
        Cours cours = coursDAO.findById(idCours).orElse(null);
        if(file != null){
            String absoultePath = UtilMethodes.sauvegarderFichier(file);
            cours.setChemin_document(absoultePath);
        }
        Module module = moduleDAO.findById(idModule).orElse(null);
        cours.setModule(module);
        cours.setTitre(titre);
        coursDAO.save(cours);
    }

    public void supprimerCours(Long id_cours){
        coursDAO.deleteById(id_cours);
    }
    public Cours getCoursById(Long id_cours){
        Optional<Cours> cours = coursDAO.findById(id_cours);
        return cours.orElse(null);
    }
    public List<Cours> getAllCours(){
        return (List<Cours>) coursDAO.findAll();
    }
    public List<Cours> getAllCoursByModule(Long id_module){
        return coursDAO.getAllByModule(id_module);
    }
}
