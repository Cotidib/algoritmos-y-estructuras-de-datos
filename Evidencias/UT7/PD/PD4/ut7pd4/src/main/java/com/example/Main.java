package com.example;

import java.util.Collection;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        LinkedList<TVertice> vertices = new LinkedList<TVertice>();
        LinkedList<TArista> aristas = new LinkedList<TArista>();

        ManejadorArchivosGenerico manejadorArchivos = new ManejadorArchivosGenerico();
        String[] aeropuertos = manejadorArchivos.leerArchivo("src\\main\\java\\com\\example\\aeropuertos_2.txt", false);
        for (String aeropuerto : aeropuertos) {
            TVertice vertice = new TVertice(aeropuerto);
            vertices.add(vertice);
        }

        String[] conexiones = manejadorArchivos.leerArchivo("src\\main\\java\\com\\example\\conexiones_2.txt", false);
        for (String conexion : conexiones) {
            String[] linea = conexion.split(",");
            TArista arista = new TArista(linea[0], linea[1], Double.parseDouble(linea[2]));
            aristas.add(arista);
        }

        TGrafoDirigido grafo = new TGrafoDirigido(vertices, aristas);

        System.out.println("Caminos de Rio_de_Janeiro a Florianopolis: ");
        TCaminos caminos = grafo.todosLosCaminos("Rio_de_Janeiro", "Florianopolis");
        for (TCamino camino : caminos.getCaminos()) {
            System.out.println(camino.imprimirEtiquetas());
            System.out.println("Costo total: " + camino.getCostoTotal());
        }

    }
}
