package modelos.api;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.StringReader;
import java.util.List;

import modelos.Pelicula;

/**
 * Created by matinal on 12/06/2018.
 */

public class PeliculasAPI {
    private String url="http://192.168.99.1:3000/peliculas";

    public void getPeliculas(Context ctx, final CallbackPeliculas respuesta){
        RequestQueue cola= VolleySingleton.getInstance(ctx).getRequestQueue();

        StringRequest request=new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.i("Respuesta",response);
                        //Uso Gson para deserializar el array automaticamente
                        List<Pelicula> peliculas = new Gson().fromJson(new StringReader(response), new TypeToken<List<Pelicula>>() {
                        }.getType());

                        //for (int i=0;i<peliculas.size();i++){
                        //    Log.e("Pelicula",peliculas.get(i).getNombre());
                        //}
                        //Llamo al callback para pasar la lista de noticias
                        respuesta.getPeliculas(peliculas);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Volley err","error");
                    }
                });
        cola.add(request);

    }

    public interface CallbackPeliculas{
        public void getPeliculas(List<Pelicula>peliculas);

    }
}

