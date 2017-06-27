package com.example.maccesarr.proyectomascotas.restApiServidor.adapter;

import com.example.maccesarr.proyectomascotas.restApiServidor.ConstantesRestAPI;
import com.example.maccesarr.proyectomascotas.restApiServidor.EndPoints;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApiAdapter {

    public EndPoints establecerConexionesRestAPI(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestAPI.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                ;
        return retrofit.create(EndPoints.class);
    }
}
