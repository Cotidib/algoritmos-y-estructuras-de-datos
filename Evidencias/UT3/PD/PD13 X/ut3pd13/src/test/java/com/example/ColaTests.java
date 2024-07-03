package com.example;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ColaTests {

  @Test 
  public void ColaInsertar(){
    Nodo nodo1 = new Nodo(1, 1);
    Nodo nodo2 = new Nodo(2, 2);
    Nodo nodo3 = new Nodo(3, 3);
    Nodo nodo4 = new Nodo(4, 4);
    Nodo nodo5 = new Nodo(5, 5);
    Nodo nodo6 = new Nodo(6, 6);

    Cola cola = new Cola<>();
    cola.insertar(nodo1);
    cola.insertar(nodo2);
    cola.insertar(nodo3);
    cola.insertar(nodo4);
    cola.insertar(nodo5);
    cola.insertar(nodo6);
    String resultado = cola.imprimir(" ");
    Assertions.assertEquals("1 2 3 4 5 6", resultado);
  }

  @Test 
  public void ColaRetirar(){
    Nodo nodo1 = new Nodo(1, 1);
    Nodo nodo2 = new Nodo(2, 2);
    Nodo nodo3 = new Nodo(3, 3);
    Nodo nodo4 = new Nodo(4, 4);
    Nodo nodo5 = new Nodo(5, 5);
    Nodo nodo6 = new Nodo(6, 6);

    Cola cola = new Cola<>();
    cola.insertar(nodo1);
    cola.insertar(nodo2);
    cola.insertar(nodo3);
    cola.insertar(nodo4);
    cola.insertar(nodo5);
    cola.insertar(nodo6);
    String resultado = cola.imprimir(" ");
    Assertions.assertEquals("1 2 3 4 5 6", resultado);
    cola.retirar();
    cola.retirar();
    cola.retirar();
    String resultado2 = cola.imprimir(" ");
    Assertions.assertEquals("4 5 6", resultado2);
  }
}
