package com.example.maccesarr.proyectomascotas.vista;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

import com.example.maccesarr.proyectomascotas.Adaptadores.AdaptadorMascotas;
import com.example.maccesarr.proyectomascotas.Dominio.Mascota;
import com.example.maccesarr.proyectomascotas.R;

public class Top5Mascotas extends AppCompatActivity {

    String sesion;

    ArrayList<Mascota> mascotas;
    private RecyclerView listaDeUsuarios;
    SharedPreferences.Editor editor;
    SharedPreferences preferencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top5_mascotas);

        Toolbar miActionBar = (Toolbar)findViewById(R.id.miActionBar2);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaDeUsuarios= (RecyclerView) findViewById(R.id.rvMascotasFavoritas);

        preferencias=getSharedPreferences("SICAM", Context.MODE_PRIVATE);
        editor =preferencias.edit();

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaDeUsuarios.setLayoutManager(llm);
        inicializarListaContactos();
        inicializarAdaptador();
    }

    public void inicializarAdaptador(){
        AdaptadorMascotas adaptadorMascotas = new AdaptadorMascotas(mascotas, this);
        listaDeUsuarios.setAdapter(adaptadorMascotas);
    }



    public  void burbuja(ArrayList<Mascota> mascotas){
        int i;

        for(i=0;i<=mascotas.size();i++){
            if(mascotas.get(mascotas.size()-i).getLikes()==0){
                mascotas.remove(mascotas.size()-i);
        }}
    }

    public void inicializarListaContactos(){

        mascotas = new ArrayList<Mascota>();



    }
}
