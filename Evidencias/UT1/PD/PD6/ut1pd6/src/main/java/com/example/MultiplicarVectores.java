package com.example;

public class MultiplicarVectores {
  public static void main(String[] args) {
    int[] intArray1 = new int[]{ 1,2,3,4,5,6,7,8,9,10 }; 
    int[] intArray2 = new int[]{ 1,2,3,4,5,6,7,8,9,10 };
    
    if (intArray1.length == intArray2.length){
      int[] nuevoArray = multiplicarVectores(intArray1, intArray2);
      for(int elemento: nuevoArray){
        System.out.println(elemento);
      }
    } else {
      System.out.println("Solo se pueden multiplicar vectores del mismo tamaño");
    }
  }

  // Como precondicion para este metodo, es necesario que los dos vectores ingresados sean del mismo tamaño, para poder multiplicar elemento con elemento
  public static int[] multiplicarVectores(int[] vec1, int[] vec2){
    int index = 0;
    int[] resultado = new int[vec1.length];
    while(index < vec1.length){
      resultado[index] = vec1[index] * vec2[index];
      index ++;
    }
    return resultado;      
  }
}
