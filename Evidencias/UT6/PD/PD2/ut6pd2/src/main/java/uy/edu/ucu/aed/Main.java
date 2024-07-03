package uy.edu.ucu.aed;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        String[] lineas = new String[15];
        int l = 0;
        lineas[l++] = "factor de carga, comparaciones insertar, comparaciones buscar";

        File insercion = new File("src\\main\\java\\uy\\edu\\ucu\\aed\\cargas\\insercion");
        File[] listOfFilesInsercion = insercion.listFiles();
        File busqueda = new File("src\\main\\java\\uy\\edu\\ucu\\aed\\cargas\\busqueda");
        File[] listOfFilesBusqueda = busqueda.listFiles();

        for (int i=0; i<listOfFilesInsercion.length; i++) {
            String file_name_insercion = listOfFilesInsercion[i].getName();
            int file_number = Integer.parseInt(file_name_insercion.substring(0, file_name_insercion.indexOf(".")));
            String file_name_busqueda = listOfFilesBusqueda[i].getName();

            String[] claves = ManejadorArchivosGenerico.leerArchivo("src\\main\\java\\uy\\edu\\ucu\\aed\\cargas\\insercion\\" + file_name_insercion);
            Hash tablaHash = new Hash(claves.length);
            
            int insertar_comparaciones = 0;
            for (String clave : claves) {
                int c = Integer.parseInt(clave);
                insertar_comparaciones += tablaHash.insertar(c);
            }
            
            String[] clavesBuscar = ManejadorArchivosGenerico.leerArchivo("src\\main\\java\\uy\\edu\\ucu\\aed\\cargas\\busqueda\\" + file_name_busqueda);
            int buscar_comparaciones = 0;
            for (String clave : clavesBuscar) {
                int c = Integer.parseInt(clave);
                buscar_comparaciones += tablaHash.buscar(c);
            }
    
            lineas[l++] = file_number + "," + insertar_comparaciones/file_number + "," + buscar_comparaciones/file_number;
        }
        
        ManejadorArchivosGenerico.escribirArchivo("salidas.csv", lineas);
    }
    
}
