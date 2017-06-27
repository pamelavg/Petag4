package com.example.maccesarr.proyectomascotas.Adaptadores;


import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.maccesarr.proyectomascotas.R;

import java.util.ArrayList;

import com.example.maccesarr.proyectomascotas.Dominio.Mascota;
import com.example.maccesarr.proyectomascotas.db.ConstructorDeMascotas;
import com.squareup.picasso.Picasso;

public class AdaptadorMascotas extends RecyclerView.Adapter<AdaptadorMascotas.ContactoViewHolder>{

    ArrayList<Mascota> mascotas;
    Activity activity;

    public AdaptadorMascotas(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }

    //Inflar el layout y lo pasará el viewHolder
    @Override
    public ContactoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new ContactoViewHolder(v);
    }

    //Cantidad de contactos del tamaño
    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public  class ContactoViewHolder extends RecyclerView.ViewHolder{
        private TextView nombre;
        private ImageView imagen;

        public ContactoViewHolder(View itemView) {
            super(itemView);
            imagen = (ImageView)itemView.findViewById(R.id.imgFotoCardView);
            nombre = (TextView)itemView.findViewById(R.id.tvRankingCardView);
        }
    }

    //Asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(final ContactoViewHolder holder, int position) {

        final Mascota mascota = mascotas.get(position);
        holder.nombre.setText(String.valueOf(mascota.getLikes()));
        Picasso.with(activity)
                .load(mascota.getUrlFotografía())
                .placeholder(R.drawable.dog_bone_96)
                .into(holder.imagen);

////AJUSTAR PARA MOSTRAR EL LIKEEEEEE
        holder.imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }






}
