package detalle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.iesvirgendelcarmen.dam.peliculasapp.R;

import modelos.Pelicula;

/**
 * Created by matinal on 29/05/2018.
 */

public class DetallePeliculas extends AppCompatActivity {
    private TextView detallenombre,detalledirector,detallegenero,detallesinopsis;
    private String nombre,director,genero,sinopsis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalle_peliculas);

        detallenombre=findViewById(R.id.detallenombre);
        detalledirector=findViewById(R.id.detalledirector);
        detallegenero=findViewById(R.id.detallegenero);
        detallesinopsis=findViewById(R.id.detallesinopsis);

        nombre = getIntent().getStringExtra("Titulo: ");
        director = getIntent().getStringExtra("Director: ");
        genero = getIntent().getStringExtra("Genero: ");
        sinopsis = getIntent().getStringExtra("Sinopsis: ");

        detallenombre.setText(nombre);
        detalledirector.setText(director);
        detallegenero.setText(genero);
        detallesinopsis.setText(sinopsis);



    }
}
