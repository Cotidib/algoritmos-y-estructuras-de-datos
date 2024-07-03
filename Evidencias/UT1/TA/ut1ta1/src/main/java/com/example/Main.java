package com.example;

// public class Main {
//     public static void main(String[] args) {

//         PruebaAtributos prueba = new PruebaAtributos();

//         System.out.println(prueba.unTexto);
//         System.out.println(prueba.unNumero);
//         System.out.println(prueba.unBool);

//         String otroTexto;
//         int otroNumero;
//         boolean otroBool;

//         // System.out.println(otroTexto); //The local variable otroTexto may not have been initialized
//         // System.out.println(otroNumero); //The local variable otroNumero may not have been initialized
//         // las variables locales no tienen valor por defecto!
//     }
// }


public class Main { 
    public static void main (String[] args){ 
        // int result = 3;  
        // System.out.println(result); 
        // result -= 1;  
        // System.out.println(result); 
        // result *= 2;
        // System.out.println(result); 
        // result /= 2;  
        // System.out.println(result); 
        // result += 8;  
        // result %= 7;   
        // System.out.println(result); 

        // int a = 5; 
        // int i = 3;  
        // int total = a+=++i; //el valor es 9
        // System.out.println(total); 

        // int i = 3; 
        // i++; 
        // System.out.println(i);     //4
        // ++i;                      
        // System.out.println(i);     //5
        // System.out.println(++i);      //6 
        // System.out.println(i++);     //6
        // System.out.println(i);      //7


    // 1 aValue = 8933.234;                      B
    // 2. aValue++;                              A
    // 3. System.out.println("Hello World!");    D
    // 4. Bicycle myBike = new Bicycle();        C
    // a) Incremento 
    // b) Asignación 
    // c) Creación de objeto 
    // d) Invocación de método 

    int aNumber = 3;

    if (aNumber >= 0) { //evalua true
        if (aNumber == 0) {  //evalua false
            System.out.println("first string");  // no ejecuta
         } else {
            System.out.println("second string");  //imprime
        }
        System.out.println("third string");        // imprime
    }

    //A) second string y third string
    //B) second string third string

    

    }
}