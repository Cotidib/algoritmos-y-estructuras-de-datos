package uy.edu.ucu.aed.parcial2;

import uy.edu.ucu.aed.*;

/**
 * Algoritmo y Estrucutras de Datos
 * Parcial 2 - Parte 3
 *
 */

public class MainParcial2 {
    public static void main(String[] args) {
        // Cargar grafo a partir de archivos de entrada
        TGrafoDeLaRed grafo = UtilGrafos.cargarGrafo("./src/main/java/uy/edu/ucu/aed/parcial2/vertices.txt",
                "./src/main/java/uy/edu/ucu/aed/parcial2/aristas.txt", false, TGrafoDeLaRed.class,
                TVerticeDeLaRed.class);

        // Calculo de todos los caminos entre dos vertices
        TCaminos<TEstacionDeLaRed> caminos = grafo.caminosDesdeHasta("Vertice_3", "Vertice_4");
        caminos.imprimirCaminosConsola();

        //Ordenar caminos de menor a mayor costo con INSERCION DIRECTA (pocas cantidades de datos)
        TCamino<TEstacionDeLaRed>[] caminosOrdenados = ordenarPorInsercion(caminos);

        // Escribir archivo de salida con el resultado de la llamada anterior
        ManejadorArchivosGenerico manejadorArchivos = new ManejadorArchivosGenerico();
        String[] lineas = new String[caminosOrdenados.length + 1];
        int i = 0;
        for(TCamino camino : caminosOrdenados){
            String linea = "Costo:  " + camino.getCostoTotal() + " " + camino.imprimirEtiquetas();
            lineas[i] = linea;
            i++;
        }
        lineas[i] = "\n";
        manejadorArchivos.escribirArchivo("salida.txt", lineas);

    }

    static TCamino<TEstacionDeLaRed>[] ordenarPorInsercion(TCaminos<TEstacionDeLaRed> datosParaClasificar) {
        if (datosParaClasificar != null) {
            TCamino<TEstacionDeLaRed>[] datos = new TCamino[datosParaClasificar.getCaminos().size()];
            int c = 0;
            for (TCamino<TEstacionDeLaRed> camino : datosParaClasificar.getCaminos()) {
                datos[c] = camino;
                c++;
            }
        
            for (int i = 1; i < datos.length; i++) {
                int j = i;
                while (j > 0 && datos[j - 1].getCostoTotal() > datos[j].getCostoTotal()) {
                    intercambiar(datos, j, j - 1);
                    j--;
                }
            }
            return datos;
        }
        return null;
    }

    static void intercambiar(TCamino<TEstacionDeLaRed>[] vector, int pos1, int pos2) {
        TCamino<TEstacionDeLaRed> temp = vector[pos2];
        vector[pos2] = vector[pos1];
        vector[pos1] = temp;
    }
}
