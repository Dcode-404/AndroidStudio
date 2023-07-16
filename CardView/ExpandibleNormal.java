package com.decodium.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
public class ExpandibleNormal extends AppCompatActivity {

    TextView titulo, descripcion;
    ImageButton button;
    ImageView imageView;
    LinearLayout layout;
    String descrip = "Elon Musk es cofundador y líder de Tesla, SpaceX, Neuralink y The Boring Company.\n" +
            "\n" +
            "Como cofundador y director general de Tesla, Elon lidera el diseño de productos, ingeniería y fabricación de los vehículos eléctricos, productos de batería y productos de energía solar a nivel mundial.\n" +
            "\n" +
            "Desde el inicio de la compañía en 2003, la misión de Tesla ha sido acelerar la transición del mundo a la energía sustentable. El primer producto de Tesla, el automóvil deportivo llamado Roadster, debutó en 2008, seguido por el sedán Model S, que se presentó en 2012, y el SUV Model X, que se lanzó en 2015.";

    String title = "Elon Musk";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.expandiblenormal);

        titulo = findViewById(R.id.titulo);
        descripcion = findViewById(R.id.descripcion);
        button = findViewById(R.id.button);
        imageView = findViewById(R.id.imagen);
        layout = findViewById(R.id.layout);

        imageView.setImageResource(R.drawable.elon);
        titulo.setText(title);
        descripcion.setText(descrip);

        button.setOnClickListener(view -> {
            if (layout.getVisibility() == View.GONE){
                layout.setVisibility(View.VISIBLE);
                button.setImageResource(R.drawable.cerrar);
            }else{
                layout.setVisibility(View.GONE);
                button.setImageResource(R.drawable.abrir);
            }
        });

    }
}