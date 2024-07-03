package com.example;

public class Cola<T> extends Lista<T> implements ICola<T> {

  @Override
  public void insertar(Nodo<T> nodoNuevo) {
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

  @Override
  public void retirar() {
    if(primero != null){
      primero = primero.getSiguiente();
    }
  }
  
}
