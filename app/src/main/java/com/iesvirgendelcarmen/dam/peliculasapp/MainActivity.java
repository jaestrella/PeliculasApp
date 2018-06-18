package com.iesvirgendelcarmen.dam.peliculasapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

import android.widget.ListView;


import java.util.ArrayList;
import java.util.List;

import adaptador.ListaPeliculas;
import detalle.DetallePeliculas;
import modelos.Pelicula;
import modelos.api.PeliculasAPI;

public class MainActivity extends AppCompatActivity {

    private Button irFormulario;
    private List<Pelicula>listaPeliculas=new ArrayList<Pelicula>();
    private Pelicula pelicula;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        irFormulario=(Button)findViewById(R.id.irFormulario);
        irFormulario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplication(),Formulario.class);
                startActivity(intent);
            }
        });

        cargarPelicula();


    }

    private void cargarPelicula(){
        PeliculasAPI api=new PeliculasAPI();

        api.getPeliculas(this, new PeliculasAPI.CallbackPeliculas() {
            @Override
            public void getPeliculas(List<Pelicula> peliculas) {
                MainActivity.this.listaPeliculas=peliculas;
                ListView lista=(ListView)findViewById(R.id.lista);
                lista.setAdapter(new ListaPeliculas(MainActivity.this,listaPeliculas));

                lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        pelicula = (Pelicula) adapterView.getItemAtPosition(i);
                        Intent intent=new Intent(getApplication(), DetallePeliculas.class);
                        intent.putExtra("Titulo: ",pelicula.getNombre());
                        intent.putExtra("Director: ",pelicula.getDirector());
                        intent.putExtra("Genero: ",pelicula.getGenero());
                        intent.putExtra("Sinopsis: ",pelicula.getSinopsis());
                        startActivity(intent);
                    }
                });
            }
        });
    }
}

