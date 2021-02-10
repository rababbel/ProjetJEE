package com.jee.Gestionnaires;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jee.Beans.Cours;
import com.jee.Beans.Edt;
import com.jee.Beans.Module;
import com.jee.Exceptions.FileAdditionFailedException;
import com.jee.Repositories.EdtDAO;
import com.jee.Utils.UtilMethodes;
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

    public void ajouterEdt(MultipartFile file, String titre, String saison)
    {
        Edt edt = new Edt();
        edt.setSaison(saison);
        if(file != null){
            String absoultePath = UtilMethodes.sauvegarderFichier(file);
            edt.setChemin(absoultePath);
        }
        edt.setTitre(titre);
        edtDAO.save(edt);

    }
    public  void modifierEdt(MultipartFile file, String titre, String saison, Long idEdt){
        Edt edt = edtDAO.findById(idEdt).orElse(null);
        edt.setSaison(saison);
        if(file != null){
            String absoultePath = UtilMethodes.sauvegarderFichier(file);
            edt.setChemin(absoultePath);
        }
        edt.setTitre(titre);
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
