package com.com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.TArista;
import com.example.TAristas;
import com.example.TGrafoNoDirigido;
import com.example.TVertice;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;
import java.util.LinkedList;

public class TGrafoNoDirigidoTest {

    private TGrafoNoDirigido grafo;

    @BeforeEach
    void setUp() {
        // Creación de vértices
        TVertice verticeA = new TVertice("A");
        TVertice verticeB = new TVertice("B");
        TVertice verticeC = new TVertice("C");
        TVertice verticeD = new TVertice("D");

        Collection<TVertice> vertices = new LinkedList<>();
        vertices.add(verticeA);
        vertices.add(verticeB);
        vertices.add(verticeC);
        vertices.add(verticeD);

        // Creación de aristas
        TArista aristaAB = new TArista("A", "B", 1);
        TArista aristaBC = new TArista("B", "C", 2);
        TArista aristaCD = new TArista("C", "D", 3);
        TArista aristaAD = new TArista("A", "D", 4);

        Collection<TArista> aristas = new LinkedList<>();
        aristas.add(aristaAB);
        aristas.add(aristaBC);
        aristas.add(aristaCD);
        aristas.add(aristaAD);

        // Creación del grafo
        grafo = new TGrafoNoDirigido(vertices, aristas);
    }

    @Test
    void testKruskal() {
        TGrafoNoDirigido mst = grafo.Kruskal();
        assertNotNull(mst);
        // Verificar que el número de aristas en el MST sea igual al número de vértices
        // - 1
        assertEquals(3, mst.getLasAristas().size() / 2);

        // Verificar manualmente las aristas
        boolean tieneAristaAB = false;
        boolean tieneAristaBC = false;
        boolean tieneAristaCD = false;

        for (TArista arista : mst.getLasAristas()) {
            if (arista.getEtiquetaOrigen().equals("A") && arista.getEtiquetaDestino().equals("B") ||
                    arista.getEtiquetaOrigen().equals("B") && arista.getEtiquetaDestino().equals("A")) {
                tieneAristaAB = true;
            }
            if (arista.getEtiquetaOrigen().equals("B") && arista.getEtiquetaDestino().equals("C") ||
                    arista.getEtiquetaOrigen().equals("C") && arista.getEtiquetaDestino().equals("B")) {
                tieneAristaBC = true;
            }
            if (arista.getEtiquetaOrigen().equals("C") && arista.getEtiquetaDestino().equals("D") ||
                    arista.getEtiquetaOrigen().equals("D") && arista.getEtiquetaDestino().equals("C")) {
                tieneAristaCD = true;
            }
        }
        assertTrue(tieneAristaAB);
        assertTrue(tieneAristaBC);
        assertTrue(tieneAristaCD);
    }

    @Test
    void testPrim() {
        TGrafoNoDirigido mst = grafo.Prim();
        assertNotNull(mst);
        // Verificar que el número de aristas en el MST sea igual al número de vértices
        // - 1
        assertEquals(3, mst.getLasAristas().size() / 2);

        // Verificar manualmente las aristas
        boolean tieneAristaAB = false;
        boolean tieneAristaBC = false;
        boolean tieneAristaCD = false;

        for (TArista arista : mst.getLasAristas()) {
            if (arista.getEtiquetaOrigen().equals("A") && arista.getEtiquetaDestino().equals("B") ||
                    arista.getEtiquetaOrigen().equals("B") && arista.getEtiquetaDestino().equals("A")) {
                tieneAristaAB = true;
            }
            if (arista.getEtiquetaOrigen().equals("B") && arista.getEtiquetaDestino().equals("C") ||
                    arista.getEtiquetaOrigen().equals("C") && arista.getEtiquetaDestino().equals("B")) {
                tieneAristaBC = true;
            }
            if (arista.getEtiquetaOrigen().equals("C") && arista.getEtiquetaDestino().equals("D") ||
                    arista.getEtiquetaOrigen().equals("D") && arista.getEtiquetaDestino().equals("C")) {
                tieneAristaCD = true;
            }
        }
        assertTrue(tieneAristaAB);
        assertTrue(tieneAristaBC);
        assertTrue(tieneAristaCD);
    }

    @Test
    void testBea() {
        Collection<TVertice> recorrido = grafo.bea("A");
        assertNotNull(recorrido);
        assertEquals(4, recorrido.size());
    }

    @Test
    void testConectados() {
        assertTrue(grafo.conectados(grafo.getVertices().get("A"), grafo.getVertices().get("B")));
        assertTrue(grafo.conectados(grafo.getVertices().get("A"), grafo.getVertices().get("C")));
        assertTrue(grafo.conectados(grafo.getVertices().get("A"), grafo.getVertices().get("D")));
        assertTrue(grafo.conectados(grafo.getVertices().get("B"), grafo.getVertices().get("C")));
        assertTrue(grafo.conectados(grafo.getVertices().get("B"), grafo.getVertices().get("D")));
        assertTrue(grafo.conectados(grafo.getVertices().get("C"), grafo.getVertices().get("D")));
    }

    @Test
    void testGetLasAristas() {
        TAristas aristas = grafo.getLasAristas();
        assertNotNull(aristas);
        assertEquals(4, aristas.size() / 2);
    }
}
