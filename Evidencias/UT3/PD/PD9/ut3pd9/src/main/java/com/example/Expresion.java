package com.example;

import java.util.List;
import java.util.Stack;

public class Expresion {
  
  public static boolean controlCorchetes(List<Character> listaDeEntrada){
    Stack pila = new Stack();
    for(Character ch : listaDeEntrada){
      if(ch.toString().equals("{")){
        pila.push(ch);
      } else if (ch.toString().equals("}")){
        if(pila.empty()){
          return false;
        } else {
          pila.pop();
        }
      }
    }
    return pila.empty();
  }
}
