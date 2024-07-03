package com.example;

public class Main {
    public static void main(String[] args) {
        ManejadorArchivosGenerico manejadorArchivos = new ManejadorArchivosGenerico();
        // instanciar curso BasicoIng...
        Conjunto<Alumno> BasicoIng = new Conjunto<>();
        // cargar alumnos del curso BasicoIng desde el archivo “basico-ing.txt”
        String[] lineasIng = manejadorArchivos.leerArchivo("ut3pd12\\src\\main\\java\\com\\example\\basico-ing.txt");
        for (String linea : lineasIng) {
            String[] datos = linea.split(",");
            Alumno alumno = new Alumno(Integer. parseInt(datos[0]), datos[1], null);
            BasicoIng.insertar(alumno.cedula, alumno);
        }
        
        // instanciar curso BasicoEmp...
        Conjunto<Alumno> BasicoEmp = new Conjunto<>();
        // cargar alumnos del curso BasicoEmp desde el archivo “basico-emp.txt”
        String[] lineasEmp = manejadorArchivos.leerArchivo("ut3pd12\\src\\main\\java\\com\\example\\basico-emp.txt");
        for (String linea : lineasEmp) {
            String[] datos = linea.split(",");
            Alumno alumno = new Alumno(Integer. parseInt(datos[0]), datos[1], null);
            BasicoEmp.insertar(alumno.cedula, alumno);
        }

       // generar el curso "integrador101" con los alumnos que hayan cursado “BASICO-ING 1” y /o “BASICO-EMP 1”
       Conjunto integrador101 = BasicoIng.union(BasicoEmp);
       System.out.println(integrador101.imprimir(" "));
       // guardar en un archivo "integrador101.txt"  - IDEALMENTE ordenados por código de alumno -
       String[] integrador101Array = integrador101.imprimir(",").split(",");
       manejadorArchivos.escribirArchivo("integrador101.txt", integrador101Array);
       
       // generar el curso "exigente102" con los alumnos que hayan cursado “BASICO-ING 1” y “BASICO-EMP 1”
       Conjunto exigente102 = BasicoIng.interseccion(BasicoEmp);
       System.out.println(exigente102.imprimir(" "));
       // guardar en un archivo "exigente102.txt" - IDEALMENTE ordenados por código de alumno -
       String[] exigente102Array = exigente102.imprimir(",").split(",");
       manejadorArchivos.escribirArchivo("exigente102.txt", exigente102Array);
        


    }
}