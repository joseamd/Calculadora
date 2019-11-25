package com.example.calculadora;

public class Operacion {

    private double num1, num2, total;
    private String operation;

    public Operacion (double num1, double num2, double total, String operacion){
        this.num1 = num1;
        this.num2 = num2;
        this.total = total;
        this.operation = operation;
    }
    public Operacion(){

    }

    public String getOperation(){
        return operation;
    }
    public void setOperation(String operation){
        this.operation = operation;
    }

    public double getNum1(){
        return num1;
    }
    public void setNum1(double num1){
        this.num1 = num1;
    }

    public double getNum2(){
        return num2;
    }
    public void setNum2(double num2){
        this.num2 = num1;
    }

    public double getTotal(){
        return total;
    }
    public void setTotal(double total){
        this.total = total;
    }

    //metodo suma
    public double operationSum(double valor1, double valor2){
        total = valor1+valor2;
        return total;
    }

    //metodo resta
    double operationRes(double valor1, double valor2){
        total = valor1-valor2;
        return total;
    }

    //metodo multiplicacion
    double operationMult(double valor1, double valor2){
        total = valor1*valor2;
        return total;
    }

    //metodo division
    double operationDiv(double valor1, double valor2){
        total = valor1/valor2;
        return total;
    }

    //metodo raiz cuadrada
    double operationRaiz(double valor1){
        total = Math.sqrt(valor1);
        return total;
    }

    //metodo elevar Exponente
    double operationExp(double valor1, double valor2){
        total = Math.pow(valor1, valor2);
        return total;
    }

}
