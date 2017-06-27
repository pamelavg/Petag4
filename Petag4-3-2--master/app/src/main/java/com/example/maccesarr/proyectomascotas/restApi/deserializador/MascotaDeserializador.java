package com.example.maccesarr.proyectomascotas.restApi.deserializador;

import com.example.maccesarr.proyectomascotas.Dominio.Mascota;
import com.example.maccesarr.proyectomascotas.restApi.JsonKeys;
import com.example.maccesarr.proyectomascotas.restApi.model.MascotaResponse;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by MacCesarR on 02/02/17.
 */

public class MascotaDeserializador implements JsonDeserializer<MascotaResponse> {

    //Con esta clase vamos a deserealizar para poder elegir que elementos requieres de JSON

    //{} son objetos.
    //[] son arreglos de objetos

    @Override
    public MascotaResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        MascotaResponse mascotaResponse = gson.fromJson(json, MascotaResponse.class);

        JsonArray mascotaResponseData = json.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_RESPONSE_ARRAY);

        mascotaResponse.setMascotas(deserealizarMascotaDeJson(mascotaResponseData ));

        return mascotaResponse;
    }

    private ArrayList<Mascota> deserealizarMascotaDeJson(JsonArray mascotaResponseData){
        ArrayList<Mascota> mascotas = new ArrayList<>();
        for (int i = 0; i < mascotaResponseData.size() ; i++ ){
            JsonObject mascotaResponseDataObject = mascotaResponseData.get(i).getAsJsonObject();
            JsonObject userJson          = mascotaResponseDataObject.getAsJsonObject(JsonKeys.USER);
            String id                   = userJson.get(JsonKeys.USER_ID).getAsString();
            String nombreCompleto       = userJson.get(JsonKeys.USER_FULLNAME).getAsString();
            String fotoPerfil                       = userJson.get(JsonKeys.USER_PROFILE_PICTURE).getAsString();

            JsonObject imageJson        = mascotaResponseDataObject.getAsJsonObject(JsonKeys.MEDIA_IMAGE);
            JsonObject urlImagen        = imageJson.getAsJsonObject(JsonKeys.MEDIA_STANDARD_RESOLUTION);
            String url                  = urlImagen.get(JsonKeys.MEDIA_URL).getAsString();

            JsonObject likesJson        = mascotaResponseDataObject.getAsJsonObject(JsonKeys.LIKES);
            int likes                   = likesJson.get(JsonKeys.MEDIA_LIKES).getAsInt();

            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(id);
            mascotaActual.setName(nombreCompleto);
            mascotaActual.setUrlFotografía(url);
            mascotaActual.setLikes(likes);
            mascotaActual.setUrlFotoPerfil(fotoPerfil);

            mascotas.add(mascotaActual);

        }

        return mascotas;
    }


}
