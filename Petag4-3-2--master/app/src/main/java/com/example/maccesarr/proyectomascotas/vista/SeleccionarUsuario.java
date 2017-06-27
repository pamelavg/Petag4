package com.example.maccesarr.proyectomascotas.vista;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.maccesarr.proyectomascotas.R;
import com.example.maccesarr.proyectomascotas.presentador.Perfil_Presenter;
import com.example.maccesarr.proyectomascotas.vista_fragments.PerfilFragment;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class SeleccionarUsuario extends AppCompatActivity {

    private Spinner spinner;
    private Button btnSubmit;
    private TextView textView;
    SharedPreferences.Editor editor;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionar_usuario);
        addItemsOnSpinner();

        textView = (TextView)findViewById(R.id.tvSeleccionar);
        btnSubmit = (Button) findViewById(R.id.btnOk);

        prefs = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        editor = prefs.edit();

        editor.putString("cuenta", "self");
        editor.commit();

        final Intent intent = new Intent(this, MainActivity.class);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(spinner.getSelectedItem().equals("Asdadasdassa")){
                    editor = prefs.edit();
                    editor.putString("cuenta", "Asdadasdassa");
                    editor.commit();
                    finish();
                    intent.putExtra("pagina", 1);
                    startActivity(intent);

                }else if (spinner.getSelectedItem().equals("petagramtest123456")){
                    editor = prefs.edit();
                    editor.putString("cuenta", "self");
                    editor.commit();
                    finish();
                    intent.putExtra("pagina", 1);
                    startActivity(intent);
                }else{

                }

            }

        });
    }

    // add items into spinner dynamically
    public void addItemsOnSpinner() {

        spinner = (Spinner)findViewById(R.id.spinner1);
        List<String> list = new ArrayList<String>();
        list.add("petagramtest123456");
        list.add("Asdadasdassa");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
    }



}
