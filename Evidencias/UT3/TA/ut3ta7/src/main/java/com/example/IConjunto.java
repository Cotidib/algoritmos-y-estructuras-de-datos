package com.example;

public interface IConjunto<T> {
  public Conjunto<T> union(Conjunto<T> otroConjunto);
  public Conjunto<T> interseccion(Conjunto<T> otroConjunto);
  public void eliminarDuplicados();
}
