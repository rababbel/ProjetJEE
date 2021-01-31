package com.jee.Controlleurs;

import com.jee.Beans.Module;
import com.jee.Gestionnaires.ModuleGestionnaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.Collection;

@RestController
public class ModuleControlleur {

    @Autowired
    private ModuleGestionnaire moduleGestionnaire;

    @PostMapping("/ajouterModule")
    @RolesAllowed({"ADMINISTRATEUR"})
    public ResponseEntity<?> ajouterModule(@Valid @RequestBody Module module){
        moduleGestionnaire.ajouterModule(module);
        return new ResponseEntity<Module>(module, HttpStatus.OK);
    }

    @PutMapping("/modifierModule")
    @RolesAllowed({"ADMINISTRATEUR"})
    public ResponseEntity<?> modifierModule(@Valid @RequestBody Module module){
        moduleGestionnaire.ajouterModule(module);
        return new ResponseEntity<Module>(module, HttpStatus.OK);
    }

    @GetMapping("/modules")
    @RolesAllowed({"ADMINISTRATEUR"})
    public Collection<Module> getAllModule(){
        Collection<Module> modules = moduleGestionnaire.getAllModules();
        return modules;
    }

    @GetMapping("/module/{id_module}")
    @RolesAllowed({"ADMINISTRATEUR"})
    public ResponseEntity<?> getModuleById(@PathVariable Long id_module){
        return new ResponseEntity<Module>(moduleGestionnaire.getModuleById(id_module), HttpStatus.OK);
    }

    @DeleteMapping("/supprimerModule/{id_module}")
    @RolesAllowed({"ADMINISTRATEUR"})
    public ResponseEntity<?> supprimerModule(@PathVariable Long id_module){
        moduleGestionnaire.supprimerModule(id_module);
        return new ResponseEntity<>("Module supprimer avec succes", HttpStatus.OK);
    }

}
