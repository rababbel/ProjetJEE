package com.jee.Controlleurs;

import com.jee.Beans.AuthenticationRequest;
import com.jee.Beans.AuthenticationResponse;
import com.jee.Beans.GeUserDetail;
import com.jee.Gestionnaires.GeUserDetailService;
import com.jee.Utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class LoginControlleurs {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private GeUserDetailService geUserDetailService;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(),authenticationRequest.getPassword())
            );
        }catch (BadCredentialsException e){
            throw new BadCredentialsException("Cet utilisateur n'existe pas");
        }

        final GeUserDetail userDetail = (GeUserDetail) geUserDetailService.loadUserByUsername(authenticationRequest.getEmail());
        final String jwt = jwtUtil.generateToken(userDetail);
        AuthenticationResponse authenticationResponse = new AuthenticationResponse(jwt, userDetail.getUtilisateur().getRole());
        return  new ResponseEntity<>(authenticationResponse, HttpStatus.OK);
    }
}
