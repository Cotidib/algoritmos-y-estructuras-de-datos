package com.example;

public class Main {
    public static void main(String[] args) {
        ManejadorArchivosGenerico manejardorArchivos = new ManejadorArchivosGenerico();

        TArbolBB arbol1 = new TArbolBB<>();
        String[] lineasClaves1 = manejardorArchivos.leerArchivo("src\\main\\java\\com\\example\\clavesPrueba.txt");
        for (String linea : lineasClaves1){
            arbol1.insertar(Integer.parseInt(linea), linea);
        }

        System.out.println("Preorden:");
        System.out.println(arbol1.preOrden());
        System.out.println("Postorden:");
        System.out.println(arbol1.postOrden());
        System.out.println("Inorden:");
        System.out.println(arbol1.inOrden());

        TElementoAB buscar6661 = arbol1.buscar(6661);
        System.out.println(buscar6661.getEtiqueta());


        TArbolBB arbol2 = new TArbolBB<>();
        String[] lineasClaves2 = manejardorArchivos.leerArchivo("src\\main\\java\\com\\example\\claves1.txt");
        for (String linea : lineasClaves2){
            arbol2.insertar(Integer.parseInt(linea), linea);
        }

        TElementoAB buscar10635 = arbol2.buscar(10635);
        if (buscar10635 != null){
            System.out.println("10635 existe");
        } else {
            System.out.println("10635 no existe");
        };

        TElementoAB buscar4567 = arbol2.buscar(4567);
        if (buscar4567 != null){
            System.out.println("4567 existe");
        } else {
            System.out.println("4567 no existe");
        };


        TElementoAB buscar12 = arbol2.buscar(12);
        if (buscar12 != null){
            System.out.println("12 existe");
        } else {
            System.out.println("12 no existe");
        };


        TElementoAB buscar8978 = arbol2.buscar(8978);
        if (buscar8978 != null){
            System.out.println("8978 existe");
        } else {
            System.out.println("8978 no existe");
        };

        System.out.println("Preorden:");
        System.out.println(arbol1.preOrden());
        System.out.println("La decima clave del listado en preorden es 10903");

    }
}