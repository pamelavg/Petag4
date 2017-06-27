package com.example.maccesarr.proyectomascotas.vista_fragments;

import com.example.maccesarr.proyectomascotas.Adaptadores.AdaptadorMascotasPerfil;
import com.example.maccesarr.proyectomascotas.Dominio.Mascota;

import java.util.ArrayList;


public interface IPerfilFragment_View {

    public void generarLayoutGrill();

    public AdaptadorMascotasPerfil crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptador(AdaptadorMascotasPerfil adaptadorMascotasPerfil);

    public void generarFotoPerfil(Mascota mascota);
}
