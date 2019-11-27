package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity  {
    //Declaración de Variables

    public Operacion operacion;
    public double operan1, operan2, total, memory;
    public int tipOperation=0;
    public String stringMensaje = "", stringDecimal="";
    public EditText visor;
    public TextView visorResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        visor = findViewById(R.id.visor);
        visorResultado = findViewById(R.id.visorResultado);
        operacion = new Operacion(); //creamos un objeto operacion

        //Al girar pantalla permanece la info del EdiText y TexView
        if(savedInstanceState != null ) {
            operan1 = savedInstanceState.getDouble("", operan1);
            stringDecimal = savedInstanceState.getString("", stringDecimal);
            visor.setText("" + operan1);
            visorResultado.setText(stringDecimal);
        }
    }

    @Override
    //Almacenamos los datos cuando se reinicia la actividad
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putDouble("", operan1);
        outState.putString("",stringDecimal);
    }


    /*Creación de metodos de los botones*/
    public void button0 (View v){
        String contenido1 = visor.getText().toString();
        contenido1= contenido1 + "0";
        visor.setText(contenido1);
    }

    public void button1 (View v){
        String contenido1 = visor.getText().toString();
        contenido1= contenido1 + "1";
        visor.setText(contenido1);
    }

    public void button2 (View v){
        String contenido1 = visor.getText().toString();
        contenido1= contenido1 + "2";
        visor.setText(contenido1);
    }

    public void button3 (View v){
        String contenido1 = visor.getText().toString();
        contenido1= contenido1 + "3";
        visor.setText(contenido1);
    }

    public void button4 (View v){
        String contenido1 = visor.getText().toString();
        contenido1= contenido1 + "4";
        visor.setText(contenido1);
    }

    public void button5 (View v){
        String contenido1 = visor.getText().toString();
        contenido1= contenido1 + "5";
        visor.setText(contenido1);
    }

    public void button6 (View v){
        String contenido1 = visor.getText().toString();
        contenido1= contenido1 + "6";
        visor.setText(contenido1);
    }

    public void button7 (View v){
        String contenido1 = visor.getText().toString();
        contenido1= contenido1 + "7";
        visor.setText(contenido1);
    }

    public void button8 (View v){
        String contenido1 = visor.getText().toString();
        contenido1= contenido1 + "8";
        visor.setText(contenido1);
    }

    public void button9 (View v){
        String contenido1 = visor.getText().toString();
        contenido1= contenido1 + "9";
        visor.setText(contenido1);
    }

    public void buttonPunto (View v){
        String contenido1 = visor.getText().toString();
        contenido1= contenido1 + ".";
        visor.setText(contenido1);
    }

    /*metodos de botones operadores*/

    public void suma (View v){

        if (visor.getText().toString().isEmpty()){
            visor.setText("+");
        }else{
            try {
                String valor1 = visor.getText().toString();
                operan1 = Double.parseDouble(valor1);
            }catch (NumberFormatException nfe){}
            visor.setText("");
            tipOperation= 1;
        }

    }

    public void resta (View v){
        if(visor.getText().toString().isEmpty()){
            visor.setText("-");
        }else {
            try {
                String valor1 = visor.getText().toString();
                operan1 = Double.parseDouble(valor1);
            }catch (NumberFormatException nfe){}
            visor.setText("");
            tipOperation= 2;
        }
    }

    public void multiplicacion (View v){
        if(visor.getText().toString().isEmpty()){
            stringMensaje = "Syntax ERROR";
            visorResultado.setText(stringMensaje);
        }else{
            try {
            String valor1 = visor.getText().toString();
            operan1 = Double.parseDouble(valor1);
        }catch (NumberFormatException nfe){}
            visor.setText("");
            tipOperation = 3;}

    }

    public void division (View v){
        if(visor.getText().toString().isEmpty()){
            stringMensaje = "Syntax ERROR";
            visorResultado.setText(stringMensaje);
        }else {
            try {
                String valor1 = visor.getText().toString();
                operan1 = Double.parseDouble(valor1);
            }catch (NumberFormatException nfe){}
            visor.setText("");
            tipOperation= 4;
        }

    }

    public void raiz (View v){
        if(visor.getText().toString().isEmpty()){
            stringMensaje = "Syntax ERROR";
            visorResultado.setText(stringMensaje);
        }else {
            try {
                String valor1 = visor.getText().toString();
                operan1 = Double.parseDouble(valor1);
                decimal(operan1);
            }catch (NumberFormatException nfe){}
            visor.setText("√"+stringDecimal);
            tipOperation= 5;
        }

    }

    public void Exponente (View v){
        if(visor.getText().toString().isEmpty()) {
            stringMensaje = "Syntax ERROR";
            visorResultado.setText(stringMensaje);
        }else {
            try {
                String valor1 = visor.getText().toString();
                operan1 = Double.parseDouble(valor1);
            }catch (NumberFormatException nfe){}
            visor.setText("");
            tipOperation= 6;
        }
    }

    public void borrarAC (View v){
        visor.setText("");
        visorResultado.setText("");
        stringDecimal= ("");
        operan1 = 0;
        operan2 = 0;
        total = 0;
    }

    public void borrarDEL (View v){
        if (!visor.getText().toString().equals("")){
            visor.setText(visor.getText().subSequence(0, visor.getText().length()-1)+"");
        }
    }

    public void memoria (View v){
        decimal(memory);
        visor.setText(""+stringDecimal);
        visorResultado.setText("");
    }

    public void igual (View v){
        if (tipOperation != 0){
            try {
                String valor2 = visor.getText().toString();
                operan2 = Double.parseDouble(valor2);
            }catch (NumberFormatException nfe){}
            visor.setText("");

            if (tipOperation == 1){
                total = operacion.operationSum(operan1, operan2);
                decimal(total);
                visorResultado.setText(stringDecimal);

            }else if (tipOperation == 2){
                total = operacion.operationRes(operan1, operan2);
                decimal(total);
                visorResultado.setText(stringDecimal);

            }else if (tipOperation == 3){
                total = operacion.operationMult(operan1, operan2);
                decimal(total);
                visorResultado.setText(stringDecimal);

            }else if (tipOperation == 4) {
                if (operan2 == 0){              //condicion si el denomidador es igual de cero
                    stringMensaje  = "Math ERROR";
                    visorResultado.setText(stringMensaje);
                }else {
                    total = operacion.operationDiv(operan1, operan2);
                    decimal(total);
                    visorResultado.setText(stringDecimal);
                }

            }else if (tipOperation == 5){
                total = operacion.operationRaiz(operan1);
                decimal(total);
                visorResultado.setText(stringDecimal);

            }else if (tipOperation == 6){
                total = operacion.operationExp(operan1, operan2);
                decimal(total);
                visorResultado.setText(stringDecimal);

            }
        }else {
            try {
                String valor1 = visor.getText().toString();
                operan1 = Double.parseDouble(valor1);
            }catch (NumberFormatException nfe){}
            visor.setText("");
            total = operan1;
            decimal(total);
            visorResultado.setText(""+stringDecimal);
        }
        tipOperation=0; //inicializamos esta variable para una nueva operacion
        memory=total; //guardamos el total en la variable memoria para hacer otra operacion
        total=0;
    }

    //convertir double a número decimal
    public void decimal(double total){
        NumberFormat nf = new DecimalFormat("##.###########");
        stringDecimal = (""+ nf.format(total));

    }

    //Intent para enviar el dato a la actividad2
    public void onSendResultado (View v){
        Intent intent = new Intent (this, Main2Activity.class);
        intent.putExtra("Dato", String.valueOf(stringDecimal));
        startActivity(intent);
    }


}
