package com.example;

public class EnumTest {
  Ppf ppf;

  public EnumTest(Ppf ppf){
    this.ppf = ppf;
  }

  public void getColor(){
    switch(ppf) {
      case BOMBON:
        System.out.println("rosado");
        break;
      case BURBUJA:
        System.out.println("celeste");
        break;
      case BELLOTA:
        System.out.println("verde");
        break;
      default:
        System.out.println("flores de muchos colores");
        break;
    }
  }
}
