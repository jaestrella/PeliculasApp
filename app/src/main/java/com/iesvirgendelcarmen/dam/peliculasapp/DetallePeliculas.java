package com.iesvirgendelcarmen.dam.peliculasapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by matinal on 29/05/2018.
 */

public class DetallePeliculas extends AppCompatActivity {
    private TextView detallenombre;
    private String nombre;
    private Pelicula pelicula=new Pelicula(nombre);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalle_peliculas);
        detallenombre=(TextView)findViewById(R.id.detallenombre);
        detallenombre.setText("TITULO: "+pelicula.getNombre());
        nombre= detallenombre.getText().toString();

    }
}
