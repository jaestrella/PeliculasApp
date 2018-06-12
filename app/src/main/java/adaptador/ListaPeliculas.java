package adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.iesvirgendelcarmen.dam.peliculasapp.R;

import java.util.List;

import modelos.Pelicula;

/**
 * Created by matinal on 29/05/2018.
 */

public class ListaPeliculas extends BaseAdapter{
    private List<Pelicula>peliculas;
    private Context context;

   public ListaPeliculas(Context nContext,List<Pelicula>peliculaList){
       this.peliculas=peliculaList;
       this.context=nContext;
   }

    @Override
    public int getCount() {
        return this.peliculas.size();
    }

    @Override
    public Object getItem(int position) {
        return peliculas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       Pelicula p=(Pelicula) getItem(position);
       if(convertView==null){
           convertView= LayoutInflater.from(context).inflate(R.layout.lista_peliculas,parent,false);
       }

       TextView nombre=convertView.findViewById(R.id.nombre);
       TextView director=convertView.findViewById(R.id.director);
       TextView genero=convertView.findViewById(R.id.genero);
       TextView sinopsis=convertView.findViewById(R.id.sinopsis);

       nombre.setText("Titulo: "+p.getNombre());
       director.setText("Director: "+p.getDirector());
       genero.setText("Genero: "+p.getGenero());
       sinopsis.setText("Sinopsis: "+p.getSinopsis());

       return convertView;
    }
}
