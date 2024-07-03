package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TArbolBBTests {
  
  @Test
  void eliminarTests(){
    TArbolBB arbol2 = new TArbolBB<>();
        arbol2.insertar(12, 12);
        arbol2.insertar(25, 25);
        arbol2.insertar(14, 14);
        arbol2.insertar(1, 1);
        arbol2.insertar(33, 33);
        arbol2.insertar(88, 88);
        arbol2.insertar(45, 45);
        arbol2.insertar(2, 2);
        arbol2.insertar(7, 7);
        arbol2.insertar(66, 66);
        arbol2.insertar(5, 5);
        arbol2.insertar(99, 99);

        String inorden = arbol2.inOrden();
        Assertions.assertEquals("1 2 5 7 12 14 25 33 45 66 88 99", inorden);

        arbol2.eliminar(99);
        inorden = arbol2.inOrden();
        Assertions.assertEquals("1 2 5 7 12 14 25 33 45 66 88", inorden);
        arbol2.eliminar(15);
        inorden = arbol2.inOrden();
        Assertions.assertEquals("1 2 5 7 12 14 25 33 45 66 88", inorden);
        arbol2.eliminar(2);
        inorden = arbol2.inOrden();
        Assertions.assertEquals("1 5 7 12 14 25 33 45 66 88", inorden);
        arbol2.eliminar(12);
        inorden = arbol2.inOrden();
        Assertions.assertEquals("1 5 7 14 25 33 45 66 88", inorden);
        arbol2.eliminar(77);
        inorden = arbol2.inOrden();
        Assertions.assertEquals("1 5 7 14 25 33 45 66 88", inorden);
        arbol2.eliminar(33);
        inorden = arbol2.inOrden();
        Assertions.assertEquals("1 5 7 14 25 45 66 88", inorden);

        String inordenFin = arbol2.inOrden();
        String preordenFin = arbol2.preOrden();
        String postordenFin = arbol2.postOrden();
        Assertions.assertEquals("1 5 7 14 25 45 66 88", inordenFin);
        Assertions.assertEquals("7 1 5 25 14 88 45 66", preordenFin);
        Assertions.assertEquals("5 1 14 66 45 88 25 7", postordenFin);
  }
}
