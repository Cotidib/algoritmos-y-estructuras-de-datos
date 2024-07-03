package com.example;

// Un Enum es un tipo de dato que permite que a una variable 
// se le puede asignar un conjunto de constantes predefinidas
// Los Enum types se deben usar cuando se quiere representar un grupo fijo de constantes

public enum Ppf {
  BOMBON ("rosa"), 
  BURBUJA ("celeste"), 
  BELLOTA ("verde");

  // En un Enum tambien se pueden definir metodos
  public String color;
  Ppf(String color){
    this.color = color;
  }

  public String getPpfColor(){
    return color;
  }

}
