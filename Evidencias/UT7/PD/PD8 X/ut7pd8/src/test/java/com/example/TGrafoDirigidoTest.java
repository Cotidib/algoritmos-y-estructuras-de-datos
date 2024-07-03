package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class TGrafoDirigidoTest {
    @Test
    void testInsertarVertice() {
        TGrafoDirigido grafo = new TGrafoDirigido(new LinkedList<>(), new LinkedList<>());
        assertTrue(grafo.insertarVertice("A"));
        assertTrue(grafo.existeVertice("A"));
    }

    @Test
    void testInsertarArista() {
        TVertice v1 = new TVertice("A");
        TVertice v2 = new TVertice("B");
        List<TVertice> vertices = Arrays.asList(v1, v2);
        TGrafoDirigido grafo = new TGrafoDirigido(vertices, new LinkedList<>());
        assertTrue(grafo.insertarArista(new TArista("A", "B", 1.0)));
        assertTrue(grafo.existeArista("A", "B"));
    }

    @Test
    void testEliminarArista() {
        TVertice v1 = new TVertice("A");
        TVertice v2 = new TVertice("B");
        TArista arista = new TArista("A", "B", 1.0);
        List<TVertice> vertices = Arrays.asList(v1, v2);
        List<TArista> aristas = Arrays.asList(arista);
        TGrafoDirigido grafo = new TGrafoDirigido(vertices, aristas);
        assertTrue(grafo.eliminarArista("A", "B"));
        assertFalse(grafo.existeArista("A", "B"));
    }

    @Test
    void testEliminarVertice() {
        TVertice v1 = new TVertice("A");
        List<TVertice> vertices = Arrays.asList(v1);
        TGrafoDirigido grafo = new TGrafoDirigido(vertices, new LinkedList<>());
        assertTrue(grafo.eliminarVertice("A"));
        assertFalse(grafo.existeVertice("A"));
    }

    @Test
    void testExisteVertice() {
        TVertice v1 = new TVertice("A");
        List<TVertice> vertices = Arrays.asList(v1);
        TGrafoDirigido grafo = new TGrafoDirigido(vertices, new LinkedList<>());
        assertTrue(grafo.existeVertice("A"));
        assertFalse(grafo.existeVertice("B"));
    }

    @Test
    void testBuscarVertice() {
        TVertice v1 = new TVertice("A");
        List<TVertice> vertices = Arrays.asList(v1);
        TGrafoDirigido grafo = new TGrafoDirigido(vertices, new LinkedList<>());
        assertNotNull(grafo.buscarVertice("A"));
        assertNull(grafo.buscarVertice("B"));
    }

    @Test
    void testCentroDelGrafo() {
        // Configuración del grafo
        TVertice v1 = new TVertice("A");
        TVertice v2 = new TVertice("B");
        TVertice v3 = new TVertice("C");
        List<TVertice> vertices = Arrays.asList(v1, v2, v3);
        TArista arista1 = new TArista("A", "B", 1.0);
        TArista arista2 = new TArista("B", "C", 1.0);
        List<TArista> aristas = Arrays.asList(arista1, arista2);
        TGrafoDirigido grafo = new TGrafoDirigido(vertices, aristas);

        assertEquals("B", grafo.centroDelGrafo());
    }

    @Test
    void testFloyd() {
        // Configuración del grafo
        TVertice v1 = new TVertice("A");
        TVertice v2 = new TVertice("B");
        TVertice v3 = new TVertice("C");
        List<TVertice> vertices = Arrays.asList(v1, v2, v3);
        TArista arista1 = new TArista("A", "B", 1.0);
        TArista arista2 = new TArista("B", "C", 2.0);
        TArista arista3 = new TArista("A", "C", 4.0);
        List<TArista> aristas = Arrays.asList(arista1, arista2, arista3);
        TGrafoDirigido grafo = new TGrafoDirigido(vertices, aristas);

        Double[][] expected = {
                { 0.0, 1.0, 3.0 },
                { Double.MAX_VALUE, 0.0, 2.0 },
                { Double.MAX_VALUE, Double.MAX_VALUE, 0.0 }
        };
        assertArrayEquals(expected, grafo.floyd());
    }

    @Test
    void testWarshall() {
        // Configuración del grafo
        TVertice v1 = new TVertice("A");
        TVertice v2 = new TVertice("B");
        TVertice v3 = new TVertice("C");
        List<TVertice> vertices = Arrays.asList(v1, v2, v3);
        TArista arista1 = new TArista("A", "B", 1.0);
        TArista arista2 = new TArista("B", "C", 2.0);
        TArista arista3 = new TArista("A", "C", 4.0);
        List<TArista> aristas = Arrays.asList(arista1, arista2, arista3);
        TGrafoDirigido grafo = new TGrafoDirigido(vertices, aristas);

        boolean[][] expected = {
                { true, true, true },
                { false, true, true },
                { false, false, true }
        };
        assertArrayEquals(expected, grafo.warshall());
    }

    @Test
    void testDijkstra() {
        // Configuración del grafo
        TVertice v1 = new TVertice("A");
        TVertice v2 = new TVertice("B");
        TVertice v3 = new TVertice("C");
        List<TVertice> vertices = Arrays.asList(v1, v2, v3);
        TArista arista1 = new TArista("A", "B", 1.0);
        TArista arista2 = new TArista("B", "C", 2.0);
        TArista arista3 = new TArista("A", "C", 4.0);
        List<TArista> aristas = Arrays.asList(arista1, arista2, arista3);
        TGrafoDirigido grafo = new TGrafoDirigido(vertices, aristas);

        Double[] expected = { 0.0, 1.0, 3.0 };
        assertArrayEquals(expected, grafo.dijkstra("A"));
    }

    @Test
    void todosLosCaminosTest(){
        TVertice v1 = new TVertice("A");
        TVertice v2 = new TVertice("B");
        TVertice v3 = new TVertice("C");
        List<TVertice> vertices = Arrays.asList(v1, v2, v3);
        TArista arista1 = new TArista("A", "B", 1.0);
        TArista arista2 = new TArista("B", "C", 2.0);
        TArista arista3 = new TArista("A", "C", 4.0);
        List<TArista> aristas = Arrays.asList(arista1, arista2, arista3);
        TGrafoDirigido grafo = new TGrafoDirigido(vertices, aristas);
        String expected1 = "Origen: A -> B -> C";
        String expected2 = "Origen: A -> B -> C";
        TCaminos caminos = grafo.todosLosCaminos("A", "C");
        String camino1 = caminos.getCaminos().iterator().next().imprimirEtiquetas();
        String camino2 = caminos.getCaminos().iterator().next().imprimirEtiquetas();
        assertEquals(expected1, camino1);
        assertEquals(expected2, camino2);
    }

}
