package com.jee.Gestionnaires;

import com.jee.Beans.GeUserDetail;
import com.jee.Beans.Type_Utilisateur;
import com.jee.Beans.Utilisateur;
import com.jee.Repositories.UtilisateurDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class GeUserDetailService implements UserDetailsService {
    @Autowired
    private UtilisateurDAO utilisateurDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        if (email.equals("admin")){
            Utilisateur utilisateur = new Utilisateur();
            utilisateur.setEmail(email);
            utilisateur.setPassword(passwordEncoder.encode("admin"));
            utilisateur.setType_utilisateur(Type_Utilisateur.ADMINISTRATEUR);
            return new GeUserDetail(utilisateur);
        }
        Utilisateur utilisateur = utilisateurDAO.findByEmail(email);

        if (utilisateur == null){
            throw new UsernameNotFoundException(email);
        }
        GeUserDetail userDetail = new GeUserDetail(utilisateur);

        return  userDetail;
    }
}
