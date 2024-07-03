package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TArbolBBTests {
  TArbolBB arbol1;
  
  @BeforeEach
  void init(){
    arbol1 = new TArbolBB<>();
    arbol1.insertar("T", "T");
    arbol1.insertar("Y", "Y");
    arbol1.insertar("U", "U");
    arbol1.insertar("P", "P");
    arbol1.insertar("L", "L");
    arbol1.insertar("K", "K");
    arbol1.insertar("J", "J");
    arbol1.insertar("S", "S");
    arbol1.insertar("A", "A");
    arbol1.insertar("Z", "Z");
    arbol1.insertar("X", "X");
    arbol1.insertar("C", "C");
    arbol1.insertar("V", "V");
    arbol1.insertar("N", "N");
  }

  @Test
  public void contarHojas(){
    Assertions.assertEquals(5, arbol1.contarHojas());
  } 

  @Test
  public void obtenerNivelTest(){
    Assertions.assertEquals(4, arbol1.obtenerNivel("J"));
    Assertions.assertEquals(0, arbol1.obtenerNivel("T"));
    Assertions.assertEquals(-1, arbol1.obtenerNivel("B"));
  } 

}
