package com.example.maccesarr.proyectomascotas.restApiServidor;

import com.example.maccesarr.proyectomascotas.restApiServidor.model.UsuarioResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by MacCesarR on 19/02/17.
 */

public interface EndPoints {

    @FormUrlEncoded
    @POST(ConstantesRestAPI.KEY_POST_ID_TOKEN)
    Call<UsuarioResponse> registrarTokenID(@Field("token") String token);

}
