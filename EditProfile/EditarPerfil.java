package com.decodium.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EditarPerfil extends AppCompatActivity {

    EditText nombre, apellido, edad, telefono;
    Button button;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editar_perfil);

        nombre = findViewById(R.id.nombre);
        apellido = findViewById(R.id.apellido);
        edad = findViewById(R.id.edad);
        telefono = findViewById(R.id.numero);
        button = findViewById(R.id.button);

        progressBar = findViewById(R.id.progressBar);

        button.setOnClickListener(view -> {
            String name = nombre.getText().toString().trim();
            String apell = apellido.getText().toString().trim();
            String age = edad.getText().toString().trim();
            String telephone = telefono.getText().toString().trim();

            progressBar.setVisibility(View.VISIBLE);
            if (name.isEmpty() || apell.isEmpty() || age.isEmpty() || telephone.isEmpty()){
                Toast.makeText(EditarPerfil.this, "Completar todos los campos", Toast.LENGTH_SHORT).show();
            } else if (Integer.parseInt(age) >= 99){
                Toast.makeText(EditarPerfil.this, "La edad es invalida", Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);
            } else if (String.valueOf(Long.parseLong(telephone)).length() <= 8) {
                Toast.makeText(EditarPerfil.this, "Numero invalido", Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);
            }else {
                Intent intent = new Intent(getApplicationContext(), Perfil.class);

                int ageInt = Integer.parseInt(age);
                long telephoneLong = Long.parseLong(telephone);

                Bundle bundle = new Bundle();
                bundle.putString("nombre", name);
                bundle.putString("apellido", apell);
                bundle.putLong("cellphone", telephoneLong);
                bundle.putInt("edad", ageInt);

                startActivity(intent.putExtras(bundle));
                Toast.makeText(EditarPerfil.this, "Datos guardados", Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);

            }
        });

        Bundle bundle = getIntent().getExtras();
        if (bundle != null){

            String name = bundle.getString("nombre");
            String apell = bundle.getString("apellido");
            int age = bundle.getInt("edad");
            Long cell = bundle.getLong("celphone");

            nombre.setText(name);
            apellido.setText(apell);
            edad.setText(String.valueOf(age));
            telefono.setText(String.valueOf(cell));
        }

    }
}