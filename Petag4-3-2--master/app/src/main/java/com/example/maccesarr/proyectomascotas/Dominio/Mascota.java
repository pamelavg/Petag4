package com.example.maccesarr.proyectomascotas.Dominio;

/**
 * Created by MacCesarR on 09/01/17.
 */

public class Mascota {

    private String id;
    private String name;
    private String urlFotografía;
    private int likes = 0;
    private String urlFotoPerfil;

    public Mascota(String id, String name, String urlFotografía, int likes, String urlFotoPerfil) {
        this.id = id;
        this.name = name;
        this.urlFotografía = urlFotografía;
        this.likes = likes;
        this.urlFotoPerfil = urlFotoPerfil;
    }

    public Mascota() {

    }

    public String getUrlFotoPerfil() {
        return urlFotoPerfil;
    }

    public void setUrlFotoPerfil(String urlFotoPerfil) {
        this.urlFotoPerfil = urlFotoPerfil;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlFotografía() {
        return urlFotografía;
    }

    public void setUrlFotografía(String urlFotografía) {
        this.urlFotografía = urlFotografía;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
