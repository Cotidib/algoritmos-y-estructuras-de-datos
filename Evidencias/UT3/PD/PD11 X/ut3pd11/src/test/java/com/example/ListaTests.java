package com.example;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ListaTests {

  Lista lista;

  @BeforeEach
  void init(){
    Nodo nodo4 = new Nodo(4, 4);
    Nodo nodo71 = new Nodo(71, 71);
    Nodo nodo3 = new Nodo(3, 3);
    Nodo nodo6 = new Nodo(6, 6);
    Nodo nodo12 = new Nodo(12, 12);
    Nodo nodo8 = new Nodo(8, 8);
    Nodo nodo35 = new Nodo(35, 35);
    Nodo nodo11 = new Nodo(11, 11);
    Nodo nodo22 = new Nodo(22, 22);
    Nodo nodo17 = new Nodo(17, 17);

    lista = new Lista<>();
    lista.insertar(nodo4);
    lista.insertar(nodo71);
    lista.insertar(nodo3);
    lista.insertar(nodo6);
    lista.insertar(nodo12);
    lista.insertar(nodo8);
    lista.insertar(nodo35);
    lista.insertar(nodo11);
    lista.insertar(nodo22);
    lista.insertar(nodo17);
  }

  @Test
  public void lista_Imprimir(){
    Assertions.assertEquals("4 71 3 6 12 8 35 11 22 17", lista.imprimir(" "));
  }

  @Test
  public void lista_Insertar(){
    Assertions.assertEquals("4 71 3 6 12 8 35 11 22 17", lista.imprimir(" "));
  }

  @Test
  public void lista_Eliminar(){
    lista.eliminar(8);
    Assertions.assertEquals("4 71 3 6 12 35 11 22 17", lista.imprimir(" "));
    lista.eliminar(6);
    Assertions.assertEquals("4 71 3 12 35 11 22 17", lista.imprimir(" "));
    lista.eliminar(17);
    Assertions.assertEquals("4 71 3 12 35 11 22", lista.imprimir(" "));
  }

  @Test
  public void lista_Buscar(){
    Nodo buscado = lista.buscar(71);
    Assertions.assertEquals("71", buscado.getEtiqueta().toString());
  }

  @Test
  public void lista_OrdenImparPar(){
    Lista listaResultado = lista.ordenaImparesPares();
    Assertions.assertEquals("3, 11, 17, 35, 71, 4, 6, 8, 12, 22", listaResultado.imprimir(", "));
  }

  @Test
  public void lista_Orden(){
    lista.ordenar();
    Assertions.assertEquals("3 4 6 8 11 12 17 22 35 71", lista.imprimir(" "));
  }
  
}
