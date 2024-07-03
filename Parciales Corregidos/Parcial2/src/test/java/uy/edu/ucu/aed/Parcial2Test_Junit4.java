package uy.edu.ucu.aed;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import uy.edu.ucu.aed.parcial2.TGrafoDeLaRed;
import uy.edu.ucu.aed.parcial2.TVerticeDeLaRed;

/**
 * Unit test for implemented methods.
 */
public class Parcial2Test_Junit4 
{
    String instanceVariable;

    @Before
    public void setUp() {
        // Initialize any resources or objects needed for the tests
        instanceVariable = "Value before test";
    }

    @Test
    public void caminosDesdeHasta_1()
    {
        TVerticeDeLaRed v1 = new TVerticeDeLaRed(new Object[] {"V_1", "2"});
        TVerticeDeLaRed v2 = new TVerticeDeLaRed(new Object[] {"V_2", "1"});
        TVerticeDeLaRed v3 = new TVerticeDeLaRed(new Object[] {"V_3", "2"});
        TVerticeDeLaRed v4 = new TVerticeDeLaRed(new Object[] {"V_4", "1"});
        TVerticeDeLaRed v5 = new TVerticeDeLaRed(new Object[] {"V_5", "1"});
        Collection<TVerticeDeLaRed> vertices = Arrays.asList(v1, v2, v3);
        TArista arista1 = new TArista("V_1", "V_2", 1.0);
        TArista arista2 = new TArista("V_2", "V_3", 2.0);
        TArista arista3 = new TArista("V_1", "V_4", 4.0);
        TArista arista4 = new TArista("V_4", "V_5", 4.0);
        TArista arista5 = new TArista("V_5", "V_3", 4.0);
        Collection<IArista> aristas = Arrays.asList(arista1, arista2, arista3, arista4, arista5);
        TGrafoDeLaRed grafo = new TGrafoDeLaRed(vertices, aristas);
        String expected = "Origen: V_1 -> V_2 -> V_3";
        TCaminos caminos = grafo.todosLosCaminos("V_1", "V_3");
        TCamino camino = (TCamino) caminos.getCaminos().iterator().next();
        String caminoS = camino.imprimirEtiquetas();
        assertEquals(expected, caminoS); //se espera 1 solo camino valido A B C de A a C
    }

    @Test
    public void caminosDesdeHasta_2()
    {
        TVerticeDeLaRed v1 = new TVerticeDeLaRed(new Object[] {"V_1", "2"});
        TVerticeDeLaRed v2 = new TVerticeDeLaRed(new Object[] {"V_2", "1"});
        TVerticeDeLaRed v3 = new TVerticeDeLaRed(new Object[] {"V_3", "2"});
        TVerticeDeLaRed v4 = new TVerticeDeLaRed(new Object[] {"V_4", "1"});
        TVerticeDeLaRed v5 = new TVerticeDeLaRed(new Object[] {"V_5", "1"});
        Collection<TVerticeDeLaRed> vertices = Arrays.asList(v1, v2, v3);
        TArista arista1 = new TArista("V_1", "V_2", 1.0);
        TArista arista3 = new TArista("V_1", "V_4", 4.0);
        TArista arista4 = new TArista("V_4", "V_5", 4.0);
        TArista arista5 = new TArista("V_5", "V_3", 4.0);
        Collection<IArista> aristas = Arrays.asList(arista1, arista3, arista4, arista5);
        TGrafoDeLaRed grafo = new TGrafoDeLaRed(vertices, aristas);
        TCaminos caminos = grafo.todosLosCaminos("V_1", "V_3");
        assertEquals(true, caminos.getCaminos().isEmpty()); // No se espera ningun camino valido de A a C
    }
}
