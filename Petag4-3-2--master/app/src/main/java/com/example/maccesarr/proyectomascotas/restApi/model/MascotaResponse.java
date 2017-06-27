package com.example.maccesarr.proyectomascotas.restApi.model;

import com.example.maccesarr.proyectomascotas.Dominio.Mascota;

import java.util.ArrayList;

/**
 * Created by MacCesarR on 01/02/17.
 */

public class MascotaResponse {

    ArrayList<Mascota> mascotas;

    public ArrayList<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }
}
