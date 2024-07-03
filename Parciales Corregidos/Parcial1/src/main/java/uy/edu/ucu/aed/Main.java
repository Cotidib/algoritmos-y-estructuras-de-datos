package uy.edu.ucu.aed;

import java.util.ArrayList;

public class Main 
{
    public static void main( String[] args )
    {
        // Cargar el árbol a partir del archivo
        // Invocar el método solicitado
        // Mostrar por consola el reusltado
        
        TArbolDeProductos<Producto> arbol = new TArbolDeProductos<Producto>();

        // COM INSERCION POR ARCHIVO TXT

        ManejadorArchivosGenerico manejadorArchivos = new ManejadorArchivosGenerico();
        String[] lineas = manejadorArchivos.leerArchivo("src\\main\\java\\uy\\edu\\ucu\\aed\\productos.txt");
        for (String linea : lineas) {
            String[] datos = linea.split(",");
            Producto producto = new Producto(Integer.parseInt(datos[0]), datos[1]);
            arbol.insertar(producto.getIdentificador(), producto);
        }

        //FIN INSERCION POR ARCHIVO TXT
        
        ArrayList<Lista> resultado = new ArrayList<Lista>();
        resultado = arbol.obtenerListas();
        Lista lista1 = resultado.get(0);    //sin categoria
        System.out.println(lista1.imprimir(" "));
        Lista lista2 = resultado.get(1);    //con categoria
        System.out.println(lista2.imprimir(" "));

        // COM ESCRITURA A TXT

        String[] salida = lista1.imprimir(",").split(",");
        manejadorArchivos.escribirArchivo("salida.txt", salida);

        // FIN ESCRITURA A TXT
    }
}
