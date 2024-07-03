package com.example;
import java.util.*;

public class Preparado {
  Lista<Farmaco> listaBlanca;
  Lista<Par<Suero, Farmaco>> listaNegra;

  public Preparado(Lista<Farmaco> listaBlanca, Lista<Par<Suero, Farmaco>> listaNegra){
    this.listaBlanca = listaBlanca;
    this.listaNegra = listaNegra;
  }

  public boolean preparadoViable(Suero identificadorSuero, Lista<Farmaco> identificadoresFarmacos){  //O(N^2)
    Nodo<Farmaco> actual = identificadoresFarmacos.getPrimero();
    while(actual != null){ // O(N)
      Lista<Suero> suerosInvalidos = new Lista<>();
      Nodo<Par<Suero, Farmaco>> actualListaNegra = listaNegra.getPrimero();
      while (actualListaNegra != null){ // O(N)
        if(actualListaNegra.getDato().getValue().codigo == actual.getDato().codigo){
          suerosInvalidos.insertar(actualListaNegra.getDato().getKey().codigo, actualListaNegra.getDato().getKey());
        }
        actualListaNegra = actualListaNegra.getSiguiente();
      }
      
      Nodo<Suero> sueroEncontrado = suerosInvalidos.buscar(identificadorSuero.codigo);
      if( sueroEncontrado != null){
        return false;
      }
      actual = actual.getSiguiente();
    }
    return true;
  }
}
