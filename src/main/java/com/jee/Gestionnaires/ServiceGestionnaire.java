package com.jee.Gestionnaires;

import com.jee.Repositories.ServiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceGestionnaire {
    @Autowired
    private ServiceDAO serviceDAO;

    public void ajouterService(com.jee.Beans.Service service){
        serviceDAO.save(service);
    }
    public void modifierService(@Valid com.jee.Beans.Service service){
        serviceDAO.save(service);
    }

    public void supprimerService(Long id_service){
        serviceDAO.deleteById(id_service);
    }
    public com.jee.Beans.Service getServiceById(Long id_service){
        Optional<com.jee.Beans.Service> service = serviceDAO.findById(id_service);
        return service.orElse(null);
    }
    public List<com.jee.Beans.Service> getAllService(){
        return (List<com.jee.Beans.Service>) serviceDAO.findAll();
    }

    public List<com.jee.Beans.Service> getAllByUtilisateur(Long id_utilisateur){
        return serviceDAO.getAllByUtilisateur(id_utilisateur);
    }
}
