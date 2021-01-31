package com.jee.Beans;

public class AuthenticationResponse {
    private String token;
    private Type_Utilisateur type_utilisateur;

    public AuthenticationResponse() {
        super();
    }

    public AuthenticationResponse(String token, Type_Utilisateur type_utilisateur) {
        this.token = token;
        this.type_utilisateur = type_utilisateur;
    }

    public String getToken() {
        return token;
    }

    public Type_Utilisateur getType_utilisateur() {
        return type_utilisateur;
    }
}
