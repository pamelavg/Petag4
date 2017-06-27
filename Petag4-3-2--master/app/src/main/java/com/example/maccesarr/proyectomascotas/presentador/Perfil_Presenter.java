package com.example.maccesarr.proyectomascotas.presentador;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.example.maccesarr.proyectomascotas.Dominio.Mascota;
import com.example.maccesarr.proyectomascotas.db.ConstructorDeMascotas;
import com.example.maccesarr.proyectomascotas.restApi.EndpointsApi;
import com.example.maccesarr.proyectomascotas.restApi.EndpointsApiID;
import com.example.maccesarr.proyectomascotas.restApi.adapter.RestApiAdapter;
import com.example.maccesarr.proyectomascotas.restApi.model.MascotaResponse;
import com.example.maccesarr.proyectomascotas.vista.MainActivity;
import com.example.maccesarr.proyectomascotas.vista_fragments.IPerfilFragment_View;
import com.example.maccesarr.proyectomascotas.vista_fragments.IPrincipalFragment_View;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by MacCesarR on 06/02/17.
 */

public class Perfil_Presenter extends AppCompatActivity implements IPerfil_Presenter {

    IPerfilFragment_View iPerfilFragment_view;
    public Context context;
    private ArrayList<Mascota> mascotas;
    private Activity activity;

    //Constructores
    public Perfil_Presenter(IPerfilFragment_View iPerfilFragment_view, Context context, String correo, String perfilID) {
        this.iPerfilFragment_view = iPerfilFragment_view;

        if(correo.equals("self")){
            obtenerMedioRecientes();
        }else if(correo.equals("Asdadasdassa")){
            obtenerMedioRecientesOtroUsuario(perfilID);
        }

    }

    public Perfil_Presenter(Context context){

    }



    //Métodos
    @Override
    public void obtenerMedioRecientes() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMediaRecent = restApiAdapter.construyendoGsonDeserializadorMediaRecent();
        EndpointsApi endpointsApi = restApiAdapter.establecerConexionesRestApiInstagram(gsonMediaRecent);
        Call<MascotaResponse> mascotaResponseCall= endpointsApi.getRecentMedia();

        mascotaResponseCall.enqueue(new Callback<MascotaResponse>() {
            @Override
            public void onResponse(Call<MascotaResponse> call, Response<MascotaResponse> response) {
                MascotaResponse mascotaResponse = response.body();
                mascotas = mascotaResponse.getMascotas();
                mostrarMascotasBaseDeDatos();
            }

            @Override
            public void onFailure(Call<MascotaResponse> call, Throwable t) {
                Toast.makeText(context,"Algo pasó en la conexión. Fallo la conexión", Toast.LENGTH_LONG).show();
                Log.e("Fallo la conexión", t.toString());
            }
        });
    }

    //Métodos
    @Override
    public void obtenerMedioRecientesOtroUsuario(String perfilID) {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMediaRecent = restApiAdapter.construyendoGsonDeserializadorMediaRecent();
        EndpointsApiID endpointsApi = restApiAdapter.establecerConexionesRestApiInstagramOtroUsuario(gsonMediaRecent);
        Call<MascotaResponse> mascotaResponseCall= endpointsApi.getRecentMediaById(perfilID);

        mascotaResponseCall.enqueue(new Callback<MascotaResponse>() {
            @Override
            public void onResponse(Call<MascotaResponse> call, Response<MascotaResponse> response) {
                MascotaResponse mascotaResponse = response.body();
                mascotas = mascotaResponse.getMascotas();
                mascotas.get(0).getUrlFotoPerfil();
                mostrarMascotasBaseDeDatos();
            }

            @Override
            public void onFailure(Call<MascotaResponse> call, Throwable t) {
                Toast.makeText(context,"Algo pasó en la conexión. Fallo la conexión", Toast.LENGTH_LONG).show();
                Log.e("Fallo la conexión", t.toString());
            }
        });
    }


    @Override
    public void mostrarMascotasBaseDeDatos() {
        iPerfilFragment_view.inicializarAdaptador(iPerfilFragment_view.crearAdaptador(mascotas));
        iPerfilFragment_view.generarLayoutGrill();

        iPerfilFragment_view.generarFotoPerfil(mascotas.get(0));
    }
}
