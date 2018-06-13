package com.iesvirgendelcarmen.dam.peliculasapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import adaptador.ListaPeliculas;
import detalle.DetallePeliculas;
import modelos.Pelicula;
import modelos.api.PeliculasAPI;

/**
 * Created by matinal on 13/06/2018.
 */

public class Formulario extends AppCompatActivity {
    TextView tvnombre,tvdirector,tvgenero,tvsinopsis,tvid;
    EditText etnombre,etdirector,etgenero,etsinopsis,etid;
    Button botonAnnadir,irLista;
    private Pelicula pelicula;
    private List<Pelicula> listaPeliculas=new ArrayList<Pelicula>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formulario_peliculas);

        tvid=(TextView)findViewById(R.id.tvid);
        tvnombre=(TextView)findViewById(R.id.tvnombre);
        tvdirector=(TextView)findViewById(R.id.tvdirector);
        tvgenero=(TextView)findViewById(R.id.tvgenero);
        tvsinopsis=(TextView)findViewById(R.id.tvsinopsis);
        etid=(EditText) findViewById(R.id.etid);
        etnombre=(EditText) findViewById(R.id.etnombre);
        etdirector=(EditText) findViewById(R.id.etdirector);
        etgenero=(EditText) findViewById(R.id.etgenero);
        etsinopsis=(EditText) findViewById(R.id.etsinopsis);
        botonAnnadir=(Button)findViewById(R.id.botonAnnadir);
        irLista=(Button)findViewById(R.id.irLista);

        botonAnnadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addPelicula();
            }
        });



        irLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplication(),MainActivity.class);
                startActivity(intent);
            }
        });


    }
    private void addPelicula() {
        Pelicula pelicula = new Pelicula(Integer.parseInt(etid.getText().toString()),etnombre.getText().toString(), etdirector.getText().toString(), etgenero.getText().toString(), etsinopsis.getText().toString());
        PeliculasAPI api = new PeliculasAPI();

        api.postPeliculas(pelicula, this);

    }
}
