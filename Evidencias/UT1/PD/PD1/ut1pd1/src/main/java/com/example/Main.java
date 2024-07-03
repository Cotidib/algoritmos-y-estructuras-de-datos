package com.example;

public class Main {
    public static void main(String[] args) {
        Multsuma multsum = new Multsuma();
        double resultado = multsum.multsuma(1.0, 2.0, 3.0);
        System.out.println(resultado);

        int resultadoRecorrrer = com.example.Alumno.recorrer("hola");
        System.out.println(resultadoRecorrrer);

        int resultadoValor = com.example.Alumno.getValor();
        System.out.println(resultadoValor);

        char resultadoPrimerCaracter = com.example.Alumno.getPrimerCaracter("hola");
        System.out.println(resultadoPrimerCaracter);

        String resultadoParaAString = com.example.Alumno.paraAString(2);
        System.out.println(resultadoParaAString);

        Contador contador = new Contador();
        contador.mostrarContador();
    }
}