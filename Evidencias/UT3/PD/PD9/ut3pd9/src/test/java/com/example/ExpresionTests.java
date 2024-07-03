package com.example;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

public class ExpresionTests {

  Expresion exp;

  @BeforeEach                                         
    void setUp() {
      exp = new Expresion();
    }
  
  @Test
  public void validSecuence() {
    String secuencia1 = "{{}}{{}}";
    List<Character> listaDeEntrada = secuencia1.chars().mapToObj(e->(char)e).collect(Collectors.toList());
    boolean result = exp.controlCorchetes(listaDeEntrada);
    Assertions.assertEquals(true, result);
  }
  
  @Test
  public void invalidSecuence() {
    String secuencia1 = "{{}{{}";
    List<Character> listaDeEntrada = secuencia1.chars().mapToObj(e->(char)e).collect(Collectors.toList());
    boolean result = exp.controlCorchetes(listaDeEntrada);
    Assertions.assertEquals(false, result);
  }

  @Test
  public void invalidSecuence2() {
    String secuencia2 = "{{}}{{}}}";
    List<Character> listaDeEntrada = secuencia2.chars().mapToObj(e->(char)e).collect(Collectors.toList());
    boolean result = exp.controlCorchetes(listaDeEntrada);
    Assertions.assertEquals(false, result);
  }

  @Test
  public void invalidSecuence3() {
    String secuencia3 = "{{{}}{{}}";
    List<Character> listaDeEntrada = secuencia3.chars().mapToObj(e->(char)e).collect(Collectors.toList());
    boolean result = exp.controlCorchetes(listaDeEntrada);
    Assertions.assertEquals(false, result);
  }
}
