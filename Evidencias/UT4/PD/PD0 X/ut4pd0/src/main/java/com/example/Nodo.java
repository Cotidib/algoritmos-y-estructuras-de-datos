package com.example;

public class Nodo<T> {

  private final Comparable etiqueta;
  private T dato;
  private Nodo<T> siguiente;

  public Nodo(Comparable etiqueta, T dato ) {
      this.etiqueta = etiqueta;
      this.dato = dato;
      this.siguiente = null;
  }


  public T getDato() {
    return this.dato;
  }


  public Nodo getSiguiente() {
    return this.siguiente;
  }


  public void setSiguiente(Nodo nodo) {
    this.siguiente = nodo;
  }


  public void imprimir() {
    System.out.println(dato.toString());
  }


  public void imprimirEtiqueta() {
    System.out.println(this.etiqueta);
  }


  public Comparable getEtiqueta() {
    return this.etiqueta;
  }


  public int compareTo(Comparable etiqueta) {
    return this.etiqueta.compareTo(etiqueta);
  }

}
