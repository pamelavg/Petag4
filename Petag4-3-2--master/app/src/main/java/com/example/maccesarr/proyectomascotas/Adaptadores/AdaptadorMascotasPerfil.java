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

import com.example.maccesarr.proyectomascotas.Dominio.Mascota;
import com.example.maccesarr.proyectomascotas.R;
import com.example.maccesarr.proyectomascotas.vista_fragments.PerfilFragment;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdaptadorMascotasPerfil extends RecyclerView.Adapter<AdaptadorMascotasPerfil.ContactoViewHolder>{

    ArrayList<Mascota> mascotas;
    Activity activity;
    PerfilFragment perfil;
    Context context;



    public AdaptadorMascotasPerfil(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }

    //Inflar el layout y lo pasará el viewHolder
    @Override
    public ContactoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota_gril, parent, false);
        return new ContactoViewHolder(v);
    }

    //Asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(final ContactoViewHolder holder, int position) {


        final Mascota mascota = mascotas.get(position);
        holder.ranking.setText(String.valueOf(mascota.getLikes()));
        Picasso.with(activity)
                .load(mascota.getUrlFotografía())
                .placeholder(R.drawable.dog_bone_96)
                .into(holder.imagen);
    }



    //Cantidad de contactos del tamaño
    @Override
    public int getItemCount() {
        return mascotas.size();
    }



    public  class ContactoViewHolder extends RecyclerView.ViewHolder{

        private TextView ranking;
        private ImageView imagen;
        private LinearLayout cardView;
        private ImageView btnRanking;
        private CircularImageView foto;





        public ContactoViewHolder(View itemView) {
            super(itemView);
            imagen = (ImageView)itemView.findViewById(R.id.imgFoto2);
            ranking = (TextView)itemView.findViewById(R.id.tvRanking2);
            cardView = (LinearLayout)itemView.findViewById(R.id.cardViewLayout2);
            btnRanking = (ImageView) itemView.findViewById(R.id.imgB_Ranking2);
            foto = (CircularImageView)itemView.findViewById(R.id.imagenAgregarPerrito);


        }


    }



}
