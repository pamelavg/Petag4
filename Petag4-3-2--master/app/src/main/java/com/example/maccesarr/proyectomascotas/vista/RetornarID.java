package com.example.maccesarr.proyectomascotas.vista;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.maccesarr.proyectomascotas.R;
import com.example.maccesarr.proyectomascotas.restApiServidor.ConstantesRestAPI;
import com.example.maccesarr.proyectomascotas.restApiServidor.EndPoints;
import com.example.maccesarr.proyectomascotas.restApiServidor.adapter.RestApiAdapter;
import com.example.maccesarr.proyectomascotas.restApiServidor.model.UsuarioResponse;
import com.google.firebase.iid.FirebaseInstanceId;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetornarID extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retornar_id);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final TextView tv = (TextView)findViewById(R.id.textoToken);
        final TextView tvID = (TextView)findViewById(R.id.textIDTOKEN);

        String token = FirebaseInstanceId.getInstance().getToken();
        String ID = FirebaseInstanceId.getInstance().getId();
        Log.d("TOKEN", token);
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        EndPoints endPoints = restApiAdapter.establecerConexionesRestAPI();
        Call<UsuarioResponse> usuarioResponseCall = endPoints.registrarTokenID(token);

        usuarioResponseCall.enqueue(new Callback<UsuarioResponse>() {
            @Override
            public void onResponse(Call<UsuarioResponse> call, Response<UsuarioResponse> response) {
                UsuarioResponse usuarioResponse = response.body();
                Log.d("ID_FIREBASE", usuarioResponse.getId());
                Log.d("USUARIO_FIREBASE", usuarioResponse.getToken());
                tv.setText((usuarioResponse.getToken().substring(0,10)));
                tvID.setText((usuarioResponse.getId().substring(0,10)));
            }

            @Override
            public void onFailure(Call<UsuarioResponse> call, Throwable t) {

            }
        });


    }

}
