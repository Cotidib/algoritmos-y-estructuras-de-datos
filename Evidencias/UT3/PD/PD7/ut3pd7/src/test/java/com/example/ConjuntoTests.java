package com.example;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConjuntoTests {
  
  @Test
  public void unionTest(){
    Nodo nodo1 = new Nodo("1",1);
    Nodo nodo2 = new Nodo("2",2);
    Nodo nodo3 = new Nodo("3",3);
    Nodo nodo4 = new Nodo("3",3);
    Nodo nodo5 = new Nodo("5",5);
    Nodo nodo6 = new Nodo("6",6);
    
    Conjunto conjunto1 = new Conjunto<>();
    conjunto1.insertar(nodo1);
    conjunto1.insertar(nodo2);
    conjunto1.insertar(nodo3);

    Conjunto conjunto2 = new Conjunto<>();
    conjunto2.insertar(nodo4);
    conjunto2.insertar(nodo5);
    conjunto2.insertar(nodo6);

    Conjunto conjunto3 = conjunto1.union(conjunto2);
    String result = conjunto3.imprimir(" ");
    Assertions.assertEquals("1 2 3 5 6", result);
  }

  @Test
  public void interseccionTest(){
    Nodo nodo1 = new Nodo("1",1);
    Nodo nodo2 = new Nodo("2",2);
    Nodo nodo3 = new Nodo("3",3);
    Nodo nodo4 = new Nodo("3",3);
    Nodo nodo5 = new Nodo("5",5);
    Nodo nodo6 = new Nodo("6",6);
    
    Conjunto conjunto1 = new Conjunto<>();
    conjunto1.insertar(nodo1);
    conjunto1.insertar(nodo2);
    conjunto1.insertar(nodo3);

    Conjunto conjunto2 = new Conjunto<>();
    conjunto2.insertar(nodo4);
    conjunto2.insertar(nodo5);
    conjunto2.insertar(nodo6);

    Conjunto conjunto3 = conjunto1.interseccion(conjunto2);
    String result = conjunto3.imprimir(" ");
    Assertions.assertEquals("3", result);
  }

  @Test
  public void unionAlumnos(){
    Alumno alumno1 = new Alumno("1234", "Juan", "Perez");
    Alumno alumno2 = new Alumno("4321", "Sofia", "Rodriguez");
    Alumno alumno4 = new Alumno("4231", "Jose", "Alvarez");

    Conjunto<Alumno> aed1 = new Conjunto<>();
    Conjunto<Alumno> pf = new Conjunto<>();

    aed1.insertar(alumno1.cedula, alumno1);
    aed1.insertar(alumno2.cedula, alumno2);
    pf.insertar(alumno4.cedula, alumno4);
    pf.insertar(alumno2.cedula, alumno2);

    Conjunto<Alumno> conjunto1 = aed1.union(pf);
    String result = conjunto1.imprimir(" ");
    Assertions.assertEquals("1234 4231 4321", result);
  }

  @Test
  public void interseccionAlumnos(){
    Alumno alumno1 = new Alumno("1234", "Juan", "Perez");
        Alumno alumno2 = new Alumno("4321", "Sofia", "Rodriguez");
        Alumno alumno4 = new Alumno("4231", "Jose", "Alvarez");

        Conjunto<Alumno> aed1 = new Conjunto<>();
        Conjunto<Alumno> pf = new Conjunto<>();

        aed1.insertar(alumno1.cedula, alumno1);
        aed1.insertar(alumno2.cedula, alumno2);
        pf.insertar(alumno4.cedula, alumno4);
        pf.insertar(alumno2.cedula, alumno2);
   
        Conjunto<Alumno> conjunto1 = aed1.interseccion(pf);
        String result = conjunto1.imprimir(" ");
        Assertions.assertEquals("4321", result);
    
  }
}
