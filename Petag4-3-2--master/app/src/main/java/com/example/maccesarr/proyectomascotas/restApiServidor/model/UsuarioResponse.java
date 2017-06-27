package com.example.maccesarr.proyectomascotas.restApiServidor.model;

/**
 * Created by MacCesarR on 19/02/17.
 */

public class UsuarioResponse {

    private String id;
    private String token;

    public UsuarioResponse(String id, String token) {
        this.id = id;
        this.token = token;
    }

    public UsuarioResponse(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
