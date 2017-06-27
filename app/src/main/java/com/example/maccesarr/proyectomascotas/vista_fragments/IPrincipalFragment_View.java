package com.example.maccesarr.proyectomascotas.vista_fragments;

import com.example.maccesarr.proyectomascotas.Adaptadores.AdaptadorMascotas;
import com.example.maccesarr.proyectomascotas.Dominio.Mascota;

import java.util.ArrayList;


public interface IPrincipalFragment_View {

    public void generarLayoutVertical();

    public AdaptadorMascotas crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptador(AdaptadorMascotas adaptadorMascotas);

    public void generarLayoutGrill();


}
