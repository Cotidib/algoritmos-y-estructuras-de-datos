package com.example;

public class Lista<T> implements ILista<T> {

  public Nodo<T> primero;

  public Lista() {
      primero = null;
  }

  @Override
  public void insertar(Nodo<T> nodo) {
    Nodo<T> nuevo = new Nodo<>(nodo.getEtiqueta(), nodo.getDato());
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
    public void insertar(Comparable etiqueta, T dato) {
        Nodo<T> nuevo = new Nodo<>(etiqueta, dato);
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
  public Nodo buscar(Comparable clave) {
    Nodo<T> actual = primero;
    while (actual != null) {
        if( actual.getEtiqueta().compareTo(clave) == 0) {
            return actual;
        }
        actual = actual.getSiguiente();
    }
    return null;
}

  @Override
  public boolean eliminar(Comparable clave) {
    if (primero == null) {
      return false;
    }
    if (primero.getSiguiente() == null && primero.getEtiqueta().equals(clave)){
      primero = null;
      return true;
    }
    if (primero.getEtiqueta().compareTo(clave) == 0) {
        primero = primero.getSiguiente();
        return true;
    }
    Nodo<T> actual = primero;
    while (actual != null) {
        if (actual.getSiguiente().getEtiqueta().compareTo(clave) == 0) {
            actual.setSiguiente(actual.getSiguiente().getSiguiente());
            return true;
        }
        actual = actual.getSiguiente();
    }
    return false;
  }

  @Override
  public String imprimir() {
    String temp = "";
    Nodo<T> actual = primero;
    while (actual != null){
        temp += actual.getEtiqueta();
        actual = actual.getSiguiente();
    }
    return temp;
  }

  @Override
  public String imprimir(String separador) {
    String temp = "";
    Nodo<T> actual = primero;
    while (actual != null){
        temp += actual.getEtiqueta();
        if (actual.getSiguiente() != null){
            temp += separador;
        }
        actual = actual.getSiguiente();
    }
    return temp;
  }

  @Override
  public int cantElementos() {
    int size = 0;
    Nodo<T> actual = primero;
    while (actual != null){
        size += 1;
        actual = actual.getSiguiente();
    }
    return size;
  }

  @Override
  public boolean esVacia() {
    if(primero == null) {
      return true;
    } else {
        return false;
    }
  }

  @Override
  public void setPrimero(Nodo unNodo) {
    if (primero == null) {
      primero = unNodo;
    } else {
        unNodo.setSiguiente(primero);
        primero = unNodo;
    }
  }

  @Override
  public Nodo<T> getPrimero() {
    return primero;
  }
  
  @Override
  public void ordenar(){
    if (primero == null || primero.getSiguiente() == null){
      return;
    }

    //Dividir a la mitad en dos listas
    Nodo<T> punteroComienzo = primero;
    Nodo<T> punteroFin = primero.getSiguiente().getSiguiente();
    while (punteroFin != null){
      punteroComienzo = punteroComienzo.getSiguiente();
      punteroFin = punteroFin.getSiguiente();
      if (punteroFin != null) {
        punteroFin = punteroFin.getSiguiente();
      }
    }
    Nodo<T> punteroMedio = punteroComienzo;

    Nodo<T> listaIzquierdaComienzo = primero;
    Lista<T> listaIzquierda = new Lista<>();
    listaIzquierda.setPrimero(listaIzquierdaComienzo);
    Nodo<T> listaDerechaComienzo = punteroMedio.getSiguiente();
    punteroMedio.setSiguiente(null);
    Lista<T> listaDerecha = new Lista<>();
    listaDerecha.setPrimero(listaDerechaComienzo);

    listaIzquierda.ordenar();
    listaDerecha.ordenar();

    // Mergear ordenados
    Nodo<T> actualIzquierda = listaIzquierda.getPrimero();
    Nodo<T> actualDerecha = listaDerecha.getPrimero();
    Nodo<T> nuevoPrimero;

    if (actualIzquierda.getEtiqueta().compareTo(actualDerecha.getEtiqueta()) <= 0) {
        nuevoPrimero = actualIzquierda;
        actualIzquierda = actualIzquierda.getSiguiente();
    } else {
        nuevoPrimero = actualDerecha;
        actualDerecha = actualDerecha.getSiguiente();
    }

    Nodo<T> actual = nuevoPrimero;

    while (actualIzquierda != null && actualDerecha != null) {
        if (actualIzquierda.getEtiqueta().compareTo(actualDerecha.getEtiqueta()) <= 0) {
            actual.setSiguiente(actualIzquierda);
            actualIzquierda = actualIzquierda.getSiguiente();
        } else {
            actual.setSiguiente(actualDerecha);
            actualDerecha = actualDerecha.getSiguiente();
        }
        actual = actual.getSiguiente();
    }

    if (actualIzquierda != null) {
        actual.setSiguiente(actualIzquierda);
    } else {
        actual.setSiguiente(actualDerecha);
    }

    primero = nuevoPrimero;
  }

  public Lista<T> ordenaImparesPares(){
    Lista<T> nuevaListaImpares = new Lista<>();
    Nodo<T> actual1 = primero;
    while (actual1 != null){
      if(Integer.parseInt(actual1.getEtiqueta().toString()) % 2 > 0){
        nuevaListaImpares.insertar(actual1);
      }
      actual1 = actual1.getSiguiente();
    }

    Lista<T> nuevaListaPares = new Lista<>();
    Nodo<T> actual2 = primero;
    while (actual2 != null){
      if(Integer.parseInt(actual2.getEtiqueta().toString()) % 2 == 0){
        nuevaListaPares.insertar(actual2);
      }
      actual2 = actual2.getSiguiente();
    }

    nuevaListaImpares.ordenar();
    nuevaListaPares.ordenar();

    Nodo<T> actualImpares = nuevaListaImpares.getPrimero();
    while(actualImpares.getSiguiente() != null){
      actualImpares = actualImpares.getSiguiente();
    }
    actualImpares.setSiguiente(nuevaListaPares.getPrimero());
    
    return nuevaListaImpares;
  }
}
