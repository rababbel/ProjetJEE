package com.jee.Gestionnaires;

import com.jee.Beans.Module;
import com.jee.Repositories.ModuleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class ModuleGestionnaire {
    @Autowired
    private ModuleDAO moduleDAO;

    public void ajouterModule(Module module){
        moduleDAO.save(module);
    }
    public void modifierModule(@Valid Module module){
        moduleDAO.save(module);
    }

    public void supprimerModule(Long id_module){
        moduleDAO.deleteById(id_module);
    }
    public Module getModuleById(Long id_module){
        Optional<Module> module = moduleDAO.findById(id_module);
        return module.orElse(null);
    }
    public List<Module> getAllModules(){
        return (List<Module>) moduleDAO.findAll();
    }
}
