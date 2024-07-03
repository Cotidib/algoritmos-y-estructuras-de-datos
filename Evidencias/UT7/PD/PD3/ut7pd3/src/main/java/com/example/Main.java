package com.example;

import java.util.Collection;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        LinkedList<TVertice> vertices = new LinkedList<TVertice>();
        LinkedList<TArista> aristas = new LinkedList<TArista>();

        ManejadorArchivosGenerico manejadorArchivos = new ManejadorArchivosGenerico();
        String[] aeropuertos = manejadorArchivos.leerArchivo("src\\main\\java\\com\\example\\aeropuertos.txt", false);
        for (String aeropuerto : aeropuertos) {
            TVertice vertice = new TVertice(aeropuerto);
            vertices.add(vertice);
        }

        String[] conexiones = manejadorArchivos.leerArchivo("src\\main\\java\\com\\example\\conexiones.txt", false);
        for (String conexion : conexiones) {
            String[] linea = conexion.split(",");
            TArista arista = new TArista(linea[0], linea[1], Double.parseDouble(linea[2]));
            aristas.add(arista);
        }

        TGrafoDirigido grafo = new TGrafoDirigido(vertices, aristas);
        Comparable[][] matriz = UtilGrafos.obtenerMatrizCostos(grafo.getVertices());
        UtilGrafos.imprimirMatrizMejorado(matriz, grafo.getVertices(), "Matriz de adyacencia");

        Comparable[][] floyd = grafo.floyd();
        UtilGrafos.imprimirMatrizMejorado(floyd, grafo.getVertices(), "Floyd");

        System.out.println("Centro del grafo: " + grafo.centroDelGrafo());
        // System.out.println("Excentricidad Curitiba: " + grafo.obtenerExcentricidad("Curitiba"));
        // System.out.println("Excentricidad Porto: " + grafo.obtenerExcentricidad("Porto_Alegre"));
        // System.out.println("Excentricidad Santos: " + grafo.obtenerExcentricidad("Santos"));
        // System.out.println("Excentricidad San Pablo: " + grafo.obtenerExcentricidad("San_Pablo"));
        // System.out.println("Excentricidad Asuncion: " + grafo.obtenerExcentricidad("Asuncion"));
        // System.out.println("Excentricidad Rio: " + grafo.obtenerExcentricidad("Rio_de_Janeiro"));
        // System.out.println("Excentricidad Buenos Aires: " + grafo.obtenerExcentricidad("Buenos_Aires"));
        // System.out.println("Excentricidad Montevideo: " + grafo.obtenerExcentricidad("Montevideo"));

        System.out.println("Caminos de Montevideo a Curitiba: ");
        TCaminos caminos = grafo.todosLosCaminos("Montevideo", "Curitiba");
        System.out.println(caminos.imprimirCaminos());

        System.out.println("BPF (Tiempo de ejecucion O(a)):");
        Collection<TVertice> bpf = grafo.bpf();
        for (TVertice vertice : bpf) {
            System.out.print(vertice.getEtiqueta() + "-");
        }
    }
}
