package com.example;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PilaTests{

  @Test
  public void PilaInsertar(){
    Nodo nodo1 = new Nodo(1, 1);
    Nodo nodo2 = new Nodo(2, 2);
    Nodo nodo3 = new Nodo(3, 3);
    Nodo nodo4 = new Nodo(4, 4);
    Nodo nodo5 = new Nodo(5, 5);
    Nodo nodo6 = new Nodo(6, 6);
    Nodo nodo7 = new Nodo(7, 7);
    Nodo nodo8 = new Nodo(8, 8);

    Pila pila = new Pila<>();
    pila.insertar(nodo1);
    pila.insertar(nodo2);
    pila.insertar(nodo3);
    pila.insertar(nodo4);
    pila.insertar(nodo5);
    pila.insertar(nodo6);

    String resultado = pila.imprimir(" ");
    Assertions.assertEquals("6 5 4 3 2 1", resultado);
  }

  @Test
  public void PilaRetirar(){
    Nodo nodo1 = new Nodo(1, 1);
    Nodo nodo2 = new Nodo(2, 2);
    Nodo nodo3 = new Nodo(3, 3);
    Nodo nodo4 = new Nodo(4, 4);
    Nodo nodo5 = new Nodo(5, 5);
    Nodo nodo6 = new Nodo(6, 6);
    Nodo nodo7 = new Nodo(7, 7);
    Nodo nodo8 = new Nodo(8, 8);

    Pila pila = new Pila<>();
    pila.insertar(nodo1);
    pila.insertar(nodo2);
    pila.insertar(nodo3);
    pila.insertar(nodo4);
    pila.insertar(nodo5);
    pila.insertar(nodo6);
    String resultado = pila.imprimir(" ");
    Assertions.assertEquals("6 5 4 3 2 1", resultado);

    pila.retirar();
    pila.retirar();
    pila.retirar();
    pila.retirar();
    pila.retirar();
    String resultado2 = pila.imprimir(" ");
    Assertions.assertEquals("1", resultado2);
  }
}