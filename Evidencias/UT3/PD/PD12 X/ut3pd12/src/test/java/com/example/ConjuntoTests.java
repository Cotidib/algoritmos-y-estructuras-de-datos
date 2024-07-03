package com.example;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConjuntoTests {
  ManejadorArchivosGenerico manejadorArchivos1;
  ManejadorArchivosGenerico manejadorArchivos2;
  Conjunto<Alumno> BasicoIng;
  Conjunto<Alumno> BasicoEmp;

  @BeforeEach
  void init(){
    manejadorArchivos1 = new ManejadorArchivosGenerico();
    // instanciar curso BasicoIng...
    BasicoIng = new Conjunto<>();
    // cargar alumnos del curso BasicoIng desde el archivo “basico-ing.txt”
    String[] lineasIng = manejadorArchivos1.leerArchivo("src\\test\\resources\\com\\example\\basico-ing.txt");
    for (String linea : lineasIng) {
        String[] datos = linea.split(",");
        Alumno alumno = new Alumno(Integer. parseInt(datos[0]), datos[1], null);
        BasicoIng.insertar(alumno.cedula, alumno);
    }
    manejadorArchivos2 = new ManejadorArchivosGenerico();
    // instanciar curso BasicoEmp...
    BasicoEmp = new Conjunto<>();
    // cargar alumnos del curso BasicoEmp desde el archivo “basico-emp.txt”
    String[] lineasEmp = manejadorArchivos2.leerArchivo("src\\test\\resources\\com\\example\\basico-emp.txt");
    for (String linea : lineasEmp) {
        String[] datos = linea.split(",");
        Alumno alumno = new Alumno(Integer. parseInt(datos[0]), datos[1], null);
        BasicoEmp.insertar(alumno.cedula, alumno);
    }
  }
  
  @Test
  public void unionTest(){
    Conjunto union = BasicoIng.union(BasicoEmp);
    String result = union.imprimir(" ");
    System.out.println(result);
    Assertions.assertEquals("1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99 100", result);
  }

  @Test
  public void interseccionTest(){
    Conjunto interseccion = BasicoIng.interseccion(BasicoEmp);
    String result = interseccion.imprimir(" ");
    Assertions.assertEquals("3 6 9 12 15 18 21 24 27 30 33 36 41 44 47 50 53 56 59 62 65 68 71 74 77 80 83 86 89 92 95 98", result);
  }

}
