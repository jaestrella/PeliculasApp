package com.iesvirgendelcarmen.dam.peliculasapp;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView tvnombre,tvdirector,tvgenero,tvsinopsis;
    EditText etnombre,etdirector,etgenero,etsinopsis;
    Button botonAnnadir;
    private Pelicula pelicula;
    private ArrayList<Pelicula>listaPeliculas=new ArrayList<Pelicula>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvnombre=(TextView)findViewById(R.id.tvnombre);
        tvdirector=(TextView)findViewById(R.id.tvdirector);
        tvgenero=(TextView)findViewById(R.id.tvgenero);
        tvsinopsis=(TextView)findViewById(R.id.tvsinopsis);
        etnombre=(EditText) findViewById(R.id.etnombre);
        etdirector=(EditText) findViewById(R.id.etdirector);
        etgenero=(EditText) findViewById(R.id.etgenero);
        etsinopsis=(EditText) findViewById(R.id.etsinopsis);
        botonAnnadir=(Button)findViewById(R.id.botonAnnadir);

        botonAnnadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = etnombre.getText().toString();
                String director = etdirector.getText().toString();
                String genero = etgenero.getText().toString();
                String sinopsis = etsinopsis.getText().toString();

                pelicula=new Pelicula(nombre,director,genero,sinopsis);
                listaPeliculas.add(pelicula);
                crearLista();
            }
        });

    }

    private void crearLista(){
        ListView lista=(ListView)findViewById(R.id.lista);
        lista.setAdapter(new ListaPeliculas(this,listaPeliculas));

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                pelicula = (Pelicula) adapterView.getItemAtPosition(i);
                Intent intent=new Intent(getApplication(),DetallePeliculas.class);
                startActivity(intent);
            }
        });
    }

}
