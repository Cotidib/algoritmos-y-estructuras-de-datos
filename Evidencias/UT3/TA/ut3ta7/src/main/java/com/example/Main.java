package com.example;

public class Main {
    public static void main(String[] args) {
        // Nodo nodo1 = new Nodo("1",1);
        // Nodo nodo2 = new Nodo("2",2);
        // Nodo nodo3 = new Nodo("3",3);
        // Nodo nodo4 = new Nodo("3",3);
        // Nodo nodo5 = new Nodo("5",5);
        // Nodo nodo6 = new Nodo("6",6);
        
        // System.out.println("UNION");
        // Conjunto conjunto1 = new Conjunto<>();
        // conjunto1.insertar(nodo1);
        // conjunto1.insertar(nodo2);
        // conjunto1.insertar(nodo3);
        // System.out.println(conjunto1.imprimir(" "));

        // Conjunto conjunto2 = new Conjunto<>();
        // conjunto2.insertar(nodo4);
        // conjunto2.insertar(nodo5);
        // conjunto2.insertar(nodo6);
        // System.out.println(conjunto2.imprimir(" "));

        // Conjunto conjunto3 = conjunto1.union(conjunto2);
        // System.out.println(conjunto3.imprimir(" "));

        // Nodo nodo7 = new Nodo("7",7);
        // Nodo nodo8 = new Nodo("8",8);
        // Nodo nodo9 = new Nodo("8",8);
        // Nodo nodo10 = new Nodo("10",10);

        // System.out.println("INTERSECCION");
        // Conjunto conjunto4 = new Conjunto<>();
        // conjunto4.insertar(nodo7);
        // conjunto4.insertar(nodo8);
        // System.out.println(conjunto4.imprimir(" "));

        // Conjunto conjunto5 = new Conjunto<>();
        // conjunto5.insertar(nodo9);
        // conjunto5.insertar(nodo10);
        // System.out.println(conjunto5.imprimir(" "));

        // Conjunto conjunto6 = conjunto4.interseccion(conjunto5);
        // System.out.println(conjunto6.imprimir(" "));

        Alumno alumno1 = new Alumno("1234", "Juan", "Perez");
        Alumno alumno2 = new Alumno("4321", "Sofia", "Rodriguez");
        Alumno alumno4 = new Alumno("4231", "Jose", "Alvarez");

        Conjunto<Alumno> aed1 = new Conjunto<>();
        Conjunto<Alumno> pf = new Conjunto<>();

        aed1.insertar(alumno1.cedula, alumno1);
        aed1.insertar(alumno2.cedula, alumno2);
        pf.insertar(alumno4.cedula, alumno4);
        pf.insertar(alumno2.cedula, alumno2);

        Conjunto<Alumno> resultado1 = aed1.union(pf);
        System.out.println(resultado1.imprimir(" "));
   
        Conjunto<Alumno> resultado2 = aed1.interseccion(pf);
        System.out.println(resultado2.imprimir(" "));



    }
}