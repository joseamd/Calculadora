package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class Main2Activity extends AppCompatActivity {

    public TextView visorResultado, visorEstuditante;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        visorResultado = findViewById(R.id.visorResultado);
        visorEstuditante = findViewById(R.id.visorEstudiante);
        visorEstuditante.setText("JOSE ALEXANDER MUÑOZ \n COD 1810206\n" +
                "ALEJANDRO PALACIOS HURTADO \n COD 1630531");

        String mensaje = getIntent().getStringExtra("Dato");
        TextView textView = (TextView) findViewById(R.id.visorResultado);
        textView.setText(mensaje);

    }

    //METODO PARA REGRESAR
    public void Regresar (View view){
        Intent intent2 = new Intent(this, MainActivity.class);
        startActivity(intent2);
    }
}
