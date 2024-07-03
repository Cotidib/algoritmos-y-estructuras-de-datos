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
  public void insertar(){
    Assertions.assertEquals("A C J K L N P S T U V X Y Z", arbol1.inOrden());
  }

  @Test
  public void inOrden(){
    Assertions.assertEquals("A C J K L N P S T U V X Y Z", arbol1.inOrden());
  }

  @Test
  public void preOrden(){
    Assertions.assertEquals("T P L K J A C N S Y U X V Z", arbol1.preOrden());
  }

  @Test
  public void postOrden(){
    Assertions.assertEquals("C A J K N L S P V X U Z Y T", arbol1.postOrden());
  }

  @Test
  public void buscar(){
    TElementoAB buscado = arbol1.buscar("N");
    Assertions.assertEquals("N", buscado.getEtiqueta().toString());
  }

  @Test
  public void eliminar(){
    arbol1.eliminar("J");
    Assertions.assertEquals("A C K L N P S T U V X Y Z", arbol1.inOrden());
    arbol1.eliminar("N");
    Assertions.assertEquals("A C K L P S T U V X Y Z", arbol1.inOrden());
    arbol1.eliminar("T");
    Assertions.assertEquals("A C K L P S U V X Y Z", arbol1.inOrden());
  }

  @Test
  public void menorClaveTest(){
    Assertions.assertEquals("A", arbol1.obtenerMenorClave());
  } 

  @Test
  public void mayorClaveTest(){
    Assertions.assertEquals("Z", arbol1.obtenerMayorClave());
  } 

  @Test
  public void contarPorNivelTest(){
    Assertions.assertEquals(4, arbol1.contarPorNivel(2));
  }

  @Test
  public void obtenerClaveAnteriorTest(){
    Assertions.assertEquals("A", arbol1.obtenerClaveAnterior("C"));
    Assertions.assertEquals("J", arbol1.obtenerClaveAnterior("A"));
    Assertions.assertEquals("K", arbol1.obtenerClaveAnterior("J"));
    Assertions.assertEquals("L", arbol1.obtenerClaveAnterior("N"));
    Assertions.assertEquals("X", arbol1.obtenerClaveAnterior("V"));
    Assertions.assertEquals("U", arbol1.obtenerClaveAnterior("X"));
    Assertions.assertEquals("T", arbol1.obtenerClaveAnterior("Y"));
  }

  @Test 
  public void listarHojasTest(){
    Assertions.assertEquals("Nodo C Nivel 6 Nodo N Nivel 3 Nodo S Nivel 2 Nodo V Nivel 4 Nodo Z Nivel 2 ", arbol1.listarHojas());
  }

  @Test
  public void esArbolBBTest(){
    Assertions.assertEquals(true, arbol1.esArbolBB());
    TArbolBB arbol2 = new TArbolBB<>();
    arbol2.insertar(2,2);
    TElementoAB der = new TElementoAB(1, 1);
    arbol2.raiz.setHijoDer(der);
    TElementoAB izq = new TElementoAB(3, 3);
    arbol2.raiz.setHijoIzq(izq);
    Assertions.assertEquals(false, arbol2.esArbolBB());
  }
}
