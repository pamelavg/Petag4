package com.example.maccesarr.proyectomascotas.vista_fragments;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.maccesarr.proyectomascotas.Adaptadores.AdaptadorMascotasPerfil;
import com.example.maccesarr.proyectomascotas.Dominio.Mascota;
import com.example.maccesarr.proyectomascotas.R;
import com.example.maccesarr.proyectomascotas.presentador.IPerfil_Presenter;
import com.example.maccesarr.proyectomascotas.presentador.Perfil_Presenter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment implements IPerfilFragment_View {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaDeUsuarios;
    private ImageView imagenPerfil;
    private IPerfil_Presenter presenter;
    public String correo;
    SharedPreferences.Editor editor;
    SharedPreferences prefs;



    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_perfil, container, false);
        listaDeUsuarios= (RecyclerView) v.findViewById(R.id.rvMascotasPerfil);
        imagenPerfil = (ImageView)v.findViewById(R.id.imagenAgregarPerrito);

        prefs = this.getActivity().getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        correo = prefs.getString("cuenta","self");
        String correo2 = "self";

        if(correo.equals("self")){

        }else{
            correo2="4575231153";
        }

        presenter = new Perfil_Presenter(this, getContext(), correo, correo2);
        return v;
    }

    @Override
    public AdaptadorMascotasPerfil crearAdaptador(ArrayList<Mascota> mascotas) {
        AdaptadorMascotasPerfil adaptadorMascotas = new AdaptadorMascotasPerfil(mascotas, getActivity());
        return  adaptadorMascotas;
    }


    @Override
    public void inicializarAdaptador(AdaptadorMascotasPerfil adaptadorMascotasPerfil) {
        listaDeUsuarios.setAdapter(adaptadorMascotasPerfil);
    }

    @Override
    public void generarFotoPerfil(Mascota mascota) {
        Picasso.with(getContext())
                .load(mascota.getUrlFotoPerfil())
                .placeholder(R.drawable.dog_bone_96)
                .into(imagenPerfil);
    }


    @Override
    public void generarLayoutGrill() {
        GridLayoutManager llm = new GridLayoutManager(getActivity(),2);
        listaDeUsuarios.setLayoutManager(llm);
    }









}
