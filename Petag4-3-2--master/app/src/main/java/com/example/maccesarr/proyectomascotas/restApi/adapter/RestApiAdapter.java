package com.example.maccesarr.proyectomascotas.restApi.adapter;

import com.example.maccesarr.proyectomascotas.restApi.ConstantesRestApi;
import com.example.maccesarr.proyectomascotas.restApi.EndpointsApi;
import com.example.maccesarr.proyectomascotas.restApi.EndpointsApiID;
import com.example.maccesarr.proyectomascotas.restApi.deserializador.MascotaDeserializador;
import com.example.maccesarr.proyectomascotas.restApi.model.MascotaResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.HttpUrl;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by MacCesarR on 01/02/17.
 */

public class RestApiAdapter  {

    public EndpointsApi establecerConexionesRestApiInstagram(Gson gson){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit.create(EndpointsApi.class);
    }

    public EndpointsApiID establecerConexionesRestApiInstagramOtroUsuario(Gson gson){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit.create(EndpointsApiID.class);
    }

    public Gson construyendoGsonDeserializadorMediaRecent(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(MascotaResponse.class, new MascotaDeserializador());

        return gsonBuilder.create();
    }
}
