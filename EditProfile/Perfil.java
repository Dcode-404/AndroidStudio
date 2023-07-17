package com.decodium.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Perfil extends AppCompatActivity {

    TextView nombre, edad, apellido, telefono;
    Button button;
    Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.perfil);

        nombre = findViewById(R.id.nombre);
        edad = findViewById(R.id.edad);
        apellido = findViewById(R.id.apellido);
        telefono = findViewById(R.id.numero);
        button = findViewById(R.id.button);

        bundle = getIntent().getExtras();
        if (bundle != null){

            String name = bundle.getString("nombre");
            String apell = bundle.getString("apellido");
            int age = bundle.getInt("edad");
            Long cell = bundle.getLong("cellphone");

            nombre.setText(name);
            apellido.setText(apell);
            edad.setText(String.valueOf(age));
            telefono.setText(String.valueOf(cell));
        }

        button.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), EditarPerfil.class);

            bundle = new Bundle();
            bundle.putString("nombre", nombre.getText().toString().trim());
            bundle.putString("apellido", apellido.getText().toString().trim());
            bundle.putLong("celphone", Long.parseLong(telefono.getText().toString().trim()));
            bundle.putInt("edad", Integer.parseInt(edad.getText().toString().trim()));

            startActivity(intent.putExtras(bundle));
        });

    }
}