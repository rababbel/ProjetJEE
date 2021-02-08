package com.jee.Gestionnaires;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jee.Beans.Cours;
import com.jee.Beans.Edt;
import com.jee.Beans.Module;
import com.jee.Exceptions.FileAdditionFailedException;
import com.jee.Repositories.EdtDAO;
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
public class EdtGestionnaire {
    @Autowired
    private EdtDAO edtDAO;

    private  String uploadDir = System.getProperty("user.dir")+"/uploadedDocs";

    public void ajouterEdt(HashMap<String,Object> map)
    {
        ObjectMapper om = new ObjectMapper();
        MultipartFile file = (MultipartFile) map.get("file");

        map.remove("file");

        File fichier = new File(uploadDir,file.getOriginalFilename());
        Path chemin = Paths.get(fichier.getAbsolutePath());
        try{
            Files.write(chemin,file.getBytes());
        }
        catch (IOException e){
            throw new FileAdditionFailedException("fichier n’a pas pu être enregistré ");
        }

        Edt edt = om.convertValue(map,Edt.class);
        edt.setChemin(fichier.getAbsolutePath());
        edtDAO.save(edt);

    }
    public void modifierEdt(@Valid Edt edt){
        edtDAO.save(edt);
    }

    public Optional<Edt> getEdtByIdEdt(Long idEdt){
        return edtDAO.findById(idEdt);
    }
    public List<Edt> getAllEdts(){
        return (List<Edt>) edtDAO.findAll();
    }

    public void supprimerEdt(Long idEdt){
        edtDAO.deleteById(idEdt);
    }
}
