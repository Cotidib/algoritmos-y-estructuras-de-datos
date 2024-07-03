package com.example;

public class Cola<T> {
  public Nodo<T> primero;

  public Cola() {
      primero = null;
  }

  public void push(Nodo<T> nodoNuevo) {
    Nodo<T> nuevo = new Nodo<>(nodoNuevo.getEtiqueta(), nodoNuevo.getDato());
    if (primero == null) {
      primero = nuevo;
    } else {
        Nodo<T> actual = primero;
        while (actual.getSiguiente() != null) {
          actual = actual.getSiguiente();
        }
        actual.setSiguiente(nuevo);
    }
  }

  public Nodo pop() {
    if(primero != null){
      Nodo devolver = primero;
      primero = primero.getSiguiente();
      return devolver;
    }
    return null;
  }
  
}
