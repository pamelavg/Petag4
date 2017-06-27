package com.example.maccesarr.proyectomascotas.vista;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

import com.example.maccesarr.proyectomascotas.Adaptadores.PageAdapter;
import com.example.maccesarr.proyectomascotas.R;
import com.example.maccesarr.proyectomascotas.db.BaseDatos;
import com.example.maccesarr.proyectomascotas.vista_fragments.PerfilFragment;
import com.example.maccesarr.proyectomascotas.vista_fragments.PrincipalFragment;
import com.example.maccesarr.proyectomascotas.presentador.IPrincipal_Presenter;
import com.example.maccesarr.proyectomascotas.presentador.Principal_Presenter;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Toolbar toolbar;
    Context contextNew;
    public String correo;
    SharedPreferences.Editor editor;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contextNew = this;

        //Agregar para dar soporte al botón de opciones
        toolbar =(Toolbar)findViewById(R.id.Toolbar);
        tabLayout = (TabLayout)findViewById(R.id.tabLayout);
        viewPager = (ViewPager)findViewById(R.id.viewPager);
        setUpViewPager();

        int defaultValue = 0;
        int page = getIntent().getIntExtra("pagina", defaultValue);
        viewPager.setCurrentItem(page);

        setSupportActionBar(toolbar);

    }

    //Métodos para crear el menú de opciones junto con el XML de Menu.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mContacto:
                Intent intent= new Intent(this, ContactoActivity.class);
                startActivity(intent);
                break;
            case R.id.mAcercaDe:
                Intent intent2= new Intent(this, BioActivity.class);
                startActivity(intent2);
                break;
            case R.id.mCuenta:
                Intent intent3= new Intent(this, SeleccionarUsuario.class);
                finish();
                startActivity(intent3);
                break;
            case R.id.Usuario:
                Intent intent4= new Intent(this, RetornarID.class);
                finish();
                startActivity(intent4);
                break;
        }
        return true;
    }

    //Menu
    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new PrincipalFragment());
        fragments.add(new PerfilFragment());
        return fragments;
    }

    public void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.dog_house_80);
        tabLayout.getTabAt(1).setIcon(R.drawable.dog_96);
    }


    public void Favorito(View view){
    }

    public  void Agregar_Imagen(View view){
    }

}
