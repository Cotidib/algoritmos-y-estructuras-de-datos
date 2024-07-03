package com.example;

public class Main {
    public static void main(String[] args) {
        short presionSanguinea = 100;
        short frecuenciaCardiaca = 150;
        short azucarSangre = 200;
        float maximaFuerza = 1500000000;
        byte minimoTiempoLatidos = 56;
        byte bateria = 87;
        char[] codigoFabricante = {'a', 'b', 'c', 'd', 'e', '6', '2', '1'};
        
        Marcapasos marcapasos = new Marcapasos(presionSanguinea, frecuenciaCardiaca, azucarSangre, maximaFuerza, minimoTiempoLatidos, bateria, codigoFabricante);
        // presionSanguinea - 2 bytes
        // frecuenciaCardiaca - 2 bytes
        // azucarSangre - 2 bytes
        // maximaFuerza - 4 bytes ( Si bien el maximo valor posible tambien entraba en un long, un float ocupa menos memoria)
        // minimoTiempoLatidos - 1 byte
        // bateria - 1 byte
        // codigoFabricante - 2 bytes * 8 = 16 bytes
        // MEMORIA TOTAL = 28 bytes
        System.out.println("marcapasos ocupa 28 bytes de memoria");
    }
}