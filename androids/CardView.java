package com.example.androids;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CardView extends AppCompatActivity {

    ImageView imagen, expandir;
    TextView titulo, descripcion;
    LinearLayout layout;
    String valor1 = "Bill Gates";
    String valor2 = "Bill Gates, nacido el 28 de octubre de 1955 en Seattle, Washington, es un empresario y filántropo estadounidense. " +
            "Es ampliamente conocido por ser el cofundador de Microsoft, una de las compañías de tecnología más importantes y exitosas del mundo.\n" +
            "\n" +
            "Desde temprana edad, Gates mostró un gran interés por la computación y la programación. En 1975, junto con Paul Allen, fundó Microsoft, " +
            "empresa que se dedicaba al desarrollo de software. Su visión y habilidades empresariales le permitieron convertir a Microsoft en una potencia " +
            "en la industria de la tecnología.\n" +
            "\n" +
            "Durante su tiempo en Microsoft, Gates desempeñó un papel fundamental en el desarrollo de sistemas operativos, como MS-DOS y Windows, que se " +
            "convirtieron en estándares en la industria. Bajo su liderazgo, la empresa creció rápidamente y se convirtió en una de las más grandes del mundo. ";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);

        imagen = findViewById(R.id.imagen);
        titulo = findViewById(R.id.titulo);
        descripcion = findViewById(R.id.descripcion);
        layout = findViewById(R.id.layout);
        expandir = findViewById(R.id.expandir);

        titulo.setText(valor1);
        descripcion.setText(valor2);
        imagen.setImageResource(R.drawable.bill);
        expandir.setImageResource(R.drawable.baseline_expand_more_24);

        expandir.setOnClickListener(v -> {
            if (layout.getVisibility() == View.GONE){
                layout.setVisibility(View.VISIBLE);
                expandir.setImageResource(R.drawable.baseline_expand_less_24);
            }else {
                layout.setVisibility(View.GONE);
                expandir.setImageResource(R.drawable.baseline_expand_more_24);

            }
        });

    }
}