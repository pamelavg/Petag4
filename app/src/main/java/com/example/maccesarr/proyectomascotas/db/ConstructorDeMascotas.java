package com.example.maccesarr.proyectomascotas.db;

import android.content.ContentValues;
import android.content.Context;

import com.example.maccesarr.proyectomascotas.Dominio.Mascota;

import java.util.ArrayList;


public class ConstructorDeMascotas {

    private Context context;
    private static final int LIKE = 1;

    public ConstructorDeMascotas(Context context) {
        this.context = context;
    }

    public  ConstructorDeMascotas() {
    }

    public ArrayList<Mascota> obtenerDatos(){
        BaseDatos baseDatos = new BaseDatos(context);
        return  baseDatos.obtenerTodosLosContactos();
    }

    public ArrayList<Mascota> eliminarDatos(Context context){
        BaseDatos baseDatos = new BaseDatos(context);
        baseDatos.LimpiarTabla();
        return  baseDatos.obtenerTodosLosContactos();
    }

    public void darLikeContacto(Mascota mascota){
        BaseDatos db= new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_ID_MASCOTAS, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_NUMERO_LIKES, LIKE);
        db.insertarLikeMascota(contentValues);
    }

    public int obtenerLikesContacto(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesContacto(mascota);
    }

}
