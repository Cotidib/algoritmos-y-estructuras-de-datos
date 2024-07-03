package com.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Factorial 4: " + factorial(4));
        System.out.println("Factorial 5: " + factorial(5));
        System.out.println("Factorial 0: " + factorial(0));

        int[] arr = {1,2,3,4,5};
        System.out.println("Suma de los primeros 4 elementos: " + sumaLineal(arr, 4));
        
        // int[] arrVacio = new int[0];
        // System.out.println(sumaLineal(arrVacio, 2));

        System.out.println("Potencia a la 0: " + potencia(4, 0));
        System.out.println("Potencia 2 a la 3: " + potencia(2, 3));
    
        int[] arr2 = {1,2,3,4,5};
        invertirArray(arr2, 1, 3);
        for (int num : arr2){
            System.out.print(num);
        }
        System.out.println("\n");

        int[] arr3 = {1,2,3,4,5};
        invertirArray(arr3, 0, 4);
        for (int num : arr3){
            System.out.print(num);
        }
        System.out.println("\n");

        int[] arr4 = {1,2,3,4,5};
        // invertirArray(arr4, 1, 10);
        // for (int num : arr4){
        //     System.out.print(num);
        // }

        int[] arr5 = {};
        // invertirArray(arr5, 0, 4);
        // for (int num : arr5){
        //     System.out.print(num);
        // }
        // System.out.println("\n");

        int[] arr6 = {1};
        invertirArray(arr6, 0, 0);
        for (int num : arr6){
            System.out.print(num);
        }
        System.out.println("\n");
    }

    public static int factorial(int numero){
        if (numero == 0){
            return 1;
        }
        return numero * factorial(numero - 1);
    }

    public static int sumaLineal(int[] array, int n){
        if (n == 1){
            return array[0];
        } else {
            return sumaLineal(array, n-1) + array[n-1];
        }
    }

    public static int potencia(int x, int n){
        if (n == 0){
            return 1;
        } else {
            return x*potencia(x, n-1);
        }
    }

    public static void invertirArray(int[] array, int i, int j){
        if(i<j){
            int iAntes = array[i];
            int jAntes = array[j];
            array[i] = jAntes;
            array[j] = iAntes;
            invertirArray(array, i+1, j-1);
        }
    }
}