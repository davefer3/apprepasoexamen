package com.davefer.apprepasoexamen.ui.home;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.davefer.apprepasoexamen.R;
import com.davefer.apprepasoexamen.peliculas.constantes;
import com.davefer.apprepasoexamen.peliculas.datospeliculas;
import com.davefer.apprepasoexamen.peliculas.pelicula;
import com.davefer.apprepasoexamen.peliculas.peliculasGestor;
import com.squareup.picasso.Picasso;

import java.util.List;

public class HomeFragment extends Fragment implements AdapterView.OnItemClickListener {

    GridView gridView;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        gridView = (GridView) root.findViewById(R.id.gvpeliculas);
        peliculasGestor.crearPeliculas();

        MyAdapter myAdapter = new MyAdapter(getContext(),R.id.gvpeliculas,peliculasGestor.PELICULAS);
        gridView.setAdapter(myAdapter);
        gridView.setOnItemClickListener(this);

        return  root;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        //Recuperamos el Tag y hacemos un casting a tipo Película
        pelicula p = (pelicula) view.getTag();

        Intent intent = new Intent(getActivity(), datospeliculas.class);

        //Le añadimos un extra que contendrá el ID de la película.
        Bundle extras = new Bundle();

        extras.putString(constantes.ID_PELICULA, p.getId());

        intent.putExtras(extras);

        //Creamos Opciones de la actividad, en este caso crear una escena de transición
        //Le pasamos la actividad actual, y elementos de ti par, que contendrá la vista a hacer la animación y una etiqueta que la identifique en la otra Actividad
        ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(
                getActivity(),
                new Pair<View,String>(view.findViewById(R.id.ivFoto), constantes.SAHRED_VIEW_FOTO),
                new Pair<View,String>(view.findViewById(R.id.tvAutor), constantes.SAHRED_VIEW_AUTOR),
                new Pair<View,String>(view.findViewById(R.id.tvTitulo), constantes.SAHRED_VIEW_TITLE)
        );

        ActivityCompat.startActivity(getActivity(),intent,activityOptions.toBundle());

        //startActivity(intent);
    }

    private class MyAdapter extends ArrayAdapter {
        HomeFragment parent;
        Context c;
        List<pelicula> peliculas;

        //Constructor de nuestro Adaptador
        //Le pasamos el contexto, la vista padre (GridView) y un ArrayList
        MyAdapter(Context c, int view, List<pelicula> peliculas){
            super(c,view,peliculas); //Llamamos al constructor de la clase padre
            this.c = c;
            this.peliculas = peliculas;
            this.parent = parent;

        }
        @Override
        public int getCount() {
            return super.getCount();
            //También podríamos haber hecho peliculas.size();
        }
        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View v;
            //Cargamos en la vista v, el layout de cada elemento del gridview
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.item_view, null);

            //Obtenemos referencia a cada uno de sus elementos
            TextView tvAutor = (TextView) v.findViewById(R.id.tvAutor);
            TextView tvTitulo = (TextView) v.findViewById(R.id.tvTitulo);
            ImageView ivPortada = (ImageView) v.findViewById(R.id.ivFoto);

            //Asigamnos valor a las vistas en función de la posición i
            tvAutor.setText(peliculas.get(i).getAutor());
            tvTitulo.setText(peliculas.get(i).getTitulo());
            String url = peliculas.get(i).getUrl_portada();

            ivPortada.setImageDrawable(Drawable.createFromPath(peliculas.get(i).getUrl_portada()));

            //Usamos Picasso para añadir una imagen de internet a un imageView
            Picasso.get()
                    .load(url)
                    //.resize(60, 100)
                    //.centerCrop()
                    .noPlaceholder()
                    .into(ivPortada);
            v.setTag(peliculas.get(i));
            return v;
        }


    }

}