package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  {
    //Declaración de Variables

    public Operacion operacion;
    public double operan1, operan2, total, memory;
    public int tipOperation;
    public String stringResult = "0";
    public EditText visor;
    public TextView visorResultado;

    @Override
    //Metodo que almacena el dato cuando se reinicia la actividad
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState != null ) {
            operan1 = savedInstanceState.getDouble("", operan1);
            total = savedInstanceState.getDouble("", total);
            visor.setText("" + operan1);
            visorResultado.setText(""+ total);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        visor = findViewById(R.id.visor);
        visorResultado = findViewById(R.id.visorResultado);
        operacion = new Operacion(); //creamos un objeto operacion
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
        try {
            String valor1 = visor.getText().toString();
            operan1 = Double.parseDouble(valor1);
        }catch (NumberFormatException nfe){}
        visor.setText("");
        tipOperation= 1;
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
        try {
            String valor1 = visor.getText().toString();
            operan1 = Double.parseDouble(valor1);
        }catch (NumberFormatException nfe){}
        visor.setText("");
        tipOperation = 3;
    }

    public void division (View v){
        try {
            String valor1 = visor.getText().toString();
            operan1 = Double.parseDouble(valor1);
        }catch (NumberFormatException nfe){}
        visor.setText("");
        tipOperation= 4;
    }

    public void raiz (View v){
        if(visor.getText().toString().isEmpty()){
            stringResult = "Syntax ERROR";
        }else {
            try {
                String valor1 = visor.getText().toString();
                operan1 = Double.parseDouble(valor1);
            }catch (NumberFormatException nfe){}
            visor.setText("√"+operan1);
            tipOperation= 5;
        }

    }

    public void Exponente (View v){
        try {
            String valor1 = visor.getText().toString();
            operan1 = Double.parseDouble(valor1);
        }catch (NumberFormatException nfe){}
        visor.setText("");
        tipOperation= 6;
    }

    public void borrarAC (View v){
        visor.setText("");
        visorResultado.setText("");
        operan1 = 0.0;
        operan2 = 0.0;
        total = 0.0;
    }

    public void borrarDEL (View v){
        if (!visor.getText().toString().equals("")){
            visor.setText(visor.getText().subSequence(0, visor.getText().length()-1)+"");
        }
    }

    public void memoria (View v){
        visor.setText(""+memory);

    }

    public void igual (View v){

        try {
            String valor2 = visor.getText().toString();
            operan2 = Double.parseDouble(valor2);
        }catch (NumberFormatException nfe){}
        visor.setText("");

        if (tipOperation == 1){
            total = operacion.operationSum(operan1, operan2);
            stringResult = Double.toString(total);

        }else if (tipOperation == 2){
            total = operacion.operationRes(operan1, operan2);
            stringResult = Double.toString(total);

        }else if (tipOperation == 3){
            total = operacion.operationMult(operan1, operan2);
            stringResult = Double.toString(total);

        }else if (tipOperation == 4) {
            if (operan2 != 0){              //condicion si el denormidador es distinto de cero
                total = operacion.operationDiv(operan1, operan2);
                stringResult = Double.toString(total);
            }else {
                stringResult = "Math ERROR";
            }

        }else if (tipOperation == 5){
            total = operacion.operationRaiz(operan1);
            stringResult = Double.toString(total);

        }else if (tipOperation == 6){
            total = operacion.operationExp(operan1, operan2);
            stringResult = Double.toString(total);

        }

        visorResultado.setText(stringResult);
        memory=total; //si queremos hacer otra operacion con el resultado
    }



    /*Elimina ceros que puede dar el double a partir de la coma */

    public void deleteCeros() {
        for(int i = stringResult.length()-1 ; i > stringResult.indexOf(".") ; i--){
            String n = String.valueOf(stringResult.charAt(i));
            if(n.equals("0")){
                stringResult = stringResult.substring(0, i);
                i--;
            }
        }
        if(stringResult.length() > 1 &&
                stringResult.substring(stringResult.length()-1, stringResult.length()).equals(".")){
            stringResult = stringResult.replace(".", "");
        }
    }


    //Intent para enviar el dato a la otra actividad

    public void onSendResultado (View v){
        Intent intent = new Intent (this, Main2Activity.class);
        intent.putExtra("Dato", String.valueOf(stringResult));
        startActivity(intent);
    }
}
