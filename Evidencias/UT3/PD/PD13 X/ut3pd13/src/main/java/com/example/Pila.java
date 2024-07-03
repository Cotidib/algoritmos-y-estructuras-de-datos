package com.example;

public class Pila<T> extends Lista<T> implements IPila<T>{

  @Override
  public void insertar(Nodo<T> nodoNuevo) {
    Nodo<T> nuevo = new Nodo<>(nodoNuevo.getEtiqueta(), nodoNuevo.getDato());
    if (primero == null) {
      primero = nuevo;
    } else {
      Nodo<T> actualPrimero = primero;
      nuevo.setSiguiente(actualPrimero);
      primero = nuevo;
    }
  }

  @Override
  public void retirar() {
    if(primero != null){
      primero = primero.getSiguiente();
    }
  }
  
}
