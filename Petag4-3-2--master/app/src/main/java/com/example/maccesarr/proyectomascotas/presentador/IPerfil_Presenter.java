package com.example.maccesarr.proyectomascotas.presentador;

/**
 * Created by MacCesarR on 06/02/17.
 */

public interface IPerfil_Presenter {

    public void obtenerMedioRecientes();

    public void mostrarMascotasBaseDeDatos();

    public void obtenerMedioRecientesOtroUsuario(String perfilID);
}
