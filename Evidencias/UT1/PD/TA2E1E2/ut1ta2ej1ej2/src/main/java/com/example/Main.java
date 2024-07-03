package com.example;

public class Main {
    public static void main(String[] args) {
        EquipoA equipoA = new EquipoA();
        EquipoB equipoB = new EquipoB();

        int resultadoA = equipoA.factorial(10);
        System.out.println(resultadoA);

        int resultadoB = equipoB.calcular(7);
        System.out.println(resultadoB);
    }
}