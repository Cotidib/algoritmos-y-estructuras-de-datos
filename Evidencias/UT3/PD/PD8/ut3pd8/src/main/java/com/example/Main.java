package com.example;

public class Main {
    public static void main(String[] args) {
        ManejadorArchivosGenerico manejadorArchivos = new ManejadorArchivosGenerico();
        
        //  PRUEBA 1
        Empresa empresa1 = new Empresa();
        String[] lineasSuc1 = manejadorArchivos.leerArchivo("ut3pd8\\src\\main\\java\\com\\example\\suc1.txt");
        for (String linea : lineasSuc1) {
            Sucursal sucursal = new Sucursal(linea);
            empresa1.insertarSucursal(sucursal);
        }

        System.out.println("Cantidad de Sucursales en suc1: " + empresa1.cantidadSucursales());
        System.out.println(empresa1.listar(" "));

        // PRUEBA 2
        empresa1.eliminar("Chicago");
        System.out.println("Cantidad de Sucursales en suc1: " + empresa1.cantidadSucursales());
        System.out.println(empresa1.listar(" "));
        System.out.println("La ciudad que le sigue a Hong Kong es Shenzhen");

        // PRUEBA 3
        Empresa empresa2 = new Empresa();
        String[] lineasSuc2 = manejadorArchivos.leerArchivo("ut3pd8\\src\\main\\java\\com\\example\\suc2.txt");
        for (String linea : lineasSuc2) {
            Sucursal sucursal = new Sucursal(linea);
            empresa2.insertarSucursal(sucursal);
        }
        System.out.println("Cantidad de Sucursales en suc2: " + empresa2.cantidadSucursales());
        System.out.println(empresa2.listar(" "));

        empresa2.eliminar("Shenzen");
        empresa2.eliminar("Tokio");
        // empresa2.eliminar("ï»¿Tokio");

        System.out.println("Cantidad de Sucursales en suc2: " + empresa2.cantidadSucursales());
        System.out.println(empresa2.listar(" "));


        // PRUEBA 4
        Empresa empresa3 = new Empresa();
        String[] lineasSuc3 = manejadorArchivos.leerArchivo("ut3pd8\\src\\main\\java\\com\\example\\suc3.txt");
        for (String linea : lineasSuc3) {
            Sucursal sucursal = new Sucursal(linea);
            empresa3.insertarSucursal(sucursal);
        }
        System.out.println("Cantidad de Sucursales en suc3: " + empresa3.cantidadSucursales());
        System.out.println(empresa3.listar(";_"));
    }
}