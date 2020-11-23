package com.davefer.apprepasoexamen.peliculas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.davefer.apprepasoexamen.R;
import com.squareup.picasso.Picasso;

public class datospeliculas extends AppCompatActivity {
    pelicula p;
    ImageView ivPortada;
    TextView tvTitulo,tvAutor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datospeliculas);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tvTitulo = (TextView)findViewById(R.id.tvTituloPeli);
        tvAutor = (TextView)findViewById(R.id.tvAutorPeli);
        ivPortada = (ImageView) findViewById(R.id.ivPortada);


        //Comprabamos que tenemos un extra y obtentemos el valor

        if(getIntent().hasExtra(constantes.ID_PELICULA)){
            String id = getIntent().getStringExtra(constantes.ID_PELICULA);

            //Con el ID del parámetro obtenemos la película
            p = peliculasGestor.getPeliculaById(id);

            if(p!=null){

                //Establecemos las transiciones, asociando la vistas de las dos actividades gracias a las constantes
                ViewCompat.setTransitionName(ivPortada, constantes.SAHRED_VIEW_FOTO);
                ViewCompat.setTransitionName(tvAutor, constantes.SAHRED_VIEW_AUTOR);
                ViewCompat.setTransitionName(tvTitulo, constantes.SAHRED_VIEW_TITLE);

                //Cargamos el contenido de las vistas.
                loadItems();

            }
        }

    }

    private void loadItems() {
        tvAutor.setText(p.getAutor());
        tvTitulo.setText(p.getTitulo());

        Picasso.get()
                .load(p.getUrl_portada())
                .into(ivPortada);
    }
}