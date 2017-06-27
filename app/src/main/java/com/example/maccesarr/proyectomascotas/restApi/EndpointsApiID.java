package com.example.maccesarr.proyectomascotas.restApi;

import com.example.maccesarr.proyectomascotas.restApi.model.MascotaResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface EndpointsApiID {

   @GET(ConstantesRestApi.URL_GET_RECENT_MEDIA_USER_ID)
   Call<MascotaResponse> getRecentMedia();

   @GET(ConstantesRestApi.URL_GET_RECENT_MEDIA_USER_ID)
   Call<MascotaResponse> getRecentMediaById(@Path("name") String name);

}
