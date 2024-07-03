package com.example;

public class Alumno {
    private int ID;
    private String fullName;
    private String email;
    private int hash;

    // Según la especificación de Java, el contrato general de hashCode establece que:
    // Si dos objetos son iguales según el método equals, entonces deben tener el mismo valor de hashCode.
    // Si dos objetos son diferentes según el método equals, no necesariamente deben tener diferentes valores de hashCode. Sin embargo, tener valores de hashCode diferentes para objetos no iguales puede mejorar el rendimiento de las estructuras de datos hash.
    // El valor devuelto por hashCode para un objeto debe permanecer constante siempre que no se modifique ninguna información utilizada en las comparaciones equals de ese objeto.

    public int hashChode(){
        int h = hash;
        if (h == 0 && fullName.length() > 0) {
            char val[] = fullName.toCharArray();

            for (int i = 0; i < fullName.length(); i++) {
                h = 31 * h + val[i];
            }
            hash = h;
        }
        return h + ID;
    }
}