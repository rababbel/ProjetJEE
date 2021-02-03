package com.jee.Gestionnaires;

import com.jee.Beans.Edt;
import com.jee.Repositories.EdtDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class EdtGestionnaire {
    @Autowired
    private EdtDAO edtDAO;

    public void ajouterEdt(Edt edt){
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
