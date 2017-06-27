package com.example.maccesarr.proyectomascotas.presentador;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.maccesarr.proyectomascotas.Dominio.Mascota;
import com.example.maccesarr.proyectomascotas.R;
import com.example.maccesarr.proyectomascotas.db.BaseDatos;
import com.example.maccesarr.proyectomascotas.db.ConstantesBaseDatos;
import com.example.maccesarr.proyectomascotas.db.ConstructorDeMascotas;
import com.example.maccesarr.proyectomascotas.restApi.EndpointsApi;
import com.example.maccesarr.proyectomascotas.restApi.EndpointsApiID;
import com.example.maccesarr.proyectomascotas.restApi.adapter.RestApiAdapter;
import com.example.maccesarr.proyectomascotas.restApi.model.MascotaResponse;
import com.example.maccesarr.proyectomascotas.vista_fragments.IPrincipalFragment_View;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by MacCesarR on 25/01/17.
 */

public class Principal_Presenter implements IPrincipal_Presenter {

    IPrincipalFragment_View iPrincipalFragment_view;
    public Context context;
    private ConstructorDeMascotas constructorDeMascotas;
    private ArrayList<Mascota> mascotas;

    public Principal_Presenter(IPrincipalFragment_View iPrincipalFragment_view, Context context) {
        this.iPrincipalFragment_view = iPrincipalFragment_view;
        this.context = context;
        obtenerMedioRecientes();
    }

    public Principal_Presenter(Context context) {

    }

    @Override
    public void obtenerMascotasBaseDeDatos() {
        constructorDeMascotas = new ConstructorDeMascotas(context);
        mascotas = constructorDeMascotas.obtenerDatos();
        mostrarMascotasBaseDeDatos();
    }

    @Override
    public void mostrarMascotasBaseDeDatos() {
        iPrincipalFragment_view.inicializarAdaptador(iPrincipalFragment_view.crearAdaptador(mascotas));
        iPrincipalFragment_view.generarLayoutGrill();
    }

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


}
