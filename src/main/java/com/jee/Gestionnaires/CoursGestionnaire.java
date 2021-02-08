package com.jee.Gestionnaires;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jee.Beans.Cours;
import com.jee.Beans.Module;
import com.jee.Exceptions.FileAdditionFailedException;
import com.jee.Repositories.CoursDAO;
import com.jee.Repositories.ModuleDAO;
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

    public  String uploadDir = System.getProperty("user.dir")+"/uploadedDocs";

    public void ajouterCours(HashMap<String,Object> map)
    {
        ObjectMapper om = new ObjectMapper();
        Long idModule = (Long) map.get("idModule");
        MultipartFile file = (MultipartFile) map.get("file");

        map.remove("idModule");
        map.remove("file");

        File fichier = new File(uploadDir,file.getOriginalFilename());
        Path chemin = Paths.get(fichier.getAbsolutePath());
        try{
            Files.write(chemin,file.getBytes());
        }
        catch (IOException e){
            throw new FileAdditionFailedException("fichier n’a pas pu être enregistré ");
        }

        Cours cours = om.convertValue(map,Cours.class);
        Module module = moduleDAO.findById(idModule).orElse(null);
        cours.setModule(module);
        cours.setChemin_document(fichier.getAbsolutePath());
        coursDAO.save(cours);
    }
    public void modifierCours(@Valid Cours cours){
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
