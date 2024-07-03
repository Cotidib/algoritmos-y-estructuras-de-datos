package com.example;

public class Conjunto<T> extends Lista<T> implements IConjunto<T>{

  // UNION
  // ESPECIFICACION EN LENGUAJE NATURAL:
  // Se empiezan a recorrer ambos conjuntos  a la vez. En cada paso de la iteracion se compara el elemento actual de un conjunto
  // con el elemento actual del otro conjunto. Si el primer elemento es menor, se inserta el elemento en un nuevo conjunto y se avanza
  // un lugar hacia adelante en el conjunto original del element. Si el primer elemento es menor, se inserta el segundo elemento al nuevo conjunto
  // y se avanza una posicion en el segundo conjunto. Si los dos elementos son iguales, se agrega el primero al nuevo conjunto y se avanza un lugar en ambos conjuntos.
  // Cuando uno de los dos conjuntos llega a su fin de iteracion, puede haber dos posiblidades, que el primero conjunto todavia tenga elementos o que el segundo conjunto 
  // todavia tenga elementos. En cualquier caso se sigue recorriendo el conjunto que haya quedado con elementos y se insertan todos en el nuevo conjunto.
  // PRECONDICIONES:
  // Se ingresa un conjunto no nulo
  // El conjunto sobre el cual es aplicada la funcion y el conjunto de entrada estan ordenados
  // POSTCONDICIONES:
  // Ninguno de los conjuntos originales es modificado
  // Se devuelve un nuevo conjunto ordenado sin elementos duplicados
  // SEUDOCODIGO
  // Conjunto funcion union(Conjunto otroConjunto)     //O(N) 
  //   iniciailizar nuevoConjunto
  //   actual1 <- primero;
  //   actual2<-  otroConjunto.primero;
  //   mientras actual1 <> null y actual2 <> null   //O(N)
  //     si actual1.clave < actual2.clave
  //       nuevoConjunto.insertar(actual1)
  //       actual1 = actual1.siguiente
  //     si actual2.clave < actual1.clave
  //       nuevoConjunto.insertar(actual2);
  //       actual2 = actual2.siguiente
  //     si actual2.clave == actual1.clave
  //       nuevoConjunto.insertar(actual1);
  //       actual1 = actual1.siguiente
  //       actual2 = actual2.siguiente
  //     fin si
  //   fin mientras
  //   si actual1 == null y actual2 <> null
  //     mientras actual2 <> null             //O(N)
  //       nuevoConjunto.insertar(actual2)
  //       actual2 = actual2.siguiente
  //     fin mientras
  //   fin si
  //   si actual2 == null y actual1 <> null
  //     mientras actual1 <> null             //O(N)
  //       nuevoConjunto.insertar(actual1)
  //       actual1 = actual1.siguiente
  //     fin mientras
  //   fin si
  // fin funcion

  @Override
  public Conjunto<T> union(Conjunto<T> otroConjunto) {
    Conjunto<T> nuevoConjunto = new Conjunto<T>();
    Nodo<T> actual1 = primero;
    Nodo<T> actual2 = otroConjunto.getPrimero();
    while (actual1 != null & actual2 != null){
      if (actual1.getEtiqueta().compareTo(actual2.getEtiqueta()) < 0){
        nuevoConjunto.insertar(actual1);
        actual1 = actual1.getSiguiente();
      } else if (actual1.getEtiqueta().compareTo(actual2.getEtiqueta()) > 0) {
        nuevoConjunto.insertar(actual2);
        actual2 = actual2.getSiguiente();
      } else if (actual1.getEtiqueta().compareTo(actual2.getEtiqueta()) == 0){
        nuevoConjunto.insertar(actual1);
        actual1 = actual1.getSiguiente();
        actual2 = actual2.getSiguiente();
      }
    }

    if(actual1 == null & actual2 != null){
      while(actual2 != null){
        nuevoConjunto.insertar(actual2);
        actual2 = actual2.getSiguiente();
      }
    }
    if(actual1 != null & actual2 == null){
      while(actual1 != null){
        nuevoConjunto.insertar(actual1);
        actual1 = actual1.getSiguiente();
      }
    }

    return nuevoConjunto;
  }

  // INTERSECCION
  // ESPECIFICACION EN LENGUAJE NATURAL:
  // Se empiezan a recorrer ambos conjuntos  a la vez. En cada paso de la iteracion se compara el elemento actual de un conjunto
  // con el elemento actual del otro conjunto. Si el primer elemento es menor, se avanza
  // un lugar hacia adelante en el conjunto original del elemento. Si el segundo elemento es menor,
  // se avanza una posicion en el segundo conjunto. Si los dos elementos son iguales, se agrega el primero al nuevo conjunto y se avanza un lugar en ambos conjuntos.
  // PRECONDICIONES:
  // Se ingresa un conjunto no nulo
  // Los conjnutos estan ordenados
  // POSTCONDICIONES:
  // Ninguno de los conjuntos originales es modificado
  // Se devuelve un nuevo conjunto con los elementos comunes
  // SEUDOCODIGO:
  // Conjunto funcion interseccion(Conjunto otroConjunto)     //O(N) 
  //   iniciailizar nuevoConjunto
  //   actual1 <- primero;
  //   actual2<-  otroConjunto.primero;
  //   mientras actual1 <> null y actual2 <> null   //O(N)
  //     si actual1.clave < actual2.clave
  //       actual1 = actual1.siguiente
  //     si actual2.clave < actual1.clave
  //       actual2 = actual2.siguiente
  //     si actual2.clave == actual1.clave
  //       nuevoConjunto.insertar(actual1);
  //       actual1 = actual1.siguiente
  //       actual2 = actual2.siguiente
  //     fin si
  //   fin mientras
  // fin funcion

  @Override
  public Conjunto<T> interseccion(Conjunto<T> otroConjunto) {
    Conjunto<T> nuevoConjunto = new Conjunto<T>();
    Nodo<T> actual1 = primero;
    Nodo<T> actual2 = otroConjunto.getPrimero();
    while (actual1 != null & actual2 != null){
      if (actual1.getEtiqueta().compareTo(actual2.getEtiqueta()) < 0){
        actual1 = actual1.getSiguiente();
      } else if (actual1.getEtiqueta().compareTo(actual2.getEtiqueta()) > 0) {
        actual2 = actual2.getSiguiente();
      } else if (actual1.getEtiqueta().compareTo(actual2.getEtiqueta()) == 0){
        nuevoConjunto.insertar(actual1);
        actual1 = actual1.getSiguiente();
        actual2 = actual2.getSiguiente();
      }
    }
    return nuevoConjunto;
  }

  @Override
  public Nodo<T> getPrimero() {
    return primero;
  }

  @Override
  public void eliminarDuplicados(){
    Nodo<T> actual = primero;
    while(actual != null){
      Nodo<T> anterior = actual;
      Nodo<T> siguiente = actual.getSiguiente();
      while(siguiente != null){
        if(siguiente.getEtiqueta().equals(actual.getEtiqueta())){
          anterior.setSiguiente(siguiente.getSiguiente());
        } else {
          anterior = siguiente; 
        }
        siguiente = siguiente.getSiguiente();
      }
      actual = actual.getSiguiente();
    }
  }

}
