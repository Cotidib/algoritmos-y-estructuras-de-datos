package uy.edu.ucu.aed;

public class Hash implements IHash{
    private Integer[] tabla;

    public Hash(int elementos){
        int tamañoTabla = obtenerSiguientePrimo(elementos);
        tabla = new Integer[tamañoTabla];
    }

    public int funcionHashing(int unaClave){
        int indice = unaClave % tabla.length;
        return indice;
    }

    public int insertar(int unaClave){
        int comparaciones = 1;
        int indice = funcionHashing(unaClave);
        while(tabla[indice] != null){
            indice ++;
            comparaciones ++;
            if (indice==tabla.length){
                indice = 0;
            }
        }
        tabla[indice] = unaClave;   
        return comparaciones;
    }

    public int buscar(int unaClave){
        int comparaciones = 1;
        int indice = funcionHashing(unaClave);
        while(tabla[indice] != null){
            if(tabla[indice] == unaClave){
                return comparaciones;
            }
            indice ++;
            comparaciones ++;
            if (indice==tabla.length){
                indice = 0;
            }
        }
        return comparaciones;
    }

    // public boolean buscar(int unaClave){
    //     int comparaciones = 1;
    //     int indice = funcionHashing(unaClave);
    //     while(tabla[indice] != null){
    //         if(tabla[indice] == unaClave){
    //             return true;
    //         }
    //         indice ++;
    //         comparaciones ++;
    //         if (indice==tabla.length){
    //             indice = 0;
    //         }
    //     }
    //     return false;
    // }

    public int obtenerSiguientePrimo(int numero) {
        int siguienteNumero = numero + 1;
        while (!esPrimo(siguienteNumero)) {
            siguienteNumero++;
        }
        return siguienteNumero;
    }

    private boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }

}
